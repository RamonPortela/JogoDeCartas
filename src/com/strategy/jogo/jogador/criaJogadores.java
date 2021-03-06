package com.strategy.jogo.jogador;

import java.util.ArrayList;
import java.util.Scanner;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.jogador.comportamento.ComportamentoDeJogador;
import com.strategy.jogo.jogador.status.StatusInicial;

public class criaJogadores {
	public static ArrayList<Jogador> criarJogadoresCPU(ArrayList<Carta> cartas){

		ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

		jogadores.add(new Jogador());

		jogadores.add(new Jogador(ledadosJogador(), cartas, 1, new ComportamentoDeJogador(), new StatusInicial()));

		return jogadores;

	}

	public static ArrayList<Jogador> criarJogadoresMPLocal(ArrayList<Carta> cartas){

		ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

		for (int contadorDeJogadores = 0; contadorDeJogadores < 2; contadorDeJogadores++) {
			jogadores.add(new Jogador(ledadosJogador(), cartas, contadorDeJogadores, new ComportamentoDeJogador(), new StatusInicial()));

		}


		//jogadores.add(new Jogador(ledadosJogador(), cartas, new ComportamentoDeJogador(), new StatusInicial()));

		return jogadores;

	}

	public static String ledadosJogador() {
		Scanner input = new Scanner(System.in);
		System.out.println("Entre com seu nome: ");
		String nome = input.nextLine();

		return nome;
	}
}
