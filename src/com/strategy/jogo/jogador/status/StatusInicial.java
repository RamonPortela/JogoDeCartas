package com.strategy.jogo.jogador.status;

import com.strategy.jogo.jogador.Jogador;

public class StatusInicial implements StatusJogador{

	private static final int DURACAO = 1;

	private int duracao = DURACAO;

	public int getDuracao() {
		return duracao;
	}

	@Override
	public int efeito(Jogador jogador) {
		// TODO Auto-generated method stub
		return this.getDuracao();
	}



}
