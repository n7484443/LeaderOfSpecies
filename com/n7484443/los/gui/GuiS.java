package com.n7484443.los.gui;

import com.n7484443.los.render.RenderThread;

public class GuiS {
	public static GuiBase[] guis;
	public GuiS(){
		init();
	}
	
	public static void init(){
		guis = new GuiBase[3];
		guis[0] = new GuiGameIn(0, 0, RenderThread.DisplayWidth, RenderThread.DisplayHeight, 0);
		guis[1] = new GuiEvolution(0, 0, RenderThread.DisplayWidth, RenderThread.DisplayHeight, 1);
		guis[2] = new GuiSetting(0, 0, RenderThread.DisplayWidth, RenderThread.DisplayHeight, 2);
		for(int i = 0; i < guis.length; i++){
			guis[i].init();
		}
		guis[0].setVisible(true);
	}
	
	public static void setGui(int i, boolean visible){
		guis[i].setVisible(visible);
	}
	
	public static boolean isGuiVisible(int i){
		return guis[i].getVisible();
	}
	
	public static void reverseGui(int i){
		guis[i].setVisible(!guis[i].getVisible());
	}
	
	public static GuiBase getGui(int i){
		return guis[i];
	}
}
