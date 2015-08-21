package com.strategy.jogo.launcher.multiplayer.online;

import com.strategy.jogo.menu.Menu;

public class LauncherMultiPlayer {
	public static final int CRIAR_SERVIDOR = 1;

	public void selecionaOpcao(int tipoDePartida){

		if(tipoDePartida == Menu.CRIAR_SERVIDOR){

		}else{
			new EntrarEmPartidaOnline();

		}

	}

}
