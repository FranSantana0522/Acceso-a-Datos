package com.accesodatos.hibernate.andaluciaskills.dao;

import com.accesodatos.hibernate.andaluciaskills.dao.abstracDao.AbstractDao;
import com.accesodatos.hibernate.andaluciaskills.dominio.Prueba;

public class PruebaDao extends AbstractDao<Prueba>{
	public PruebaDao() {
		setClazz(Prueba.class);
	}
}
