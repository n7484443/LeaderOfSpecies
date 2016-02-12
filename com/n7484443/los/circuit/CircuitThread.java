package com.n7484443.los.circuit;

import com.n7484443.los.entity.*;
import com.n7484443.los.main.*;
import com.n7484443.los.map.*;
import com.n7484443.los.savedata.SaveDataThread;

public class CircuitThread extends Thread{
	public final long fps = 1000/60;
	public long nowfps;
	public int counter = 0;
	public boolean flag;
	public void run(){
		new CellEntity(MapS.map[0].width/2,MapS.map[0].height/2, 64, MapS.map[0]);
		//Random r = new Random();
		//for(int i = 0; i <1000; i++){
		//	new Dust(1+r.nextInt(MapS.map[0].width-1),1+r.nextInt(MapS.map[0].height-1), (r.nextInt(10)*3), MapS.map[0]);
		//}
		//CellEntity cell = new CellEntity(100, 400, 64, MapS.map[0]);
		//flag = false;
		while(Core.Loop){
			nowfps = System.currentTimeMillis();
			for(int i = 0; i < MapS.map.length; i++){
					MapS.map[i].CheckEntity();
			}
			
			if(counter % 3600000 == 0){
				SaveDataThread sdt = new SaveDataThread();
				sdt = new SaveDataThread();
				sdt.run();
			}
			
			if((System.currentTimeMillis() - nowfps)>0){
				Core.CircuitTime = (int)(1000/(System.currentTimeMillis() - nowfps));
			}else{
				Core.CircuitTime = -1;
			}
			if(System.currentTimeMillis() - nowfps < fps){
				try {
					sleep(fps-(System.currentTimeMillis() - nowfps));
				} catch (InterruptedException e) {
				}
			}
			counter++;
			/*if(cell.x >= cell.map.width){
				flag = true;
			}else if(cell.x <= 0){
				flag = false;
			}
			cell.x += (flag ? -2 : 2);*/
		}
	}
	
	
}
