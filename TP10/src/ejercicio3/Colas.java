package ejercicio3;

import java.util.ArrayList;

import ejercicio4.Criterio;

public abstract class Colas {

	public abstract ArrayList<ColaTerminal> getColas();
	public abstract int getCantidadTotal();
	public abstract int getCantidadColasTerminales();
	public abstract int profundidad();
	public abstract ArrayList<ColaTerminal> lista(Criterio criterio);
	public abstract void addElemento(Object elemento);
	public abstract ArrayList<Object> getElemento();
	
	public ColaTerminal getColaConMasElementos() {
		ArrayList<ColaTerminal> aux= this.getColas();
		if(aux.size()>=0) {
			ColaTerminal mayor= aux.get(0);
			for(ColaTerminal t: aux) {
				if(t.getCantidadTotal()>mayor.getCantidadTotal()) {
					mayor= t;
				}
			}
			return mayor;
		}
		else {
			return null;
		}
	}
}
