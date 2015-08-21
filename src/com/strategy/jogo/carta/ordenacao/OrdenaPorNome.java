package com.strategy.jogo.carta.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.strategy.jogo.carta.Carta;



public class OrdenaPorNome implements Ordenavel{

	private static final long serialVersionUID = 11L;

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
