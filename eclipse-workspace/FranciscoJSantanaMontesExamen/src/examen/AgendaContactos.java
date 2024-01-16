package examen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class AgendaContactos implements Serializable{
	ArrayList<Contacto> agen;
	final File nomArchivo = new File("agenda.txt");

	public AgendaContactos() {
		if(!nomArchivo.exists()) {
			agen = new ArrayList<Contacto>();
		}else {
			agen = new ArrayList<Contacto>();
			cargarContactosDesdeArchivo();
		}
	}

	public void cargarContactosDesdeArchivo() {
		try {
			BufferedReader br=new BufferedReader(new FileReader(nomArchivo));
			String linea;
			while((linea=br.readLine())!=null) {
				String nombre=linea;
				linea=br.readLine();
				String tlf=linea;
				linea=br.readLine();
				String correo=linea;
				agen.add(new Contacto(nombre,tlf,correo));
			}
			br.close();
		}catch(EOFException e) {
			System.out.println("Fin fichero");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void guardarContactosEnArchivo() {
		try {
			BufferedWriter bw=new BufferedWriter(new FileWriter(nomArchivo));
			for(int i=0;i<agen.size();i++) {
				bw.write(agen.get(i).getNombre());
				bw.newLine();
				bw.write(agen.get(i).getTlf());
				bw.newLine();
				bw.write(agen.get(i).getCorreo());
				bw.newLine();
			}
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void guardarContactosEnArchivoBin() {
		try{
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("agenda.dat"));
			oos.writeObject(agen);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public void agregarContacto(String nombre, String telefono, String correo) {
	}

	public void listarContactos() {
		for (int i = 0; i < agen.size(); i++) {
			System.out.println("Nombre: " + agen.get(i).getNombre());
			System.out.println("Teléfono: " + agen.get(i).getTlf());
			System.out.println("Correo Electrónico: " + agen.get(i).getCorreo());
			System.out.println();
		}
	}

}
