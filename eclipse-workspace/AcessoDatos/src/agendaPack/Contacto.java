package agendaPack;

public class Contacto {
	private String nombre;
	private String apellidos;
	private Integer telf;
	
	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", apellidos=" + apellidos + ", telf=" + telf + "]";
	}
	public Contacto(String nombre, String apellidos, Integer telf) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telf = telf;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Integer getTelf() {
		return telf;
	}
	public void setTelf(Integer telf) {
		this.telf = telf;
	}
	
	
}
