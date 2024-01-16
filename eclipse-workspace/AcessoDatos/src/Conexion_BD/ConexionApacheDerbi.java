package Conexion_BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionApacheDerbi {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		Connection conexion=DriverManager.getConnection("jdbc:derby:/home/usuario/db-derby-10.17.1.0-bin/testDB;");
		
		Statement sentencia=conexion.createStatement();
		ResultSet consulta=sentencia.executeQuery("SELECT * FROM departamentos");
		while(consulta.next()) {
			System.out.printf("%d,%s,%s %n",consulta.getInt(1),consulta.getString(2),consulta.getString(3));
		}
		consulta.close();
		sentencia.close();
		conexion.close();
	}

}
