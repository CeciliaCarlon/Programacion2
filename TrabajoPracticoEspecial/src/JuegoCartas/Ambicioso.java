package JuegoCartas;
public class Ambicioso implements Estrategia {
	
	public Atributo elegirValorAtributo(Carta carta) {
		return carta.getCantidadAtributos();
	}
}

