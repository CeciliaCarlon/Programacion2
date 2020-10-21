package JuegoCartas;

import java.util.*;

public class Mazo {

	private ArrayList<Carta> cartas;
	private Criterio criterioCantidad;
	private Criterio criterioTipo;
	
	public Mazo() {
		cartas= new ArrayList<>();
	}
	
	public Mazo(Carta c1, Carta c2) {
		cartas= new ArrayList<>();
		cartas.add(c1);
		cartas.add(c2);
	}
	
	public void mezclar() {
		Collections.shuffle(cartas);
	}
	
	public ArrayList<Carta> getCartas() {
		return new ArrayList<>(this.cartas);
	}
	
	public Carta getPrimeraCarta() {
		Carta c= cartas.get(0);
		return c;
	}
	
	public int getCantidadCartas() {
		int cantidad=0;
		for(int i=0; i<this.cartas.size();i++) {
			cantidad++;
		}
		return cantidad;
	}
	
	public Carta getCartaElegida(Mazo mazo) {
		ArrayList <Carta> cartas= mazo.getCartas();
		return cartas.get(((int) (Math.random() * cartas.size())));
	}
	
	public void addCarta(Carta c) {
		if(cartas.size()==0) {
			this.cartas.add(c);
		}
		else {
			if(c.equals(this.getPrimeraCarta())) {
				this.cartas.add(c);
			}
		}
	}
	
	public void removeCarta(Carta carta) {
		cartas.remove(carta);
	}
	
	@Override
	public String toString() {
		return cartas.toString();
	}
}
