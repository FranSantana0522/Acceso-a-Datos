package com.accesodatos.hibernate.andaluciaskills.dominio;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Competidor")
public class Competidor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	
	private String centro;
	
	@ManyToOne
	@JoinColumn
	private Especialidad id_especialidad;
	
	@ManyToMany
	@JoinTable(name = "Puntuacion_Prueba",
	joinColumns = @JoinColumn(name = "id_competidor"),
	inverseJoinColumns = @JoinColumn(name = "id_prueba"))
	private Set<Prueba> pruebas = new HashSet<>();

	public Competidor() {
		super();
	}

	public Competidor(String nombre, String centro) {
		super();
		this.nombre = nombre;
		this.centro = centro;
	}
	
	
}
