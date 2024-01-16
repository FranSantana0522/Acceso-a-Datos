package examen;

import java.io.Serializable;

public class Contacto implements Serializable{
	private String nombre;
	private String tlf;
	private String correo;

	@Override
	public String toString() {
		return "Contacto [Nombre=" + nombre + ", tlf=" + tlf + ", correo=" + correo + "]";
	}

	public Contacto(String nombre, String tlf, String correo) {
		super();
		this.nombre = nombre;
		this.tlf = tlf;
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
