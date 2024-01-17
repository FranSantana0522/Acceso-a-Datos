package com.accesodatos.hibernate.andaluciaskills.dao;

import com.accesodatos.hibernate.andaluciaskills.dao.abstracDao.AbstractDao;
import com.accesodatos.hibernate.andaluciaskills.dominio.Especialidad;

public class EspecialidadDao extends AbstractDao<Especialidad>{
	public EspecialidadDao() {
		setClazz(Especialidad.class);
	}
}
