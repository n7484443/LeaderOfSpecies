package com.n7484443.los.render;

import org.newdawn.slick.opengl.Texture;

public class TextureHelper {
	public static Texture[] EntityTexture;
	public static Texture[] GuiTexture;
	public TextureHelper(){
		init();
	}
	public void init(){
		EntityTexture = new Texture[10];
		EntityTexture[0] = TextureLoadingHelper.getTexture("png", "com/n7484443/los/image/cell_prokaryote.png");
		EntityTexture[1] = TextureLoadingHelper.getTexture("png", "com/n7484443/los/image/cell_eukaryota.png");
		
		GuiTexture = new Texture[10];
		GuiTexture[0] = TextureLoadingHelper.getTexture("png", "com/n7484443/los/image/cell_prokaryote.png");
	}
}
