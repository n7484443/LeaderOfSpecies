package com.n7484443.los.render;

import static org.lwjgl.opengl.GL11.*;
import static com.n7484443.los.math.MathS.*;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.*;

public class RenderingHelper {
	public static void RenderLine(int x1, int y1, int x2, int y2) {
		glBegin(GL_LINE_STRIP);
		glVertex2i(x1, y1);
		glVertex2i(x2, y2);
		glEnd();
	}
	
	public static void RenderLine(double x1, double y1, double x2, double y2) {
		glBegin(GL_LINE_STRIP);
		glVertex2d(x1, y1);
		glVertex2d(x2, y2);
		glEnd();
	}
	
	public static void RenderLine(float x1, float y1, float x2, float y2) {
		glBegin(GL_LINE_STRIP);
		glVertex2f(x1, y1);
		glVertex2f(x2, y2);
		glEnd();
	}
	
	public static void RenderHexagon(float x1, float y1, float size) {
		glBegin(GL_LINE_LOOP);
		glVertex2f(x1, y1);
		glVertex2f(x1+size, y1+size*sqrt3);
		glVertex2f(x1+size*3, y1+size*sqrt3);
		glVertex2f(x1+size*4, y1);
		glVertex2f(x1+size*3, y1-size*sqrt3);
		glVertex2f(x1+size, y1-size*sqrt3);
		glEnd();
	}
	
	public static void RenderPackedHexagon(float x1, float y1, float size) {
		glBegin(GL_TRIANGLE_FAN);
		glVertex2f(x1, y1);
		glVertex2f(x1+size, y1+size*sqrt3);
		glVertex2f(x1+size*3, y1+size*sqrt3);
		glVertex2f(x1+size*4, y1);
		glVertex2f(x1+size*3, y1-size*sqrt3);
		glVertex2f(x1+size, y1-size*sqrt3);
		glEnd();
	}
	
	public static void RenderHexagonWithCenter(float x1, float y1, float size) {
		x1 -= size*sqrt3/2 + size;
		glBegin(GL_LINE_LOOP);
		glVertex2f(x1, y1);
		glVertex2f(x1+size, y1+size*sqrt3);
		glVertex2f(x1+size*3, y1+size*sqrt3);
		glVertex2f(x1+size*4, y1);
		glVertex2f(x1+size*3, y1-size*sqrt3);
		glVertex2f(x1+size, y1-size*sqrt3);
		glEnd();
	}
	
	public static void RenderPackedHexagonWithCenter(float x1, float y1, float size) {
		x1 -= size*sqrt3/2 + size;
		glBegin(GL_TRIANGLE_FAN);
		glVertex2f(x1, y1);
		glVertex2f(x1+size, y1+size*sqrt3);
		glVertex2f(x1+size*3, y1+size*sqrt3);
		glVertex2f(x1+size*4, y1);
		glVertex2f(x1+size*3, y1-size*sqrt3);
		glVertex2f(x1+size, y1-size*sqrt3);
		glEnd();
	}
	
	public static void RenderCircle(int x1, int y1, int c, int size, int border) {
		glBegin(GL_LINE_LOOP);
		for (int i = 0; i <= c; i++) {
			double angle = Math.PI * 2 * i / c;
			double x = Math.cos(angle);
			double y = Math.sin(angle);
			glVertex2d(x1 + x * size, y1 + y * size);
		}
		glEnd();
	}
	
	public static void RenderCircle(float x1, float y1, int c, int size, int border) {
		glBegin(GL_LINE_LOOP);
		for (int i = 0; i <= c; i++) {
			double angle = Math.PI * 2 * i / c;
			double x = Math.cos(angle);
			double y = Math.sin(angle);
			glVertex2d(x1 + x * size, y1 + y * size);
		}
		glEnd();
	}

	public static void RenderCircle(int x1, int y1, int size) {
		glBegin(GL_LINE_LOOP);
		for (int i = 0; i <= 100; i++) {
			double angle = Math.PI * 2 * i / 100;
			double x = Math.cos(angle);
			double y = Math.sin(angle);
			glVertex2d(x1 + x * size, y1 + y * size);
		}
		glEnd();
	}

	public static void RenderPackedCircle(int x1, int y1, int size) {
		glBegin(GL_TRIANGLE_FAN);
		for (int i = 0; i <= 100; i++) {
			double angle = Math.PI * 2 * i / 100;
			double x = Math.cos(angle);
			double y = Math.sin(angle);
			glVertex2d(x1 + x * size, y1 + y * size);
		}
		glEnd();
	}

	public static void RenderQuadangle(int x, int y, int xsize, int ysize, Texture texture) {
		if (texture == null) {
			glDisable(GL_TEXTURE_2D);
			glBegin(GL_QUADS);
			glVertex2d(x - xsize / 2, y - ysize / 2);
			glVertex2d(x + xsize / 2, y - ysize / 2);
			glVertex2d(x + xsize / 2, y + ysize / 2);
			glVertex2d(x - xsize / 2, y + ysize / 2);
			glEnd();
		} else {
			glEnable(GL_TEXTURE_2D);
			texture.bind();
			glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex2d(x - xsize / 2, y - ysize / 2);
			glTexCoord2f(texture.getWidth(), 0);
			glVertex2d(x + xsize / 2, y - ysize / 2);
			glTexCoord2f(texture.getWidth(), texture.getHeight());
			glVertex2d(x + xsize / 2, y + ysize / 2);
			glTexCoord2f(0, texture.getHeight());
			glVertex2d(x - xsize / 2, y + ysize / 2);
			glEnd();
		}
	}

	public static void RenderQuadangleXY(int x, int y, int xsize, int ysize, Texture texture) {
		if (texture == null) {
			glDisable(GL_TEXTURE_2D);
			glBegin(GL_QUADS);
			glVertex2d(x, y);
			glVertex2d(x + xsize, y);
			glVertex2d(x + xsize, y + ysize);
			glVertex2d(x, y + ysize);
			glEnd();
		} else {
			glEnable(GL_TEXTURE_2D);
			texture.bind();
			glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex2d(x, y);
			glTexCoord2f(texture.getWidth(), 0);
			glVertex2d(x + xsize, y);
			glTexCoord2f(texture.getWidth(), texture.getHeight());
			glVertex2d(x + xsize, y + ysize);
			glTexCoord2f(0, texture.getHeight());
			glVertex2d(x, y + ysize);
			glEnd();
		}
	}
	
	public static void RenderQuadangleXY(float x, float y, int xsize, int ysize, Texture texture) {
		if (texture == null) {
			glDisable(GL_TEXTURE_2D);
			glBegin(GL_QUADS);
			glVertex2d(x, y);
			glVertex2d(x + xsize, y);
			glVertex2d(x + xsize, y + ysize);
			glVertex2d(x, y + ysize);
			glEnd();
		} else {
			glEnable(GL_TEXTURE_2D);
			texture.bind();
			glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex2d(x, y);
			glTexCoord2f(texture.getWidth(), 0);
			glVertex2d(x + xsize, y);
			glTexCoord2f(texture.getWidth(), texture.getHeight());
			glVertex2d(x + xsize, y + ysize);
			glTexCoord2f(0, texture.getHeight());
			glVertex2d(x, y + ysize);
			glEnd();
		}
	}

	public static void RenderQuadangleXY(int x, int y, int xsize, int ysize, Texture texture, float texx1, float texy1,
			float texx2, float texy2) {
		if (texture == null) {
			glDisable(GL_TEXTURE_2D);
			glBegin(GL_QUADS);
			glVertex2d(x, y);
			glVertex2d(x + xsize, y);
			glVertex2d(x + xsize, y + ysize);
			glVertex2d(x, y + ysize);
			glEnd();
		} else {
			glEnable(GL_TEXTURE_2D);
			texture.bind();
			glBegin(GL_QUADS);
			glTexCoord2f(texx1, texy1);
			glVertex2d(x, y);
			glTexCoord2f(texx2, texy1);
			glVertex2d(x + xsize, y);
			glTexCoord2f(texx2, texy2);
			glVertex2d(x + xsize, y + ysize);
			glTexCoord2f(texx1, texy2);
			glVertex2d(x, y + ysize);
			glEnd();
		}
	}

	public static void RenderText(int x, int y, String str) {
		FontRenderer.render(x, y, str, true);
	}
	
	public static void RenderText(float x, float y, String str) {
		FontRenderer.render(x, y, str, true);
	}
	
	public static void RenderText(int x, int y, String str, boolean t) {
		FontRenderer.render(x, y, str, t);
	}
	
	public static void RenderText(int x, int y, String str, int size, boolean t) {
		FontRenderer.renderReSizeable(x, y, size, str, t);
	}
	
	public static void RenderText(int x, int y, String str, int size, float alpha, boolean t) {
		FontRenderer.renderReSizeable(x, y, size, str, alpha, t);
	}
	
	
	public static void RenderText(float x, float y, String str, int size, float alpha, boolean t) {
		FontRenderer.renderReSizeable(x, y, size, str, alpha, t);
	}

	public static void SetColor(int r, int g, int b, int alpha) {
		if (alpha == -1) {
			glColor3f(r, g, b);
		} else {
			glColor4f(r, g, b, alpha);
		}
	}
	
	public static void SetLineBorder(float f){
		glLineWidth(f);
	}

	public static void SetBlendMode(boolean b) {
		if (b) {
			glEnable(GL_BLEND);
			glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		} else {
			glDisable(GL_BLEND);
		}
	}

}
