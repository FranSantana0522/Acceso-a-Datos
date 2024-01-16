package binariosClase;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Boletin3Ejer6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Pedido listaP[] = new Pedido[0];
		int op;
		String nomFichero = "pedidos.dat";
		do {
			System.out.println("Selecciona una opcion:\n1-Escribir pedido\n2-Leer Pedidos\n3-Salir");
			op = sc.nextInt();
			switch (op) {
			case 1 -> {
				listaP = Arrays.copyOf(listaP, listaP.length + 1);
				escribirPedidos(listaP, nomFichero);
			}
			case 2 -> {
				leerPedidos(nomFichero);
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

	public static void escribirPedidos(Pedido[] pedidos, String nomFichero) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Descripcion del pedido");
		String desc = sc.nextLine();
		System.out.println("Numero de Unidades:");
		Integer numP = sc.nextInt();
		System.out.println("Precio por Unidad");
		Double precio = sc.nextDouble();
		pedidos[pedidos.length - 1] = new Pedido(desc, numP, precio);
		try {
			ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream(nomFichero));
			ob.writeObject(pedidos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void leerPedidos(String nomFichero) {
		try {
			ObjectInputStream oi = new ObjectInputStream(new FileInputStream(nomFichero));
			System.out.println(Arrays.deepToString((Pedido[]) oi.readObject()));
		} catch (EOFException e) {
			System.out.println("Fin de fichero");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
