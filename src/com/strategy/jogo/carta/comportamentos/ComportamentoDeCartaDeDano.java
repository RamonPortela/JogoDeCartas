package com.strategy.jogo.carta.comportamentos;

import java.util.ArrayList;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.carta.CartaDeLuta;
import com.strategy.jogo.jogador.Jogador;

public class ComportamentoDeCartaDeDano implements ComportamentoDeCarta{

	@Override
	public void efeito(Carta carta, ArrayList<Jogador> jogadores, Jogador jogadorQueUsou) {
		int dano = ((CartaDeLuta)carta).getDano();

		for (Jogador jogador : jogadores) {
			if(jogador != jogadorQueUsou){
				jogador.setVida(jogador.getVida() - dano);
			}
		}

	}


	@Override
	public String toString(){
		String descricao = "luta";
		return descricao;
	}
}
