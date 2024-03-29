package com.accesodatos.hibernate.otrareunionmas;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.accesodatos.hibernate.otrareunionmas.dao.ActaDao;
import com.accesodatos.hibernate.otrareunionmas.dao.PersonaDao;
import com.accesodatos.hibernate.otrareunionmas.dao.ReunionDao;
import com.accesodatos.hibernate.otrareunionmas.dao.SalaDao;
import com.accesodatos.hibernate.otrareunionmas.dominio.Acta;
import com.accesodatos.hibernate.otrareunionmas.dominio.Persona;
import com.accesodatos.hibernate.otrareunionmas.dominio.Reunion;
import com.accesodatos.hibernate.otrareunionmas.dominio.Sala;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ReunionDao reunionDao = new ReunionDao();
        
        List<Reunion> reuniones =reunionDao.getAll();
        System.out.println("*** "+ reuniones);
        
        Reunion rNueva	= new Reunion(LocalDateTime.now().plus(2,ChronoUnit.DAYS),"Reunion de pasado mañana");
        System.out.println(rNueva);
        reunionDao.save(rNueva);
        System.out.println(rNueva);
        //System.out.println(reunionDao.getProximaReunion());
        System.out.println(reunionDao.getReunionesManyana());
        System.out.println(reunionDao.getProximaReunion());
        
        SalaDao salaDao=new SalaDao();
        
        List<Sala> salas=salaDao.getAll();
        System.out.println("*** "+salas);
        
        Sala sNueva=new Sala();
        System.out.println(sNueva);
        
        ActaDao actaDao= new ActaDao();
        System.out.println("*** "+ actaDao);
        Acta acta1=new Acta("Reunion anulada", rNueva);
        actaDao.save(acta1);
        
        PersonaDao personaDao=new PersonaDao();
        //Funciona pero esta comentado para que no de error por duplicate key 
       /* Persona p1= new Persona(1154,"Raul","Sanchez Diaz");
        Persona p2= new Persona(2154,"Laura","Lopez Gil");
        
        rNueva.addParticipante(p1);
        rNueva.addParticipante(p2);
        reunionDao.update(rNueva);
        
        Reunion r2= new Reunion (LocalDateTime.now(), "Reunion 2");
        reunionDao.save(r2);
        Persona p3= new Persona (9922,"Marta","Sanchez Sanchez");
        p3.addReunion(r2);
        personaDao.save(p3);*/	
        Optional<Persona> optPersona=personaDao.get(1);
        if (optPersona.isPresent()) {
        	Persona persona=optPersona.get();
        	System.out.println(persona);
        	
        	Set<Reunion> reuniones2=persona.getReuniones();
        	System.out.println("Reuniones de esta persona: "+reuniones2);
        	
        	Set<Sala> salas2=new HashSet<Sala>();
        	Set<Persona> compis=new HashSet<Persona>();
        	Set<Acta> actas=new HashSet<Acta>();
        	
        	for(Reunion reunion:reuniones2) {
        		salas.add(reunion.getSala());
        		compis.addAll(reunion.getParticipantes());
        		actas.add(reunion.getActa());
        	}
        	System.out.println("Salas: "+salas);
        	System.out.println("Compis: "+compis);
        	System.out.println("Actas: "+actas);
        }
        
        
    }
}
