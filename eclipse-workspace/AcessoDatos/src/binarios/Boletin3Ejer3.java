package binarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Boletin3Ejer3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File f = new File("datos.dat");
			DataInputStream dataIN = new DataInputStream(new FileInputStream(f));
			int x;
			while (true) {
				x=dataIN.readInt();
				System.out.println(x);
			}
		} catch (EOFException e) {
			System.out.println("Fin fichero");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
