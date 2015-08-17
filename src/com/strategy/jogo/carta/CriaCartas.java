package com.strategy.jogo.carta;

import java.util.ArrayList;

import com.strategy.jogo.carta.comportamentos.passivas.PossuiPassivaSangrar;
import com.strategy.jogo.jogador.status.StatusSangramento;

public class CriaCartas {

	public static ArrayList <Carta> criaCartas(){
		ArrayList <Carta> cartas = new ArrayList<Carta>();

		cartas.add(new CartaDeLuta());
		cartas.add(new CartaDeLuta());
		cartas.add(new CartaDeLuta());
		cartas.add(new CartaDeLuta());
		cartas.add(new CartaDeLuta());
		cartas.add(new CartaDeLuta("Lacaio Chefe", 1, 30, new PossuiPassivaSangrar(5, 3)));
		cartas.add(new CartaDeLuta("Mago", 2, 10));
		cartas.add(new CartaDeLuta("Mago", 2, 10));
		cartas.add(new CartaDeLuta("Bruxo", 5, 22));
		cartas.add(new CartaDeLuta("Cavaleiro", 6, 20, new PossuiPassivaSangrar(2, 3)));
		cartas.add(new CartaDeLuta("Guerreiro", 4, 12, new PossuiPassivaSangrar(1, 3)));
		cartas.add(new CartaDeLuta("Guerreiro", 3, 12));
		cartas.add(new CartaDeLuta("Lutador", 5, 21));
		cartas.add(new CartaDeLuta("Arqueiro", 3, 11));
		cartas.add(new CartaDeLuta("Caçador", 6, 21, new PossuiPassivaSangrar(3, 3)));
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
