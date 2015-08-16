package com.strategy.jogo.carta.comportamentos.passivas;

import java.util.ArrayList;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.jogador.Jogador;

public class PossuiPassivaSangrar implements PossuiPassiva{

	@Override
	public void passiva(Carta carta, ArrayList<Jogador> jogadores, Jogador jogadorQueUsou) {

		for (Jogador jogador : jogadores) {

			if(jogador != jogadorQueUsou){
				jogador.setVida(jogador.getVida() - 5);
			}

		}

	}

	@Override
	public String toString() {
		String passiva = "Causa sangramento de 5 de dano.";
		return passiva;
	}

}
