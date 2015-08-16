package com.strategy.jogo.jogador;

import com.strategy.jogo.carta.Carta;

public interface ComportamentoJogador {
	abstract Carta escolheCarta(Jogador jogador);
}
