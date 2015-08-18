package com.strategy.jogo.carta.comportamentos.passivas.porRodada;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.carta.comportamentos.passivas.PossuiPassivaPorRodada;
import com.strategy.jogo.jogador.Jogador;
import com.strategy.jogo.jogador.status.StatusCura;

public class PossuiPassivaCurarVidaPorRodada extends PossuiPassivaPorRodada{

	private static final int CURA_PADRAO = 2;

	private int curaVida;
	private int duracao;

	public int getCuraVida() {
		return curaVida;
	}

	public void setCuraVida(int curaVida) {
		this.curaVida = curaVida;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	@Override
	public void passiva(Carta carta, Jogador jogadorQueUsou) {

		jogadorQueUsou.getStatus().add(new StatusCura(this.getCuraVida(), this.getDuracao()));

	}

	public PossuiPassivaCurarVidaPorRodada(){
		this(CURA_PADRAO, DURACAO_PADRAO);
	}

	public PossuiPassivaCurarVidaPorRodada(int cura, int duracao){
		this.setCuraVida(cura);
		this.setDuracao(duracao);
	}

	@Override
	public String toString() {
		String passiva = "Realiza "+ this.getCuraVida()+ " de cura por " + this.getDuracao()+ " rodadas";
		return passiva;
	}
}
