package com.strategy.jogo.menu;

import java.util.Scanner;

import com.strategy.jogo.launcher.local.LauncherLocal;
import com.strategy.jogo.launcher.multiplayer.online.LauncherMultiPlayer;

public class Menu {

	private static final int SAIR = 0;
	private static final int PRIMEIRA_OPCAO = 1;
	private static final int SEGUNDA_OPCAO = 2;
	private static final int TERCEIRA_OPCAO = 3;

	public static final int JOGO_CONTRA_CPU = 1;
	public static final int JOGO_MULTIPLAYER_LOCAL = 2;

	public static final int CRIAR_SERVIDOR = 1;
	public static final int ENTRAR_EM_SERVIDOR = 2;

	public static void menuPrincipal() {

		Scanner input = new Scanner(System.in);
		LauncherLocal launcher = new LauncherLocal();
		int opcaoMenu;

		do{
			System.out.println("0 - Sair do jogo");
			System.out.println("1 - Jogar contra CPU: ");
			System.out.println("2 - Jogar Multiplayer");
			System.out.println("Entre com a opção desejada: ");
			opcaoMenu = input.nextInt();

			switch (opcaoMenu) {
			case SAIR:
				break;

			case PRIMEIRA_OPCAO:
				launcher.preparaJogo(JOGO_CONTRA_CPU);
				break;

			case SEGUNDA_OPCAO:
				subMenuMultiPlayer();
				break;

			default:
				System.out.println("Opção inválida.");
			}

		}while(opcaoMenu != SAIR);

	}

	private static void subMenuMultiPlayer(){
		Scanner input = new Scanner(System.in);
		LauncherLocal launcher = new LauncherLocal();
		LauncherMultiPlayer launcherOnline = new LauncherMultiPlayer();
		int opcaoMenu;

		do{
			System.out.println("0 - Voltar para menu principal");
			System.out.println("1 - MultiPlayer local");
			System.out.println("2 - Criar uma partida online");
			System.out.println("3 - Se juntar a uma partida online");
			opcaoMenu = input.nextInt();

			switch (opcaoMenu) {
			case SAIR:
				break;

			case PRIMEIRA_OPCAO:
				launcher.preparaJogo(JOGO_MULTIPLAYER_LOCAL);
				break;

			case SEGUNDA_OPCAO:
				launcherOnline.selecionaOpcao(CRIAR_SERVIDOR);
				break;

			case TERCEIRA_OPCAO:
				launcherOnline.selecionaOpcao(ENTRAR_EM_SERVIDOR);
				break;

			default:
				System.out.println("Opção inválida.");
			}

		}while(opcaoMenu != SAIR);
	}
}
