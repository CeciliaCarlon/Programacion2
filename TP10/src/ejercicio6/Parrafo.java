package ejercicio6;

import java.util.ArrayList;

public class Parrafo extends Traductor {

	private ArrayList<Palabra> palabras;
	private String idioma;
	private boolean copyright;
	
	public Parrafo(String idioma) {
		this.idioma = idioma;
	}
	
	public int getCantidadPalabras() {
		return this.palabras.size();
	}
	
	public Palabra getPalabra(int num) {
		return this.palabras.get(num);
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public void addPalabra(Palabra palabra) {
		this.palabras.add(palabra);
	}

	public boolean isCopyright() {
		return copyright;
	}

	public void setCopyright(boolean copyright) {
		this.copyright = copyright;
	}
}
