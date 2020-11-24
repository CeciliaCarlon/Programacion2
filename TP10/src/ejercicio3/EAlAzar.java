package ejercicio3;

import java.util.ArrayList;

public class EAlAzar extends Estrategia {

	@Override
	public ColaTerminal buscar(Colas cola) {
		ArrayList<ColaTerminal> aux= cola.getColas();
		int posicion= (int)(Math.random() * aux.size() +1);
		return aux.get(posicion);
	}

}
