package JuegoCartas;

public class Atributo implements Comparable<Atributo>{
	
	private String nombre;
	private double valor;

	public Atributo(String nombre, double valor) {
		this.nombre=nombre;
		this.valor=valor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public int compareTo(Atributo atributo) {
		return (int)this.getValor() - (int)atributo.getValor();
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
