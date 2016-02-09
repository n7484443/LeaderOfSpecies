package com.n7484443.los.gui;

import static com.n7484443.los.render.RenderingHelper.*;
import com.n7484443.los.math.MathS;
import com.n7484443.los.render.FontRenderer;

public class ButtonHexagon extends ButtonBase{
	
	public ButtonHexagon(int x, int y, int size, int gui, int num, String off, int page) {
		super(x, y, size, size, gui, num, off, page);
		this.size = 12;
	}
	
	public boolean CheckMouseIn(int mousex, int mousey){
		if(Check(mousex, mousey)){
			this.state = true;
			return true; 
		}
		this.state = false;
		return false;
	}

	public boolean Check(int mousex, int mousey){
		if(mousex > x - width*2 && mousey > y - MathS.sqrt3*width && mousex < x + width*2 && mousey < y + MathS.sqrt3*width){
			if(mousex >= x - width && mousey >= y - MathS.sqrt3*width && mousex <= x + width && mousey <= y + MathS.sqrt3*width){
				return true; 
			}else if(mousex < x - width){
				if(Math.tan(Math.toRadians(60))*(2*width-x+mousex)> Math.abs(MathS.sqrt3-y+mousey)){
					return true; 
				}
			}else if(mousex > x + width){
				if(Math.tan(Math.toRadians(60))*(2*width + x - mousex) > Math.abs(MathS.sqrt3-y+mousey)){
					return true; 
				}
			}
		}
		return false; 
	}
	
	public void Render(){
		System.out.println(size);
		RenderPackedHexagonWithCenter(x, y, width);
		RenderText(x - FontRenderer.getXSize(getString(), size)/2 +2, y - FontRenderer.getYSize(size)/2, getString(), size, 1.0f, false);
	}
	
}
