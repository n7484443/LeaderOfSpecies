package com.n7484443.los.evolution;

import com.n7484443.los.language.LanguageStringLoader;

public class EvolutionS {
	public static EvolutionBase[] evolutionS;
	public EvolutionS(){
		evolutionS = new EvolutionBase[64];
		
		for(int i = 0; i < evolutionS.length; i++){
			evolutionS[i] = new EvolutionBase(LanguageStringLoader.getLanguage("evolution." + i + ".title"), LanguageStringLoader.getLanguage("evolution." + i + ".sub"), -1);
		}
		evolutionS[24].setNeed(null);
		evolutionS[25].setNeed(24);
		evolutionS[26].setNeed(25);
	}
	public static boolean getEvolution(int i){
		return evolutionS[i].Evolutioned;
	}
	
	public static EvolutionBase Evolution(int i){
		return evolutionS[i];
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
