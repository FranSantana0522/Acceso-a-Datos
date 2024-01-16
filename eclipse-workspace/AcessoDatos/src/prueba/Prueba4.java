package prueba;

import java.io.File;

public class Prueba4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dir=".";
		String sep="=";
		File f=new File(dir);
		directorios(f,sep);
	}
	
	public static void directorios(File f, String separador) {
		String[] archivos = f.list();
		System.out.printf("Ficheros en el directorio actual:"+ archivos.length+"\n");
		for (int i = 0; i < archivos.length; i++) {
			File f2 = new File(f, archivos[i]);
			if(f2.isDirectory()) {
				System.out.println(separador+"Directorio "+ f2.getName());
				separador=separador.concat("*");
				directorios(f2,separador);
			}else {
				System.out.println(separador+"Archivo "+f2.isFile()+ " "+ f2.getName());
			}
		}
	}
}
