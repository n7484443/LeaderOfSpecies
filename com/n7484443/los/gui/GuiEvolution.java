package com.n7484443.los.gui;

import static com.n7484443.los.render.RenderingHelper.*;

import org.newdawn.slick.Color;

import com.n7484443.los.evolution.*;
import com.n7484443.los.math.MathS;
import com.n7484443.los.render.*;

public class GuiEvolution extends GuiBase {

	public ButtonPage[] Page;
	public ButtonPage up;
	public int nowPage;
	public int mouseonButton;
	public int ownxhex = 50;
	public int ownyhex = 160;
	public int size = 25;
	
	public GuiEvolution(int x, int y, int width, int height, int gui) {
		super(x, y, width, height, gui, gui, false);
	}

	public void init() {
		mouseonButton = 0;
		int a = (RenderThread.DisplayWidth - 2) / 6;
		nowPage = 0;
		Page = new ButtonPage[6];
		for (int i = 0; i < Page.length; i++) {
			Page[i] = new ButtonPage();
		}
		up = new ButtonPage();
		up.Buttons.add(new ButtonBase(x + 1, y + 3, a, 50, gui, 0, "개요", 0));
		up.Buttons.add(new ButtonBase(x + 1 + 1 + a, y + 3, a, 50, gui, 1, "돌연변이", 0));
		up.Buttons.add(new ButtonBase(x + 1 + 2 + a * 2, y + 3, a, 50, gui, 2, "생명력", 0));
		up.Buttons.add(new ButtonBase(x + 1 + 3 + a * 3, y + 3, a, 50, gui, 3, "번식력", 0));
		up.Buttons.add(new ButtonBase(x + 1 + 4 + a * 4, y + 3, a, 50, gui, 4, "유전 방식", 0));
		up.Buttons.add(new ButtonBase(x + 1 + 5 + a * 5, y + 3, a, 50, gui, 5, "진화 방향", 0));
		float xhex = ownxhex;
		float yhex = ownyhex;
		int w = 8;
		int h = 8;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				Page[1].Buttons.add(new ButtonHexagon(x + xhex, y + yhex, size - 3, gui, i * w + j, null, 2).setOneTimeClick());
				xhex += size * 3;
				yhex += MathS.sqrt3 * size * (j % 2 == 0 ? -1 : 1);
			}
			yhex += MathS.sqrt3 * size * (h % 2 == 0 ? 2 : 3);
			xhex -= size * 3 * h;
		}
		
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
			if (Page[1].getButton(num).onoff == false) {
				if (EvolutionS.Evolution(num).isEvolutioned()) {
					Page[1].getButton(num).onoff = true;
					EvolutionS.Evolutioned(num);
				}
			}
			break;
		}
	}

	public void GuiRender() {
		ColorS.GlassGreen.bind();
		RenderQuadangleXY(x, y, width, height, getTexture());
	}

	public void BeforeRender() {
		SetBlendMode(false);
		if (nowPage == 1) {
			float xhex = ownxhex;
			float yhex = ownyhex;
			int w = 8;
			int h = 8;
			for (int i = 0; i < w; i++) {
				for (int j = 0; j < h; j++) {
					Color.black.bind();
					RenderPackedHexagonWithCenter(x + xhex, y + yhex, size);
					Color.white.bind();
					RenderPackedHexagonWithCenter(x + xhex, y + yhex, size - 1);
					xhex += size * 3;
					yhex += MathS.sqrt3 * size * (j % 2 == 0 ? -1 : 1);
				}
				yhex += MathS.sqrt3 * size * (h % 2 == 0 ? 2 : 3);
				xhex -= size * 3 * h;
			}
		}
		SetBlendMode(false);
		for (ButtonBase button : up.Buttons) {
			if (button != null) {
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
		if (nowPage == 1) {
			for (ButtonBase button : getButtonPage().Buttons) {
				if (button != null) {
					if (button.state) {
						mouseonButton = button.num;
					}
					if(button.onoff){
						Color.cyan.bind();
					}else if(!EvolutionS.Evolution(button.num).isEvolutioned()){
						if (button.state) {
							Color.pink.bind();
						} else {
							Color.red.bind();
						}
					}else{
						if (button.state) {
							Color.darkGray.bind();
						} else {
							Color.gray.bind();
						}
					}
					button.RenderButton();
				}
			}
		}else{
			for (ButtonBase button : getButtonPage().Buttons) {
				if (button != null) {
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
		}
		ExplainRender();
		
	}
	
	public void ExplainRender(){
		Color.black.bind();
		RenderQuadangleXY(0, height-110, width, 10, null);
		Color.white.bind();
		RenderQuadangleXY(0, height-100, width, 100, null);
		Color.black.bind();
		if(nowPage == 1 && mouseonButton >= 0 && EvolutionS.Evolution(mouseonButton) != null && EvolutionS.Evolution(mouseonButton).str != null){
			RenderText(20, height-90, EvolutionS.Evolution(mouseonButton).str, 16, false);
			if(EvolutionS.Evolution(mouseonButton).explain != null)
			RenderText(20, height-60, EvolutionS.Evolution(mouseonButton).explain, 12, false);
		}
	}

	public void AfterRender() {
		Color.black.bind();
		RenderPackedCircle(x + width - 64 - 20, y + 128 + 64, 90);
		Color.white.bind();
		RenderPackedCircle(x + width - 64 - 20, y + 128 + 64, 85);
		SetBlendMode(true);
		RenderQuadangleXY(x + width - 128 - 20, y + 128, 32, 32,
				TextureHelper.EntityTexture[EvolutionS.EntityCellImageEvolution()]);
		RenderQuadangleXY(x + width - 128 - 20, y + 128 + 110, 16, 16,
				TextureHelper.EntityTexture[EvolutionS.EntityCellImageEvolution()]);
		RenderQuadangleXY(x + width - 128 - 20, y + 128, 128, 128,
				TextureHelper.EntityTexture[EvolutionS.EntityCellImageEvolution()]);

	}
}
