package JuegoCartas;

public class Atributo implements Comparable<Atributo>{
	
	private String nombre;
	private int valor;

	public Atributo(String nombre, int valor) {
		this.nombre=nombre;
		this.valor=valor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	@Override
	public int compareTo(Atributo atributo) {
		return this.getValor() - atributo.getValor();
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
