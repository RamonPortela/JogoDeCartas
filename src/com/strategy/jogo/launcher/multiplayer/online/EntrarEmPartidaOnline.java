package com.strategy.jogo.launcher.multiplayer.online;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.strategy.jogo.carta.Carta;
import com.strategy.jogo.carta.CriaCartas;
import com.strategy.jogo.jogador.Jogador;
import com.strategy.jogo.jogador.criaJogadores;
import com.strategy.jogo.jogador.comportamento.ComportamentoDeJogador;
import com.strategy.jogo.jogador.status.StatusInicial;

public class EntrarEmPartidaOnline {

	Socket socket;
	ObjectOutputStream escritor;
	ObjectInputStream leitor;
	Jogador jogador;

	private void entrarEmPartida(){

		try {
			socket = new Socket("localhost", 12345);

			escritor = new ObjectOutputStream(socket.getOutputStream());
			leitor = new ObjectInputStream(socket.getInputStream());

			this.enviarInfoJogador();

		} catch (UnknownHostException e) {
			System.out.println("Servidor não encontrado.");

		} catch (IOException e) {
			System.out.println("Erro na conexão.");
		}

	}

	public EntrarEmPartidaOnline(){

		this.entrarEmPartida();

	}

	private void enviarInfoJogador(){

		ArrayList<Carta> cartas;

		try {
			cartas = ((ArrayList<Carta>) leitor.readObject());
			int identificador = leitor.readInt();

			this.jogador = new Jogador(criaJogadores.ledadosJogador(), cartas, identificador, new ComportamentoDeJogador(), new StatusInicial());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			this.escritor.writeObject(this.jogador);
			this.escritor.flush();

			for (Carta carta : this.jogador.getCartasDaMao()) {
				System.out.println(carta.getNome());
			}

			try {

				if(this.jogador.getIdentificador() == ((Jogador) leitor.readObject()).getIdentificador()){
					System.out.println(leitor.readObject());
				}

				while(true){

					try {
						String texto = (String) leitor.readObject();
						System.out.println(texto);

						if(this.jogador.getIdentificador() != ((Jogador) leitor.readObject()).getIdentificador()){
							System.out.println("Aguarde sua vez...");
						}


					} catch (ClassNotFoundException e) {

						e.printStackTrace();
						break;
					} catch (IOException e) {
						e.printStackTrace();
						break;
					}
				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		} catch (IOException /*| ClassNotFoundException */e) {
			System.out.println("Errroooo");
			e.printStackTrace();
		}

	}

}
