package JuegoCartas;

import java.util.*;

public class Mazo {

	private ArrayList<Carta> cartas;
	
	public Mazo() {
		cartas= new ArrayList<>();
	}
	
	public void mezclarCartas() {
		Collections.shuffle(cartas);
	}
	
	public Carta getCartaPorPosicion(int i) {
		return this.cartas.get(i);
	}
	
	public Carta getPrimeraCarta() {
		return this.cartas.get(0);
	}
	
	public int getCantidadCartas() {
		return cartas.size();
	}
	
	public Carta getCartaElegida() {
		return this.cartas.get(((int) (Math.random() * cartas.size())));
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
}
