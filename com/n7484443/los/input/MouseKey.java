package com.n7484443.los.input;

public class MouseKey {
	public int key;
	public boolean state;
	public int beforex;
	public int beforey;
	public int movex;
	public int movey;
	public boolean draged;
	// 0 = none 1 = held;
	//before -1 : none
	public MouseKey(int key){
		this.key = key;
		this.state = false;
		draged = false;
		beforex = -1;
		beforey = -1;
		movex = 0;
		movey = 0;
	}
	
	public void setEvent(boolean b, int x, int y){
		if(b)this.setPressed(x, y);
		else this.setReleased(x, y);
	}
	
	public void setPressed(int x, int y){
		beforex = x;
		beforey = y;
		movex = 0;
		movey = 0;
		PressedEvent(x, y);
	}
	
	public void setReleased(int x, int y){
		beforex = -1;
		beforey = -1;
		RealeasedEvent(x, y);
		movex = 0;
		movey = 0;
		draged = false;
	}
	
	public boolean getState(){
		return state;
	}
	
	public void PressedEvent(int x, int y){
		state = true;
		MouseInputEvent.PressedEvent(key, x, y);
	}
	
	public void RealeasedEvent(int x, int y){
		state = false;
		MouseInputEvent.RealeasedEvent(key, x, y);
	}
	
	public void HoldingEvent(int x, int y){
		if(state){
			if(Math.abs(movex) + Math.abs(movey) <= 3){
				MouseInputEvent.HoldingEvent(key, x, y);
			}
		}
	}
	
	public void DragingEvent(int x, int y){
		if(state){
			if(Math.abs(movex) + Math.abs(movey) > 3){
				draged = true;
				MouseInputEvent.DragingEvent(key, beforex, beforey, x, y);
			}
		}
	}
	
	public void UpdateMove(int dx, int dy){
		movex += dx;
		movey += dy;
	}
}
