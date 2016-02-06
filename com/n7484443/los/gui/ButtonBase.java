package com.n7484443.los.gui;

import static com.n7484443.los.render.RenderingHelper.RenderQuadangleXY;
import static com.n7484443.los.render.RenderingHelper.RenderText;

import com.n7484443.los.input.ButtonInput;
import com.n7484443.los.render.FontRenderer;

public class ButtonBase {
	public int x;
	public int y;
	public int width;
	public int height;
	public int gui;
	public int num;
	public boolean state;
	public boolean onoff;
	public String[] str;
	public boolean oneTime;
	public int page;
	public int size;
	public ButtonBase(int x, int y, int width, int height, int gui, int num, String[] onoff, int page) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.gui = gui;
		this.num = num;
		this.state = false;
		this.str = onoff;
		this.onoff = false;
		this.oneTime = false;
		this.page = page;
		this.size = FontRenderer.baseSize;
	}
	
	public ButtonBase(int x, int y, int width, int height, int gui, int num, String off, int page) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.gui = gui;
		this.num = num;
		this.state = false;
		this.str = new String[1];
		this.str[0] = off;
		this.onoff = false;
		this.oneTime = false;
		this.page = page;
		this.size = FontRenderer.baseSize;
	}
	
	public ButtonBase setOneTimeClick(){
		this.oneTime = true;
		return this;
	}
	
	public ButtonBase setFontSize(int size){
		this.size = size;
		return this;
	}
	
	public String getString(){
		if(str.length != 1){
			return onoff ? str[1]: str[0];
		}else{
			return str[0];
		}
	}
	
	public boolean isRender(){
		return false;
	}
	
	public void Render(){
		RenderQuadangleXY(x, y, width, height, null);
		RenderText(x + width/2 - FontRenderer.getXSize(getString(), size)/2, y + height/2 - FontRenderer.getYSize(size)/2, getString());
	}
	public void RenderButton(){
		if(isRender()){
			Render();
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
