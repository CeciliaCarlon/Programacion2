package JuegoCartas.Estrategia;

import JuegoCartas.Atributo;
import JuegoCartas.Carta;

public interface Estrategia {
	
	public abstract Atributo elegirAtributo(Carta carta);
}
