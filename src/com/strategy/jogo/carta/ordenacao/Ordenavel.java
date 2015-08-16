package com.strategy.jogo.carta.ordenacao;

import java.util.ArrayList;

import com.strategy.jogo.carta.Carta;


public interface Ordenavel {

	public abstract ArrayList<Carta> embaralha(ArrayList<Carta> deck);

}
