package com.strategy.jogo.jogador;

import java.util.ArrayList;
import java.util.Scanner;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.jogador.comportamento.ComportamentoDeJogador;

public class criaJogadores {
	public static ArrayList<Jogador> criarJogadores(ArrayList<Carta> cartas){

		ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

		jogadores.add(new Jogador());

		jogadores.add(new Jogador(ledadosJogador(), cartas, new ComportamentoDeJogador()));

		return jogadores;

	}

	private static String ledadosJogador() {
		Scanner input = new Scanner(System.in);
		System.out.println("Entre com seu nome: ");
		String nome = input.nextLine();

		return nome;
	}
}
