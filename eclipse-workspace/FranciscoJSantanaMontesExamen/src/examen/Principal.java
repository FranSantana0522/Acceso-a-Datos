package examen;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner scanner = new Scanner(System.in)) {
			int opcion;
			AgendaContactos agenda=new AgendaContactos();
			do {
				System.out.println("Menú de Agenda de Contactos");
				System.out.println("1. Agregar contacto");
				System.out.println("2. Listar contactos");
				System.out.println("3. Guardar en archivo binario");
				System.out.println("4. Guardar en archivo y Salir");
				System.out.print("Seleccione una opción: ");
				opcion = scanner.nextInt();

				switch (opcion) {
				case 1:
					System.out.println("Introduzca los datos del nuevo contacto:");
					System.out.print("Nombre: ");
					String nombre = scanner.next();
					System.out.print("Teléfono: ");
					String telefono = scanner.next();
					System.out.print("Correo Electrónico: ");
					String correo = scanner.next();
					agenda.agen.add(new Contacto(nombre,telefono,correo));
					break;

				case 2:
					System.out.println("Listado de contactos:");
					agenda.listarContactos();
					break;

				case 3:
					System.out.println("Contactos guardados en archivo binario.");
					agenda.guardarContactosEnArchivoBin();
					break;

				case 4:
					System.out.println("Contactos guardados en archivo de texto.");
					agenda.guardarContactosEnArchivo();
					System.out.println("Saliendo del programa.");
					break;

				default:
					System.out.println("Opción no válida. Inténtelo de nuevo.");
				}
			} while (opcion != 4);
		}
	}

}
