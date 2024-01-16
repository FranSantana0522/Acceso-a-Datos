package examenU2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
			/**
			 * @author Francisco Javier Santana Montes
			 */
public class Consulta {
	
	private Statement statement;
	
	private PreparedStatement preparedStatement;
	
	public ArrayList<Cliente> listaClientes(Connection conexion) throws SQLException {
		ArrayList<Cliente> listaCliente=new ArrayList<>();
		String sqlString="SELECT * FROM CLIENTE";
		statement=conexion.createStatement();
		ResultSet consulta=statement.executeQuery(sqlString);
		while(consulta.next()) {
			Cliente cliente=new Cliente();
			cliente.setDni(consulta.getString(1));
			cliente.setNombre(consulta.getString(2));
			cliente.setEdad(consulta.getInt(3));
			cliente.setSexo(consulta.getString(4));
			
			listaCliente.add(cliente);
		}
		consulta.close();
		statement.close();

		return listaCliente;
	}
	
	public int listaClientesComercio(Connection conexion, int cif) throws SQLException {
		int num=0;
		String sqlString=String.format("select count(*) from CLIENTE where dni in (select dni from REGISTRA r,COMERCIO c WHERE r.cif=%d)",cif);
		statement=conexion.createStatement();
		ResultSet consulta=statement.executeQuery(sqlString);
		while(consulta.next()) {
			num=consulta.getInt(1);
		}
		consulta.close();
		statement.close();
		return num;
	}
	public ArrayList<Comercio> listaComercioPrograma(Connection conexion) throws SQLException {
		ArrayList<Comercio> listaComercio=new ArrayList<Comercio>();
		String sqlString="SELECT * FROM COMERCIO WHERE cif IN (SELECT cif FROM DISTRIBUYE GROUP BY cif HAVING COUNT(*) > 1)";
		preparedStatement=conexion.prepareStatement(sqlString);	
		ResultSet rs=preparedStatement.executeQuery();
		while(rs.next()) {
			Comercio comercio=new Comercio();
			comercio.setCif(rs.getInt(1));
			comercio.setNombre(rs.getString(2));
			comercio.setCiudad(rs.getString(3));
			comercio.setTrabajadores(rs.getInt(4));
			listaComercio.add(comercio);
		}
		rs.close();
		preparedStatement.close();
		return listaComercio;
	}
	public void ActualizarRegistros(Connection conexion, String letra) throws SQLException {	
		String sqlString="UPDATE REGISTRA SET fecha = NOW() WHERE cif IN (SELECT cif FROM COMERCIO c WHERE c.nombre LIKE ?)";
		preparedStatement=conexion.prepareStatement(sqlString);	
		preparedStatement.setString(1,"%"+letra);
		int filas;
		try {
			filas = preparedStatement.executeUpdate();
			System.out.println("Filas afectadas: " + filas);
		} catch (SQLException e) {
			System.out.printf("HA OCURRIDO UNA EXCEPCION: %n");
			System.out.printf("Mensaje    : %s %n", e.getMessage());
			System.out.printf("SQL estado : %s %n", e.getSQLState());
			System.out.printf("Cod error  : %s %n", e.getErrorCode());
		}
		preparedStatement.close();
	}
	public void Crear(Connection conexion) throws SQLException {	
		boolean hacer=true;
		conexion.setAutoCommit(false);
		try {
			String sqlString="INSERT INTO PROGRAMA VALUES(23,'Programa Examen','Intento 1',1000.00)";
			preparedStatement=conexion.prepareStatement(sqlString);	
			int filas;
			try {
				filas = preparedStatement.executeUpdate();
				System.out.println("Filas afectadas: " + filas);
			} catch (SQLException e) {
				hacer=false;
				System.out.printf("HA OCURRIDO UNA EXCEPCION: %n");
				System.out.printf("Mensaje    : %s %n", e.getMessage());
				System.out.printf("SQL estado : %s %n", e.getSQLState());
				System.out.printf("Cod error  : %s %n", e.getErrorCode());
			}
			preparedStatement.close();
			
			sqlString="INSERT INTO PROGRAMA VALUES(24,'Programa Examen','Intento 2',2000.00)";
			preparedStatement=conexion.prepareStatement(sqlString);	
			try {
				filas = preparedStatement.executeUpdate();
				System.out.println("Filas afectadas: " + filas);
			} catch (SQLException e) {
				hacer=false;
				System.out.printf("HA OCURRIDO UNA EXCEPCION: %n");
				System.out.printf("Mensaje    : %s %n", e.getMessage());
				System.out.printf("SQL estado : %s %n", e.getSQLState());
				System.out.printf("Cod error  : %s %n", e.getErrorCode());
			}
			preparedStatement.close();
			
			sqlString="INSERT INTO FABRICANTE VALUES(8,'Francisco S.L','España')";
			preparedStatement=conexion.prepareStatement(sqlString);	
			try {
				filas = preparedStatement.executeUpdate();
				System.out.println("Filas afectadas: " + filas);
			} catch (SQLException e) {
				hacer=false;
				System.out.printf("HA OCURRIDO UNA EXCEPCION: %n");
				System.out.printf("Mensaje    : %s %n", e.getMessage());
				System.out.printf("SQL estado : %s %n", e.getSQLState());
				System.out.printf("Cod error  : %s %n", e.getErrorCode());
			}
			preparedStatement.close();
			
			sqlString="INSERT INTO DESARROLLA VALUES(8,23)";
			preparedStatement=conexion.prepareStatement(sqlString);	
			try {
				filas = preparedStatement.executeUpdate();
				System.out.println("Filas afectadas: " + filas);
			} catch (SQLException e) {
				hacer=false;
				System.out.printf("HA OCURRIDO UNA EXCEPCION: %n");
				System.out.printf("Mensaje    : %s %n", e.getMessage());
				System.out.printf("SQL estado : %s %n", e.getSQLState());
				System.out.printf("Cod error  : %s %n", e.getErrorCode());
			}
			preparedStatement.close();
			
			sqlString="INSERT INTO DESARROLLA VALUES(8,24)";
			preparedStatement=conexion.prepareStatement(sqlString);	
			try {
				filas = preparedStatement.executeUpdate();
				System.out.println("Filas afectadas: " + filas);
			} catch (SQLException e) {
				hacer=false;
				System.out.printf("HA OCURRIDO UNA EXCEPCION: %n");
				System.out.printf("Mensaje    : %s %n", e.getMessage());
				System.out.printf("SQL estado : %s %n", e.getSQLState());
				System.out.printf("Cod error  : %s %n", e.getErrorCode());
			}
			preparedStatement.close();
			if(hacer) {
				conexion.commit();
			}
		}catch(SQLException e) {
			conexion.rollback();
		}	
		
	}
}
