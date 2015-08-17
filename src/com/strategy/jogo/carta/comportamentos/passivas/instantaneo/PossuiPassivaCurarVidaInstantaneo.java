package com.strategy.jogo.carta.comportamentos.passivas.instantaneo;

import java.util.ArrayList;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.carta.comportamentos.passivas.PossuiPassiva;
import com.strategy.jogo.jogador.Jogador;

public class PossuiPassivaCurarVidaInstantaneo implements PossuiPassiva{

	private static final int CURA_PADRAO = 5;

	private int curaVida;

	public int getCuraVida() {
		return curaVida;
	}

	public void setCuraVida(int curaVida) {
		this.curaVida = curaVida;
	}

	@Override
	public void passiva(Carta carta, ArrayList<Jogador> jogadores, Jogador jogadorQueUsou) {

		for (Jogador jogador : jogadores) {

			if(jogador == jogadorQueUsou){
				jogador.setVida(jogador.getVida() + this.getCuraVida());
			}

		}

	}

	public PossuiPassivaCurarVidaInstantaneo(){
		this(CURA_PADRAO);
	}

	public PossuiPassivaCurarVidaInstantaneo(int cura){
		this.setCuraVida(cura);
	}

	@Override
	public String toString() {
		String passiva = "Recupera "+this.getCuraVida()+"  de vida";
		return passiva;
	}
}
