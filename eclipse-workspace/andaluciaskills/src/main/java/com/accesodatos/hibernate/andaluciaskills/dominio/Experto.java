package com.accesodatos.hibernate.andaluciaskills.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Experto")
public class Experto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	
	@ManyToOne
	@JoinColumn
	private Especialidad id_especialidad;
	
	@OneToOne
	@JoinColumn
	private Usuario id_usuario;

	public Experto() {
		super();
	}

	public Experto(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Experto [id=" + id + ", nombre=" + nombre + ", id_especialidad=" + id_especialidad + ", id_usuario="
				+ id_usuario + "]";
	}
	
	
}
