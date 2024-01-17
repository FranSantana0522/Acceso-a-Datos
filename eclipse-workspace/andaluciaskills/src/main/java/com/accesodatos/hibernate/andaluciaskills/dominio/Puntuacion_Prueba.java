package com.accesodatos.hibernate.andaluciaskills.dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Puntuacion_Prueba")
public class Puntuacion_Prueba implements Serializable{
	@Id
	@ManyToOne
	@JoinColumn(name = "id_competidor")
	private Competidor id_competidor;

	@Id
	@ManyToOne
	@JoinColumn(name = "id_prueba")
	private Prueba id_prueba;
	
	private double puntuacion;

	
	public Puntuacion_Prueba() {
		super();
	}

	public Puntuacion_Prueba(double puntuacion) {
		super();
		this.puntuacion = puntuacion;
	}

	@Override
	public String toString() {
		return "Puntuacion_Prueba [id_competidor=" + id_competidor + ", id_prueba=" + id_prueba + ", puntuacion="
				+ puntuacion + "]";
	}
	
	
}
