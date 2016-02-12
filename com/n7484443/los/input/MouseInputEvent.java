package com.n7484443.los.input;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import com.n7484443.los.gui.ButtonBase;
import com.n7484443.los.gui.GuiBase;
import com.n7484443.los.gui.GuiS;

public class MouseInputEvent {
	public static MouseKey[] button;
	public static void init(){
		
		try {
			Mouse.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		button = new MouseKey[Mouse.getButtonCount()];
		for(int i = 0; i < button.length; i++){
			button[i] = new MouseKey(i);
		}
	}
	public static void Update(){
		CheckClick();
		ButtonUpdate();
	}
	public static void CheckClick(){
		int dWheel = Mouse.getDWheel();
	    if (dWheel != 0) {
	    	ScrollEvent(dWheel, Mouse.getX(), Display.getHeight() - Mouse.getY());
	    }
		while (Mouse.next()) {
			if (Mouse.isInsideWindow()) {
				if(Mouse.getEventButton() >= 0){
					button[Mouse.getEventButton()].setEvent(Mouse.getEventButtonState(), Mouse.getX(), Display.getHeight() - Mouse.getY());
				}
			}
		}
		for(int i = 0; i < button.length; i++){
			button[i].UpdateMove(Mouse.getDX(), Mouse.getDY());
			button[i].HoldingEvent(Mouse.getX(), Display.getHeight() - Mouse.getY());
			button[i].DragingEvent(Mouse.getX(), Display.getHeight() - Mouse.getY());
		}
	}
	
	public static void ScrollEvent(int Dwheel, int mousex, int mousey){
		
	}
	
	public static void ButtonUpdate(){
		for(int i = 0; i < GuiS.guis.length; i++){
			GuiBase gui = GuiS.getGui(i);
			if(gui.getVisible()){
				if(gui.getButtonPage() != null)
				for(ButtonBase but : gui.getButtonPage().Buttons){
					but.CheckMouseIn(Mouse.getX(), Display.getHeight() - Mouse.getY());
				}
				if(gui.getGuiButtonPage() != null)
				for(ButtonBase but : gui.getGuiButtonPage().Buttons){
					but.CheckMouseIn(Mouse.getX(), Display.getHeight() - Mouse.getY());
				}
			}
		}
	}
	
	public static void PressedEvent(int button, int mousex, int mousey){
		for(int i = 0; i < GuiS.guis.length; i++){
			GuiBase gui = GuiS.getGui(i);
			if(gui.getVisible()){
				if(gui.getButtonPage() != null){
				for(ButtonBase but : gui.getButtonPage().Buttons){
					if(but != null){
						if(but.state){
							but.DoButtonInput();
						}
					}
				}
				}
				if(gui.getGuiButtonPage() != null){
				for(ButtonBase but : gui.getGuiButtonPage().Buttons){
					if(but != null){
						if(but.state){
							but.DoButtonInput();
						}
					}
				}
				}
			}
		}
	}
	
	public static void RealeasedEvent(int button, int mousex, int mousey){
		
	}
	
	public static void HoldingEvent(int button, int mousex, int mousey){
		
	}
	public static void DragingEvent(int button, int beforex, int beforey, int mousex, int mousey){
	
	}
}
