package com.strategy.jogo.carta.comportamentos.passivas;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.jogador.Jogador;

public class NaoPossuiPassiva implements PossuiPassiva{

	@Override
	public void passiva(Carta carta, Jogador jogador) {

	}

	@Override
	public String toString() {

		String passiva = "N�o possui passiva.";
		return passiva;
	}

}
