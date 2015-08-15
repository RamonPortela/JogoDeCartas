package com.strategy.jogo.jogador;

import java.util.ArrayList;

import com.strategy.jogo.carta.Carta;

public class JogadorNpc extends Jogador{


	public JogadorNpc(){
		super();
		
		this.setJogavel(new NaoJogavel());
	}
	
	public void escolheCarta(ArrayList<Carta> cartasDaMao) {
		
		
	}

}
