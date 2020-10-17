package JuegoCartas;

public class CriterioCantidadAtributos extends Criterio {
	
	private int cantidad=0;
	
	public CriterioCantidadAtributos(int cant) {
		this.cantidad=cant;
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
	
}
