package com.n7484443.los.entity;

import com.n7484443.los.map.MapBase;

public class EntityBase {
	public enum State{STOPED, MOVING, WILLDELETE};
	public State nowstate;
	public float x;
	public float y;
	public int width;
	public int height;
	public float xScale = 1;
	public float yScale = 1;
	public int id;
	public MapBase map;
	public int texture;
	public EntityBase(int x, int y, int width, int height, MapBase map, int image){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.map = map;
		this.map.EntityCreate(this);
		this.texture = image;
		this.nowstate = State.MOVING;
	}
	public EntityBase(int x, int y, int width, int height, float xScale, float yScale, MapBase map){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.xScale = xScale;
		this.yScale = yScale;
		this.map = map;
		this.map.EntityCreate(this);
		this.nowstate = State.MOVING;
	}
	public void EntityDelete(){
		nowstate = State.WILLDELETE;
	}
	
	public void EntityDisable(){
		nowstate = State.STOPED;
	}
	
	public void EntityAble(){
		nowstate = State.MOVING;
	}
	
	public void EntityCreateEvent(){}
	
	public void EntityDeleteEvent(){}
	
	public void update(){}
	public void CheckIsOut(){
		if(x<0) x = 0;
		if(y<0) y = 0;
		if(x>map.width) x= map.width;
		if(y>map.height) y = map.height;
	}
	public void RenderingEntity(){
		
	}
}
