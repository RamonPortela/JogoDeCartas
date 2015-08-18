package com.strategy.jogo.carta.comportamentos.passivas.porRodada;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.carta.comportamentos.passivas.PossuiPassivaPorRodada;
import com.strategy.jogo.jogador.Jogador;
import com.strategy.jogo.jogador.status.StatusSangramento;

public class PossuiPassivaSangrarPorRodada extends PossuiPassivaPorRodada{

	private static final int DANO_PADRAO = 2;

	int dano;
	int duracao;

	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	@Override
	public void passiva(Carta carta, Jogador jogadorQueUsou) {

		jogadorQueUsou.getOponente().getStatus().add(new StatusSangramento(this.getDano(), this.getDuracao()));

	}

	public PossuiPassivaSangrarPorRodada(){
		this(DANO_PADRAO, DURACAO_PADRAO);
	}

	public PossuiPassivaSangrarPorRodada(int dano, int duracao){
		this.setDano(dano);
		this.setDuracao(duracao);
	}

	@Override
	public String toString() {
		String passiva = "Causa sangramento de "+ this.getDano()+" de dano por " + this.getDuracao()+ " rodadas";
		return passiva;
	}

}
