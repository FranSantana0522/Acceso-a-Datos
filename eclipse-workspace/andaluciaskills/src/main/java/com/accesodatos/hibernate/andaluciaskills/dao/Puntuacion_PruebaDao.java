package com.accesodatos.hibernate.andaluciaskills.dao;

import com.accesodatos.hibernate.andaluciaskills.dao.abstracDao.AbstractDao;
import com.accesodatos.hibernate.andaluciaskills.dominio.Puntuacion_Prueba;

public class Puntuacion_PruebaDao extends AbstractDao<Puntuacion_Prueba>{
	public Puntuacion_PruebaDao() {
		setClazz(Puntuacion_Prueba.class);
	}
}
