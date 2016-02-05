package com.n7484443.los.gui;

import static com.n7484443.los.render.RenderingHelper.RenderQuadangleXY;
import static com.n7484443.los.render.RenderingHelper.RenderText;

import com.n7484443.los.render.FontRenderer;

public class ButtonScroll extends ButtonBase{
	public String[] option;
	public int choose;
	public ButtonScroll(int x, int y, int width, int height, int gui, int num, boolean oneTime, String[] option, int page) {
		super(x, y, width, height, gui, num, oneTime, option[0], page);
		this.option = option;
		choose = 0;
	}

	public String getString(){
		return option[choose];
	}
	
	public boolean isRender(){
		return true;
	}
	public void Render(){
		if(option.length % 2 == 0){
			
		}else{
			
		}
		for(int i = 0; i < option.length; i++){
			RenderQuadangleXY(x, y, width, height, null);
			RenderText(x + width/2 - FontRenderer.getSize(option[i])/2, y, getString());
		}
	}
	
	
}
