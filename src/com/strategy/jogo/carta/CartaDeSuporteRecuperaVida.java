package com.strategy.jogo.carta;

import com.strategy.jogo.carta.comportamentos.ComportamentoDeCartaDeCura;

public class CartaDeSuporteRecuperaVida extends CartaDeSuporte {

	private int recuperaVida;

	public int getRecuperaVida() {
		return recuperaVida;
	}

	public void setRecuperaVida(int recuperaVida) {
		this.recuperaVida = recuperaVida;
	}

	CartaDeSuporteRecuperaVida() {
		this("Recuperar Vida", Carta.CUSTO_PADRAO, Carta.CURA_PADRAO);
	}

	CartaDeSuporteRecuperaVida(String nome, int custo, int cura) {
		super(nome, custo);

		this.setCdc(new ComportamentoDeCartaDeCura());
		this.setRecuperaVida(cura);
	}
}
