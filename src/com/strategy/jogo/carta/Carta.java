package com.strategy.jogo.carta;

import java.io.Serializable;

import com.strategy.jogo.carta.comportamentos.ComportamentoDeCarta;
import com.strategy.jogo.carta.comportamentos.passivas.PossuiPassiva;

public abstract class Carta implements Serializable{

	private static final long serialVersionUID = 10000L;

	protected static final int CUSTO_PADRAO = 1;
	protected static final int DANO_PADRAO = 5;
	protected static final int CURA_PADRAO = 5;
	protected static final int RECUPERACAO_PADRAO = 5;

	private String nome;
	private int custo;
	private ComportamentoDeCarta cdc;
	private PossuiPassiva pp;

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

	public PossuiPassiva getPp() {
		return pp;
	}

	public void setPp(PossuiPassiva pp) {
		this.pp = pp;
	}

	public Carta(){
		this("Lacaio", CUSTO_PADRAO);
	}

	public Carta(String nomeCarta, int custoCarta) {
		this.setNome(nomeCarta);
		this.setCusto(custoCarta);
	}

}
