package ejercicio3;

import java.util.ArrayList;

import ejercicio4.Criterio;

public class ColaTerminal extends Colas {

	private ArrayList<Object> elementos;
	
	public ColaTerminal() {
		this.elementos= new ArrayList<>();
	}
	
	public void addElemento(Object o) {
		this.elementos.add(o);
	}

	@Override
	public ArrayList<ColaTerminal> getColas() {
		ArrayList<ColaTerminal> aux= new ArrayList<>();
		aux.add(this);
		return aux;
	}

	@Override
	public int getCantidadTotal() {
		return this.elementos.size();
	}

	@Override
	public int getCantidadColasTerminales() {
		return 1;
	}

	@Override
	public int profundidad() {
		return 0;
	}

	@Override
	public ArrayList<ColaTerminal> lista(Criterio criterio) {
		ArrayList<ColaTerminal> aux= new ArrayList<>();
		 if(criterio.cumple(this)) {
			 aux.add(this);
		 }
		 return aux;
	}

	@Override
	public ArrayList<Object> getElemento() {
		return new ArrayList<Object>(this.elementos);
	}
}
