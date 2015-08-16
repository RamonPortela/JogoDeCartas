package com.strategy.jogo.jogador;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.carta.PassarAVez;

public class EJogavel implements ComportamentoJogador{
	private static final int OPCAO_MINIMA = 0;
	private static final int OPCAO_MAXIMA = 4;
	private static final int VALOR_MINIMO_MANA = 0;
	private static final int CORRETOR_OPCAO = 1;

	public Carta escolheCarta(Jogador jogador) {
		Carta c;
		int contadorDeCartas = 0;
		int numeroDaCarta;

		for(Carta cartaASerContada : jogador.getCartasDaMao()){
			if((jogador.getMana() - cartaASerContada.getCusto()) < 0){
				contadorDeCartas++;
			}
		}

		if(!(contadorDeCartas < jogador.getCartasDaMao().size() - 1)){
			c = new PassarAVez("Passar a vez", 0);
			return c;
		}

		boolean temProblema = false;
		Scanner input = new Scanner(System.in);
		int numeroCarta = OPCAO_MINIMA;
		do{
			temProblema = false;
			System.out.println("Escolha uma carta para jogar: ");
			try{
				numeroCarta = (input.nextInt() - CORRETOR_OPCAO);
			}catch(InputMismatchException e){
				System.out.println("Selecione uma carta. ");
				temProblema = true;
			}

			if(numeroCarta < OPCAO_MINIMA || numeroCarta > OPCAO_MAXIMA){
				temProblema = true;
			}
			else{
				if((jogador.getMana() - jogador.getCartasDaMao().get(numeroCarta).getCusto() < VALOR_MINIMO_MANA)){
					System.out.println("Você não possui mana para usar esta carta.");
					temProblema = true;
				}
			}

		}while(temProblema);

		Carta carta = jogador.getCartasDaMao().get(numeroCarta);
		jogador.setMana(jogador.getMana() - jogador.getCartasDaMao().get(numeroCarta).getCusto());
		jogador.getCartasDaMao().remove(numeroCarta);

		return carta;
	}

	@Override
	public String toString() {
		String descricao= "jogavel";
		return descricao;
	}

}
