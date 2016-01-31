package com.n7484443.los.gui;

import com.n7484443.los.input.ButtonInput;

public class ButtonBase {
	public int x;
	public int y;
	public int width;
	public int height;
	public int gui;
	public int num;
	public boolean state;
	public boolean onoff;
	public String on;
	public String off;
	public boolean oneTime;
	public int page;
	public ButtonBase(int x, int y, int width, int height, int gui, int num, boolean oneTime, String off, String on, int page) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.gui = gui;
		this.num = num;
		this.state = false;
		this.on = on;
		this.off = off;
		this.onoff = false;
		this.oneTime = oneTime;
		this.page = page;
	}
	
	public ButtonBase(int x, int y, int width, int height, int gui, int num, boolean oneTime, String off, int page) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.gui = gui;
		this.num = num;
		this.state = false;
		this.off = off;
		this.on = null;
		this.onoff = false;
		this.oneTime = oneTime;
		this.page = page;
	}
	
	public String getString(){
		if(on != null){
			return onoff ? on: off;
		}else{
			return off;
		}
	}
	
	public boolean CheckMouseIn(int mousex, int mousey){
		if(mousex > x  && mousey > y && mousex < x + width && mousey < y+height){
			this.state = true;
			return true;
		}
		this.state = false;
		return false;
	}
	public void DoButtonInput(){
		if(!oneTime){
			ButtonInput.InputButton(gui, num, page);
		}else{
			if(!onoff){
				ButtonInput.InputButton(gui, num, page);
			}
		}
	}
}
