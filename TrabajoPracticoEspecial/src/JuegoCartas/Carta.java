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
	
	public Atributo getAtributoElegido(Carta carta) {
		ArrayList<Atributo> atributosElegidos= carta.getAtributo();
		return atributosElegidos.get(((int) (Math.random() * atributosElegidos.size()) + 1));
	}
	
	public int getCantidadAtributos() {
		int cantidad=0;
		for(int i=0; i<atributos.size();i++) {
			cantidad++;
		}
		return cantidad;
	}
	
	public void addAtributo(Atributo a) {
		if (!tieneAtributo(a)) {
			this.atributos.add(a);
		}
		else {
			actualizarAtributo(a.getNombre(), a.getValor());
		}
	}
	
	public void actualizarAtributo(String nombre, double valor) {
		Atributo atr= this.getAtributoPorNombre(nombre);
		if(atr!=null) {
			atr.setValor(valor);
		}
	}
	
	public boolean tieneAtributo(Atributo a) {
		return atributos.contains(a);
	}
	
	public Atributo getAtributoPorNombre(String nombre) {
		for (int i=0; i<atributos.size();i++) {
			Atributo a= atributos.get(i);
			if(a.getNombre().equals(nombre)) {
				return a;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return atributos.toString();
	}
}
