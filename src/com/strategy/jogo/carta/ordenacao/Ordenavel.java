package com.strategy.jogo.carta.ordenacao;

import java.io.Serializable;
import java.util.ArrayList;

import com.strategy.jogo.carta.Carta;


public interface Ordenavel extends Serializable{

	public abstract ArrayList<Carta> embaralha(ArrayList<Carta> deck);

}
