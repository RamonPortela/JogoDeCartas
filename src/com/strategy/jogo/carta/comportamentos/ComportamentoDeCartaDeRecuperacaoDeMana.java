package com.strategy.jogo.carta.comportamentos;

import java.util.ArrayList;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.carta.CartaDeSuporteRecuperaMana;
import com.strategy.jogo.carta.CartaDeSuporteRecuperaVida;
import com.strategy.jogo.jogador.Jogador;

public class ComportamentoDeCartaDeRecuperacaoDeMana implements ComportamentoDeCarta {

	@Override
	public void efeito(Carta carta, ArrayList<Jogador> jogadores, Jogador jogadorQueUsou) {
		int mana = ((CartaDeSuporteRecuperaMana)carta).getRecuperaMana();

		for (Jogador jogador : jogadores) {
			if(jogador == jogadorQueUsou){
				jogador.setMana(jogador.getMana() + mana);
			}
		}

	}
}