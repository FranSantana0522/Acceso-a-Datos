	package prueba;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterA {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter w=new PrintWriter(new FileWriter("Prueba.txt"));
		for(int i=0;i<11;i++) {
			w.println("Fila numero: "+i);
		}
		w.close();
	}

}
