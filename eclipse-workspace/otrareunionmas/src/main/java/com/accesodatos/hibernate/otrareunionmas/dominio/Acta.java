package com.accesodatos.hibernate.otrareunionmas.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Acta")
public class Acta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String contenido;
	
	@OneToOne
	@JoinColumn
	private Reunion reunion;
	
	
	public Acta() {
	
	}


	public Acta (String contenido ,Reunion reunion) {
		super();
		this.contenido=contenido;
		this.reunion=reunion;
		reunion.setActa(this);
	}


	@Override
	public String toString() {
		return "Acta [id=" + id + ", contenido=" + contenido + ", reunion=" + reunion + "]";
	}
	
}
