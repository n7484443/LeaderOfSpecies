package com.n7484443.los.map;

public class MapUnderSea extends MapBase{
	public static int F;
	public static int i = 0;
	public MapUnderSea(int width, int height) {
		super(width, height);
		F = 100000;
		i = 0;
	}

	public void afterDo(){
		if(i % 60 == 0){
			F+= 10;
		}
		i++;
	}
	

}
