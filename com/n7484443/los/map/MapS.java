package com.n7484443.los.map;

import com.n7484443.los.render.RenderThread;

public class MapS {
	public static MapBase[] map;
	public static int nowMap;
	public MapS(){
		init();
		nowMap = 0;
	}
	public static void init(){
		map = new MapBase[1];
		map[0] = new MapUnderSea(RenderThread.DisplayWidth, RenderThread.DisplayHeight);
	}
	public static void update(){
		map[nowMap].CheckEntity();
	}
	public static MapBase getMap(int i){
		return map[i];
	}
	
	public static MapBase getNowMap(){
		return map[nowMap];
	}
}
