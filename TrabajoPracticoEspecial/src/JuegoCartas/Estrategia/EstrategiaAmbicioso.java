package JuegoCartas.Estrategia;

import JuegoCartas.Atributo;
import JuegoCartas.Carta;

public class EstrategiaAmbicioso implements Estrategia {
	
	public Atributo elegirAtributo(Carta carta) {
		Carta cartaNueva= carta;
		Atributo atributoMasAlto=cartaNueva.getPrimerAtributo();
		cartaNueva.removeAtributo(atributoMasAlto);
		int limite=cartaNueva.getCantidadAtributos();
		for(int i=0; i<limite; i++) {
			if(cartaNueva.getPrimerAtributo().compareTo(atributoMasAlto)>0) {
				atributoMasAlto=cartaNueva.getPrimerAtributo();
			}
			cartaNueva.removeAtributo(atributoMasAlto);
		}
		return atributoMasAlto;
	}
}

