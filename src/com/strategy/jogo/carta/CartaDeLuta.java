package com.strategy.jogo.carta;

import com.strategy.jogo.carta.comportamentos.ComportamentoDeCartaDeDano;

public class CartaDeLuta extends Carta{
	private int dano;


	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

	CartaDeLuta(){
		this("Lacaio", 1, Carta.DANO_PADRAO);
	}

	CartaDeLuta(String nome, int custo, int dano) {
		super(nome, custo);

		this.setCdc(new ComportamentoDeCartaDeDano());
		this.setDano(dano);
	}

	@Override
	public String toString(){
		String descricao = this.getNome();

		return descricao;

	}

}
