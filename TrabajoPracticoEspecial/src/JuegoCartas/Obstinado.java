package JuegoCartas;
public class Obstinado implements Estrategia {
	
	public Atributo AtributoElegido(Carta carta) {
		return carta.atributoElegido();
	}
}
