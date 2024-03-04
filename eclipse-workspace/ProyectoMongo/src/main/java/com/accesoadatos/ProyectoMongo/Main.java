package com.accesoadatos.ProyectoMongo;

import com.accesoadatos.ProyectoMongo.mongodb.MongoDB;

public class Main {
	
	public static void main(String[] args) {
		//Iniciamos la conexion a la base de datos en el constructor
		MongoDB mongodb=new MongoDB();
		mongodb.borrarDocumentos("alumnos");
		mongodb.borrarDocumentos("profesores");
		// Creamos las colecciones con un dato dentro
		mongodb.crearColecciones();
		//Insertamos mas datos a las colecciones creadas
		mongodb.insertarDatos();
		
		//Consultas basicas sobre las colecciones
		System.out.println("Consultas basicas");
		mongodb.consultasBasicas();
		System.out.println("***************************************************************************");
		
		System.out.println("Actualizaciones");
		mongodb.actualizaciones();
		System.out.println("***************************************************************************");

		System.out.println("Consultas y modificaciones sobre arrays");
		mongodb.conModArrays();
		System.out.println("***************************************************************************");
		
		System.out.println("Borrado de documentos");
		mongodb.borradoDoc();
		System.out.println("***************************************************************************");
		
		System.out.println("Consulta pipeline con 5 tipos");
		mongodb.consultasPipeline();
		System.out.println("***************************************************************************");

		System.out.println("Consultas sobre arrays con funciones");
		mongodb.consultasArrays();
		System.out.println("***************************************************************************");

		System.out.println("Consulta sobre documentos enlazados");
		mongodb.consultasDocumentosEnl();
		System.out.println("***************************************************************************");

		
		//Cerramos la conexion a la bd
		mongodb.cerrarConexion();
	}
}
