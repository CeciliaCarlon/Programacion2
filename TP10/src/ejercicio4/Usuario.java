package ejercicio4;

public class Usuario {

	private String nombre;
	private Criterio preferencia;
	
	
	public Usuario(String nombre, Criterio preferencia) {
		this.nombre = nombre;
		this.preferencia = preferencia;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Criterio getPreferencia() {
		return preferencia;
	}
	public void setPreferencia(Criterio preferencia) {
		this.preferencia = preferencia;
	}
	
	
}
