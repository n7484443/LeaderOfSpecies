package com.n7484443.los.render;

import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class TextureLoadingHelper {
	public static Texture getTexture(String type, String str){
		Texture texture = null;
		try {
			texture = TextureLoader.getTexture(type, ResourceLoader.getResourceAsStream(str));
			 
			/*System.out.println("Texture loaded: "+texture);
			System.out.println(">> Image width: "+texture.getImageWidth());
			System.out.println(">> Image height: "+texture.getImageHeight());
			System.out.println(">> Texture width: "+texture.getTextureWidth());
			System.out.println(">> Texture height: "+texture.getTextureHeight());
			System.out.println(">> Texture ID: "+texture.getTextureID());*/
		} catch (IOException e) {
			e.printStackTrace();
		}
		return texture;
	}
}
