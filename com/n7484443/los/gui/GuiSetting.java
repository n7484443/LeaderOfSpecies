package com.n7484443.los.gui;

import static com.n7484443.los.render.RenderingHelper.RenderQuadangleXY;
import static com.n7484443.los.render.RenderingHelper.RenderText;

import org.newdawn.slick.Color;

import com.n7484443.los.develop.EvolutionS;
import com.n7484443.los.main.Core;
import com.n7484443.los.render.FontRenderer;
import com.n7484443.los.render.RenderThread;
import com.n7484443.los.savedata.SaveDataThread;

public class GuiSetting extends GuiBase{

	public ButtonPage[] Page;
	public ButtonPage Menu;
	public LabbelPage[] labbel;
	public int nowPage;
	public int Buttonnum;
	
	public GuiSetting(int x, int y, int width, int height, int gui) {
		super(x, y, width, height, gui, gui, false);
		Buttonnum = 6;
	}

	public void init() {
		int a = (RenderThread.DisplayWidth)/(Buttonnum+1);
		int space = a/(Buttonnum+1);
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
		Menu.Buttons.add(new ButtonBase(x + space, y + space, a, 50, gui, 0, "돌아가기", 0));
		Menu.Buttons.add(new ButtonBase(x + space*2 + a, y + space, a, 50, gui, 1, "그래픽 설정", 0));
		Menu.Buttons.add(new ButtonBase(x + space*3 + a * 2, y + space, a, 50, gui, 2, "사운드 설정", 0));
		Menu.Buttons.add(new ButtonBase(x + space*4 + a * 3, y + space, a, 50, gui, 3, "키 설정", 0));
		Menu.Buttons.add(new ButtonBase(x + space*5 + a * 4, y + space, a, 50, gui, 4, "게임 저장", 0));
		Menu.Buttons.add(new ButtonBase(x + space*6 + a * 5, y + space, a, 50, gui, 5, "메뉴", 0));
		//Page[1].Buttons.add(new ButtonBase(x + 3, y + height / 2 - a / 2, a, 50, gui, 0, false, "창 크기 변경", 2));
		
		labbel[1].Labbels.add(new LabbelBase(x + 3, y + height / 2 - a / 2, a, 50, "창 크기 변경"));
		Page[1].Buttons.add(new ButtonScroll(x + 3 + space *2 + a, y + height / 2 - a / 2, a, 50, gui, 0, new String[]{"창 크기 변경", "창 크기"}, 1));
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
				Menu.Buttons.get(1).onoff = false;
				Menu.Buttons.get(2).onoff = false;
				Menu.Buttons.get(3).onoff = false;
				Menu.Buttons.get(4).onoff = false;
				Menu.Buttons.get(5).onoff = false;
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
		
		case 4:
			SaveDataThread sdt = new SaveDataThread();
			sdt = new SaveDataThread();
			sdt.run();
			break;
		}
	}

	public void BeforeRender() {
		Color.lightGray.bind();
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
			button.Render();
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
			button.Render();
		}
		
		for (LabbelBase labbel : getLabbelPage().Labbels) {
			if (labbel != null){
				Color.lightGray.bind();
				labbel.Render();
			}
		}
	}

	public void AfterRender() {
	}
}
