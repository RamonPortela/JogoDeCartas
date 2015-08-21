package com.strategy.jogo.launcher.multiplayer.online;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.strategy.jogo.Jogo;
import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.carta.CriaCartas;
import com.strategy.jogo.jogador.Jogador;
import com.strategy.jogo.jogador.status.StatusJogador;
import com.strategy.jogo.launcher.local.LauncherLocal;

public class CriaServidor {

	ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	ArrayList<Carta> cartas = new ArrayList<Carta>();



	public static void main(String[] args) {
		new CriaServidor();
	}

	private class EscutaJogador implements Runnable{

		Jogador jogadorRecebido;
		ObjectInputStream leitor;
		ObjectOutputStream escritor;
		Socket cliente;

		public EscutaJogador(Socket cliente, Jogador jogador, ObjectOutputStream escritor, ObjectInputStream leitor){
			System.out.println("Entrei no escuta jogador.");

			try {
				this.jogadorRecebido = jogador;

				this.cliente = cliente;

				this.escritor = escritor;
				this.leitor = leitor;

				System.out.println("Cheguei no escuta jogador");

			}finally{

				jogadores.get(0).setOponente(jogadores.get(1));
				jogadores.get(1).setOponente(jogadores.get(0));

			}

		}

		private int fazRodada(Jogador jogador) {
			int turnoStatus;
			ArrayList<StatusJogador> copia;

				copia = (ArrayList<StatusJogador>) jogador.getStatus().clone();
				for (StatusJogador status : jogador.getStatus()) {
					turnoStatus = status.efeito(jogador);
					if(turnoStatus == 0){
						copia.remove(status);
					}
				}

				jogador.setStatus(copia);

				if(jogadores.get(0).getVida() < 1 || jogadores.get(1).getVida() < 1){
					return 0;
				}

				if(jogador.getJogavel().toString().equals("npc")){
					System.out.println("O CPU está jogando...");
					Carta cartaJogada = jogador.jogar();
					if(!(cartaJogada.getNome().equals("Passar a vez"))){
						System.out.println(cartaJogada.getCdc().toStringSemMana(cartaJogada) + " - " + cartaJogada.getPp().toString());
						cartaJogada.getCdc().efeito(cartaJogada, jogador);
						cartaJogada.getPp().passiva(cartaJogada, jogador);
					}
					else{
						System.out.println(cartaJogada.getNome());
					}

					if(jogadores.get(0).getVida() < 1 || jogadores.get(1).getVida() < 1){
						return 0;
					}

				}

				else{
					System.out.println("Escolha a carta que você vai jogar: ");
					System.out.println("Você possui: "+ jogador.getMana() + " de mana.");

					int contador = 0;
					System.out.println(contador+": Passar a vez");
					for (Carta carta : jogador.getCartasDaMao()) {
						contador++;
						System.out.println(contador+ ": "+carta.getCdc().toString(carta) + " - " + carta.getPp().toString());
					}

					Carta cartaJogada = jogador.jogar();
					if(!(cartaJogada.getNome().equals("Passar a vez"))){
						System.out.println(cartaJogada.getCdc().toStringSemMana(cartaJogada) + " - " + cartaJogada.getPp().toString());
						cartaJogada.getCdc().efeito(cartaJogada, jogador);
						cartaJogada.getPp().passiva(cartaJogada, jogador);
					}
					else{
						System.out.println(cartaJogada.getNome());
					}

				}

			return 0;
		}

		private void exibePlacar(ArrayList<Jogador> jogadores) {
			for (Jogador jogador : jogadores) {
				System.out.println(jogador.getNome() + " " + jogador.getVida() + " pontos de vida. | "+jogador.getMana()+ " pontos de mana.");
			}

		}

		@Override
		public void run() {

			try {

				Jogo jogo = new Jogo(jogadores, cartas);

				escritor.writeObject("Inciando a partida...");
				escritor.flush();

				boolean primeiraRodada = true;
				int numeroRodadas = 0;

				while(true){
					while((jogo.getJogadores().get(0).getVida() > 0) && (jogo.getJogadores().get(1).getVida() > 0)){

						if(primeiraRodada){
							jogadorRecebido.setCartasDaMao(jogadorRecebido.getDeck(), 5);
							primeiraRodada = false;

						}else{
							jogadorRecebido.setCartasDaMao(jogadorRecebido.getDeck(), 1);
							if((numeroRodadas % 2) == 0){
								jogadorRecebido.setMana(jogadorRecebido.getMana() + 1);
							}
						}

						fazRodada(jogadorRecebido);

						if(jogadores.get(0).getVida() < 1 || jogadores.get(0).getVida() < 1){
							break;
						}

						exibePlacar(jogadores);

						numeroRodadas++;
					}

					if(jogadores.get(0).getVida() < 1){
						System.out.println("Parabens: "+ jogadores.get(1).getNome()+", você venceu\n");
					}
					else{
						System.out.println("Parabens: "+ jogadores.get(0).getNome()+", você venceu\n");
					}
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public CriaServidor(){
		ServerSocket servidor;
		Jogador jogadorRecebido;

		try {

			servidor = new ServerSocket(12345);

			while(true){

				Socket jogador1 = new Socket();
				Socket jogador2 = new Socket();

				ObjectInputStream leitor1 = null;
				ObjectOutputStream escritor1 = null;
				ObjectInputStream leitor2 = null;
				ObjectOutputStream escritor2 = null;

				ObjectInputStream leitor;
				ObjectOutputStream escritor;

				cartas = CriaCartas.criaCartas();

				for (int contadorJogadores = 0; contadorJogadores < 2; contadorJogadores++) {

					if(contadorJogadores < 1){
						jogador1 = servidor.accept();
						escritor = new ObjectOutputStream(jogador1.getOutputStream());
						escritor1 = escritor;

						escritor.writeObject(cartas);
						escritor.flush();

						escritor.writeInt(contadorJogadores);
						escritor.flush();

						leitor = new ObjectInputStream(jogador1.getInputStream());
						leitor1 = leitor;

						jogadorRecebido = ((Jogador) leitor.readObject());
						jogadores.add(jogadorRecebido);

						System.out.println("Jogador com o IP: "+jogador1.getInetAddress()+ " se conectou.");

						escritor.writeObject(jogadorRecebido);
						escritor.writeObject("Aguardando adversário...");
						escritor.flush();
					}
					else{
						jogador2 = servidor.accept();
						escritor = new ObjectOutputStream(jogador2.getOutputStream());
						escritor2 = escritor;

						escritor.writeObject(cartas);
						escritor.flush();

						escritor.writeInt(contadorJogadores);
						escritor.flush();

						leitor = new ObjectInputStream(jogador2.getInputStream());
						leitor2 = leitor;

						jogadorRecebido = ((Jogador) leitor.readObject());
						jogadores.add(jogadorRecebido);
						escritor.writeObject(jogadores.get(0));

						System.out.println("Jogador com o IP: "+jogador2.getInetAddress()+ " se conectou.");
					}

					if(contadorJogadores < 1){

						System.out.println("Aguardando outro jogador...");
					}

				}

				new Thread(new EscutaJogador(jogador1, jogadores.get(0), escritor1, leitor1)).start();
				new Thread(new EscutaJogador(jogador2, jogadores.get(1), escritor2, leitor2)).start();


			}
		}catch(IOException e){
			System.out.println("naõ sei o que deu errado");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
