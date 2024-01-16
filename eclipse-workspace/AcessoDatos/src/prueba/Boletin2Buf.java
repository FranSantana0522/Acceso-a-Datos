package prueba;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Boletin2Buf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// /home/usuario/eclipse-workspace/AcessoDatos/src/prueba/LeerFichero.java
		try {
			BufferedReader f=new BufferedReader
					(new FileReader(args[0]));
			String linea;
			while((linea=f.readLine()) !=null) {
				System.out.println(linea);
			}
			f.close();
		}catch(FileNotFoundException e) {
			 System.out.println(e.getMessage());
		}catch(IOException e) {
			 System.out.println(e.getMessage());
		}
	}

}
