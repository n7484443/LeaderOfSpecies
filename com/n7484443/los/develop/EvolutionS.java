package com.n7484443.los.develop;

public class EvolutionS {
	public static EvolutionBase[] evolutionS;
	public EvolutionS(){
		evolutionS = new EvolutionBase[1];
		for(int i = 0; i < evolutionS.length; i++){
			evolutionS[i] = new EvolutionBase("ㄷ");
		}
	}
	public static boolean getEvolution(int i){
		return evolutionS[i].Evolutioned;
	}
	public static void setEvolution(int i, boolean b){
		evolutionS[i].Evolutioned = b;
	}
	public static void Evolutioned(int i){
		evolutionS[i].Evolutioned = true;
	}
	public static int EntityCellImageEvolution(){
		if(evolutionS[0].Evolutioned){
			return 1;
		}
		return 0;
	}
}
