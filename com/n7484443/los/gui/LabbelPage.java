package com.n7484443.los.gui;

import java.util.ArrayList;

public class LabbelPage {
	public ArrayList<LabbelBase> Labbels = new ArrayList<LabbelBase>();
	public LabbelBase getLabbel(int i){
		return Labbels.get(i);
	}
	
	public void setLabbel(int i, String str){
		Labbels.get(i).setLabel(str);
	}
}
