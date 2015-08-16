package com.strategy.jogo.carta.comportamentos;

import java.util.ArrayList;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.carta.CartaDeSuporteRecuperaVida;
import com.strategy.jogo.jogador.Jogador;

public class ComportamentoDeCartaDeCura implements ComportamentoDeCarta {
	@Override
	public void efeito(Carta carta, ArrayList<Jogador> jogadores, Jogador jogadorQueUsou) {
		int cura = ((CartaDeSuporteRecuperaVida)carta).getRecuperaVida();

		for (Jogador jogador : jogadores) {
			if(jogador == jogadorQueUsou){
				jogador.setVida(jogador.getVida() + cura);
			}
		}

	}
}
