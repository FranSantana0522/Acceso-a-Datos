package com.accesodatos.hibernate.andaluciaskills.dominio;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Prueba")
public class Prueba {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true)
	private String nombre;

	@ManyToMany(mappedBy = "pruebas")
	private Set<Competidor> competidores = new HashSet<>();


	public Prueba() {
		super();
	}

	public Prueba(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Prueba [id=" + id + ", nombre=" + nombre + ", competidores=" + competidores + "]";
	}
	
	
}
