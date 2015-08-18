package com.strategy.jogo.launcher.local;

import java.util.ArrayList;
import java.util.Scanner;

import com.strategy.jogo.Jogo;
import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.carta.CriaCartas;
import com.strategy.jogo.jogador.Jogador;
import com.strategy.jogo.jogador.criaJogadores;
import com.strategy.jogo.jogador.status.StatusJogador;
import com.strategy.jogo.menu.Menu;

public class LauncherLocal {

	private static final int JOGADOR_UM = 0;
	private static final int JOGADOR_DOIS = 1;
	private static final int CARTAS_PRIMEIRA_RODADA = 5;
	private static final int CARTAS_POR_RODADA = 1;
	private static final int MANA_POR_RODADA = 1;
	private static final int VIDA_MINIMA = 1;



	public void preparaJogo(int tipoDePartida){

		ArrayList<Carta> cartas = CriaCartas.criaCartas();
		ArrayList<Jogador> jogadores;

		if(tipoDePartida == Menu.JOGO_CONTRA_CPU){
			jogadores = criaJogadores.criarJogadoresCPU(cartas);
		}else{
			jogadores = criaJogadores.criarJogadoresMPLocal(cartas);
		}

		for (Jogador jogador : jogadores) {

			if(jogador.equals(jogadores.get(JOGADOR_UM))){
				jogador.setOponente(jogadores.get(JOGADOR_DOIS));
				System.out.println("Meu oponente é o jogador: "+jogadores.get(JOGADOR_DOIS).getNome());
			}

			else{
				jogador.setOponente(jogadores.get(JOGADOR_UM));
				System.out.println("Meu oponente é o jogador: "+jogadores.get(JOGADOR_UM).getNome());
			}
		}

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
						jogador.setMana(jogador.getMana() + MANA_POR_RODADA);
					}
				}
			}

			LauncherLocal.fazRodada(jogadores);

			if(jogadores.get(JOGADOR_UM).getVida() < VIDA_MINIMA || jogadores.get(JOGADOR_DOIS).getVida() < VIDA_MINIMA){
				break;
			}

			LauncherLocal.exibePlacar(jogadores);

			LauncherLocal.pressionarEnter();


			numeroRodadas++;
		}

		if(jogadores.get(JOGADOR_UM).getVida() < VIDA_MINIMA){
			System.out.println("Parabens: "+ jogadores.get(JOGADOR_DOIS).getNome()+", você venceu\n");
		}
		else{
			System.out.println("Parabens: "+ jogadores.get(JOGADOR_UM).getNome()+", você venceu\n");
		}
	}

	public static int fazRodada(ArrayList<Jogador> jogadores) {
		int turnoStatus;
		ArrayList<StatusJogador> copia;

		for (Jogador jogador : jogadores) {
			copia = (ArrayList<StatusJogador>) jogador.getStatus().clone();
			for (StatusJogador status : jogador.getStatus()) {
				turnoStatus = status.efeito(jogador);
				if(turnoStatus == 0){
					copia.remove(status);
				}
			}

			jogador.setStatus(copia);

			if(jogadores.get(JOGADOR_UM).getVida() < VIDA_MINIMA || jogadores.get(JOGADOR_DOIS).getVida() < VIDA_MINIMA){
				return 0;
			}

			if(jogador.getJogavel().toString().equals("npc")){
				System.out.println("O CPU está jogando...");
				Carta cartaJogada = jogador.jogar();
				if(!(cartaJogada.getNome().equals("Passar a vez"))){
					System.out.println(cartaJogada.getCdc().toStringSemMana(cartaJogada) + " - " + cartaJogada.getPp().toString());
					cartaJogada.getCdc().efeito(cartaJogada, jogador);
					cartaJogada.getPp().passiva(cartaJogada, jogador);
				}
				else{
					System.out.println(cartaJogada.getNome());
				}

				if(jogadores.get(JOGADOR_UM).getVida() < VIDA_MINIMA || jogadores.get(JOGADOR_DOIS).getVida() < VIDA_MINIMA){
					return 0;
				}

				pressionarEnter();
			}

			else{
				System.out.println("Escolha a carta que você vai jogar: ");
				System.out.println("Você possui: "+ jogador.getMana() + " de mana.");

				int contador = 0;
				System.out.println(contador+": Passar a vez");
				for (Carta carta : jogador.getCartasDaMao()) {
					contador++;
					System.out.println(contador+ ": "+carta.getCdc().toString(carta) + " - " + carta.getPp().toString());
				}

				Carta cartaJogada = jogador.jogar();
				if(!(cartaJogada.getNome().equals("Passar a vez"))){
					System.out.println(cartaJogada.getCdc().toStringSemMana(cartaJogada) + " - " + cartaJogada.getPp().toString());
					cartaJogada.getCdc().efeito(cartaJogada, jogador);
					cartaJogada.getPp().passiva(cartaJogada, jogador);
				}
				else{
					System.out.println(cartaJogada.getNome());
				}

			}

			pressionarEnter();

		}

		return 0;
	}

	private static void exibePlacar(ArrayList<Jogador> jogadores) {
		for (Jogador jogador : jogadores) {
			System.out.println(jogador.getNome() + " " + jogador.getVida() + " pontos de vida. | "+jogador.getMana()+ " pontos de mana.");
		}

	}

	private static void pressionarEnter() {
		System.out.println("Pressione enter para continuar.");
		Scanner input = new Scanner(System.in);
		input.nextLine();
	}
}
