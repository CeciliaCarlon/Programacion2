package JuegoCartas.Pocima;

import JuegoCartas.Atributo;

public class PocimaIncrementar extends Pocima {
	
	public PocimaIncrementar(String nombre, int porcentaje) {
		super(nombre);
		valorPorcentaje= porcentaje;
	}

	@Override
	public double encantamiento(Atributo atributo) {
		double porcentaje= valorPorcentaje+100;
		return (atributo.getValor()/100)*porcentaje;
	}

}
