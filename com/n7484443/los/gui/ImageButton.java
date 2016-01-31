package com.n7484443.los.gui;

public class ImageButton extends ButtonBase{
	int texture;
	public ImageButton(int x, int y, int width, int height, int gui, boolean oneTime, int num, int texture, String on, String off, int page) {
		super(x, y, width, height, gui, num, oneTime, on, off, page);
		this.texture = texture;
	}

}
