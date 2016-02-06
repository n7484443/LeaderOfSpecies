package com.n7484443.los.gui;

import static com.n7484443.los.render.RenderingHelper.RenderQuadangleXY;
import static com.n7484443.los.render.RenderingHelper.RenderText;

import org.newdawn.slick.Color;

import com.n7484443.los.render.FontRenderer;

public class LabbelBase {
	public int x;
	public int y;
	public int width;
	public int height;
	public String str;
	public int size;
	public LabbelBase(int x, int y, int width, int height, String str) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.str = str;
		this.size = FontRenderer.baseSize;
	}
	
	public void setSize(int size){
		this.size = size;
	}
	
	public void setLabel(String str){
		this.str = str;
	}
	
	public String getLabel(){
		return str;
	}
	
	public void Render(){
		RenderQuadangleXY(x, y, width, height, null);
		Color.white.bind();
		RenderText(x + width/2 - FontRenderer.getXSize(getLabel(), size)/2, y + height/2 - FontRenderer.getYSize(size)/2, getLabel());
	}
}
