package com.strategy.jogo.carta.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.strategy.jogo.carta.Carta;

public class OrdernaPorCusto implements Ordenavel{

	private static final long serialVersionUID = 12L;

	@Override
	public ArrayList<Carta> embaralha(ArrayList<Carta> deck) {
		Collections.sort(deck, OrdernaPorCusto.OrdenaCusto);

		return deck;
	}

	public static Comparator<Carta> OrdenaCusto= new Comparator<Carta>(){
		public int compare(Carta c1, Carta c2){
			int pontoCarta1 = c1.getCusto();
			int pontoCarta2 = c2.getCusto();

			return pontoCarta1-pontoCarta2;
		}
	};

}
