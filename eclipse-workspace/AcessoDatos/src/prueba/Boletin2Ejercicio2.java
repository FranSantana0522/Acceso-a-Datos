package prueba;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Boletin2Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			escribe();
			leer();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void escribe() throws IOException {
		PrintWriter wri=new PrintWriter(new FileWriter("numNaturales.txt"));
		for(int i=1;i<101;i++) {
			wri.println(i);
		}
		wri.close();
		
	}
	public static void leer() throws IOException {
		File f = new File("numNaturales.txt");
		FileReader fic = new FileReader(f);
		int i;
		while ((i = fic.read()) != -1) {
			System.out.print((char) i);
		}
		fic.close();
	}

}
