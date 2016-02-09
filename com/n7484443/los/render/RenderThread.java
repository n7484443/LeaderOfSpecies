package com.n7484443.los.render;

import static org.lwjgl.opengl.GL11.*;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import static com.n7484443.los.render.RenderingHelper.*;

import org.lwjgl.*;
import org.lwjgl.opengl.*;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.jinput.LWJGLEnvironmentPlugin;
import org.newdawn.slick.Color;

import com.n7484443.los.entity.*;
import com.n7484443.los.gui.*;
import com.n7484443.los.main.*;
import com.n7484443.los.map.*;

public class RenderThread extends Thread {
	TextureHelper textureHelper;
	long firsttime;
	long fpslimit = 1000 / 60;
	int loop;
	public static final int DisplayWidth = Display.getDesktopDisplayMode().getWidth();
	public static final int DisplayHeight = Display.getDesktopDisplayMode().getHeight();

	public void run() {
		DisplayInit(DisplayWidth, DisplayHeight);
		Core.DiplayCreated = true;
		textureHelper = new TextureHelper();
		try {
			FontRenderer.init();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		loop = 0;
		while (Core.Loop) {
			Core.RenderEnd = false;
			firsttime = System.currentTimeMillis();
			glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			glColor3f(0.5f, 0.5f, 1.0f);
			RenderMap();
			RenderGui();
			Display.update();
			Display.sync(60);

			if (loop % 30 == 0 && (System.currentTimeMillis() - firsttime) > 0)
				Display.setTitle("fps:" + 1000 / (System.currentTimeMillis() - firsttime) + "cps:" + Core.CircuitTime);
			if (System.currentTimeMillis() - firsttime < fpslimit) {
				try {
					Thread.sleep(fpslimit - (System.currentTimeMillis() - firsttime));
				} catch (InterruptedException e) {
				}
			}
			Core.RenderEnd = true;
			loop++;
		}

		DisplayEnd();
	}

	public void RenderEntity(int gui) {
		if (GuiS.getGui(gui).visible) {
			SetBlendMode(true);
			MapBase map = MapS.getNowMap();

			for (int i = 0; i < map.getEntityS().size(); i++) {
				if (map.getEntityS().get(i) != null) {
					EntityBase entity = map.getEntityS().get(i);
					SetColor(1, 1, 1, -1);
					// RenderQuadrangle(entity.x, entity.y, entity.width,
					// entity.height,
					// TextureHelper.EntityTexture[entity.texture]);
					entity.RenderingEntity();
				}
			}
		}
	}

	public void RenderMap() {
	}

	public void RenderGui() {
		for (int i = 0; i < GuiS.guis.length; i++) {
			GuiBase gui = GuiS.getGui(i);
			if (gui.getVisible()) {
				Color.white.bind();
				RenderQuadangleXY(gui.getX(), gui.getY(), gui.getWidth(), gui.getHeight(), gui.getTexture());
				gui.BeforeRender();
				if (gui.entityAble) {
					RenderEntity(i);
				}
				gui.AfterRender();
			}
		}
	}

	public static void DisplayInit(int width, int height) {
		try {
			DisplayMode DisplayModes = Display.getDesktopDisplayMode();
			System.out.println(DisplayModes);
			DisplayMode disp = DisplayModes;
			Display.create(new PixelFormat(32, 0, 24, 0, 2));
			Display.setFullscreen(true);
			Display.setResizable(true);
			Display.setTitle("LeaderOfSpecies");
			Display.setDisplayMode(new DisplayMode(disp.getWidth(), disp.getHeight()));

			glMatrixMode(GL_PROJECTION);
			glLoadIdentity();
			glOrtho(0, width, height, 0, 1, -1);
			glMatrixMode(GL_MODELVIEW);
			System.out.println("OpenGL version: " + GL11.glGetString(GL11.GL_VERSION));
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}

	public static void DisplayEnd() {
		Display.destroy();
	}
}
