package examenU2;
/**
 * @author Francisco Javier Santana Montes
 */
public class Comercio {
	private Integer cif;
	private String nombre;
	private String ciudad;
	private Integer trabajadores;
	

	
	@Override
	public String toString() {
		return "Comercio [cif=" + cif + ", nombre=" + nombre + ", ciudad=" + ciudad + ", trabajadores=" + trabajadores
				+ "]";
	}
	public Comercio() {
		super();
	}
	public Comercio(Integer cif, String nombre, String ciudad, Integer trabajadores) {
		super();
		this.cif = cif;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.trabajadores = trabajadores;
	}
	public Integer getCif() {
		return cif;
	}
	public void setCif(Integer cif) {
		this.cif = cif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public Integer getTrabajadores() {
		return trabajadores;
	}
	public void setTrabajadores(Integer trabajadores) {
		this.trabajadores = trabajadores;
	}
	
}
