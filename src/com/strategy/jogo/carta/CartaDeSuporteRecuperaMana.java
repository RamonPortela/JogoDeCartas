package com.strategy.jogo.carta;

import com.strategy.jogo.carta.comportamentos.ComportamentoDeCartaDeRecuperacaoDeMana;
import com.strategy.jogo.carta.comportamentos.passivas.NaoPossuiPassiva;
import com.strategy.jogo.carta.comportamentos.passivas.PossuiPassiva;

public class CartaDeSuporteRecuperaMana extends CartaDeSuporte{

	private static final long serialVersionUID = 12001L;

	private static final int CUSTO_PADRAO = 0;

	private int recuperaMana;

	public int getRecuperaMana() {
		return recuperaMana;
	}

	public void setRecuperaMana(int recuperaMana) {
		this.recuperaMana = recuperaMana;
	}

	CartaDeSuporteRecuperaMana() {
		this("Benção", CUSTO_PADRAO, Carta.RECUPERACAO_PADRAO, new NaoPossuiPassiva());
	}

	CartaDeSuporteRecuperaMana(String nome, int custo, int recupera) {
		this(nome, custo, recupera, new NaoPossuiPassiva());

		this.setCdc(new ComportamentoDeCartaDeRecuperacaoDeMana());
		this.setRecuperaMana(recupera);
	}

	CartaDeSuporteRecuperaMana(String nome, int custo, int recupera, PossuiPassiva pp) {
		super(nome, custo);

		this.setCdc(new ComportamentoDeCartaDeRecuperacaoDeMana());
		this.setRecuperaMana(recupera);
		this.setPp(pp);

	}
}
