package com.strategy.jogo.jogador;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.strategy.jogo.carta.Carta;

public class JogadorJogavel extends Jogador{

	public JogadorJogavel(String nome, int pontuacaoParaGastar, ArrayList<Carta> cartas) {
		super(nome, pontuacaoParaGastar, cartas);
		
		this.setJogavel(new EJogavel());
	}

}
