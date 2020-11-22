package ejercicio4;

public class Atributo {

	private String nombre;
	private Object valor;
	
	public Atributo(String nombre, Object valor) {
		this.nombre = nombre;
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}
	
	@Override
	public boolean equals(Object obj) {
		Atributo a= (Atributo) obj;
		try {
			return this.getValor().equals(a.getValor());
		}
		catch(Exception e) {
			return false;
		}
	}
	
}
