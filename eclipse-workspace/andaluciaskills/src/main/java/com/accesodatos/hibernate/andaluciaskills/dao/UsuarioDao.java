package com.accesodatos.hibernate.andaluciaskills.dao;

import com.accesodatos.hibernate.andaluciaskills.dao.abstracDao.AbstractDao;
import com.accesodatos.hibernate.andaluciaskills.dominio.Usuario;

public class UsuarioDao extends AbstractDao<Usuario>{
	public UsuarioDao() {
		setClazz(Usuario.class);
	}
}
