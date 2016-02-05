package com.n7484443.los.gui;

import static com.n7484443.los.render.RenderingHelper.RenderQuadangleXY;
import static com.n7484443.los.render.RenderingHelper.RenderText;
import static com.n7484443.los.render.RenderingHelper.SetBlendMode;

import org.newdawn.slick.Color;

import com.n7484443.los.develop.EvolutionS;
import com.n7484443.los.render.FontRenderer;
import com.n7484443.los.render.RenderThread;
import com.n7484443.los.render.RenderingHelper;
import com.n7484443.los.render.TextureHelper;

public class GuiEvolution extends GuiBase {

	public ButtonPage[] Page;
	public ButtonPage up;
	public int nowPage;

	public GuiEvolution(int x, int y, int width, int height, int gui) {
		super(x, y, width, height, gui, gui, false);
	}

	public void init() {
		int a = (RenderThread.DisplayWidth-2)/6;
		nowPage = 0;
		Page = new ButtonPage[6];
		for(int i = 0; i < Page.length; i++){
			Page[i] = new ButtonPage();
		}
		up = new ButtonPage();
		up.Buttons.add(new ButtonBase(x + 1, y + 3, a, 50, gui, 0, false, "개요", 0));
		up.Buttons.add(new ButtonBase(x + 1 + 1 + a, y + 3, a, 50, gui, 1, false, "돌연변이", 0));
		up.Buttons.add(new ButtonBase(x + 1 + 2 + a * 2, y + 3, a, 50, gui, 2, false, "생명력", 0));
		up.Buttons.add(new ButtonBase(x + 1 + 3 + a * 3, y + 3, a, 50, gui, 3, false, "번식력", 0));
		up.Buttons.add(new ButtonBase(x + 1 + 4 + a * 4, y + 3, a, 50, gui, 4, false, "유전 방식", 0));
		up.Buttons.add(new ButtonBase(x + 1 + 5 + a * 5, y + 3, a, 50, gui, 5, false, "진화 방향", 0));
		Page[1].Buttons.add(new ButtonBase(x + 3, y + height / 2 - a / 2, a, 50, gui, 0, true, "핵막 생성", 2));
		up.Buttons.get(0).onoff = true;
	}

	public ButtonPage getButtonPage() {
		return Page[nowPage];
	}

	public ButtonPage getGuiButtonPage() {
		return up;
	}

	public void updateButton(int num, int page) {
		switch (page) {
		case 0: 
			if (num < 6) {
				up.setButton(0, false);
				up.setButton(1, false);
				up.setButton(2, false);
				up.setButton(3, false);
				up.setButton(4, false);
				up.setButton(5, false);
				up.setButton(num, true);
				nowPage = num;
			}
			break;
		case 2:
			if (num == 0 && Page[1].Buttons.get(0).onoff == false) {
				Page[1].Buttons.get(0).onoff = true;
			}
			break;
		}
	}

	public void BeforeRender() {
		for (ButtonBase button : up.Buttons) {
			if (button != null){
				if (!button.onoff) {
					if (button.state) {
						Color.darkGray.bind();
					} else {
						Color.gray.bind();
					}
				} else {
					if (button.state) {
						Color.black.bind();
					} else {
						Color.darkGray.bind();
					}
				}
			}
			button.RenderButton();
		}
		for (ButtonBase button : getButtonPage().Buttons) {
			if (button != null)
				if (!button.onoff) {
					if (button.state) {
						Color.darkGray.bind();
					} else {
						Color.gray.bind();
					}
				} else {
					if (button.state) {
						Color.black.bind();
					} else {
						Color.darkGray.bind();
					}
				}
			button.RenderButton();
		}
	}

	public void AfterRender() {
		Color.black.bind();
		RenderingHelper.RenderPackedCircle(x + width - 64 - 20, y + 128 + 64, 90);
		Color.white.bind();
		RenderingHelper.RenderPackedCircle(x + width - 64 - 20, y + 128 + 64, 85);
		SetBlendMode(true);
		RenderingHelper.RenderQuadangleXY(x + width - 128 - 20, y + 128, 32, 32,
				TextureHelper.EntityTexture[EvolutionS.EntityCellImageEvolution()]);
		RenderingHelper.RenderQuadangleXY(x + width - 128 - 20, y + 128 + 110, 16, 16,
				TextureHelper.EntityTexture[EvolutionS.EntityCellImageEvolution()]);
		RenderingHelper.RenderQuadangleXY(x + width - 128 - 20, y + 128, 128, 128,
				TextureHelper.EntityTexture[EvolutionS.EntityCellImageEvolution()]);
	}
}
