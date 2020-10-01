package JuegoCartas;

import java.util.*;

public class Mazo {

	private ArrayList<Carta> cartas;
	
	public Mazo() {
		new ArrayList<Carta>();
	}
	
	public void mezclar() {
		Collections.shuffle(cartas);
	}
	
	public void separaEnPosos(Mazo poso1, Mazo poso2) {
		for(int i=0; i<cartas.size()/2;i++) {
			poso1.addCarta(cartas.remove(i));
		}
		for (int f=0;f<cartas.size();f++){
			poso2.addCarta(cartas.remove(f));
		}
	}
	
	public Carta getPrimeraCarta() {
		return cartas.get(0);
	}
	
	public void juntarCarta(Carta cartaJugadorGanador, Carta cartaJugadorPerdedor, Mazo posoGanador, Mazo posoPerdedor) {
		posoGanador.addCarta(cartaJugadorGanador);
		posoGanador.addCarta(cartaJugadorPerdedor);
	}
	
	public void eliminarCartasElegidas() {
		
	}
	
	public void addCarta(Carta c) {
		//comprobar si las cartas son correctas para poder agregarlas al array de cartas.
		cartas.add(c);
	}
}
