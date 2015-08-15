package com.strategy.jogo.jogador;

import java.util.ArrayList;

import com.strategy.jogo.carta.Carta;

public class JogadorJogavel extends Jogador{

	public JogadorJogavel(String nome, ArrayList<Carta> cartas) {
		super(nome, cartas);
		
		this.setJogavel(new EJogavel());
	}


}
