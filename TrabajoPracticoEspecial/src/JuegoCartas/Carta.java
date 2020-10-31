package JuegoCartas;

import java.util.*;

import JuegoCartas.Pocima.Pocima;

public class Carta {

	private ArrayList<Atributo> atributos;
	private String nombre;
	private Pocima pocima;
	
	public Carta(String nombre) {
		this.nombre=nombre;
		atributos= new ArrayList<>();
	}
	
	public Atributo elegirAtributoAleatorio() {
		return this.atributos.get(((int) (Math.random() * atributos.size())));
	}
	
	public double aplicarPocima(Atributo atributoElegido) {
		if(pocima!=null) {
			this.pocima.encantamiento(atributoElegido);
		}
		return atributoElegido.getValor();
	}
	
	public Pocima getPocima() {
		return pocima;
	}

	public void setPocima(Pocima pocima) {
		this.pocima = pocima;
	}
	
	public boolean tienePocima() {
		return this.pocima!=null;
	}
	
	public int getCantidadAtributos() {
		return atributos.size();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	/*public Carta compararCartas(Carta carta, Atributo atributoElegido) {
		if(this.atributoElegido.compareTo(carta.atributoElegido)>0){
			return this;
		}
		else if(atributoElegido.compareTo(carta.atributoElegido)<0) {
			return carta;
		}
		else {
			return null;
		}
	}*/
	//equals(preguntar cantidad, pregunta si tiene atributo con el mismo nombre).
	@Override
	public boolean equals(Object obj) {
		Carta c= (Carta) obj;
		boolean resultado=false;
		try {
			if(this.getCantidadAtributos()==c.getCantidadAtributos()) {
				for(Atributo atributo: atributos) {
					if(c.tieneAtributo(atributo)) {
						resultado= true;
					}
				}
			}
			return resultado;
		}
		catch(Exception e) {
			return false;
		}
	} 
	
	@Override
	public String toString() {
		return atributos.toString();
	}
}
