package Conexion_BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RepasoSQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Statement sentencia;
		PreparedStatement sentenciaP;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Empresa?useSSL=false",
					"root", "root");
			
			
			// Calcular el número total de horas que ha trabajado el empleado 7698.
			String sql = "select sum(horas) from trabaja where emp_no=7698";

			sentencia=conexion.createStatement();
			ResultSet consulta=sentencia.executeQuery(sql);
			while(consulta.next()) {
				System.out.printf("Numero total de horas de 7698 => %d %n", consulta.getInt(1));
			}
			consulta.close();
			sentencia.close();
			
			
			// Subir los salarios de los empleados en un 10%.
			sql="update empleados set salario=salario*0.1+salario;";
			
			sentenciaP=conexion.prepareStatement(sql);
			int filas;
			try {
				filas = sentenciaP.executeUpdate();
				System.out.println("Filas afectadas: " + filas);
			} catch (SQLException e) {
				System.out.printf("HA OCURRIDO UNA EXCEPCION: %n");
				System.out.printf("Mensaje    : %s %n", e.getMessage());
				System.out.printf("SQL estado : %s %n", e.getSQLState());
				System.out.printf("Cod error  : %s %n", e.getErrorCode());
			}
			sentenciaP.close();
			
			
			// Mostrar, ordenados por apellido, los empleados que han trabajado en el proyecto 2.
			// Hazlo sin join, y luego con join.
			
			//SELECT *
			//FROM empleados 
			//WHERE emp_no IN (SELECT emp_no FROM trabaja WHERE proyecto_no = 2) 
			//order by apellido desc;
			
			
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
