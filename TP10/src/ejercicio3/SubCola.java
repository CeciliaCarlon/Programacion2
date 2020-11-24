package ejercicio3;

import java.util.ArrayList;

import ejercicio4.Criterio;

public class SubCola extends Colas {

	private ArrayList<Colas> colas;
	private Estrategia politica;
	
	public SubCola(Colas elemDerecho, Colas elemIzquierdo, Estrategia politica) {
		this.colas= new ArrayList<>();
		this.politica = politica;
	}

	public void addCola(Colas cola) {
		this.colas.add(cola);
	}

	public Estrategia getPolitica() {
		return politica;
	}

	@Override
	public ArrayList<ColaTerminal> getColas() {
		ArrayList<ColaTerminal> aux= new ArrayList<>();
		for(Colas cola: colas) {
			aux.addAll(cola.getColas());
		}
		return aux;
	}

	@Override
	public int getCantidadTotal() {
		int total=0;
		for(Colas c: colas) {
			total+= c.getCantidadTotal();
		}
		return total;
	}

	@Override
	public int getCantidadColasTerminales() {
		int cantidad=0;
		for(Colas cola: colas) {
			cantidad+=cola.getCantidadColasTerminales();
		}
		return cantidad;
	}

	@Override
	public int profundidad() {
		int cantidad=0;
		for(Colas cola: colas) {
			cantidad+=cola.getCantidadColasTerminales();
		}
		return cantidad+1;
	}

	@Override
	public ArrayList<ColaTerminal> lista(Criterio criterio) {
		ArrayList<ColaTerminal> aux= new ArrayList<>();
		for(Colas cola: colas) {
			aux.addAll(cola.lista(criterio));
		}
		return aux;
	}

	@Override
	public void addElemento(Object elemento) {
		ColaTerminal ct=politica.buscar(this);
		ct.addElemento(elemento);
	}

	@Override
	public ArrayList<Object> getElemento() {
		ColaTerminal ct=politica.buscar(this);
		return ct.getElemento();
	}
	
}
