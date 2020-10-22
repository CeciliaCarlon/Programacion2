package JuegoCartas;

public class Timbero implements Estrategia{
	
	public Atributo elegirAtributo(Carta carta) {
		return carta.elegirAtributoAleatorio();
	}
}
