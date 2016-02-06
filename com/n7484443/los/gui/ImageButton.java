package com.n7484443.los.gui;

public class ImageButton extends ButtonBase{
	int texture;
	public ImageButton(int x, int y, int width, int height, int gui, int num, int texture, String[] str, int page) {
		super(x, y, width, height, gui, num, str, page);
		this.texture = texture;
	}

}
