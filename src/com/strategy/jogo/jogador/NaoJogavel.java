package com.strategy.jogo.jogador;

import java.util.ArrayList;

import com.strategy.jogo.carta.Carta;

public class NaoJogavel implements Jogavel{

	@Override
	public Carta escolheCarta(ArrayList<Carta> cartasDaMao) {
		Carta carta = cartasDaMao.get((int) (Math.random() * 5));
		return carta;
	}
	
	@Override
	public String toString() {
		String descricao = "npc";
		return descricao;
	}
}
