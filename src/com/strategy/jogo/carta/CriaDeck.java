package com.strategy.jogo.carta;

import java.util.ArrayList;
import java.util.LinkedList;

public class CriaDeck {
	
	private static final int QUANTIDADE_CARTAS_DECK = 30;
	private static final int TOTAL_CARTAS = 20;
	
	public static LinkedList<Carta> criaDeck(ArrayList<Carta> cartas){
		
		LinkedList<Carta> deck = new LinkedList<Carta>();
		for (int contador = 0; contador < QUANTIDADE_CARTAS_DECK; contador++) {
			deck.add(cartas.get(((int) (Math.random() * TOTAL_CARTAS))));
		}		
		
		return deck;
	}
	
}
