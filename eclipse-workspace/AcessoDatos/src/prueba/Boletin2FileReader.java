package prueba;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Boletin2FileReader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// /home/usuario/eclipse-workspace/AcessoDatos/src/prueba/LeerFichero.java
		File f = new File(args[0]);
		FileReader fic = new FileReader(f);
		int i;
		while ((i = fic.read()) != -1) {
			System.out.print((char) i);
		}
		fic.close();
	}
}
