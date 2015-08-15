package com.strategy.jogo.carta;

public class Carta {
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
		this("Lacaio", 1, 5);
	}
	public Carta(String nomeCarta, int custoCarta, int pontuacaoCarta) {
		this.setNome(nomeCarta);
		this.setCusto(custoCarta);
		this.setDano(pontuacaoCarta);
	}
		
}
