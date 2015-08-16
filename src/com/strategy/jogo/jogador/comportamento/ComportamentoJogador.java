package com.strategy.jogo.jogador.comportamento;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.jogador.Jogador;

public interface ComportamentoJogador {
	abstract Carta escolheCarta(Jogador jogador);
}
