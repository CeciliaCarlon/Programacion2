package JuegoCartas;

import java.util.*;

public class Mazo {

	private ArrayList<Carta> cartas;
	private Criterio criterioCantidad;
	private Criterio criterioTipo;
	
	public Mazo() {
		cartas= new ArrayList<>();
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
	
	public void addCarta(Carta c) {
		int cantidad= this.getPrimeraCarta().getCantidadAtributos();
		ArrayList<Atributo> atributosCorrectos=this.getPrimeraCarta().getAtributos();
		criterioCantidad= new CriterioCantidadAtributos(cantidad);
		//criterioTipo= new CriterioTipoAtributo(atributosCorrectos); No creo que pasar un array como parametro este bien, pero no se que hacer.
		if(cartas.size()<0) {
			cartas.add(c);
		}
		else {
			for(Carta carta: cartas) {
				if(criterioCantidad.cumple(carta)) { // && (criterioTipo.cumple(carta));
					cartas.add(carta);
				}
			}
		}
	}
	
	public void removeCarta(Carta carta) {
		cartas.remove(carta);
	}
}
