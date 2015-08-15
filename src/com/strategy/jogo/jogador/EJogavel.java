package com.strategy.jogo.jogador;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.strategy.jogo.carta.Carta;

public class EJogavel implements Jogavel{

	public Carta escolheCarta(ArrayList<Carta> cartasDaMao) {
		boolean temExcecao = false;
		Scanner input = new Scanner(System.in);
		int numeroCarta = 0;
		
		do{
			temExcecao = false;
			System.out.println("Escolha uma carta para jogar: ");
			try{				
				numeroCarta = input.nextInt();
			}catch(InputMismatchException e){
				System.out.println("Selecione uma carta. ");
				temExcecao = true;
			}
			
			if(numeroCarta < 0 || numeroCarta > 4){
				temExcecao = true;
			}
			
		}while(temExcecao);
		Carta carta = cartasDaMao.get(numeroCarta);
		cartasDaMao.remove(numeroCarta);
		
		return carta;
	}
	
	@Override
	public String toString() {
		String descricao= "jogavel";
		return descricao;
	}
	
}
