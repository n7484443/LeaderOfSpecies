package com.n7484443.los.render;

import org.newdawn.slick.Color;

public enum ColorS {
	AquaBlue(126, 210, 255),
	GlassGreen(173, 255, 166);
	
	Color color;
	ColorS(int r, int g, int b){
		color = new Color(r, g, b);
	}
	public void bind(){
		color.bind();
	}
}
