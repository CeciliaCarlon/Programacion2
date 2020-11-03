package JuegoCartas.Pocima;

import JuegoCartas.Atributo;

public abstract class Pocima {
	
	protected int valorPorcentaje;
	protected String nombre;
	
	protected Pocima (String nombre) {
		this.nombre= nombre;
	}
	
	public abstract double encantamiento(Atributo atributo);

	public String getNombre() {
		return nombre;
	}
	
	@Override
	public boolean equals(Object obj) {
		Pocima pocima= (Pocima) obj;
		try {
			return this.getNombre().equals(pocima.getNombre());
		}
		catch(Exception e) {
			return false;
		}
	}
	
}
