package com.n7484443.los.map;

import java.util.ArrayList;

import com.n7484443.los.entity.EntityBase;

public class MapBase{
	public int width;
	public int height;
	private ArrayList<EntityBase> entitys;
	public MapBase(int width, int height){
		this.width = width;
		this.height = height;
		entitys = new ArrayList<EntityBase>();
	}
	
	public void CheckEntity(){
		beforeDo();
		for(int i = 0; i < entitys.size(); i++){
			EntityBase en = entitys.get(i);
			if(en.nowstate == EntityBase.State.WILLDELETE){
				en.EntityDeleteEvent();
				entitys.remove(i);
				continue;
			}
			en.id = i;
			en.update();
			entitys.set(i, en);
		}
		afterDo();
	}
	public void beforeDo(){}
	public void afterDo(){}
	public void EntityCreate(EntityBase entity){
		entitys.add(entity);
		entity.EntityCreateEvent();
	}
	
	public ArrayList<EntityBase> getEntityS(){
		return entitys;
	}
}
