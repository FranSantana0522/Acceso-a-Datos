package Conexion_BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tarea4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dep = args[0];
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Empresa?useSSL=false",
					"root", "root");

			String sql = "SELECT apellido, salario, oficio FROM empleados WHERE dept_no = ? ORDER BY 1";

			System.out.println(sql);
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setInt(1, Integer.parseInt(dep));
			
			ResultSet rs=sentencia.executeQuery();
			while(rs.next()) {
				System.out.printf("%s => %.2f & %s %n",rs.getString("apellido"),rs.getFloat("salario"),rs.getString("oficio"));
			}
			rs.close();
			sentencia.close();
			
			sql="SELECT dnombre FROM departamentos WHERE dept_no = ?";
			
			sentencia=conexion.prepareStatement(sql);
			sentencia.setInt(1, Integer.parseInt(dep));
			
			rs=sentencia.executeQuery();
			while(rs.next()) {
				System.out.printf("Nombre departamento: %s %n", rs.getString("dnombre"));
			}
			rs.close();
			sentencia.close();
			
			sql="SELECT AVG(salario), COUNT(*) FROM empleados WHERE dept_no = ?";
			
			sentencia=conexion.prepareStatement(sql);
			sentencia.setInt(1, Integer.parseInt(dep));
			
			rs=sentencia.executeQuery();
			while(rs.next()) {
				System.out.printf("Salario medio: %.2f %nNumero total empleados: %d",rs.getFloat("AVG(salario)"),rs.getInt("COUNT(*)"));
			}
			
			conexion.close();
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {
			System.out.printf("HA OCURRIDO UNA EXCEPCION: %n");
			System.out.printf("Mensaje    : %s %n", e.getMessage());
			System.out.printf("SQL estado : %s %n", e.getSQLState());
			System.out.printf("Cod error  : %s %n", e.getErrorCode());
		}
	}

}
