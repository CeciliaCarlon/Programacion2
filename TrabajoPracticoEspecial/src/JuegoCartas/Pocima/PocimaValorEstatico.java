package JuegoCartas.Pocima;

import JuegoCartas.Atributo;

public class PocimaValorEstatico extends Pocima {

	private int valorFijo;
	
	public PocimaValorEstatico(String nombre, int valor) {
		super(nombre);
		this.valorFijo=valor;
	}

	@Override
	public double encantamiento(Atributo atributo) {
		Atributo nuevo= atributo;
		nuevo.setValor(valorFijo);
		return this.valorFijo;
	}

}
