package com.strategy.jogo.jogador.status;

import java.io.Serializable;

import com.strategy.jogo.jogador.Jogador;

public interface StatusJogador extends Serializable{
	public int efeito(Jogador jogador);
}
