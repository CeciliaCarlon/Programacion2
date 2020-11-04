package JuegoCartas.Estrategia;

import JuegoCartas.Atributo;
import JuegoCartas.Carta;

public class EstrategiaTimbero implements Estrategia{
	
	public Atributo elegirAtributo(Carta carta) {
		return carta.getAtributoPorPosicion((int) (Math.random() * carta.getCantidadAtributos()));
	}
}
