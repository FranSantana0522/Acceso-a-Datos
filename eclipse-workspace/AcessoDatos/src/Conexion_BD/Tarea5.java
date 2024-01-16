package Conexion_BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Tarea5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/Empresa?useSSL=false"
					,"root", "root");
			conexion.setAutoCommit(false);
			try {
				String sql = "INSERT INTO departamentos VALUES" + "( ?, ?, ? )";

				System.out.println(sql);
				PreparedStatement sentencia = conexion.prepareStatement(sql);
				sentencia.setInt(1, Integer.parseInt("2"));
				sentencia.setString(2, "MARKETING");
				sentencia.setString(3, "SALTA");
				sentencia.executeUpdate();
				sentencia.close();
				
				//Primera vez dara error comentar luego de probar que de error
//				sentencia = conexion.prepareStatement(sql);
//				sentencia.setInt(1, Integer.parseInt("2"));
//				sentencia.setString(2, "MARKETING");
//				sentencia.setString(3, "SALTA");
//				sentencia.executeUpdate();
//				sentencia.close();
				
				sentencia = conexion.prepareStatement(sql);
				sentencia.setInt(1, Integer.parseInt("3"));
				sentencia.setString(2, "RRHH");
				sentencia.setString(3, "SEVILLA");
				sentencia.executeUpdate();
				sentencia.close();
				
				
				conexion.commit();
			}catch(SQLException e) {
				conexion.rollback();
				e.printStackTrace();
				System.out.printf("HA OCURRIDO UNA EXCEPCION: %n");
				System.out.printf("Mensaje    : %s %n", e.getMessage());
				System.out.printf("SQL estado : %s %n", e.getSQLState());
				System.out.printf("Cod error  : %s %n", e.getErrorCode());
			}
			
		}catch(ClassNotFoundException e) {
			
		}catch(SQLException e) {
			System.out.printf("HA OCURRIDO UNA EXCEPCION: %n");
			System.out.printf("Mensaje    : %s %n", e.getMessage());
			System.out.printf("SQL estado : %s %n", e.getSQLState());
			System.out.printf("Cod error  : %s %n", e.getErrorCode());
		}
	}

}
