package com.strategy.jogo.jogador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.carta.CriaCartas;
import com.strategy.jogo.carta.CriaDeck;
import com.strategy.jogo.jogador.comportamento.ComportamentoDeNPC;
import com.strategy.jogo.jogador.comportamento.ComportamentoJogador;
import com.strategy.jogo.jogador.status.StatusInicial;
import com.strategy.jogo.jogador.status.StatusJogador;

public class Jogador implements Serializable{

	private static final long serialVersionUID = 20000L;

	private static final int VIDA_INICIAL = 100;
	private static final int MANA_INICIAL = 15;

	private String nome;
	private int vida;
	private int mana;
	private LinkedList<Carta> deck;
	private ArrayList<Carta> cartasDaMao;
	private Jogador oponente;
	private int identificador;
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

	public Jogador getOponente(){
		return this.oponente;
	}

	public void setOponente(Jogador oponente){
		this.oponente = oponente;
	}


	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public Carta jogar(){
		Carta cartaJogada = this.getJogavel().escolheCarta(this);
		return cartaJogada;
	}

	public Jogador(){
		this(CriaCartas.criaCartas());

	}

	public Jogador(ArrayList<Carta> cartas){
		this("CPU", cartas, 0, new ComportamentoDeNPC(), new StatusInicial());
	}

	public Jogador(String nome, ArrayList<Carta> cartas, int identificador, ComportamentoJogador comportamento, StatusJogador status) {
		this.setNome(nome);
		this.setMana(MANA_INICIAL);
		this.setDeck(CriaDeck.criaDeck(cartas));
		this.setVida(VIDA_INICIAL);
		this.setIdentificador(identificador);
		this.setCartasDaMao();
		this.setJogavel(comportamento);
		this.getStatus().add(status);
	}

	@Override
	public boolean equals(Object jogador) {
		if(this == jogador)
			return true;

		if(jogador == null)
			return false;

		if(jogador instanceof Jogador){
			Jogador jogadorComparacao = (Jogador) jogador;

			if(jogadorComparacao.getJogavel() == this.getJogavel())
				return this.getIdentificador() == jogadorComparacao.getIdentificador();
			else
				return false;
		}
		else{
			return false;
		}
	}

}
