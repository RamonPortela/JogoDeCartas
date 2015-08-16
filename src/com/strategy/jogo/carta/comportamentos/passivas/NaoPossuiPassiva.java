package com.strategy.jogo.carta.comportamentos.passivas;

import java.util.ArrayList;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.jogador.Jogador;

public class NaoPossuiPassiva implements PossuiPassiva{

	@Override
	public void passiva(Carta carta, ArrayList<Jogador> jogadores, Jogador jogador) {

	}

	@Override
	public String toString() {

		String passiva = "Não possui passiva.";
		return passiva;
	}

}
