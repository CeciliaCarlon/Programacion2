package ejercicio4;

import java.util.ArrayList;

public class Prenda extends Armario {

	private ArrayList<Atributo> caracteristicas;
	private int cantUsada;
	
	public Prenda() {
		this.caracteristicas= new ArrayList<>();
		cantUsada=0;
	}

	public int getCantUsada() {
		return cantUsada;
	}

	public void setCantUsada(int cantUsada) {
		this.cantUsada = cantUsada;
	}
	
	public void addCaracteristica(Atributo a) {
		this.caracteristicas.add(a);
	}

	@Override
	public int cantidadPrendas(Atributo atributo) {
		if(this.caracteristicas.contains(atributo)) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public ArrayList<Atributo> getAtributoPorNombre(String nombre) {
		ArrayList<Atributo> aux= new ArrayList<>();
		for(int i=0; i<this.caracteristicas.size(); i++) {
			Atributo a= this.caracteristicas.get(i);
			if(a.getNombre().equals(nombre)) {
				aux.add(a);
			}
		}
		return aux;
	}

	@Override
	public ArrayList<Prenda> getVestimentas(Atributo atributo) {
		ArrayList<Prenda> aux= new ArrayList<>();
		if(this.caracteristicas.contains(atributo)) {
			aux.add(this);
		}
		return aux;
	}

	@Override
	public ArrayList<Armario> getArmario(Usuario usuario) {
		ArrayList<Armario> aux= new ArrayList<>();
		Criterio c= usuario.getPreferencia();
		if(c.cumple(this)) {
			aux.add(this);
		}
		return aux;
	}
}
