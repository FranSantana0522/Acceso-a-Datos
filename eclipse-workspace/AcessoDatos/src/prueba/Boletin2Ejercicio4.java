package prueba;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Boletin2Ejercicio4 {

	public static void main(String[] args) {
		File path1 = new File("/home/usuario/eclipse-workspace/AcessoDatos/src/prueba/Boletin2Ejercicio3.java");
		File path2 = new File("Copia Primos.txt");
		escribe(path1, path2);
	}

	public static void escribe(File origen, File destino) {
		Scanner sc = new Scanner(System.in);
		try {
			FileReader fic = new FileReader(origen);
			PrintWriter wri = new PrintWriter(new FileWriter(destino));
			if (existe(destino)) {
				int i;
				while ((i = fic.read()) != -1) {
					wri.print((char) i);
				}
				fic.close();
				wri.close();
			} else {
				System.out.println("Elija nuevo nombre para el archivo");
				String fil = sc.next();
				destino = new File(fil);
				wri = new PrintWriter(new FileWriter(destino));
				int i;
				while ((i = fic.read()) != -1) {
					wri.print((char) i);
				}
				fic.close();
				wri.close();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public static boolean existe(File comprobar) {
		Scanner sc = new Scanner(System.in);
		boolean reemplazo = false;
		int op;
		if (comprobar.exists()) {
			do {
				System.out.println("¿Quiere reemplazar el archivo?-1/SI-2/NO");
				op = sc.nextInt();
				switch (op) {
				case 1 -> {
					reemplazo = true;
				}
				case 2 -> {
					reemplazo = false;
				}
				default -> {
					System.out.println("Elija de nuevo");
				}
				}
			} while (op < 1 || op > 2);
			return reemplazo;
		} else {
			return reemplazo;
		}
	}
}
