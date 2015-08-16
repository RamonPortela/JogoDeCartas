package com.strategy.jogo.jogador.comportamento;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.carta.CartaDeLuta;
import com.strategy.jogo.carta.PassarAVez;
import com.strategy.jogo.jogador.Jogador;

public class ComportamentoDeNPC implements ComportamentoJogador{

	private static final int NUMERO_TOTAL_DE_CARTAS = 5;
	private static final int NUMERO_MININO_MANA = 0;

	@Override
	public Carta escolheCarta(Jogador jogador) {
		int contadorDeCartas = 0;
		int numeroDaCarta = 0;
		boolean escolheOutra = false;
		Carta carta;

		carta = jogador.getCartasDaMao().get((int) (Math.random() * NUMERO_TOTAL_DE_CARTAS));

		for (Carta cartaASerContada : jogador.getCartasDaMao()) {
			if((jogador.getMana() - cartaASerContada.getCusto()) < NUMERO_MININO_MANA){
				contadorDeCartas++;
			}
		}

		if(contadorDeCartas < jogador.getCartasDaMao().size() - 1){
			do{
				numeroDaCarta = (int) (Math.random() * (jogador.getCartasDaMao().size() - 1));

				escolheOutra = false;

				carta = jogador.getCartasDaMao().get(numeroDaCarta);
				if((jogador.getMana() - carta.getCusto()) < NUMERO_MININO_MANA){
					escolheOutra = true;
				}
			}while(escolheOutra);
		}
		else{
			carta = new PassarAVez("Passar a vez", NUMERO_MININO_MANA);
		}

		jogador.setMana((jogador.getMana() - carta.getCusto()));
		jogador.getCartasDaMao().remove(numeroDaCarta);

		return carta;
	}

	@Override
	public String toString() {
		String descricao = "npc";
		return descricao;
	}
}
