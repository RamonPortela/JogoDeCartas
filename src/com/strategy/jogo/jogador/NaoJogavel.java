package com.strategy.jogo.jogador;

import com.strategy.jogo.carta.Carta;

public class NaoJogavel implements Jogavel{

	@Override
	public Carta escolheCarta(Jogador jogador) {
		int contadorDeCartas = 0;
		int numeroDaCarta = 0;
		boolean escolheOutra = false;
		Carta carta;
		
		//Carta carta = jogador.getCartasDaMao().get((int) (Math.random() * 5));
		
		for (Carta cartaASerContada : jogador.getCartasDaMao()) {
			if((jogador.getMana() - cartaASerContada.getCusto()) < 0){
				contadorDeCartas++;
			}
		}
		
		if(contadorDeCartas < jogador.getCartasDaMao().size() - 1){
			do{				
				numeroDaCarta = (int) (Math.random() * 5);
				
				escolheOutra = false;
				
				carta = jogador.getCartasDaMao().get(numeroDaCarta);
				if((jogador.getMana() - carta.getCusto()) < 0){
					escolheOutra = true;
				}				
			}while(escolheOutra);
		}
		else{
			carta = new Carta("Passar a vez", 0, 0);
		}
		
		jogador.setMana(jogador.getMana() - carta.getCusto());
		System.out.println("Sua mana atual é: "+jogador.getMana());
		jogador.getCartasDaMao().remove(numeroDaCarta);
		
		return carta;
	}
	
	@Override
	public String toString() {
		String descricao = "npc";
		return descricao;
	}
}
