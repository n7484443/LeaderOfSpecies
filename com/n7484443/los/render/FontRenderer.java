package com.n7484443.los.render;

import java.io.*;
import java.util.*;

import org.lwjgl.opengl.*;
import org.newdawn.slick.*;
import org.newdawn.slick.opengl.*;
import org.newdawn.slick.util.*;

public class FontRenderer {
	public static Texture kor_white;
	public static Texture kor_black;
	public static BufferedReader br;
	public static int koreanheight;
	public static int line;
	public static final int baseSize = 20;
	public static Map<Integer, Integer> x = new HashMap<Integer, Integer>();
	public static Map<Integer, Integer> y = new HashMap<Integer, Integer>();
	public static Map<Integer, Integer> width = new HashMap<Integer, Integer>();
	
	
	public static void init() throws IOException{
		kor_white = TextureLoader.getTexture("png", new FileInputStream(new File("c:/LeaderOfSpecies/korean_white.png")));
		kor_black = TextureLoader.getTexture("png", new FileInputStream(new File("c:/LeaderOfSpecies/korean_black.png")));
		br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("c:/LeaderOfSpecies/korean.fnt"))));
		String str;
		boolean b = true;
		while((str = br.readLine()) != null){
			if(b){
				if(str.contains("height=")){
					koreanheight = Integer.valueOf(str.substring(str.indexOf("=") + 1));
				}else if(str.contains("line=")){
					line = Integer.valueOf(str.substring(str.indexOf("=") + 1));
					b = false;
				}
			}else{
				int i = Integer.valueOf(str.substring(str.indexOf("=") + 1, str.indexOf("x")));
				x.put(i, Integer.valueOf(str.substring(str.indexOf("x") + 2, str.indexOf("y"))));
				y.put(i, Integer.valueOf(str.substring(str.indexOf("y") + 2, str.indexOf("w"))));
				width.put(i, Integer.valueOf(str.substring(str.indexOf("h") + 2)));
			}
		}
		br.close();
	}
	
	public static void render(float x1, float y1, String str, boolean whiteorblack){
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		Color.white.bind();
		boolean b = false;
		boolean isfirst = false;
		for(int i = 0; i < str.length(); i++){
			if((int)str.charAt(i) == 39){
				b = true;
				isfirst = !isfirst;
			}
			int fontx;
			int fonty;
			int fontwidth;
			if(b){
				if(isfirst){
					fontx = x.get(8216);
					fonty = y.get(8216);
					fontwidth = width.get(8216);
				}else{
					fontx = x.get(8217);
					fonty = y.get(8217);
					fontwidth = width.get(8217);
				}
			}else{
				fontx = x.get((int)str.charAt(i));
				fonty = y.get((int)str.charAt(i));
				fontwidth = width.get((int)str.charAt(i));
			}
			float texx1 = fontx/2048F;
			float texx2 = (fontx+fontwidth)/2048F;
			float texy1 = fonty/2048F;
			float texy2 = (fonty+koreanheight)/2048F;
			RenderingHelper.RenderQuadangleXY((int)x1, (int)y1, fontwidth, koreanheight, whiteorblack ? kor_white : kor_black, texx1, texy1, texx2, texy2);
			x1 += fontwidth;
			if(b){
				b= false;
			}
		}
		GL11.glDisable(GL11.GL_BLEND);
	}
	
	public static int getXSize(String str, int sizeX){
		int size = 0;
		float m = (float)sizeX / 20;
		boolean b = false;
		boolean isfirst = false;
		for(int i = 0; i < str.length(); i++){
			if((int)str.charAt(i) == 39){
				b = true;
				isfirst = !isfirst;
			}
			int fontwidth;
			if(b){
				if(isfirst){
					fontwidth = width.get(8216);
				}else{
					fontwidth = width.get(8217);
				}
			}else{
				fontwidth = width.get((int)str.charAt(i));
			}
			size += fontwidth;
			if(b){
				b= false;
			}
		}
		return (int) (size*m);
	}
	
	public static int getYSize(int size){
		return (int) (koreanheight*((float)size / 20));
	}
	
	public static void renderReSizeable(int x1, int y1, int size, String str, boolean whiteorblack){
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		float m = (float)size / 20;
		for(int i = 0; i < str.length(); i++){
			int fontx = x.get((int)str.charAt(i));
			int fonty = y.get((int)str.charAt(i));
			int fontwidth = width.get((int)str.charAt(i));
			float texx1 = fontx/2048F;
			float texx2 = (fontx+fontwidth)/2048F;
			float texy1 = fonty/2048F;
			float texy2 = (fonty+koreanheight)/2048F;
			int he = (int) (koreanheight*m);
			RenderingHelper.RenderQuadangleXY(x1, y1, (int)(fontwidth*m), (int)(he), whiteorblack ? kor_white : kor_black, texx1, texy1, texx2, texy2);
			x1 += fontwidth*m;
		}
		GL11.glDisable(GL11.GL_BLEND);
	}
	
	public static void renderReSizeable(float x1, float y1, int size, String str, float Alpha, boolean whiteorblack){
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		float m = (float)size / 20;
		for(int i = 0; i < str.length(); i++){
			int fontx = x.get((int)str.charAt(i));
			int fonty = y.get((int)str.charAt(i));
			int fontwidth = width.get((int)str.charAt(i));
			float texx1 = fontx/2048F;
			float texx2 = (fontx+fontwidth)/2048F;
			float texy1 = fonty/2048F;
			float texy2 = (fonty+koreanheight)/2048F;
			int he = (int) (koreanheight*m);
			RenderingHelper.RenderQuadangleXY((int)x1, (int)y1, (int)(fontwidth*m), (int)(he), whiteorblack ? kor_white : kor_black, texx1, texy1, texx2, texy2);
			x1 += fontwidth*m;
		}
		GL11.glDisable(GL11.GL_BLEND);
	}
}
