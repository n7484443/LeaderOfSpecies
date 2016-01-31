package com.n7484443.los.input;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;

import com.n7484443.los.gui.GuiS;

public class KeyboardInputEvent {
	public static Key[] Keys;
	public static void init(){
		try {
			Keyboard.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		Keys = new Key[Keyboard.getKeyCount()];
		
		for(int i = 0; i < Keys.length; i++){
			Keys[i] = new Key(i);
		}
		
	}
	public static void PressedEvent(int key){
		if(!GuiS.isGuiVisible(2) && key == Keyboard.KEY_E){
			GuiS.reverseGui(0);
			GuiS.reverseGui(1);
		}
		if(key == Keyboard.KEY_ESCAPE){
			GuiS.reverseGui(2);
		}
	}
	
	public static void RealeasedEvent(int key){
	}
	
	public static void HoldingEvent(int key){
	}
	
	public static void Update(){
		CheckKeyboard();
	}
	
	public static void CheckKeyboard(){
		while (Keyboard.next()) {
			Keys[Keyboard.getEventKey()].setEvent(Keyboard.getEventKeyState());
		}
		for(int i = 0; i < Keys.length; i++){
			Keys[i].HoldingEvent();
		}
	}
}
