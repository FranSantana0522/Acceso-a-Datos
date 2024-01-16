package binarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Boletin3Ejer1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		File f=new File("datos.dat");
		DataOutputStream dataOS=new DataOutputStream(new FileOutputStream(f));	
		System.out.println("Numero de enteros a introducir");
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			System.out.println("Introduce entero");
			int ne=sc.nextInt();
			dataOS.writeInt(ne);
		}
	}

}
