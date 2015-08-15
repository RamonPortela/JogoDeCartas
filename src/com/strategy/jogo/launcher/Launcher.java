package com.strategy.jogo.launcher;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

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
		while((jogo.getJogadores().get(JOGADOR_UM).getVida() > 0) && (jogo.getJogadores().get(JOGADOR_DOIS).getVida() > 0)){
			
			if(primeiraRodada){
				
				for (Jogador jogador : jogadores) {
					jogador.setCartasDaMao(jogador.getDeck(), CARTAS_PRIMEIRA_RODADA);
				}
				primeiraRodada = false;
				
			}else{
				for (Jogador jogador : jogadores) {
					jogador.setCartasDaMao(jogador.getDeck(), CARTAS_POR_RODADA);
				}
			}
			
			for (Jogador jogador : jogadores) {
				if(jogador.getJogavel().toString().equals("npc")){					
					System.out.println("O CPU está jogando...");
					
					Carta cartaJogada = jogador.jogar();
					System.out.println(cartaJogada.getNome());
					jogadores.get(JOGADOR_DOIS).setVida(jogadores.get(JOGADOR_DOIS).getVida() - cartaJogada.getDano());
					System.out.println("Você sofreu: "+ cartaJogada.getDano() + " de dano.");
				}
				
				else{
					System.out.println("Escolha a carta que você vai jogar: ");
					
					for (Carta carta : jogador.getCartasDaMao()) {
						System.out.println(carta.getNome());
					}
					
					Carta cartaJogada = jogador.jogar();
					System.out.println(cartaJogada.getNome());
					jogadores.get(JOGADOR_UM).setVida(jogadores.get(JOGADOR_UM).getVida() - cartaJogada.getDano());
					System.out.println("Você causou: "+ cartaJogada.getDano() + " de dano.");
				}
				
			}
			
			Launcher.exibePlacar(jogadores);
			
			Launcher.pressionarEnter();
			
		}
		
		if(jogadores.get(JOGADOR_UM).getVida() < 1){
			System.out.println("Parabens você venceu");
		}
		else{
			System.out.println("É uma pena você perdeu");
		}
	}
	
	private static void exibePlacar(ArrayList<Jogador> jogadores) {
		for (Jogador jogador : jogadores) {
			System.out.println(jogador.getNome() + " " + jogador.getVida() + " pontos de vida.");
		}
		
	}

	private static void pressionarEnter() {
		System.out.println("Pressione enter para continuar.");
		Scanner input = new Scanner(System.in);
		input.nextLine();//só continua pro proximo passo se o usuario apertar a tecla enter
	}
}
