package binarios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Boletin3Ejer4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombreArchivo = "matriz.txt";
		try {
			BufferedReader br=new BufferedReader(new FileReader(nombreArchivo));
			String linea;
			while((linea=br.readLine())!=null) {
				System.out.println(linea);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
