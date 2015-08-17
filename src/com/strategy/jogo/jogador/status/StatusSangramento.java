package com.strategy.jogo.jogador.status;

import com.strategy.jogo.jogador.Jogador;

public class StatusSangramento implements StatusJogador {

	int sangramento;
	int duracao;

	public int getSangramento() {
		return sangramento;
	}

	public void setSangramento(int sangramento) {
		this.sangramento = sangramento;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	@Override
	public int efeito(Jogador jogador) {
		jogador.setVida(jogador.getVida() - getSangramento());
		this.setDuracao(this.getDuracao() - 1);
		System.out.println(this.getSangramento()+ " de dano causado em "+jogador.getNome() + " devido a sangramento.");
		System.out.println(jogador.getVida()+ " é sua vida atual\n");
		return this.getDuracao();
	}

	public StatusSangramento(int sangramentoDano, int duracao){
		this.setSangramento(sangramentoDano);
		this.setDuracao(duracao);
	}

}
