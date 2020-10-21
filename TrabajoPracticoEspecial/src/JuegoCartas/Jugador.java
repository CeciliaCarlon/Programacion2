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
		carta=poso.getCartaElegida(poso);
		return carta;
	}
	
	public Atributo elegirAtributo(Carta c) {
		return c.elegirAtributoAleatorio();
	}
	
	public boolean posoVacio() {
		if(poso.getCantidadCartas()==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int incrementarPuntos(int p) {
		return p++;
	}

	public String getNombre() {
		return nombre;
	}
	
	public int getCantidadCartas() {
		return this.poso.getCantidadCartas();
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
	
	public String toString() {
		return 	"La carta de "+ this.getNombre()+" es "+this.getCarta().getNombre()+" con "+this.getCarta().getAtributoElegido().getNombre()+" "+this.getCarta().getAtributoElegido().getValor();
	}
	
}
