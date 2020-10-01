package JuegoCartas;

import java.util.*;

public class Carta {

	private ArrayList<Atributo> atributos;
	
	public Carta() {
		atributos= new ArrayList<>();
	}
	
	public ArrayList<Atributo> getAtributo() {
		return new ArrayList<>(this.atributos);
	}
	
	public Atributo getAtributoPorNombre(String nombre) {
		//if para comprobar si existe.
		for(int f=0; f<atributos.size(); f++) {
			if(atributos.get(f).getNombre().equals(nombre)) {
				return atributos.get(f);
			}
		}
		return null;
	}
	
	public void addAtributo(Atributo a) {
		if (!tieneAtributo(a)) {
			this.atributos.add(a);
		}
		else {
			actualizarAtributo(a);
		}
	}
	
	public void actualizarAtributo(Atributo atr) {
		Atributo a = getAtributoPorNombre(nombre);
		if(a!=null) {
			a.setValor(valor);
		}
	}
	
	public void compararAtributos(Atributo atributo1, Atributo atributo2, Carta cartaJugador1, Carta cartaJugador2) {
		if (atributo1.getValor()>atributo2.getValor()) {
			jugador1.incrementarPuntos(puntos1);
		}
		else if(atributo2.getValor()>atributo1.getValor()){
			jugador2.incrementarPuntos(puntos2);
		}
		else {
			
		}
	}
	
	public boolean tieneAtributo(String nombre) {
		Atributo a= this.getAtributo(nombre);
		return (a!=null);
	}
	
	public boolean tieneAtributo(Atributo a) {
		return atributos.contains(a);
	}
	
	@Override
	public String toString() {
		return atributos.toString();
	}
}
