package com.n7484443.los.gui;

import static com.n7484443.los.render.RenderingHelper.RenderQuadangleXY;
import static com.n7484443.los.render.RenderingHelper.RenderText;

import org.newdawn.slick.Color;

import com.n7484443.los.develop.EvolutionS;
import com.n7484443.los.render.FontRenderer;

public class GuiSetting extends GuiBase{

	public ButtonPage[] Page;
	public ButtonPage Menu;
	public LabbelPage[] labbel;
	public int nowPage;
	
	public GuiSetting(int x, int y, int width, int height, int gui) {
		super(x, y, width, height, gui, gui, false);
	}

	public void init() {
		int a = 158;
		nowPage = 0;
		Page = new ButtonPage[6];
		for(int i = 0; i < Page.length; i++){
			Page[i] = new ButtonPage();
		}
		labbel = new LabbelPage[6];
		for(int i = 0; i < Page.length; i++){
			labbel[i] = new LabbelPage();
		}
		Menu = new ButtonPage();
		Menu.Buttons.add(new ButtonBase(x + 3, y + 3, a, 50, gui, 0, false, "돌아가기", 0));
		Menu.Buttons.add(new ButtonBase(x + 3 + 1 + a, y + 3, a, 50, gui, 1, false, "그래픽 설정", 0));
		Menu.Buttons.add(new ButtonBase(x + 3 + 2 + a * 2, y + 3, a, 50, gui, 2, false, "사운드 설정", 0));
		Menu.Buttons.add(new ButtonBase(x + 3 + 3 + a * 3, y + 3, a, 50, gui, 3, false, "키 설정", 0));
		Menu.Buttons.add(new ButtonBase(x + 3 + 4 + a * 4, y + 3, a, 50, gui, 4, false, "게임 저장", 0));
		Menu.Buttons.add(new ButtonBase(x + 3 + 5 + a * 5, y + 3, a, 50, gui, 5, false, "메뉴", 0));
		//Page[1].Buttons.add(new ButtonBase(x + 3, y + height / 2 - a / 2, a, 50, gui, 0, false, "창 크기 변경", 2));
		
		labbel[1].Labbels.add(new LabbelBase(x + 3, y + height / 2 - a / 2, a, 50, "창 크기 변경"));
	}

	public ButtonPage getButtonPage() {
		return Page[nowPage];
	}
	
	public LabbelPage getLabbelPage() {
		return labbel[nowPage];
	}

	public ButtonPage getGuiButtonPage() {
		return Menu;
	}

	public void updateButton(int num, int page) {
		switch (page) {
		case 0: 
			if (num == 0){
				GuiS.reverseGui(gui);
			}else if (num < 6) {
				Menu.Buttons.get(1).onoff = false;
				Menu.Buttons.get(2).onoff = false;
				Menu.Buttons.get(3).onoff = false;
				Menu.Buttons.get(4).onoff = false;
				Menu.Buttons.get(5).onoff = false;
				Menu.Buttons.get(num).onoff = true;
				nowPage = num;
			}
			break;
		case 2:
			if (num == 0 && Page[1].Buttons.get(0).onoff == false) {
				Page[1].Buttons.get(0).onoff = true;
				EvolutionS.Evolutioned(0);
			}
			break;
		}
	}

	public void BeforeRender() {
		Color.black.bind();
		RenderQuadangleXY(x, y, width, height, null);
		for (ButtonBase button : Menu.Buttons) {
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
			RenderQuadangleXY(button.x, button.y, button.width, button.height, null);
			RenderText(button.x + button.width/2 - FontRenderer.getSize(button.getString())/2, button.y, button.getString());
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
			RenderQuadangleXY(button.x, button.y, button.width, button.height, null);
			RenderText(button.x + button.width/2 - FontRenderer.getSize(button.getString())/2, button.y, button.getString());
		}
		
		for (LabbelBase labbel : getLabbelPage().Labbels) {
			if (labbel != null){
				Color.black.bind();
				RenderQuadangleXY(labbel.x, labbel.y, labbel.width, labbel.height, null);
				RenderText(labbel.x + labbel.width/2 - FontRenderer.getSize(labbel.getLabel())/2, labbel.y, labbel.getLabel());
			}
		}
	}

	public void AfterRender() {
	}
}
