package com.strategy.jogo.jogador.comportamento;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.carta.PassarAVez;
import com.strategy.jogo.jogador.Jogador;

public class ComportamentoDeNPC implements ComportamentoJogador{

	private static final int CUSTO_PASSAR_VEZ = 0;
	private static final int CORRETOR_OPCAO = 1;
	private static final int VALOR_MININO_MANA = 0;

	@Override
	public Carta escolheCarta(Jogador jogador) {
		int contadorDeCartas = 0;
		int numeroDaCarta = 0;
		boolean escolheOutra = false;
		Carta carta;

		carta = jogador.getCartasDaMao().get((int) (Math.random() * (jogador.getCartasDaMao().size() - CORRETOR_OPCAO)));

		for (Carta cartaASerContada : jogador.getCartasDaMao()) {
			if((jogador.getMana() - cartaASerContada.getCusto()) < VALOR_MININO_MANA){
				contadorDeCartas++;
			}
		}

		if(contadorDeCartas < jogador.getCartasDaMao().size() - CORRETOR_OPCAO){
			do{
				numeroDaCarta = (int) (Math.random() * (jogador.getCartasDaMao().size() - CORRETOR_OPCAO));

				escolheOutra = false;

				carta = jogador.getCartasDaMao().get(numeroDaCarta);
				if((jogador.getMana() - carta.getCusto()) < VALOR_MININO_MANA){
					escolheOutra = true;
				}
			}while(escolheOutra);
		}
		else{
			carta = new PassarAVez("Passar a vez", CUSTO_PASSAR_VEZ);
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
