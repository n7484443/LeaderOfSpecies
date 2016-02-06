package com.n7484443.los.gui;

import static com.n7484443.los.render.RenderingHelper.RenderQuadangleXY;
import static com.n7484443.los.render.RenderingHelper.RenderText;

import org.newdawn.slick.Color;

import com.n7484443.los.render.FontRenderer;

public class ButtonScroll extends ButtonBase{
	public String[] option;
	public int choose;
	public int shownum;//show
	public int show;
	public ButtonScroll(int x, int y, int width, int height, int gui, int num, String[] option, int page) {
		super(x, y, width, height, gui, num, option, page);
		this.option = option;
		choose = 0;
		if(option.length < 7){
			shownum = option.length;
		}else{
			shownum = 7;
		}
		show = 0;
	}

	public String getString(){
		return option[choose];
	}
	
	public boolean isRender(){
		return true;
	}
	public void Render(){
		if(show % 2 == 0){
			if(show + shownum > option.length){
				show = option.length - shownum;
			}
			for(int i = 0; i <shownum; i++){
				Color.gray.bind();
				RenderQuadangleXY(x, y-(i-shownum/2)*height, width, height, null);
				RenderText(x, y-(i-shownum/2)*height, option[i+show]);
			}
		}else{
			if(show + shownum > option.length){
				show = option.length - shownum;
			}
			for(int i = 0; i <show; i++){
				Color.gray.bind();
				RenderQuadangleXY(x, y-(show-(shownum+1)/2)*height, width, height, null);
				RenderText(x, y-(show-(shownum+1)/2)*height, option[i+show]);
			}
		}
	}
	
	
}
