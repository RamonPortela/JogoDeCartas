package com.strategy.jogo.carta.comportamentos;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.carta.CartaDeSuporteRecuperaVida;
import com.strategy.jogo.jogador.Jogador;

public class ComportamentoDeCartaDeCura implements ComportamentoDeCarta {

	private static final long serialVersionUID = 1001L;

	@Override
	public void efeito(Carta carta, Jogador jogadorQueUsou) {
		int cura = ((CartaDeSuporteRecuperaVida)carta).getRecuperaVida();

		jogadorQueUsou.setVida(jogadorQueUsou.getVida() + cura);

	}

	@Override
	public String toString(Carta carta) {
		String cartaDescricao = (carta.getNome()+ " - " +carta.getCusto()+ " - recupera "+ ((CartaDeSuporteRecuperaVida)carta).getRecuperaVida()+" de vida");
		return cartaDescricao;
	}

	@Override
	public String toStringSemMana(Carta carta) {
		String cartaDescricao = (carta.getNome()+" - recupera "+ ((CartaDeSuporteRecuperaVida)carta).getRecuperaVida()+" de vida");
		return cartaDescricao;
	}
}
