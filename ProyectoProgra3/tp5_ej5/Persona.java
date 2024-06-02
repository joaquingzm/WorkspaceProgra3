package tp5_ej5;

public class Persona {
	private boolean jubilacionPercibida;
	private boolean esJubilado;
	private String nombre;
	
	public Persona(boolean esJubilado,boolean jubilacionPercibida,String nombre) {
		if(esJubilado) {
			this.jubilacionPercibida=jubilacionPercibida;
			this.esJubilado=true;
		}
		else {
			this.esJubilado=false;
		}
		this.nombre=nombre;
	}
	
	public boolean esJubilado() {
		return esJubilado;
	}
	
	public boolean jubilacionPercibida() {
		return jubilacionPercibida;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	@Override
	public String toString() {
		return nombre+(this.esJubilado?(this.jubilacionPercibida?" JP":" JNP"):" P");
	}
}
