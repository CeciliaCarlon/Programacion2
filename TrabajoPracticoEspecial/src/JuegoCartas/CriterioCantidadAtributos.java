package JuegoCartas;

public class CriterioCantidadAtributos extends Criterio {
	
	private int cantidad;
	
	public CriterioCantidadAtributos(Mazo m) {
		Carta cartaCorrecta=m.getPrimeraCarta();
		cantidad=cartaCorrecta.getCantidadAtributos();
	}
	
	@Override
	public boolean cumple(Carta c) {
		if (c.getCantidadAtributos()==cantidad) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/*@Override
	public boolean equals(Object obj) {
		int cantidad=(int) obj;
		try {
			return this.getNombre().equals(otra.getNombre());
		}
		
		catch(Exception e){
			return false;
		}
	}*/
}
