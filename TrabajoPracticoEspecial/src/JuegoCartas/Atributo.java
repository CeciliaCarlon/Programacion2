package JuegoCartas;

public class Atributo {
	
	private String nombre;
	private Object valor;

	public Atributo(String nombre, Object valor) {
		this.nombre=nombre;
		this.valor=valor;
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
		Atributo otra=(Atributo) obj;
		try {
			return this.getNombre().equals(otra.getNombre());
		}
		
		catch(Exception e){
			return false;
		}
	}
	
	@Override
	public String toString() {
		return this.getNombre()+" = "+this.getValor();
	}
	
	
}
