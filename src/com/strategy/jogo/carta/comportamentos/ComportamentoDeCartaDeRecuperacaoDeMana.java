package com.strategy.jogo.carta.comportamentos;

import java.util.ArrayList;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.carta.CartaDeSuporteRecuperaMana;
import com.strategy.jogo.jogador.Jogador;

public class ComportamentoDeCartaDeRecuperacaoDeMana implements ComportamentoDeCarta {

	@Override
	public void efeito(Carta carta, Jogador jogadorQueUsou) {
		int mana = ((CartaDeSuporteRecuperaMana)carta).getRecuperaMana();

		jogadorQueUsou.setMana(jogadorQueUsou.getMana() + mana);

	}

	@Override
	public String toString(Carta carta) {
		String cartaDescricao = (carta.getNome()+ " - " +carta.getCusto()+ " - recupera "+ ((CartaDeSuporteRecuperaMana)carta).getRecuperaMana()+" de mana");
		return cartaDescricao;
	}

	@Override
	public String toStringSemMana(Carta carta) {
		String cartaDescricao = (carta.getNome()+ " - recupera "+ ((CartaDeSuporteRecuperaMana)carta).getRecuperaMana()+" de mana");
		return cartaDescricao;
	}

}
