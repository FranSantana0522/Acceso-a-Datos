package Conexion_BD;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepareSentencias {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dep = args[0];
		String dnombre = args[1];
		String loc = args[2];
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Empresa?useSSL=false",
					"root", "root");

			String sql = "INSERT INTO departamentos VALUES" + "( ?, ?, ? )";

			System.out.println(sql);
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setInt(1, Integer.parseInt(dep));
			sentencia.setString(2, dnombre);
			sentencia.setString(3, loc);
			int filas;
			try {
				filas = sentencia.executeUpdate();
				System.out.println("Filas afectadas: " + filas);
			} catch (SQLException e) {
				System.out.printf("HA OCURRIDO UNA EXCEPCION: %n");
				System.out.printf("Mensaje    : %s %n", e.getMessage());
				System.out.printf("SQL estado : %s %n", e.getSQLState());
				System.out.printf("Cod error  : %s %n", e.getErrorCode());
			}
			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {

		}
	}

}
