package com.strategy.jogo.jogador;

import com.strategy.jogo.carta.Carta;

public interface Jogavel {
	abstract Carta escolheCarta(Jogador jogador);
}
