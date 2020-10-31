package JuegoCartas;

import java.util.*;

import JuegoCartas.Pocima.Pocima;

public class Mazo {

	private ArrayList<Carta> cartas;
	
	public Mazo() {
		cartas= new ArrayList<>();
	}
	
	public void mezclarCartas() {
		Collections.shuffle(cartas);
	}
	
	public void asignarPocima(Pocima pocima) {
		Carta cartaElegida=cartas.get(((int) (Math.random() * cartas.size())));
		if(!cartaElegida.tienePocima()){
			cartaElegida.setPocima(pocima);
		}
	}
	
	public Carta getPrimeraCarta() {
		return this.cartas.get(0);
	}
	
	public int getCantidadCartas() {
		return cartas.size();
	}
	
	public Carta getCartaElegida(Mazo mazo) {
		ArrayList <Carta> cartas= mazo.cartas;
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
