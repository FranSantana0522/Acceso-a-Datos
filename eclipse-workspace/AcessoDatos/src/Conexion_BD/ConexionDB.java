package Conexion_BD;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/Empresa?useSSL=false"
				,"root", "root");

			Statement sentencia=conexion.createStatement();
			ResultSet consulta=sentencia.executeQuery("SELECT * FROM departamentos");
			while(consulta.next()) {
				System.out.printf("%d,%s,%s %n",consulta.getInt(1),consulta.getString(2),consulta.getString(3));
			}
			consulta.close();
			sentencia.close();
			conexion.close();
		}catch(ClassNotFoundException e) {
			
		}catch(SQLException e) {
			
		}
	}

}
