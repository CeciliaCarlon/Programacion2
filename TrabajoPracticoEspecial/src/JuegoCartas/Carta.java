package JuegoCartas;

import java.util.*;

public class Carta {

	private ArrayList<Atributo> atributos;
	private String nombre;
	private Atributo atributoElegido;
	
	public Carta(String nombre) {
		this.nombre=nombre;
		atributos= new ArrayList<>();
	}
	
	public ArrayList<Atributo> getAtributos() {
		return new ArrayList<>(this.atributos);
	}
	
	public Atributo elegirAtributoAleatorio() {
		ArrayList<Atributo> atributosElegidos= this.getAtributos();
		atributoElegido= atributosElegidos.get(((int) (Math.random() * atributosElegidos.size()) + 1));
		return atributoElegido;
	}
	
	public Atributo getAtributoElegido() {
		return atributoElegido;
	}
	
	public int getCantidadAtributos() {
		int cantidad=0;
		for(int i=0; i<atributos.size();i++) {
			cantidad++;
		}
		return cantidad;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setAtributoElegido(Atributo atributoElegido) {
		this.atributoElegido = atributoElegido;
	}

	public void addAtributo(Atributo a) {
		if (!tieneAtributo(a)) {
			this.atributos.add(a);
		}
		else {
			actualizarAtributo(a.getNombre(), a.getValor());
		}
	}
	
	public void actualizarAtributo(String nombre, int valor) {
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
	
	public Carta compararCartas(Carta carta) {
		if(this.atributoElegido.compareTo(carta.atributoElegido)>0){
			return this;
		}
		else if(atributoElegido.compareTo(carta.atributoElegido)<0) {
			return carta;
		}
		else {
			return null;
		}
	}
	
	@Override
	public String toString() {
		return atributos.toString();
	}
}
