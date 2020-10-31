package JuegoCartas.Pocima;

import JuegoCartas.Atributo;

public class PocimaIncrementar extends Pocima {

	private int valorPorcentaje;
	
	public PocimaIncrementar(String nombre, int porcentaje) {
		super(nombre);
		this.valorPorcentaje= porcentaje;
	}

	@Override
	public double encantamiento(Atributo atributo) {
		Atributo nuevo= atributo;
		double porcentaje= (valorPorcentaje/100)+1;
		double valorFinal= nuevo.getValor()*porcentaje;
		nuevo.setValor(valorFinal);
		return valorFinal;
	}

}
