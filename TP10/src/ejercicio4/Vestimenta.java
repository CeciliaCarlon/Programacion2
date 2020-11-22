package ejercicio4;

import java.util.ArrayList;

public class Vestimenta extends Armario {

	private ArrayList<Armario> armario;
	
	public Vestimenta() {
		this.armario= new ArrayList<>();
	}
	
	public void addArmario(Armario a) {
		this.armario.add(a);
	}

	@Override
	public int cantidadPrendas(Atributo atributo) {
		int total=0;
		for(Armario a: armario) {
			total+= a.cantidadPrendas(atributo);
		}
		return total;
	}

	@Override
	public ArrayList<Atributo> getAtributoPorNombre(String nombre) {
		ArrayList<Atributo> aux= new ArrayList<>();
		for(Armario a: armario) {
			aux.addAll(a.getAtributoPorNombre(nombre));
		}
		return aux;
	}

	@Override
	public ArrayList<Prenda> getVestimentas(Atributo atributo) {
		ArrayList<Prenda> aux= new ArrayList<>();
		for(Armario a: armario) {
			aux.addAll(a.getVestimentas(atributo));
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
		for(Armario a: armario) {
			aux.addAll(a.getArmario(usuario));
		}
		return aux;
	}
}
