package com.strategy.jogo.jogador;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.strategy.jogo.carta.Carta;

public class EJogavel implements Jogavel{

	public Carta escolheCarta(Jogador jogador) {
		boolean temProblema = false;
		Scanner input = new Scanner(System.in);
		int numeroCarta = 0;
		do{
			temProblema = false;
			System.out.println("Escolha uma carta para jogar: ");
			try{				
				numeroCarta = input.nextInt();
			}catch(InputMismatchException e){
				System.out.println("Selecione uma carta. ");
				temProblema = true;
			}
			
			if(numeroCarta < 0 || numeroCarta > 4){
				temProblema = true;
			}
			
			if((jogador.getMana() - jogador.getCartasDaMao().get(numeroCarta).getCusto() < 0)){
				System.out.println("Você não possui mana para usar esta carta.");
				temProblema = true;
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
