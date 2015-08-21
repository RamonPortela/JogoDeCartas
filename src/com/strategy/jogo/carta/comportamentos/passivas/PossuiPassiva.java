package com.strategy.jogo.carta.comportamentos.passivas;

import java.io.Serializable;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.jogador.Jogador;

public interface PossuiPassiva extends Serializable{
	public void passiva(Carta carta, Jogador jogadorQueUsou);

}
