package com.strategy.jogo.carta;

import com.strategy.jogo.carta.comportamentos.ComportamentoDeCartaDeDano;
import com.strategy.jogo.carta.comportamentos.passivas.NaoPossuiPassiva;
import com.strategy.jogo.carta.comportamentos.passivas.PossuiPassiva;

public class CartaDeLuta extends Carta{
	private int dano;


	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

	CartaDeLuta(){
		this("Lacaio", Carta.CUSTO_PADRAO, Carta.DANO_PADRAO, new NaoPossuiPassiva());
	}

	CartaDeLuta(String nome, int custo, int dano) {
		this("nome", custo, dano, new NaoPossuiPassiva());

		this.setCdc(new ComportamentoDeCartaDeDano());
		this.setDano(dano);
	}

	CartaDeLuta(String nome, int custo, int dano, PossuiPassiva pp) {
		super(nome, custo);

		this.setCdc(new ComportamentoDeCartaDeDano());
		this.setDano(dano);
		this.setPp(pp);
	}

	@Override
	public String toString(){
		String descricao = this.getNome();

		return descricao;

	}

}
