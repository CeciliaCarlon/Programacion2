package JuegoCartas.Pocima;

import JuegoCartas.Atributo;

public abstract class Pocima {
	
	protected String nombre;
	
	public Pocima (String nombre) {
		this.nombre= nombre;
	}
	
	public abstract double encantamiento(Atributo atributo);

	public String getNombre() {
		return nombre;
	}
	
	
}
