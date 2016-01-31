package com.n7484443.los.savedata;

public class SaveDataThread extends Thread{
	public void run(){
		saveData();
	}
	
	public void saveData(){
		System.out.println("자동저장 되었습니다.");
	}
}
