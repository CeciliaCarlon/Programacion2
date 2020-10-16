package JuegoCartas;

import java.util.*;

public class Juego {

	private int puntos1;
	private int puntos2;
	private Jugador jugador1;
	private Jugador jugador2;
	private Mazo mazo;
	private int rondas;
	private int turnos;
	private int MAXRONDAS=10;
	private int MAXTURNOS=10;
	
	public Juego() {
		puntos1=0;
		puntos2=0;
		rondas=0;
		turnos=0;
	}
	
	public Juego(int maxrondas, int maxturnos) {
		puntos1=0;
		puntos2=0;
		rondas=0;
		turnos=0;
		MAXRONDAS=maxrondas;
		MAXTURNOS=maxturnos;
	}
	
	public void jugar() {
		//crear mazo con json.
		ArrayList<Mazo> posos=this.repartir(mazo);
		jugador1.setPoso(posos.get(0));
		jugador2.setPoso(posos.get(1));
		Mazo poso1= jugador1.getPoso();
		Mazo poso2= jugador2.getPoso();
		while((poso1.getCantidadCartas()>0) || (poso2.getCantidadCartas()>0) || (rondas==MAXRONDAS)) {
			Carta carta1=jugador1.elegirCarta(poso1);
			Carta carta2=jugador2.elegirCarta(poso2);
			this.eliminarCartasElegidas(carta1, carta2, poso1, poso2);
			if((turnos/2)==0) {
				Atributo atributo1=jugador1.elegirAtributo(carta1);
				this.mostrarCartaJugadores(jugador1, jugador2);
			}
			else {
				Atributo atributo2=jugador2.elegirAtributo(carta2);
				this.mostrarCartaJugadores(jugador2, jugador1);
			}
			if(carta1.compararCartas(carta2)==carta1) {
				jugador1.incrementarPuntos(puntos1);
				this.juntarCarta(carta1, carta2, poso1, mazo);
				this.mostrarGanador(jugador1, jugador2);
			}
			else if(carta1.compararCartas(carta2)==carta2) {
				jugador2.incrementarPuntos(puntos2);
				this.juntarCarta(carta2, carta1, poso2, mazo);
				this.mostrarGanador(jugador2, jugador1);
			}	
			else {
				this.devolverCarta(carta1, carta2, poso1, poso2, mazo);
				this.mostrarempate(jugador2, jugador2);
			}
			rondas++;
			turnos++;
		}
		Jugador ganador=this.getGanador();
		this.mostrarGanadorDelJuego(ganador);
	}
	
	public String mostrarCartaJugadores(Jugador j1, Jugador j2) {
		return "El jugador "+j1.getNombre()+" selecciona competir por el atributo "+j1.getCarta().getAtributoElegido()+j1.toString()+j2.toString();
	}
	
	public String mostrarGanador(Jugador j1, Jugador j2) {
		return "Gana la ronda "+j1.getNombre()+
				j1.getNombre()+ " posee ahora "+j1.getPoso().getCantidadCartas()+" cartas y "+j2.getNombre()+" posee ahora "+j2.getPoso().getCantidadCartas()+" cartas";
	}
	
	public String mostrarempate(Jugador j1, Jugador j2) {
		return "Hubo un empate."+
				j1.getNombre()+ " posee ahora "+j1.getPoso().getCantidadCartas()+" cartas y "+j2.getNombre()+" posee ahora "+j2.getPoso().getCantidadCartas()+" cartas";
	}
	
	public String mostrarGanadorDelJuego(Jugador j) {
		if(j==null) {
			return "El juego termino, hubo un empate";
		}
		else {
			return "El juego termino,"+j.getNombre()+" ha ganado el juego!!";
		}
	}
	
	public ArrayList<Mazo> repartir(Mazo mazoCentral) {
		ArrayList<Mazo> posos= new ArrayList<>();
		mazo.mezclar();
		Mazo poso1= new Mazo();
		Mazo poso2= new Mazo();
		for(int i=0; i<mazo.getCartas().size()/2; i++) {
			poso1.addCarta(mazo.getCartas().remove(i), mazoCentral);
			posos.add(poso1);
		}
		for (int f=0;f<mazo.getCartas().size();f++){
			poso2.addCarta(mazo.getCartas().remove(f), mazoCentral);
			posos.add(poso2);
		}
		return posos;
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
	
	public void devolverCarta(Carta cartaJugador1, Carta cartaJugador2, Mazo poso1, Mazo poso2, Mazo mazoCentral) {
		poso1.addCarta(cartaJugador1, mazoCentral);
		poso2.addCarta(cartaJugador2, mazoCentral);
	}
	
	public void juntarCarta(Carta cartaJugadorGanador, Carta cartaJugadorPerdedor, Mazo posoGanador, Mazo mazoCentral) {
		posoGanador.addCarta(cartaJugadorGanador, mazoCentral);
		posoGanador.addCarta(cartaJugadorPerdedor, mazoCentral);
	}
	
	public void eliminarCartasElegidas(Carta carta1, Carta carta2, Mazo poso1, Mazo poso2) {
		poso1.removeCarta(carta1);
		poso2.removeCarta(carta2);
	}
}
