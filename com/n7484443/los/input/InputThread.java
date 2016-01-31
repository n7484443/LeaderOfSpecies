package com.n7484443.los.input;

import com.n7484443.los.main.Core;

public class InputThread extends Thread{
	public void run(){
		try {
			while(!Core.DiplayCreated){
				Thread.sleep(100);
			}
			
		} catch (InterruptedException e2) {
		}
		KeyboardInputEvent.init();
		MouseInputEvent.init();
		while(Core.Loop){
			KeyboardInputEvent.Update();
			MouseInputEvent.Update();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
		}
	}
}
