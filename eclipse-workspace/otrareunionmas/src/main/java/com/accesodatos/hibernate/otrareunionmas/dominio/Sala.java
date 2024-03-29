package com.accesodatos.hibernate.otrareunionmas.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sala")
public class Sala {
	@Id
	@Column(length=20)
	private String id;
	private String descripcion;
	private int capacidad;
	
	@OneToMany(mappedBy="sala")
	private List<Reunion> reuniones;

	public Sala() {
		super();
	}
	
	public void addReunion(Reunion r) {
		if (this.reuniones == null) {
			reuniones = new ArrayList<Reunion>();
		}
		reuniones.add(r);
		if(!r.getSala().equals(this)) {
			r.setSala(this);
		}
	}
	
	public void removeReunion(Reunion r) {
		reuniones.remove(r);
		r.setSala(null);
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public List<Reunion> getReuniones() {
		return reuniones;
	}

	public void setReuniones(List<Reunion> reuniones) {
		this.reuniones = reuniones;
	}

	@Override
	public String toString() {
		return "Sala [id=" + id + ", descripcion=" + descripcion + ", capacidad=" + capacidad + ", reuniones="
				+ reuniones + "]";
	}

	public boolean containsReunion(Reunion reunion) {
		return reuniones.contains(reunion);
	}
	
	
}
