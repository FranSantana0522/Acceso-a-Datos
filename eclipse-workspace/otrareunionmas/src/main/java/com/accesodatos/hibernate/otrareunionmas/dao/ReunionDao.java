package com.accesodatos.hibernate.otrareunionmas.dao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import com.accesodatos.hibernate.otrareunionmas.dao.abstractDao.AbstractDao;
import com.accesodatos.hibernate.otrareunionmas.dominio.Persona;
import com.accesodatos.hibernate.otrareunionmas.dominio.Reunion;

public class ReunionDao extends AbstractDao<Reunion>{
	
	public ReunionDao() {
		setClazz(Reunion.class);
	}
	
	public Reunion getProximaReunion() {
		String sqlString=" FROM "+Reunion.class.getName() + " WHERE fecha> now() ORDER BY fecha";
		Query query = getEntityManager().createQuery(sqlString).setMaxResults(1);
		return (Reunion) query.getSingleResult();
	}
	public List<Reunion> getReunionesManyana() {
		String qlString=" FROM "+Reunion.class.getName() +" WHERE fecha BETWEEN ?1 AND ?2";
		Query query = getEntityManager().createQuery(qlString);
		
		LocalDate manyana=LocalDate.now().plus(1, ChronoUnit.DAYS);
		query.setParameter(1, manyana.atStartOfDay());
		query.setParameter(2, manyana.plus(1, ChronoUnit.DAYS).atStartOfDay());
				
		return (List<Reunion>) query.getResultList();
	}
	

	//criteriaQuery.multiselect(joinReunion).where(cb.equal(fromPersona.get("numeroEmpleado"), numEmple));
	//ver en https://www.initgrep.com/posts/java/jpa/select-values-in-criteria-queries
	
	public List<Reunion> reunionesParticipante(String numEmple){
		CriteriaBuilder cb= getEntityManager().getCriteriaBuilder();
		//Reunion porque quiero recuperar objetos reunión. Si por ejemplo fuera a hacer un count, 
		//pondría CriteriaQuery<Long> y Long.class
		CriteriaQuery<Reunion> criteriaQuery =cb.createQuery(Reunion.class);
		
		Root<Persona> fromPersona=criteriaQuery.from(Persona.class);
		
		Join<Persona, Reunion> joinReunion = fromPersona.join("reuniones", JoinType.INNER);
		
		criteriaQuery.select(joinReunion).where(cb.equal(fromPersona.get("numeroEmpleado"), numEmple));
		TypedQuery<Reunion> query=getEntityManager().createQuery(criteriaQuery);
		return query.getResultList();
	}

}

	