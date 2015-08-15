package com.strategy.jogo.carta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



public class OrdenaPorNome implements Ordenavel{

	@Override
	public ArrayList<Carta> embaralha(ArrayList<Carta> deck) {
		Collections.sort(deck, OrdenaPorNome.EmbaralhaNome);
		
		return deck;
	}
	
	public static Comparator<Carta> EmbaralhaNome = new Comparator<Carta>(){
		public int compare(Carta c1, Carta c2){
			String nomeCarta1 = c1.getNome().toUpperCase();
			String nomeCarta2 = c2.getNome().toUpperCase();
			
			return nomeCarta1.compareTo(nomeCarta2);
		}
	};

}
