package com.strategy.jogo.jogador;

import java.util.ArrayList;
import java.util.LinkedList;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.carta.CriaCartas;
import com.strategy.jogo.carta.CriaDeck;

public abstract class Jogador {
	
	private static final int VIDA_INICIAL = 100;
	
	private String nome;
	private int vida;
	private int pontoParaGastar;
	private LinkedList<Carta> deck;
	private ArrayList<Carta> cartasDaMao;
	private Jogavel jogavel;

	public Jogavel getJogavel() {
		return jogavel;
	}

	public void setJogavel(Jogavel jogavel) {
		this.jogavel = jogavel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getPontoParaGastar() {
		return pontoParaGastar;
	}

	public void setPontoParaGastar(int pontoParaGastar) {
		this.pontoParaGastar = pontoParaGastar;
	}

	public LinkedList<Carta> getDeck() {
		return deck;
	}

	public void setDeck(LinkedList<Carta> deck) {
		this.deck = deck;
	}

	public ArrayList<Carta> getCartasDaMao() {
		return cartasDaMao;
	}

	private void setCartasDaMao(){
		this.cartasDaMao = new ArrayList<Carta>();
	}
	
	public void setCartasDaMao(LinkedList<Carta> deck, int qtdCartas) {
		ArrayList<Carta> cartasDaMao = this.getCartasDaMao();
		
		for (int contador = 0; contador < qtdCartas; contador++) {
			cartasDaMao.add(deck.poll());
		}
		
		this.cartasDaMao = cartasDaMao;
	}
	
	public Carta jogar(){
		return this.getJogavel().escolheCarta(getCartasDaMao());
	}

	public Jogador(){
		this(CriaCartas.criaCartas());
		
	}
	
	public Jogador(ArrayList<Carta> cartas){
		this("CPU", 0, cartas);
	}

	public Jogador(String nome, int pontoParaGastar, ArrayList<Carta> cartas) {
		this.setNome(nome);
		this.setPontoParaGastar(pontoParaGastar);
		this.setDeck(CriaDeck.criaDeck(cartas));
		this.setVida(VIDA_INICIAL);
		this.setCartasDaMao();
	}
	
}
