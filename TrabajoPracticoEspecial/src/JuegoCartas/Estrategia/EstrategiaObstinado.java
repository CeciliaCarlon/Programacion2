package JuegoCartas.Estrategia;

import JuegoCartas.Atributo;
import JuegoCartas.Carta;

public class EstrategiaObstinado extends Estrategia {
	
	private String nombreAtributo;
	
	public EstrategiaObstinado(String nombre) {
		this.nombreAtributo=nombre;
	}
	
	public Atributo elegirAtributo(Carta carta) {
		return carta.getAtributoPorNombre(nombreAtributo);
	}
}
