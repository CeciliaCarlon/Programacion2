package ejercicio6;

import java.util.ArrayList;

public class Diccionario {
	
	private String idioma;
	private ArrayList<Palabra> traducciones;

	public Diccionario(String idioma) {
		this.idioma = idioma;
	}
	
	public void addTraduccion(Palabra t) {
		this.traducciones.add(t);
	}
	
	public Palabra getTraduccion(Palabra p) {
		int idBuscado=p.getId();
		for(int i=0; i<this.traducciones.size(); i++) {
			if(traducciones.get(i).getId()==idBuscado) {
				return traducciones.get(i);
			}
		}
		return null;
	}

	public Parrafo traducir(Parrafo parrafo) {
		if(!parrafo.isCopyright()) {
			Parrafo parrafoTraducido= new Parrafo(idioma);
			for(int i=0; i<parrafo.getCantidadPalabras(); i++) {
				Palabra palabra=parrafo.getPalabra(i);
				if(getTraduccion(palabra)!=null) {
					parrafoTraducido.addPalabra(getTraduccion(palabra));
				}
				else {
					Palabra error= new Palabra("ERROR", 0);
					parrafoTraducido.addPalabra(error);
				}
			}
			return parrafoTraducido;
		}
		else {
			Parrafo parrafoOriginal= new Parrafo(parrafo.getIdioma());
			for(int i=0; i<parrafo.getCantidadPalabras(); i++) {
				Palabra palabra=parrafo.getPalabra(i);
				parrafoOriginal.addPalabra(palabra);
			}
			return parrafoOriginal;
		}
	}
}
