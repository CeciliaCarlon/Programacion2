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
	
	public void separaEnPosos(Mazo poso1, Mazo poso2, Mazo mazoCentral) {
		
		for(int i=0; i<cartas.size()/2;i++) {
			poso1.addCarta(cartas.remove(i), mazoCentral);
		}
		for (int f=0;f<cartas.size();f++){
			poso2.addCarta(cartas.remove(f), mazoCentral);
		}
	}
	
	public ArrayList<Carta> getCarta() {
		return new ArrayList<>(this.cartas);
	}
	
	public Carta getPrimeraCarta() {
		return cartas.get(0);
	}
	
	public Carta getCartaElegida(Mazo mazo) {
		ArrayList <Carta> cartas= mazo.getCarta();
		return cartas.get(((int) (Math.random() * cartas.size()) + 1));
	}
	
	public void addCarta(Carta carta, Mazo mazoCentral) {
		Criterio criterioCantidad= new CriterioCantidadAtributos(mazoCentral);
		Criterio criterioTipo= new CriterioTipoAtributo(mazoCentral);
		if(criterioCantidad.cumple(carta) && criterioTipo.cumple(carta)) {
			cartas.add(carta);
		}
	}
	
	public void removeCarta(Carta carta) {
		cartas.remove(carta);
	}
}
