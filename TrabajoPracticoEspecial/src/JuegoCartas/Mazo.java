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
	
	public ArrayList<Carta> getCartas() {
		return new ArrayList<>(this.cartas);
	}
	
	public Carta getPrimeraCarta() {
		return cartas.get(0);
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
		return cartas.get(((int) (Math.random() * cartas.size()) + 1));
	}
	
	public void addCarta(Carta carta) {
		Criterio criterioCantidad= new CriterioCantidadAtributos(this);
		Criterio criterioTipo= new CriterioTipoAtributo(this);
		if(criterioCantidad.cumple(carta) && criterioTipo.cumple(carta)) {
			cartas.add(carta);
		}
	}
	
	public void removeCarta(Carta carta) {
		cartas.remove(carta);
	}
}
