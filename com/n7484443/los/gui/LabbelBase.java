package com.n7484443.los.gui;

public class LabbelBase {
	public int x;
	public int y;
	public int width;
	public int height;
	public String str;
	public LabbelBase(int x, int y, int width, int height, String str) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.str = str;
	}
	
	public void setLabel(String str){
		this.str = str;
	}
	
	public String getLabel(){
		return str;
	}
}
