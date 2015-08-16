package com.strategy.jogo.carta;

import com.strategy.jogo.carta.comportamentos.ComportamentoDeCartaDeCura;
import com.strategy.jogo.carta.comportamentos.passivas.NaoPossuiPassiva;
import com.strategy.jogo.carta.comportamentos.passivas.PossuiPassiva;

public class CartaDeSuporteRecuperaVida extends CartaDeSuporte {

	private int recuperaVida;

	public int getRecuperaVida() {
		return recuperaVida;
	}

	public void setRecuperaVida(int recuperaVida) {
		this.recuperaVida = recuperaVida;
	}

	CartaDeSuporteRecuperaVida() {
		this("Recuperar Vida", Carta.CUSTO_PADRAO, Carta.CURA_PADRAO, new NaoPossuiPassiva());
	}

	CartaDeSuporteRecuperaVida(String nome, int custo, int cura) {
		this(nome, custo, cura, new NaoPossuiPassiva());

		this.setCdc(new ComportamentoDeCartaDeCura());
		this.setRecuperaVida(cura);
	}

	CartaDeSuporteRecuperaVida(String nome, int custo, int cura, PossuiPassiva pp) {
		super(nome, custo);

		this.setCdc(new ComportamentoDeCartaDeCura());
		this.setRecuperaVida(cura);
		this.setPp(pp);
	}
}
