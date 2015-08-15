package com.strategy.jogo;

import java.util.ArrayList;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.carta.CriaCartas;
import com.strategy.jogo.carta.Ordenavel;
import com.strategy.jogo.jogador.Jogador;
import com.strategy.jogo.jogador.criaJogadores;

public class Jogo {
	
	private static final int NUMERO_DE_JOGADORES = 2;
	
	private String nome;
	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>(NUMERO_DE_JOGADORES);
	private Ordenavel embaralhador;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}
	public void setJogadores(ArrayList<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	
	public Ordenavel getEmbaralhador() {
		return embaralhador;
	}
	public void setEmbaralhador(Ordenavel embaralhador) {
		this.embaralhador = embaralhador;
	}
	
	public Jogo(){
		this(CriaCartas.criaCartas());
	}
	
	public Jogo(ArrayList<Carta> cartas){
		this(criaJogadores.criarJogadores(cartas), cartas);
	}
	
	public Jogo(ArrayList<Jogador> jogadores, ArrayList<Carta> cartas){
		this.setNome("Um jogo qualquer");
		this.setJogadores(jogadores);
	}
	
}
