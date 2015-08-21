package com.strategy.jogo.jogador.comportamento;

import java.io.Serializable;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.jogador.Jogador;

public interface ComportamentoJogador extends Serializable{
	abstract Carta escolheCarta(Jogador jogador);
}
