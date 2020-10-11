package JuegoCartas;

public class Jugador {
	
	private String nombre;
	private int puntos;
	private Mazo poso;
	private Carta carta;
	
	public Jugador(String nom) {
		nombre=nom;
		puntos=0;
	}
	
	public Carta elegirCarta(Mazo poso) { 
		return poso.getCartaElegida(poso);
	}
	
	public Atributo elegirAtributo(Carta c) {
		return c.getAtributoElegido(c);
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

	public Carta getCarta() {
		return carta;
	}
	
	
	
}
