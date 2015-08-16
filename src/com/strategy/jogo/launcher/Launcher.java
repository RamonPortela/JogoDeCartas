package com.strategy.jogo.launcher;

import java.util.ArrayList;
import java.util.Scanner;

import com.strategy.jogo.Jogo;
import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.carta.CriaCartas;
import com.strategy.jogo.jogador.Jogador;
import com.strategy.jogo.jogador.criaJogadores;

public class Launcher {

	private static final int JOGADOR_UM = 0;
	private static final int JOGADOR_DOIS = 1;
	private static final int CARTAS_PRIMEIRA_RODADA = 5;
	private static final int CARTAS_POR_RODADA = 1;


	public void preparaJogo(){

		ArrayList<Carta> cartas = CriaCartas.criaCartas();
		ArrayList<Jogador> jogadores = criaJogadores.criarJogadores(cartas);

		Jogo jogo = new Jogo(jogadores, cartas);

		comecaJogo(jogadores, jogo);

	}

	private void comecaJogo(ArrayList<Jogador> jogadores, Jogo jogo) {
		boolean primeiraRodada = true;
		int numeroRodadas = 0;

		while((jogo.getJogadores().get(JOGADOR_UM).getVida() > 0) && (jogo.getJogadores().get(JOGADOR_DOIS).getVida() > 0)){

			if(primeiraRodada){

				for (Jogador jogador : jogadores) {
					jogador.setCartasDaMao(jogador.getDeck(), CARTAS_PRIMEIRA_RODADA);
				}
				primeiraRodada = false;

			}else{
				for (Jogador jogador : jogadores) {
					jogador.setCartasDaMao(jogador.getDeck(), CARTAS_POR_RODADA);
					if((numeroRodadas % 2) == 0){
						jogador.setMana(jogador.getMana() + 1);
					}
				}
			}

			Launcher.fazRodada(jogadores);

			Launcher.exibePlacar(jogadores);

			Launcher.pressionarEnter();

			if(jogadores.get(JOGADOR_UM).getVida() < 1 && jogadores.get(JOGADOR_DOIS).getVida() < 1){
				break;
			}

			numeroRodadas++;
		}

		if(jogadores.get(JOGADOR_UM).getVida() < 1){
			System.out.println("Parabens voc� venceu");
		}
		else{
			System.out.println("� uma pena voc� perdeu");
		}
	}

	public static void fazRodada(ArrayList<Jogador> jogadores) {
		for (Jogador jogador : jogadores) {
			if(jogador.getJogavel().toString().equals("npc")){
				System.out.println("O CPU est� jogando...");

				Carta cartaJogada = jogador.jogar();
				System.out.println(cartaJogada.getNome());
				if(!(cartaJogada.getNome().equals("Passar a vez"))){
					cartaJogada.getCdc().efeito(cartaJogada, jogadores, jogador);
				}
			}

			else{
				System.out.println("Escolha a carta que voc� vai jogar: ");
				System.out.println("Voc� possui: "+ jogador.getMana() + " de mana.");

				int contador = 0;
				for (Carta carta : jogador.getCartasDaMao()) {
					contador++;
					System.out.println(contador+": "+carta.getNome()+ " - "+ carta.getCusto());
				}

				Carta cartaJogada = jogador.jogar();
				System.out.println(cartaJogada.getNome());
				if(!(cartaJogada.getNome().equals("Passar a vez"))){
					cartaJogada.getCdc().efeito(cartaJogada, jogadores, jogador);
				}
			}

		}
	}

	private static void exibePlacar(ArrayList<Jogador> jogadores) {
		for (Jogador jogador : jogadores) {
			System.out.println(jogador.getNome() + " " + jogador.getVida() + " pontos de vida. | "+jogador.getMana()+ "pontos de mana.");
		}

	}

	private static void pressionarEnter() {
		System.out.println("Pressione enter para continuar.");
		Scanner input = new Scanner(System.in);
		input.nextLine();
	}
}
