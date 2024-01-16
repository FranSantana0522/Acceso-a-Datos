package examenU2;
/**
 * @author Francisco Javier Santana Montes
 */
public class Cliente {
	private String dni;
	private String nombre;
	private Integer edad;
	private String sexo;
	
	
	
	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + "]";
	}
	public Cliente() {
		super();
	}
	public Cliente(String dni, String nombre, Integer edad, String sexo) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
}	
