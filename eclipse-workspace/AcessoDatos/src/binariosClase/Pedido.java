package binariosClase;

import java.io.Serializable;

public class Pedido implements Serializable{
	private String desc;
	private Integer numUnidades;
	private Double precio;
	
	@Override
	public String toString() {
		return "Pedido\n[Descripcion=" + desc + ", NºUnidades=" + numUnidades + ", Precio=" + precio + "]\n";
	}
	public Pedido(String desc, Integer numUnidades, Double precio) {
		super();
		this.desc = desc;
		this.numUnidades = numUnidades;
		this.precio = precio;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Integer getNumUnidades() {
		return numUnidades;
	}
	public void setNumUnidades(Integer numUnidades) {
		this.numUnidades = numUnidades;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
}
