package JuegoCartas.Estrategia;

import JuegoCartas.Atributo;
import JuegoCartas.Carta;

public class EstrategiaAmbicioso extends Estrategia {
	
	public Atributo elegirAtributo(Carta carta) {
		Atributo atributoMasAlto=carta.getPrimerAtributo();
		for(String nombre: carta.getNombresDeAtributos()) {
			if(carta.getAtributoPorNombre(nombre).compareTo(atributoMasAlto)>0) {
				atributoMasAlto= carta.getAtributoPorNombre(nombre);
			}
		}
		return atributoMasAlto;
	}
}

