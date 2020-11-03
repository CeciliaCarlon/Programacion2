package JuegoCartas.Pocima;

import JuegoCartas.Atributo;

public class PocimaSelectiva extends Pocima {

	private String tipoAtributo;
	
	public PocimaSelectiva(String nombre, int porcentaje, String tipo) {
		super(nombre);
		valorPorcentaje= porcentaje;
		this.tipoAtributo= tipo;
	}

	@Override
	public double encantamiento(Atributo atributo) {
		Atributo nuevo= atributo;
		double valorFinal=0;
		if(nuevo.getNombre().equals(tipoAtributo)) {
			double porcentaje= (valorPorcentaje/100)+1;
			valorFinal= nuevo.getValor()*porcentaje;
			nuevo.setValor(valorFinal);
		}
		return valorFinal;
	}

}
