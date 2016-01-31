package com.n7484443.los.input;

public class Key {
	public int key;
	public boolean state;
	// 0 = none 1 = held;
	public Key(int key){
		this.key = key;
		this.state = false;
	}
	
	public void setEvent(boolean b){
		if(b)this.setPressed();
		else this.setReleased();
	}
	
	public void setPressed(){
		PressedEvent();
	}
	
	public void setReleased(){
		RealeasedEvent();
	}
	
	public boolean getState(){
		return state;
	}
	
	public void PressedEvent(){
		state = true;
		KeyboardInputEvent.PressedEvent(key);
	}
	
	public void RealeasedEvent(){
		state = false;
		KeyboardInputEvent.RealeasedEvent(key);
	}
	
	public void HoldingEvent(){
		if(state){
			KeyboardInputEvent.HoldingEvent(key);
		}
	}
	
}
