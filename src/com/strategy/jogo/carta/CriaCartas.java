package com.strategy.jogo.carta;

import java.util.ArrayList;

import com.strategy.jogo.carta.comportamentos.passivas.instantaneo.PossuiPassivaCurarVidaInstantaneo;
import com.strategy.jogo.carta.comportamentos.passivas.porRodada.PossuiPassivaCurarVidaPorRodada;
import com.strategy.jogo.carta.comportamentos.passivas.porRodada.PossuiPassivaSangrarPorRodada;

public class CriaCartas {

	public static ArrayList <Carta> criaCartas(){
		ArrayList <Carta> cartas = new ArrayList<Carta>();

		cartas.add(new CartaDeLuta());
		cartas.add(new CartaDeLuta());
		cartas.add(new CartaDeLuta());
		cartas.add(new CartaDeLuta());
		cartas.add(new CartaDeLuta());
		cartas.add(new CartaDeLuta("Lacaio Chefe", 1, 30, new PossuiPassivaSangrarPorRodada(5, 3)));
		cartas.add(new CartaDeLuta("Mago", 2, 10));
		cartas.add(new CartaDeLuta("Mago", 2, 10));
		cartas.add(new CartaDeLuta("Bruxo", 5, 22));
		cartas.add(new CartaDeLuta("Cavaleiro", 6, 20, new PossuiPassivaSangrarPorRodada(2, 3)));
		cartas.add(new CartaDeLuta("Guerreiro", 4, 12, new PossuiPassivaSangrarPorRodada(1, 3)));
		cartas.add(new CartaDeLuta("Guerreiro", 3, 12));
		cartas.add(new CartaDeLuta("Lutador", 5, 21));
		cartas.add(new CartaDeLuta("Arqueiro", 3, 11));
		cartas.add(new CartaDeLuta("Caçador", 6, 21, new PossuiPassivaSangrarPorRodada(3, 3)));
		cartas.add(new CartaDeLuta("Curandeiro", 5, 4, new PossuiPassivaCurarVidaInstantaneo(6)));
		cartas.add(new CartaDeLuta("Curandeiro", 4, 5, new PossuiPassivaCurarVidaPorRodada(2, 2)));
		cartas.add(new CartaDeSuporteRecuperaVida());
		cartas.add(new CartaDeSuporteRecuperaVida());
		cartas.add(new CartaDeSuporteRecuperaVida("Bonus de vida", 0, 5));
		cartas.add(new CartaDeSuporteRecuperaVida("Bonus de vida", 0, 5));
		cartas.add(new CartaDeSuporteRecuperaVida("Sortudo", 0, 15));
		cartas.add(new CartaDeSuporteRecuperaMana());
		cartas.add(new CartaDeSuporteRecuperaMana());
		cartas.add(new CartaDeSuporteRecuperaMana("Bonus de mana", 0, 5));
		cartas.add(new CartaDeSuporteRecuperaMana("Bonus de mana", 0, 5));
		cartas.add(new CartaDeSuporteRecuperaMana("Bonus de mana", 0, 5));
		cartas.add(new CartaDeSuporteRecuperaMana("Sacerdote", 3, 10));


		return cartas;

	}

}
