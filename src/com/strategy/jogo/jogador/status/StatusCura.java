package com.strategy.jogo.jogador.status;

import com.strategy.jogo.jogador.Jogador;

public class StatusCura implements StatusJogador{

	int cura;
	int duracao;

	public int getCura() {
		return cura;
	}

	public void setCura(int cura) {
		this.cura = cura;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	@Override
	public int efeito(Jogador jogador) {
		jogador.setVida(jogador.getVida() + this.getCura());
		this.setDuracao(this.getDuracao() - 1);
		System.out.println(this.getCura()+ " de vida recuperado por "+jogador.getNome() + " devido a regeneração de vida.");
		System.out.println(jogador.getVida()+ " é sua vida atual\n");
		return this.getDuracao();
	}

	public StatusCura(int cura, int duracao){
		this.setCura(cura);
		this.setDuracao(duracao);
	}
}
