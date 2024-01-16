package prueba;

import java.io.File;
import java.io.IOException;

public class Prueba2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String dir = args[0];
		File f = new File(dir);
		String[] archivos3 = f.list();
		System.out.printf("Ficheros en el directorio actual: %d %n", archivos3.length);
		for (int i = 0; i < archivos3.length; i++) {
			File f2 = new File(f, archivos3[i]);
			if(f2.isAbsolute()) {
				System.out.printf(f2.getAbsolutePath());
			}else {
				System.out.printf(f2.getCanonicalPath());
			}
			if(f2.canWrite()) {
				System.out.println("\nSe puede escribir");
			}else {
				System.out.println("\nNo se puede escribir");
			}
			if(f2.canRead()) {
				System.out.println("Se puede leer");
			}else {
				System.out.println("No se puede leer");
			}
			if(f2.isDirectory()) {
				System.out.println("Es un directorio");
			}else {
				System.out.println("No es un directorio");
			}
			if(f2.isFile()) {
				System.out.println("Es un archivo");
			}else {
				System.out.println("No es un archivo");
			}
			
			System.out.println(f2.getParent());
			
		

		}

	}
}
