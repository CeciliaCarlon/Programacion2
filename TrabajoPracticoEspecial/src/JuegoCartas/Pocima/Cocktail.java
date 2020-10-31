package JuegoCartas.Pocima;

import JuegoCartas.Atributo;

public class Cocktail extends Pocima {

	private Pocima p1;
	private Pocima p2;
	
	public Cocktail(String nombre, Pocima p1, Pocima p2) {
		super(nombre);
		this.p1=p1;
		this.p2=p2;
	}

	@Override
	public double encantamiento(Atributo atributo) {
		Atributo nuevo= atributo;
		nuevo.setValor(p1.encantamiento(atributo));
		nuevo.setValor(p2.encantamiento(atributo));
		return nuevo.getValor();
	}

}
