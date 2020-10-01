package JuegoCartas;

import java.util.ArrayList;

public class Jugador {
	
	private String nombre;
	private int puntos;
	private Mazo poso;
	
	public Jugador(String nom) {
		nombre=nom;
		puntos=0;
	}
	
	public Carta elegirCarta(Mazo poso) { 
		//poso.getCarta();
		for (int i=0; i<poso.size(); i++) {
			//pregunta sobre metodos random.
			Carta cartaElegida= poso.get(i);
		}
		return cartaElegida;
	}
	
	public int elegirAtributo() {
		//agarra la carta en orden y elije atributo.
		for(int i=0; i<c.getAtributo().size();i++) {
			//elegir atributo de manera random
			Atributo atributoElegido= //atributoAleatorio
		}
		return atributoElegido;
	}
	
	public int incrementarPuntos(int p) {
		return p++;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public Mazo getPoso() {
		return poso;
	}

	public void setPoso(Mazo poso) {
		this.poso = poso;
	}
	
	
}
