package com.strategy.jogo.carta.comportamentos.passivas;

import java.util.ArrayList;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.jogador.Jogador;

public interface PossuiPassiva {
	public void passiva(Carta carta, ArrayList<Jogador> jogadores, Jogador jogador);

}
