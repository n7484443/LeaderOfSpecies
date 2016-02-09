package com.n7484443.los.evolution;

public class EvolutionBase {
	public boolean Evolutioned;
	public String str;
	public String explain;
	public EvolutionBase[] need;
	public EvolutionBase(String str, String explain, EvolutionBase... need){
		Evolutioned = false;
		this.str = str;
		this.explain = explain;
		this.need = need;
	}
}
