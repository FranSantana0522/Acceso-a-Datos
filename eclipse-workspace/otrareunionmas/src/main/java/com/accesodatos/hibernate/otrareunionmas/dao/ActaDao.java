package com.accesodatos.hibernate.otrareunionmas.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Query;

import com.accesodatos.hibernate.otrareunionmas.dao.abstractDao.AbstractDao;
import com.accesodatos.hibernate.otrareunionmas.dominio.Acta;
import com.accesodatos.hibernate.otrareunionmas.dominio.Sala;

public class ActaDao extends AbstractDao<Acta>{
	public ActaDao() {
		setClazz(Acta.class);
	}
	public List<Acta> findActasReunionesAntiguas(){
		String qlString=" FROM "+Acta.class.getName()+" a WHERE a.reunion.fecha<:ayer";
		LocalDateTime ayer=LocalDateTime.now().minusDays(1);
		Query query = getEntityManager().createQuery(qlString);
		query.setParameter("ayer", ayer);
		return query.getResultList();
	}
}
