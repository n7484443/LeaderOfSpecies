package com.n7484443.los.evolution;

public class EvolutionS {
	public static EvolutionBase[] evolutionS;
	public EvolutionS(){
		evolutionS = new EvolutionBase[49];
		evolutionS[0] = new EvolutionBase("세포막 함입", "이 진화는 세포막이 핵 속으로 우연적이게 들어갈 수 있게 합니다.");
		evolutionS[1] = new EvolutionBase("엽록체",
				"위험! 산소 발생으로 인하여 대부분의 세포들이 죽게 생겼습니다! 먹이인 철 이온이 먹을 수 없는 산화철이 되었고, 이산화 탄소대신 산소가 가득차게 되었습니다.",
				evolutionS[0]);
		evolutionS[2] = new EvolutionBase("미토콘드리아", "미토콘드리아는 산소를 이용하여 에너지를 만듭니다. 이 에너지는 ATP라고 불리지만 그건 후의 얘기...", evolutionS[1]);
		
		for(int i = 3; i < evolutionS.length; i++){
			evolutionS[i] = new EvolutionBase("ㄷ", null);
		}
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
