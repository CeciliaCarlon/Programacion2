package ejercicio6;

import java.util.ArrayList;

public class Texto extends Traductor {

	private String titulo;
	private ArrayList<Traductor> contenido;
	
	public Texto(String titulo) {
		this.titulo = titulo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void addCotenido(Traductor con) {
		this.contenido.add(con);
	}
	
}
