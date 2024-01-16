package Conexion_BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Tarea3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Empresa?useSSL=false",
					"root", "root");
			Statement sentencia = conexion.createStatement();
			ResultSet rs;
			String fecha = String.valueOf(LocalDate.now());
			String sql = String.format("INSERT INTO empleados VALUES(%s, '%s', '%s', %s, '%s', %s, %s, %s)", args[0],
					args[1], args[2], args[3], fecha, args[4], args[5], args[6]);
			System.out.println(sql);
			boolean realizarConsulta = true;
			String emp_no = String.format("SELECT emp_no FROM empleados WHERE emp_no=%s", args[0]);
			boolean emp_noB = sentencia.execute(emp_no.toString());
			if (!emp_noB) {
				realizarConsulta = false;
				System.out.println("ERROR: Hay un empleado con el mismo numero");
			}
			sentencia.close();
			sentencia = conexion.createStatement();
			String dept_no = String.format("SELECT dept_no FROM departamentos WHERE dept_no=%s", args[5]);
			boolean dept_noB = sentencia.execute(dept_no.toString());
			if (!dept_noB) {
				realizarConsulta = false;
				System.out.println("ERROR: No existe ese departamento");
			}
			sentencia.close();
			if (Float.valueOf(args[4]) <= 0) {
				realizarConsulta = false;
				System.out.println("ERROR: El salario es menor igual a 0");
			}
			sentencia = conexion.createStatement();
			String dir = String.format("SELECT dir FROM empleados WHERE dir=%s", args[3]);
			boolean dirB = sentencia.execute(dir.toString());
			if (!dirB) {
				realizarConsulta = false;
				System.out.println("ERROR: El director no existe");
			}
			sentencia.close();
			sentencia = conexion.createStatement();
			if (realizarConsulta) {
				try {
					boolean consulta = sentencia.execute(sql.toString());
					if (consulta) {
						rs = sentencia.getResultSet();
						while (rs.next()) {
							System.out.printf("%d, %s, %s, %d, %s,%.2f, %.2f, %d", rs.getInt(1), rs.getString(2),
									rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getFloat(6), rs.getFloat(7),
									rs.getInt(8));
						}
						rs.close();
					}
				} catch (SQLException e) {
					System.out.printf("HA OCURRIDO UNA EXCEPCION: %n");
					System.out.printf("Mensaje    : %s %n", e.getMessage());
					System.out.printf("SQL estado : %s %n", e.getSQLState());
					System.out.printf("Cod error  : %s %n", e.getErrorCode());
				}
			} else {
				System.out.println("No se realizo la consulta");
			}

			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {

		}
	}

}
