package examenU2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Francisco Javier Santana Montes
 */
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Consulta consulta=new Consulta();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/examenU2?useSSL=false"
					,"examenU2", "examenU2@");
			int opcion;
			do {
				System.out.println("\nEliga una opcion\n"
						+ "1-Mostrar una lista de objetos Cliente\n"
						+ "2-Mostrar el número de clientes registrados en comercios de la ciudad que indique "
						+ "el usuario\n"
						+ "3-Mostrar los datos de aquellos comercios que hayan distribuído más de un programa\n"
						+ "4-Actualizar los datos de Registro de los comercios cuyo nombre acabe por la letra que\n"
						+ "indique el usuario\n"
						+ "5-Inserta dos programas y un fabricante nuevo\n"
						+ "6-Salir\n");
				opcion = sc.nextInt();

				switch (opcion) {
				case 1:
					ArrayList<Cliente> listaClientes=new ArrayList<Cliente>();
					listaClientes.addAll(consulta.listaClientes(conexion));
					for(int i=0;i<listaClientes.size();i++) {
						System.out.println(listaClientes.get(i).toString());
					}
					break;

				case 2:
					System.out.println("Introduce el cif del comercio");
					int num=sc.nextInt();
					int result=consulta.listaClientesComercio(conexion, num);
					System.out.println(result);
					break;

				case 3:
					ArrayList<Comercio> listaComercio=new ArrayList<Comercio>();
					listaComercio.addAll(consulta.listaComercioPrograma(conexion));
					for(int i=0;i<listaComercio.size();i++) {
						System.out.println(listaComercio.get(i).toString());
					}
		
					break;

				case 4:
					System.out.println("Introduce la ultima letra del comercio a actualizar");
					String letra=sc.next();
					letra=String.valueOf(letra.charAt(0));
					consulta.ActualizarRegistros(conexion, letra);
					break;
				case 5:
					consulta.Crear(conexion);
					break;
					
				case 6:
					System.out.println("Has salido del programa");
					conexion.close();	
					break;

				default:
					System.out.println("Opción no válida. Inténtelo de nuevo.");
				}
			} while (opcion != 6);
		
			
		}catch(ClassNotFoundException e) {
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
