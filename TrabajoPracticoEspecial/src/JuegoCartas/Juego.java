package JuegoCartas;

import java.util.*;

public class Juego {

	private int puntos1;
	private int puntos2;
	private Jugador jugador1;
	private Jugador jugador2;
	private Mazo mazo;
	private int rondas;
	
	public Juego() {
		puntos1=0;
		puntos2=0;
		ArrayList<Mazo> poso1=new ArrayList<>();
		ArrayList<Mazo> poso2= new ArrayList<>();
	}
	
	public void jugar() {
		this.repartir(poso1, poso2);
		Carta carta1=jugador1.elegirCarta(poso1);
		Carta carta2=jugador2.elegirCarta(poso2);
		Atributo atributo1=jugador1.elegirAtributo(carta1);
		Atributo atributo2=jugador2.elegirAtributo(carta2);
		Jugador ganador=this.compararAtributos(carta1, carta2, atributo1, atributo2);
		this.eliminarCartasElegidas(carta1, carta2, poso1, poso2);
		//como obtener al perdedor.
		this.juntarCarta(ganador.getCarta(), cartaJugadorPerdedor, ganador.getPoso(), posoPerdedor, mazo);
		rondas++;
		if((poso1.size()==0) || (poso2.size()==0) || (rondas==10)) {
			this.getGanador();
		}
		else {
			this.jugar();
		}
	}
	
	public void repartir(Mazo poso1, Mazo poso2) {
		mazo.mezclar();
		mazo.separaEnPosos(poso1, poso2, mazo);
	}
	
	public Jugador getGanador() {
		if (puntos1>puntos2) {
			return jugador1;
		} else if (puntos2>puntos1) {
			return jugador2;
		} else {
			return null;
		}
	}
	
	public Jugador compararAtributos(Carta cartaJugador1, Carta cartaJugador2, Atributo atributo1, Atributo atributo2) {
		if (atributo1.getValor()>atributo2.getValor()) {
			jugador1.incrementarPuntos(puntos1);
			return jugador1;
		}
		else if(atributo2.getValor()>atributo1.getValor()){
			jugador2.incrementarPuntos(puntos2);
			return jugador2;
		}
		return null;
	}
	
	public void juntarCarta(Carta cartaJugadorGanador, Carta cartaJugadorPerdedor, Mazo posoGanador, Mazo posoPerdedor, Mazo mazoCentral) {
		posoGanador.addCarta(cartaJugadorGanador, mazoCentral);
		posoGanador.addCarta(cartaJugadorPerdedor, mazoCentral);
	}
	
	public void eliminarCartasElegidas(Carta carta1, Carta carta2, Mazo poso1, Mazo poso2) {
		poso1.removeCarta(carta1);
		poso2.removeCarta(carta2);
	}
}
