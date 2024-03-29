package com.accesodatos.hibernate.andaluciaskills;

import com.accesodatos.hibernate.andaluciaskills.dao.CompetidorDao;
import com.accesodatos.hibernate.andaluciaskills.dao.EspecialidadDao;
import com.accesodatos.hibernate.andaluciaskills.dao.ExpertoDao;
import com.accesodatos.hibernate.andaluciaskills.dao.PruebaDao;
import com.accesodatos.hibernate.andaluciaskills.dao.Puntuacion_PruebaDao;
import com.accesodatos.hibernate.andaluciaskills.dao.UsuarioDao;
import com.accesodatos.hibernate.andaluciaskills.dominio.Competidor;
import com.accesodatos.hibernate.andaluciaskills.dominio.Especialidad;
import com.accesodatos.hibernate.andaluciaskills.dominio.Experto;
import com.accesodatos.hibernate.andaluciaskills.dominio.Prueba;
import com.accesodatos.hibernate.andaluciaskills.dominio.Puntuacion_Prueba;
import com.accesodatos.hibernate.andaluciaskills.dominio.Usuario;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	CompetidorDao competidorDao = new CompetidorDao();
    	Competidor competidor = new Competidor("Daniel", "Centro");

    	EspecialidadDao especialidadDao = new EspecialidadDao();
    	Especialidad especialidad = new Especialidad(1, "BBDD");

    	ExpertoDao expertoDao = new ExpertoDao();
    	Experto experto = new Experto("El Xokas");

    	PruebaDao pruebaDao = new PruebaDao();
    	Prueba prueba = new Prueba("Cascos");

    	Puntuacion_PruebaDao puntuacionPruebaDao = new Puntuacion_PruebaDao();
    	Puntuacion_Prueba puntuacionPrueba = new Puntuacion_Prueba(20);

    	UsuarioDao usuarioDao = new UsuarioDao();
    	Usuario usuario = new Usuario("dgb", "111");
    }
}
