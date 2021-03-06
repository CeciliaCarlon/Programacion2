package JuegoCartas;

import java.util.*;

import JuegoCartas.Pocima.Pocima;

public class Juego {

	private Jugador jugador1;
	private Jugador jugador2;
	private Mazo mazo;
	private int rondas;
	private boolean turno;
	private int MAXRONDAS;
	private ArrayList<Pocima> pocimas;
	
	public Juego(Jugador j1, Jugador j2, Mazo mazo) {
		rondas=1;
		MAXRONDAS=10;
		this.jugador1=j1;
		this.jugador2=j2;
		this.mazo=mazo;
		pocimas= new ArrayList<>();
	}
	
	public Juego(int maxrondas, Jugador j1, Jugador j2, Mazo mazo) {
		rondas=1;
		turno=false;
		MAXRONDAS=maxrondas;
		this.jugador1=j1;
		this.jugador2=j2;
		this.mazo=mazo;
		pocimas= new ArrayList<>();
	}
	
	public void jugar() {
		//SE SETEAN POSOS, CARTAS Y ATRIBUTOS.
		ArrayList<Mazo> posos=this.repartir();
		Mazo poso1= posos.get(0);
		Mazo poso2= posos.get(1);
		jugador1.setPoso(poso1);
		jugador2.setPoso(poso2);
		while((!jugador1.posoVacio()) && (!jugador2.posoVacio()) && (rondas<=MAXRONDAS)) {
			System.out.println("------- Ronda "+this.rondas+" -------");
			Carta carta1=jugador1.elegirCarta();
			Carta carta2=jugador2.elegirCarta();
			Atributo atributo1;
			Atributo atributo2;
			poso1.removeCarta(carta1);
			poso2.removeCarta(carta2);
			//SE ELIGE EL ATRIBUTO POR EL CUAL SE COMPITE Y SE IMPRIME POR PANTALLA
			if(!turno) {
				atributo1=jugador1.elegirAtributo(carta1);
				atributo2=carta2.getAtributoPorNombre(atributo1.getNombre());
				System.out.println("El jugador "+jugador1.getNombre()+" selecciona competir por el atributo "+atributo1.getNombre());
				if(carta1.tienePocima()) {
					System.out.println("La carta de "+ jugador1.getNombre()+" es "+carta1.getNombre()+" con "+atributo1.getNombre()+" "+atributo1.getValor()+
							", se aplico pocima "+carta1.getPocima().getNombre()+" valor resultante "+carta1.encantar(atributo1));
				}
				else {
					System.out.println("La carta de "+ jugador1.getNombre()+" es "+carta1.getNombre()+" con "+atributo1.getNombre()+" "+atributo1.getValor());
				}
				System.out.println("La carta de "+ jugador2.getNombre()+" es "+carta2.getNombre()+" con "+atributo2.getNombre()+" "+atributo2.getValor());
			}
			else {
				atributo2=jugador2.elegirAtributo(carta2);
				atributo1=carta1.getAtributoPorNombre(atributo2.getNombre());
				System.out.println("El jugador "+jugador2.	getNombre()+" selecciona competir por el atributo "+atributo2.getNombre());
				System.out.println("La carta de "+ jugador1.getNombre()+" es "+carta1.getNombre()+" con "+atributo1.getNombre()+" "+atributo1.getValor());
				if(carta2.tienePocima()) {
					System.out.println("La carta de "+ jugador2.getNombre()+" es "+carta2.getNombre()+" con "+atributo2.getNombre()+" "+atributo2.getValor()+
							", se aplico pocima "+carta2.getPocima().getNombre()+" valor resultante "+carta2.encantar(atributo2));
				}
				else {
					System.out.println("La carta de "+ jugador2.getNombre()+" es "+carta2.getNombre()+" con "+atributo2.getNombre()+" "+atributo2.getValor());
				}
			}
			//SE COMPARAN LOS ATRIBUTOS Y SE AGREGA: LOS PUNTOS, LAS CARTAS AL GANADOR E IMPRIME POR PANTALLA
			if(atributo1.compareTo(atributo2)>0) {
				jugador1.incrementarPuntos();
				poso1.addCarta(carta1);
				poso1.addCarta(carta2);
				System.out.println("Gana la ronda "+jugador1.getNombre());
				turno=false;
			}
			else if(atributo1.compareTo(atributo2)<0) {
				jugador2.incrementarPuntos();
				poso2.addCarta(carta1);
				poso2.addCarta(carta2);
				System.out.println("Gana la ronda "+jugador2.getNombre());
				turno=true;
			}	
			else {
				poso1.addCarta(carta1);
				poso2.addCarta(carta2);
				System.out.println("Empate!!");
			}
			System.out.println(jugador1.getNombre()+" posee ahora "+poso1.getCantidadCartas()+" cartas y "+jugador2.getNombre()+" posee ahora "+poso2.getCantidadCartas()+" cartas.");
			rondas++;
		}
		//SALE DEL WHILE E IMPRIME AL GANADOR.
		Jugador ganador=this.getGanador();
		if(ganador==null) {
			System.out.println("Empate en el juego!!");
		}
		else {
			System.out.println("El ganador del juego es "+ ganador.getNombre());
		}
	}
	
	public ArrayList<Mazo> repartir() {
		ArrayList<Mazo> posos= new ArrayList<>();
		mazo.mezclarCartas();
		this.mezclarPocimas();
		Mazo poso1= new Mazo();
		Mazo poso2= new Mazo();
		int cantidad= mazo.getCantidadCartas();
		for(int i=0; i<cantidad; i++) {
			if(!turno) {
				if(!pocimas.isEmpty()) {
					mazo.getCartaPorPosicion(i).setPocima(this.pocimas.get(0));
					this.removePocima(this.pocimas.get(0));
				}
				poso1.addCarta(mazo.getCartaPorPosicion(i));
				turno=true;
			}
			else{
				if(!pocimas.isEmpty()) {
					mazo.getCartaPorPosicion(i).setPocima(this.pocimas.get(0));
					this.removePocima(this.pocimas.get(0));
				}
				poso2.addCarta(mazo.getCartaPorPosicion(i));
				turno=false;
			}
		}
		posos.add(poso1);
		posos.add(poso2);
		return posos;
	}
	
	public Jugador getGanador() {
		if (jugador1.getPuntos()>jugador2.getPuntos()) {
			return jugador1;
		} 
		else if (jugador2.getPuntos()>jugador1.getPuntos()) {
			return jugador2;
		} 
		else {
			return null;
		}
	}	
	
	public void mezclarPocimas() {
		Collections.shuffle(pocimas);
	}
	
	public int getCantidadPocimas() {
		return pocimas.size();
	}
	
	public void removePocima(Pocima p) {
		pocimas.remove(p);
	}
	
	public void addPocima(Pocima p) {
		this.pocimas.add(p);
	}

	public Mazo getMazo() {
		return mazo;
	}

	public void setMazo(Mazo mazo) {
		this.mazo = mazo;
	}

	public Jugador getJugador1() {
		return jugador1;
	}

	public void setJugador1(Jugador jugador1) {
		this.jugador1 = jugador1;
	}

	public Jugador getJugador2() {
		return jugador2;
	}

	public void setJugador2(Jugador jugador2) {
		this.jugador2 = jugador2;
	}	
	
}
