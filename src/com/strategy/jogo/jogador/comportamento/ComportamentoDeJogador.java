package com.strategy.jogo.jogador.comportamento;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.carta.PassarAVez;
import com.strategy.jogo.jogador.Jogador;

public class ComportamentoDeJogador implements ComportamentoJogador{

	private static final long serialVersionUID = 20001L;

	private static final int CUSTO_PASSAR_VEZ = 0;
	private static final int OPCAO_MINIMA = -1;
	private static final int VALOR_MINIMO_MANA = 0;
	private static final int CORRETOR_OPCAO = 1;

	public Carta escolheCarta(Jogador jogador) {
		Carta c;
		int contadorDeCartas = 0;

		for(Carta cartaASerContada : jogador.getCartasDaMao()){
			if((jogador.getMana() - cartaASerContada.getCusto()) < VALOR_MINIMO_MANA){
				contadorDeCartas++;
			}
		}

		if(!(contadorDeCartas < jogador.getCartasDaMao().size() - CORRETOR_OPCAO)){
			c = new PassarAVez("Passar a vez", CUSTO_PASSAR_VEZ);
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

			if(numeroCarta < OPCAO_MINIMA || numeroCarta > (jogador.getCartasDaMao().size() - CORRETOR_OPCAO)){
				temProblema = true;
			}
			else{
				if(numeroCarta == OPCAO_MINIMA){
					c = new PassarAVez("Passar a vez", CUSTO_PASSAR_VEZ);
					return c;
				}
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
	public boolean equals(Object comportamento) {
		if(this == comportamento)
			return true;

		if(comportamento == null)
			return false;

		if(comportamento instanceof ComportamentoDeJogador){
			ComportamentoDeJogador outroComportamento = ((ComportamentoDeJogador) comportamento);

			return (this.toString().equals(outroComportamento.toString()));
		}
		else{
			return false;
		}

	}

	@Override
	public String toString() {
		String descricao= "jogavel";
		return descricao;
	}

}
