package com.n7484443.los.main;

import org.lwjgl.opengl.*;

import com.n7484443.los.circuit.CircuitThread;
import com.n7484443.los.evolution.EvolutionS;
import com.n7484443.los.gui.GuiS;
import com.n7484443.los.input.InputThread;
import com.n7484443.los.language.LanguageStringLoader;
import com.n7484443.los.map.MapS;
import com.n7484443.los.render.*;

public class Core extends Thread{
	public static String version;
	//public static boolean CircuitEnd = false;
	public static boolean RenderEnd = false;
	public static boolean DiplayCreated = false;
	public static CircuitThread circuitThread;
	public static RenderThread renderThread;
	public static InputThread inputThread;
	public static boolean Loop = true;
	public static int CircuitTime = 0;
	public static Core instance;
	
	public GuiS guis;
	public MapS maps;
	public EvolutionS evolutions;
	
	public static void main(String[] args) {
		instance = new Core();
		instance.start();
	}   
	public void run(){
		LanguageStringLoader.init();
		setPriority(Thread.NORM_PRIORITY+2);
		evolutions = new EvolutionS();
		guis = new GuiS();
		maps = new MapS();
		ThreadInit();
		while(Loop){
			if(Display.isCreated() && Display.isCloseRequested()){
				Loop = false;
				break;
			}
		}
		ThreadEnd();
	}
	
	
	
	public static void ThreadInit(){
		circuitThread = new CircuitThread();
		renderThread = new RenderThread();
		inputThread = new InputThread();
		circuitThread.start();
		renderThread.start();
		inputThread.start();
	}
	
	
	public static void ThreadEnd(){
		circuitThread.interrupt();
		renderThread.interrupt();
		inputThread.interrupt();
	}
}
