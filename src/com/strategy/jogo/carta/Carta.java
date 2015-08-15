package com.strategy.jogo.carta;

public class Carta {
	
	private static final int CUSTO_PADRAO = 1;
	private static final int DANO_PADRAO = 5;
	
	private String nome;
	private int custo;
	private int dano;
	
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
	public int getDano() {
		return dano;
	}
	public void setDano(int dano) {
		this.dano = dano;
	}
	
	public Carta(){
		this("Lacaio", CUSTO_PADRAO, DANO_PADRAO);
	}
	public Carta(String nomeCarta, int custoCarta, int pontuacaoCarta) {
		this.setNome(nomeCarta);
		this.setCusto(custoCarta);
		this.setDano(pontuacaoCarta);
	}
		
}
