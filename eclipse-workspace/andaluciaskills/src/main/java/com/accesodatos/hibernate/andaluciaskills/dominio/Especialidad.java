package com.accesodatos.hibernate.andaluciaskills.dominio;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Especialidad")
public class Especialidad {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true)
	private int codigo;
	
	private String nombre;
	
	@OneToMany(mappedBy = "id_especialidad")
	private Set<Experto> expertos = new HashSet <>();
	
	@OneToMany(mappedBy = "id_especialidad")
	private Set<Competidor> competidores = new HashSet <>();

	public Especialidad() {
		super();
	}

	public Especialidad(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Especialidad [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", experto=" + expertos
				+ ", competidor=" + competidores + "]";
	}

	
	
	
}
