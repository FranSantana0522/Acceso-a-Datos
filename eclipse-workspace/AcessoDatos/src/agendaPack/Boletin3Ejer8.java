package agendaPack;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Boletin3Ejer8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File nomArchivo=new File("agenda.dat");
		Scanner sc = new Scanner(System.in);
		int op;
		ArrayList<Contacto> lista = new ArrayList<Contacto>();
		Agenda agenda = new Agenda(lista);
		do {
			System.out.println("Selecciona una opcion:\n1-Escribir pedido\n2-Leer Pedidos\n3-Salir");
			op = sc.nextInt();
			switch (op) {
			case 1 -> {
				agregarContacto(lista, nomArchivo);
				agenda.agen.add(lista);
				try {
					if(!nomArchivo.exists()) {
						ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream(nomArchivo));
						ob.writeObject(agenda);
					}else {
						ObjectOutputStream ob = new MiObjectOutputStream(new FileOutputStream(nomArchivo,true));
						ob.writeObject(agenda);
					}
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			case 2 -> {
				leerContactos(nomArchivo);
			}
			case 3 -> {
				System.out.println("Has salido");
			}
			default -> {
				System.out.println("Elige una opcion correcta");
			}
			}
		} while (op != 3);
	}

	public static void agregarContacto(ArrayList<Contacto> lista, File nomFichero) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nombre:");
		String nom = sc.next();
		System.out.println("Apellidos");
		String apellido = sc.nextLine();
		System.out.println("Telefono:");
		Integer tel = sc.nextInt();
		lista.add(new Contacto(nom, apellido, tel));
	}

	public static void leerContactos(File nomFichero) {
		try {
			ObjectInputStream oi=new ObjectInputStream(new FileInputStream(nomFichero));
		}catch(EOFException e) {
			System.out.println("Fin fichero");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
