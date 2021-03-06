package com.strategy.jogo.carta.comportamentos;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.carta.CartaDeLuta;
import com.strategy.jogo.jogador.Jogador;

public class ComportamentoDeCartaDeDano implements ComportamentoDeCarta{


	private static final long serialVersionUID = 1002L;

	@Override
	public void efeito(Carta carta, Jogador jogadorQueUsou) {
		int dano = ((CartaDeLuta)carta).getDano();

		jogadorQueUsou.getOponente().setVida(jogadorQueUsou.getOponente().getVida() - dano);

	}

	@Override
	public String toString(Carta carta) {
		String cartaDescricao = (carta.getNome()+ " - " +carta.getCusto()+ " - causa "+ ((CartaDeLuta)carta).getDano()+" de dano");
		return cartaDescricao;
	}

	@Override
	public String toStringSemMana(Carta carta) {
		String cartaDescricao = (carta.getNome()+" - causa "+ ((CartaDeLuta)carta).getDano()+" de dano");
		return cartaDescricao;
	}

}
