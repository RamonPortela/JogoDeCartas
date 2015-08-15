package com.strategy.jogo.jogador;

import java.util.ArrayList;

import com.strategy.jogo.carta.Carta;

public interface Jogavel {
	abstract Carta escolheCarta(ArrayList<Carta> cartasDaMao);
}
