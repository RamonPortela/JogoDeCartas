package com.strategy.jogo.carta;

import java.util.ArrayList;

public class CriaCartas {

	public static ArrayList <Carta> criaCartas(){
		ArrayList <Carta> cartas = new ArrayList<Carta>();

		cartas.add(new CartaDeLuta());
		cartas.add(new CartaDeLuta());
		cartas.add(new CartaDeLuta());
		cartas.add(new CartaDeLuta());
		cartas.add(new CartaDeLuta());
		cartas.add(new CartaDeLuta("Lacaio Chefe", 1, 30));
		cartas.add(new CartaDeLuta("Mago", 2, 10));
		cartas.add(new CartaDeLuta("Mago", 2, 10));
		cartas.add(new CartaDeLuta("Bruxo", 5, 22));
		cartas.add(new CartaDeLuta("Cavaleiro", 5, 20));
		cartas.add(new CartaDeLuta("Guerreiro", 3, 12));
		cartas.add(new CartaDeLuta("Guerreiro", 3, 12));
		cartas.add(new CartaDeLuta("Lutador", 5, 21));
		cartas.add(new CartaDeLuta("Arqueiro", 3, 11));
		cartas.add(new CartaDeLuta("Caçador", 5, 21));
		cartas.add(new CartaDeSuporteRecuperaVida());
		cartas.add(new CartaDeSuporteRecuperaVida());
		cartas.add(new CartaDeSuporteRecuperaVida("Bonus de vida", 0, 5));
		cartas.add(new CartaDeSuporteRecuperaVida("Bonus de vida", 0, 5));
		cartas.add(new CartaDeSuporteRecuperaVida("Sortudo", 0, 15));
		cartas.add(new CartaDeSuporteRecuperaVida("Curandeiro", 2, 10));
		cartas.add(new CartaDeSuporteRecuperaVida("Curandeiro", 2, 10));
		cartas.add(new CartaDeSuporteRecuperaMana());
		cartas.add(new CartaDeSuporteRecuperaMana());
		cartas.add(new CartaDeSuporteRecuperaMana("Bonus de mana", 0, 5));
		cartas.add(new CartaDeSuporteRecuperaMana("Bonus de mana", 0, 5));
		cartas.add(new CartaDeSuporteRecuperaMana("Bonus de mana", 0, 5));
		cartas.add(new CartaDeSuporteRecuperaMana("Sacerdote", 3, 10));


		return cartas;

	}

}
