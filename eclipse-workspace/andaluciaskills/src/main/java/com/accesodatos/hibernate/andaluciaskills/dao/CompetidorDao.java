package com.accesodatos.hibernate.andaluciaskills.dao;

import com.accesodatos.hibernate.andaluciaskills.dao.abstracDao.AbstractDao;
import com.accesodatos.hibernate.andaluciaskills.dominio.Competidor;

public class CompetidorDao extends AbstractDao<Competidor>{
	public CompetidorDao() {
		setClazz(Competidor.class);
	}
}
