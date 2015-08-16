package com.strategy.jogo.carta;

import com.strategy.jogo.carta.comportamentos.ComportamentoDeCartaDeRecuperacaoDeMana;

public class CartaDeSuporteRecuperaMana extends CartaDeSuporte{

	private static final int CUSTO_PADRAO = 0;

	private int recuperaMana;

	public int getRecuperaMana() {
		return recuperaMana;
	}

	public void setRecuperaMana(int recuperaMana) {
		this.recuperaMana = recuperaMana;
	}

	CartaDeSuporteRecuperaMana() {
		this("Benção", CUSTO_PADRAO, Carta.RECUPERACAO_PADRAO);
	}

	CartaDeSuporteRecuperaMana(String nome, int custo, int recupera) {
		super(nome, custo);

		this.setCdc(new ComportamentoDeCartaDeRecuperacaoDeMana());
		this.setRecuperaMana(recupera);
	}
}
