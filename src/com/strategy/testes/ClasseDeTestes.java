package com.strategy.testes;

import java.util.ArrayList;

import com.strategy.jogo.Jogo;
import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.carta.CriaCartas;
import com.strategy.jogo.jogador.Jogador;
import com.strategy.jogo.jogador.JogadorJogavel;
import com.strategy.jogo.jogador.criaJogadores;
import com.strategy.jogo.launcher.Launcher;

public class ClasseDeTestes {
	public static void main(String[] args) {
		Launcher launcher = new Launcher();
		launcher.preparaJogo();
		
/*		ArrayList<Carta> cartas = CriaCartas.criaCartas();
		ArrayList<Jogador> jogadores = criaJogadores.criarJogadores(cartas);		
		
		Jogo jogo = new Jogo(jogadores, cartas);
		
		for (Jogador jogador : jogadores) {
			jogador.setCartasDaMao(jogador.getDeck(), 5);
		}
		
		for (int i = 0; i < 50; i++) {
			Launcher.fazRodada(jogadores);
			jogadores.get(0).setCartasDaMao(jogadores.get(0).getDeck(), 1);
			
		}*/
	}
}
