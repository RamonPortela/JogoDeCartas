package com.strategy.jogo.carta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrdenaPorPontuacao implements Ordenavel{

	@Override
	public ArrayList<Carta> embaralha(ArrayList<Carta> deck) {
		Collections.sort(deck, OrdenaPorPontuacao.EmbaralhaPonto);
		
		return deck;
	}
	
	public static Comparator<Carta> EmbaralhaPonto= new Comparator<Carta>(){
		public int compare(Carta c1, Carta c2){
			int pontoCarta1 = c1.getDano();
			int pontoCarta2 = c2.getDano();
			
			return pontoCarta1-pontoCarta2;
		}
	};

}
