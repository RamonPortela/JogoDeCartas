package com.strategy.jogo.carta.comportamentos.passivas;

import java.util.ArrayList;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.jogador.Jogador;
import com.strategy.jogo.jogador.status.StatusSangramento;

public class PossuiPassivaSangrar implements PossuiPassiva{

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
	public void passiva(Carta carta, ArrayList<Jogador> jogadores, Jogador jogadorQueUsou) {



		for (Jogador jogador : jogadores) {

			if(jogador != jogadorQueUsou){
				jogador.getStatus().add(new StatusSangramento(this.getDano(), this.getDuracao()));
			}

		}

	}


	public PossuiPassivaSangrar(int dano, int duracao){
		this.setDano(dano);
		this.setDuracao(duracao);
	}

	@Override
	public String toString() {
		String passiva = "Causa sangramento de "+ this.getDano()+" de dano por " + this.getDuracao()+ " rodadas";
		return passiva;
	}

}
