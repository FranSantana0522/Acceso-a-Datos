package Conexion_BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Tarea2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/Empresa?useSSL=false"
					,"root", "root");
			
			Statement sentencia=conexion.createStatement();
			ResultSet consulta=sentencia.executeQuery("SELECT apellido,salario FROM empleados WHERE salario=(select max(salario) from empleados)");
			while(consulta.next()) {
				System.out.printf("%s, %.2f %n", consulta.getString(1),consulta.getFloat(2));
			}
			consulta.close();
			sentencia.close();
			conexion.close();
		}catch(ClassNotFoundException e) {
			
		}catch(SQLException e) {
			
		}
	}

}
