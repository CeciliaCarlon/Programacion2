package JuegoCartas;

import java.util.*;

public class CriterioTipoAtributo extends Criterio {

	private ArrayList<Atributo> atributosCorrectos;
	
	public CriterioTipoAtributo (Mazo m) {
		Carta c= m.getPrimeraCarta();
		ArrayList<Atributo> ac= c.getAtributo();
		for (int i=0; i<ac.size(); i++) {
			atributosCorrectos.add(ac.get(i));
		}
	}
	
	@Override
	public boolean cumple(Carta carta) {
		boolean cumple=false;
		ArrayList<Atributo> ac= carta.getAtributo();
		for(int i=0; i<ac.size(); i++) {
			Atributo atributo=ac.get(i);
			if (atributosCorrectos.contains(atributo)) {
				cumple=true;
			}
			else {
				cumple=false;
			}
		}
		return cumple;
	}

}
