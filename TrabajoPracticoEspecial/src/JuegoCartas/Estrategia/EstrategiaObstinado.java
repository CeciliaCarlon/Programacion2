package JuegoCartas.Estrategia;

import JuegoCartas.Atributo;
import JuegoCartas.Carta;

public class EstrategiaObstinado implements Estrategia {
	
	private String nombreAtributo;
	
	public EstrategiaObstinado(String nombre) {
		this.nombreAtributo=nombre;
	}
	
	public Atributo elegirAtributo(Carta carta) {
		Carta cartaNueva= carta;
		Atributo atributo= cartaNueva.getPrimerAtributo();
		cartaNueva.removeAtributo(atributo);
		int limite=cartaNueva.getCantidadAtributos();
		for(int i=0; i<limite; i++) {
			if(!atributo.getNombre().equals(nombreAtributo)) {
				atributo= cartaNueva.getPrimerAtributo();
			}
			cartaNueva.removeAtributo(atributo);
		}
		return atributo;
	}
}
