package JuegoCartas.Pocima;

import JuegoCartas.Atributo;

public class PocimaCocktail extends Pocima {

	private Pocima p1;
	private Pocima p2;
	
	public PocimaCocktail(String nombre, Pocima p1, Pocima p2) {
		super(nombre);
		this.p1=p1;
		this.p2=p2;
	}

	@Override
	public double encantamiento(Atributo atributo) {
		Atributo nuevo= atributo;
		double valorFinal=nuevo.getValor();
		valorFinal=p1.encantamiento(atributo)+p2.encantamiento(atributo);
		nuevo.setValor(valorFinal);
		return nuevo.getValor();
	}

}
