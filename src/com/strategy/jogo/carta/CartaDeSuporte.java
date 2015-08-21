package com.strategy.jogo.carta;

public abstract class CartaDeSuporte extends Carta{

	private static final long serialVersionUID = 12000L;

	CartaDeSuporte(){

	}

	CartaDeSuporte(String nome, int custo){
		super(nome, custo);
	}
}
