package com.accesodatos.hibernate.otrareunionmas.dao;

import com.accesodatos.hibernate.otrareunionmas.dao.abstractDao.AbstractDao;
import com.accesodatos.hibernate.otrareunionmas.dominio.Persona;

public class PersonaDao extends AbstractDao<Persona>{
	public PersonaDao() {
		setClazz(Persona.class);
	}
}
