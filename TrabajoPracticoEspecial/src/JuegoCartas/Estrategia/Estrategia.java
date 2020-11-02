package JuegoCartas.Estrategia;

import JuegoCartas.Atributo;
import JuegoCartas.Carta;

public abstract class Estrategia {

	protected Carta cartaNueva;
	
	public abstract Atributo elegirAtributo(Carta carta);
}
