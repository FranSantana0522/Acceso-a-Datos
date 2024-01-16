package Conexion_BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepareSentenciasEj6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dep = args[0];
		String oficio = args[1];
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Empresa?useSSL=false",
					"root", "root");

			String sql = "SELECT apellido, salario FROM empleados WHERE dept_no = ? AND "
					+"oficio = ? ORDER BY 1";

			System.out.println(sql);
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setInt(1, Integer.parseInt(dep));
			sentencia.setString(2, oficio);
			
			ResultSet rs=sentencia.executeQuery();
			while(rs.next()) {
				System.out.printf("%s => %.2f %n",rs.getString("apellido"),rs.getFloat("salario"));
			}
			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {

		}
	}

}
