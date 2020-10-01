package JuegoCartas;

import java.util.Collections;

public class Juego {

	private int puntos1;
	private int puntos2;
	private Jugador jugador1;
	private Jugador jugador2;
	private Mazo mazo;
	
	public Juego() {
		puntos1=0;
		puntos2=0;
	}
	
	public void jugar() {
		Mazo poso1;
		Mazo poso2;
		this.repartir(poso1, poso2);
		jugador1.elegirCarta(poso1);
		jugador2.elegirCarta(poso2);
		jugador1.elegirAtributo(cartaJugador1);
		jugador2.elegirAtributo(cartaJugador2);
		
	}
	
	public Mazo repartir(Mazo poso1, Mazo poso2) {
		mazo.mezclar();
		mazo.separaEnPosos(poso1, poso2);
	}
	
	public Jugador getGanador() {
		if (puntos1>puntos2) {
			return "Jugador 1";
		} else if (puntos2>puntos1) {
			return "Jugador 2";
		} else {
			return null;
		}
	}
}
