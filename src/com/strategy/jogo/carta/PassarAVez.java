package com.strategy.jogo.carta;

public class PassarAVez extends Carta{

	private static final long serialVersionUID = 19999L;

	private static final int CUSTO_PASSAR_VEZ = 0;

	public PassarAVez(){
		this("Passar a vez", CUSTO_PASSAR_VEZ);
	}

	public PassarAVez(String nome, int custo){
		super("Passar a vez", CUSTO_PASSAR_VEZ);
	}
}
