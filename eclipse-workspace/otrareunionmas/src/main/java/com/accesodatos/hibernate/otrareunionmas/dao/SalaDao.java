package com.accesodatos.hibernate.otrareunionmas.dao;

import java.util.List;

import javax.persistence.Query;

import com.accesodatos.hibernate.otrareunionmas.dao.abstractDao.AbstractDao;
import com.accesodatos.hibernate.otrareunionmas.dominio.Reunion;
import com.accesodatos.hibernate.otrareunionmas.dominio.Sala;

public class SalaDao extends AbstractDao<Sala>{
	public SalaDao() {
		setClazz(Sala.class);
	}
	public List<Sala> findSalasParaNPersonas(int numPersonas){
		String qlString="FROM "+Sala.class.getName()+" WHERE capacidad >= ?1";
		Query query =getEntityManager().createQuery(qlString);
		query.setParameter(1, numPersonas);
		return query.getResultList();
	}

}
