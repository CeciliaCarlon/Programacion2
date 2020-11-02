package JuegoCartas.Estrategia;

import java.util.ArrayList;

import JuegoCartas.Atributo;
import JuegoCartas.Carta;

public class EstrategiaTimbero extends Estrategia{
	
	public Atributo elegirAtributo(Carta carta) {
		super.cartaNueva= carta;
		ArrayList<Atributo> atributos= new ArrayList<Atributo>();
		int limite= cartaNueva.getCantidadAtributos();
		for(int i=0; i<limite; i++) {
			atributos.add(cartaNueva.getPrimerAtributo());
			cartaNueva.removeAtributo(cartaNueva.getPrimerAtributo());
		}
		return atributos.get((int) (Math.random() * atributos.size()));
	}
	
}
