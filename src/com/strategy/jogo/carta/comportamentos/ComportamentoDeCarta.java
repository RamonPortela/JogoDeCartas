package com.strategy.jogo.carta.comportamentos;

import java.util.ArrayList;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.jogador.Jogador;

public interface ComportamentoDeCarta {
	public void efeito(Carta carta, ArrayList<Jogador> jogadores, Jogador jogador);
}
