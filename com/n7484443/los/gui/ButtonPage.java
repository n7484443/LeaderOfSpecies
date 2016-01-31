package com.n7484443.los.gui;

import java.util.ArrayList;

public class ButtonPage {
	public ArrayList<ButtonBase> Buttons = new ArrayList<ButtonBase>();
	public ButtonBase getButton(int i){
		return Buttons.get(i);
	}
	
	public void setButton(int i, boolean onoff){
		Buttons.get(i).onoff = onoff;
	}
}
