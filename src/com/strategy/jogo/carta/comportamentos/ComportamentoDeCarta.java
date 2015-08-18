package com.strategy.jogo.carta.comportamentos;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.jogador.Jogador;

public interface ComportamentoDeCarta {
	public void efeito(Carta carta, Jogador jogadorQueUsou);

	String toString(Carta carta);
	String toStringSemMana(Carta carta);
}
