package com.n7484443.los.gui;

import static com.n7484443.los.render.RenderingHelper.RenderQuadangleXY;

import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.*;

import com.n7484443.los.render.*;

public class GuiBase{
	public int x;
	public int y;
	public int gui;
	public int width;
	public int height;
	public int texture;
	public boolean visible;
	public boolean entityAble;
	public GuiBase(int x, int y, int width, int height, int texture, int gui, boolean entityAble) {
		this.x = x;
		this.y = y;
		this.gui = gui;
		this.width = width;
		this.height = height;
		this.texture = texture;
		this.visible = false;
		this.entityAble = entityAble;
	}
	
	public void updateButton(int num, int Page) {}
	public ButtonPage getButtonPage() {
		return null;
	}
	public ButtonPage getGuiButtonPage() {
		return null;
	}

	public void init() {}
	
	public Texture getTexture() {
		if(texture != -1){
			return TextureHelper.GuiTexture[texture];
		}else{
			return null;
		}
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	
	
	public void setVisible(boolean b) {
		this.visible = b;
	}
	
	public boolean getVisible() {
		return this.visible;
	}
	
	public void GuiRender(){
		Color.white.bind();
		RenderQuadangleXY(x, y, width, height, getTexture());
	}
	public void BeforeRender(){}
	public void AfterRender(){}
	public void DoSomething(){}
}
