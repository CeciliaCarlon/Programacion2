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
	
	public Pocima getPocima() {
		return pocima;
	}
	
	public double encantar(Atributo a) {
		return pocima.encantamiento(a);
	}

	public void setPocima(Pocima pocima) {
		this.pocima = pocima;
	}
	
	public boolean tienePocima() {
		return this.pocima!=null;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Atributo getPrimerAtributo() {
		return this.atributos.get(0);
	}
	
	public Atributo getAtributoPorPosicion(int n) {
		return this.atributos.get(n);
	}
	
	public void removeAtributo(Atributo atributo) {
		this.atributos.remove(atributo);
	}
	
	public int getCantidadAtributos() {
		return atributos.size();
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
		Atributo a=null;
		for (Atributo atributo: atributos) {
			if(atributo.getNombre().equals(nombre)) {
				a=atributo;
			}
		}
		return a;
	}
	
	public ArrayList<String> getNombresDeAtributos(){
		ArrayList<String> nombres=new ArrayList<String>();
		for(Atributo a: atributos) {
			nombres.add(a.getNombre());
		}
		return nombres;
	}
	
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
					else {
						resultado=false;
						return resultado;
					}
				}
			}
			return resultado;
		}
		catch(Exception e) {
			return false;
		}
	} 
}
