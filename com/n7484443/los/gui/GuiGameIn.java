package com.n7484443.los.gui;

import static com.n7484443.los.render.RenderingHelper.RenderQuadangleXY;

import org.newdawn.slick.Color;

import com.n7484443.los.map.MapS;
import com.n7484443.los.map.MapUnderSea;
import com.n7484443.los.render.RenderingHelper;

public class GuiGameIn extends GuiBase{
	
	public GuiGameIn(int x, int y, int width, int height, int gui) {
		super(x, y, width, height, -1, gui, true);
	}
	
	public void init(){
	}
	public void updateButton(int num) {}
	
	public void BeforeRender(){
		Color.white.bind();
	}
	public void AfterRender(){
		Color.black.bind();
		RenderQuadangleXY(10, 10, 200, 30, null);
		RenderingHelper.RenderText(10, 10, String.valueOf(((MapUnderSea)MapS.map[0]).F));
	}
}
