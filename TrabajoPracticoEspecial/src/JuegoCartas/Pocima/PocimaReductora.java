package JuegoCartas.Pocima;

import JuegoCartas.Atributo;

public class PocimaReductora extends Pocima {

	private int valorPorcentaje;
	
	public PocimaReductora(String nombre, int porcentaje) {
		super(nombre);
		this.valorPorcentaje=porcentaje;
	}

	@Override
	public double encantamiento(Atributo atributo) {
		Atributo nuevo= atributo;
		double porcentaje= (nuevo.getValor()*this.valorPorcentaje)/100;
		double valorFinal= nuevo.getValor()-porcentaje;
		nuevo.setValor(valorFinal);
		return valorFinal;
	}

}
