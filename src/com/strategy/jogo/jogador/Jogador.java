package com.strategy.jogo.jogador;

import java.util.ArrayList;
import java.util.LinkedList;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.carta.CriaCartas;
import com.strategy.jogo.carta.CriaDeck;
import com.strategy.jogo.jogador.comportamento.ComportamentoDeNPC;
import com.strategy.jogo.jogador.comportamento.ComportamentoJogador;
import com.strategy.jogo.jogador.status.StatusInicial;
import com.strategy.jogo.jogador.status.StatusJogador;

public class Jogador {

	private static final int VIDA_INICIAL = 100;
	private static final int MANA_INICIAL = 15;

	private String nome;
	private int vida;
	private int mana;
	private LinkedList<Carta> deck;
	private ArrayList<Carta> cartasDaMao;
	private ComportamentoJogador jogavel;
	private ArrayList<StatusJogador> status = new ArrayList<StatusJogador>();

	public ComportamentoJogador getJogavel() {
		return jogavel;
	}

	public void setJogavel(ComportamentoJogador jogavel) {
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

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public ArrayList<StatusJogador> getStatus() {
		return status;
	}

	public void setStatus(ArrayList<StatusJogador> status){
		this.status = status;
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
		Carta cartaJogada = this.getJogavel().escolheCarta(this);
		return cartaJogada;
	}

	public Jogador(){
		this(CriaCartas.criaCartas());

	}

	public Jogador(ArrayList<Carta> cartas){
		this("CPU", cartas, new ComportamentoDeNPC(), new StatusInicial());
	}

	public Jogador(String nome, ArrayList<Carta> cartas, ComportamentoJogador comportamento, StatusJogador status) {
		this.setNome(nome);
		this.setMana(MANA_INICIAL);
		this.setDeck(CriaDeck.criaDeck(cartas));
		this.setVida(VIDA_INICIAL);
		this.setCartasDaMao();
		this.setJogavel(comportamento);
		this.getStatus().add(status);
	}

}
