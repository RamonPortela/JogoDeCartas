package com.strategy.jogo.carta;

import com.strategy.jogo.carta.comportamentos.ComportamentoDeCarta;

public abstract class Carta {

	protected static final int CUSTO_PADRAO = 1;
	protected static final int DANO_PADRAO = 5;
	protected static final int CURA_PADRAO = 5;

	private String nome;
	private int custo;
	private ComportamentoDeCarta cdc;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCusto() {
		return custo;
	}
	public void setCusto(int custo) {
		this.custo = custo;
	}

	public ComportamentoDeCarta getCdc() {
		return cdc;
	}
	public void setCdc(ComportamentoDeCarta cdc) {
		this.cdc = cdc;
	}
	public Carta(){
		this("Lacaio", CUSTO_PADRAO);
	}
	public Carta(String nomeCarta, int custoCarta) {
		this.setNome(nomeCarta);
		this.setCusto(custoCarta);
	}

}
