package com.accesodatos.hibernate.otrareunionmas.dominio;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="persona")
public class Persona {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(unique=true)
	private int numeroEmpleado;
	private String nombre;
	private String apellidos;
	
	@ManyToMany
	private Set<Reunion> reuniones;
	
	


	public Persona() {
		super();
		reuniones= new HashSet <Reunion>();
	}

	public Persona(int numeroEmpleado, String nombre, String apellidos, Set<Reunion> reuniones) {
		super();
		this.numeroEmpleado = numeroEmpleado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.reuniones = reuniones;
	}

	public Persona(int numeroEmpleado, String nombre, String apellidos) {
		this();
		this.numeroEmpleado = numeroEmpleado;
		this.nombre = nombre;
		this.apellidos = apellidos;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(int numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
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

	public Set<Reunion> getReuniones() {
		return reuniones;
	}

	public void setReuniones(Set<Reunion> reuniones) {
		this.reuniones = reuniones;
	}

	public void addReunion(Reunion reunion) {
		if (reunion == null) {
			reuniones = new HashSet<>();
		}
		this.reuniones.add(reunion);
		if(!reunion.getParticipantes().contains(this)) {
			reunion.addParticipante(this);
		}
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", numeroEmpleado=" + numeroEmpleado + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", reuniones=" + reuniones + "]";
	}
	
	
}
