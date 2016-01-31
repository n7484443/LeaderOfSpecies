package com.n7484443.los.input;

import com.n7484443.los.gui.GuiS;

public class ButtonInput {
	//state 0 : out 1 : in
	public static void InputButton(int gui, int num, int page){
		GuiS.getGui(gui).updateButton(num, page);
	}
}
