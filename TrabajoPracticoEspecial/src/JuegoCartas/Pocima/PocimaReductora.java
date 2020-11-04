package JuegoCartas.Pocima;

import JuegoCartas.Atributo;

public class PocimaReductora extends Pocima {
	
	public PocimaReductora(String nombre, int porcentaje) {
		super(nombre);
		valorPorcentaje=porcentaje;
	}

	@Override
	public double encantamiento(Atributo atributo) {
		double porcentaje= (atributo.getValor()*this.valorPorcentaje)/100;
		return atributo.getValor()-porcentaje;
	}

}
