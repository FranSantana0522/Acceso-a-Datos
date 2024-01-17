package com.accesodatos.hibernate.andaluciaskills.dao;

import com.accesodatos.hibernate.andaluciaskills.dao.abstracDao.AbstractDao;
import com.accesodatos.hibernate.andaluciaskills.dominio.Experto;

public class ExpertoDao extends AbstractDao<Experto>{
	public ExpertoDao() {
		setClazz(Experto.class);
	}
}
