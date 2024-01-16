package binarios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Boletin3Ejer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese el número de filas: ");
		int filas = sc.nextInt();
		System.out.print("Ingrese el número de columnas: ");
		int columnas = sc.nextInt();
		Double array[][] = new Double[filas][columnas];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = (Double) (Math.random() * 10.00);
			}
		}

		String nombreArchivo = "matriz.txt";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
			writer.write("  ");
            for (int j = 0; j < columnas; j++) {
                writer.write(j + "  ");
            }
            writer.newLine();
			for (int i = 0; i < array.length; i++) {
				writer.write(i+ " ");
				for (int j = 0; j < array[i].length; j++) {
					writer.write(array[i][j] + " ");
				}
				writer.newLine();
			}
			System.out.println("La matriz se ha escrito en el archivo " + nombreArchivo);
		} catch (IOException e) {
			System.err.println("Error al escribir en el archivo: " + e.getMessage());
		}
	}

}
