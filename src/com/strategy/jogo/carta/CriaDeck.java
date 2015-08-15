package com.strategy.jogo.carta;

import java.util.ArrayList;
import java.util.LinkedList;

public class CriaDeck {
	
	private static final int TOTAL_CARTAS = 21;
	
	public static LinkedList<Carta> criaDeck(ArrayList<Carta> cartas){
		
		LinkedList<Carta> deck = new LinkedList<Carta>();
		for (int contador = 0; contador < TOTAL_CARTAS; contador++) {
			deck.add(cartas.get(((int) (Math.random() * 20))));
		}		
		
		return deck;
	}
	
}
