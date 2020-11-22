package ejercicio4;

import java.util.ArrayList;

public abstract class Armario {

	public Atributo atributoPredominante(String nombre){
		ArrayList<Atributo> aux = new ArrayList<>();
		aux.addAll(this.getAtributoPorNombre(nombre));
		int mayor = 0;
		Atributo atrPredominante = new Atributo(nombre, null);
		for(Atributo s: aux){
			int numero = this.cantidadPrendas(s);
			if(numero>mayor){
				mayor = numero;
				atrPredominante.setValor(s.getValor());
			}
		}
		return atrPredominante;
	}

	public abstract int cantidadPrendas(Atributo atributo);
	public abstract ArrayList<Atributo> getAtributoPorNombre(String nombre);
	public abstract ArrayList<Prenda> getVestimentas(Atributo atributo);
	public abstract ArrayList<Armario> getArmario(Usuario usuario);
}
