package binarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Boletin3Ejer5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File a1= new File("foto.jpeg");
		File a2= new File("CopiaImagen.jpeg");
		Byte b[]=new Byte[0];
		try {
			DataInputStream in = new DataInputStream(new FileInputStream(a1));
			Byte a;
			while(true) {
				a=in.readByte();
				b=Arrays.copyOf(b, b.length+1);
				b[b.length-1]=a;
			}
		}catch(EOFException e) {
			System.out.println("Fin lectura");
		}catch (IOException e) {
			e.printStackTrace();
		}
		try {
			DataOutputStream out=new DataOutputStream(new FileOutputStream(a2));
			for(Byte i: b) {
				out.writeByte(i);
			}
			out.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
