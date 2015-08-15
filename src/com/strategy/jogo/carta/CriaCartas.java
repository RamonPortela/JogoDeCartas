package com.strategy.jogo.carta;

import java.util.ArrayList;

public class CriaCartas {
	
	public static ArrayList <Carta> criaCartas(){
		ArrayList <Carta> cartas = new ArrayList<Carta>();
		
		cartas.add(new Carta());		
		cartas.add(new Carta());
		cartas.add(new Carta());
		cartas.add(new Carta());
		cartas.add(new Carta());
		cartas.add(new Carta("Guerreiro", 3, 12));
		cartas.add(new Carta("Mago", 2, 10));
		cartas.add(new Carta("Mago", 2, 10));
		cartas.add(new Carta("Bruxo", 5, 22));
		cartas.add(new Carta("Cavaleiro", 5, 20));
		cartas.add(new Carta("Guerreiro", 3, 12));
		cartas.add(new Carta("Bonus pontuacao", 0, 5));
		cartas.add(new Carta("Bonus pontuacao", 0, 5));
		//cartas.add(new Carta("Azarado", 0, -5));
		cartas.add(new Carta("Sortudo", 0, 15));
		cartas.add(new Carta("Mestre", 5, 21));
		cartas.add(new Carta("Caçador", 3, 11));
		cartas.add(new Carta("Arqueiro", 3, 11));
		cartas.add(new Carta("Curandeiro", 2, 10));
		cartas.add(new Carta("Curandeiro", 2, 10));
		cartas.add(new Carta("Lacaio Chefe", 1, 30));
		
		return cartas;
		
	}

}
