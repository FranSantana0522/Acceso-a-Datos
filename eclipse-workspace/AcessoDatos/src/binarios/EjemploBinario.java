package binarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EjemploBinario {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f=new File("FichBin.dat");
		DataOutputStream dataOS=new DataOutputStream(new FileOutputStream(f));
		DataInputStream dataIS=new DataInputStream(new FileInputStream(f));
		String n;
		int e;
		String nombres[]= {"Ana","Miguel","Alicia","Pedro","Manuel","Andres","Julio","Antonio","Maria"};
		
		int edades[]= {14,15,13,15,16,12,16,14,13};
		for(int i=0;i<edades.length;i++) {
			dataOS.writeUTF(nombres[i]);
			dataOS.writeInt(edades[i]);
		}
		dataOS.close();
		try {
			while(true) {
				n=dataIS.readUTF();
				e=dataIS.readInt();
				System.out.println("Nombre: "+n+ ", edad: "+e);
			}
		}catch(EOFException ex) {
			System.out.println("Fin de fichero");
		}
		dataIS.close();
	}

}
