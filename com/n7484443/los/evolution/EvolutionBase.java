package com.n7484443.los.evolution;

public class EvolutionBase {
	public boolean Evolutioned;
	public String str;
	public String explain;
	public int[] need;
	public EvolutionBase(String str, String explain, int... need){
		Evolutioned = false;
		this.str = str;
		this.explain = explain;
		this.need = need;
	}
	public EvolutionBase(String str, String explain){
		Evolutioned = false;
		this.str = str;
		this.explain = explain;
		this.need = null;
	}
	
	public void setNeed(int... need){
		this.need = need;
	}
	
	public boolean isEvolutioned(){
		if(need != null){
			for(int i = 0; i < need.length; i++){
				if(need[i] < 0){
					return false;
				}
				if(!EvolutionS.getEvolution(need[i])){
					return false;
				}
			}
			return true;
		}
		return true;
	}
}
