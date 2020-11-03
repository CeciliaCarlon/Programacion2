package JuegoCartas;

import JuegoCartas.Estrategia.Estrategia;
import JuegoCartas.Estrategia.EstrategiaTimbero;

public class Jugador {
	
	private String nombre;
	private int puntos;
	private Mazo poso;
	private Estrategia estrategia;
	
	public Jugador(String nom) {
		nombre=nom;
		puntos=0;
		estrategia= new EstrategiaTimbero();
	}
	
	public Carta elegirCarta() { 
		Carta carta=this.poso.getCartaElegida();
		return carta;
	}
	
	public Atributo elegirAtributo(Carta c) {
		return this.estrategia.elegirAtributo(c);
	}
	
	public Estrategia getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(Estrategia estrategia) {
		this.estrategia = estrategia;
	}

	public boolean posoVacio() {
		if(poso.getCantidadCartas()==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void incrementarPuntos() {
		puntos++;
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
