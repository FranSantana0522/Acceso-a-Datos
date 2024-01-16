package prueba;

import java.io.File;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File parent=new File("/home/usuario/eclipse-workspace/AcessoDatos/src");
		String [] archivos=parent.list();
		for(int i=0;i<archivos.length;i++) {
			System.out.println(archivos[i]);
		}
		
		File[] archivos2 = parent.listFiles();
		for(int i=0;i<archivos2.length;i++) {
			System.out.println(archivos2[i]);
		}
		
		String dir=args[0];
		File f=new File(dir);
		String[] archivos3 = f.list();
		System.out.printf("Ficheros en el directorio actual: %d %n", archivos3.length);
		for(int i=0; i<archivos3.length; i++) {
		File f2= new File(f, archivos3[i]);
		if(f2.isDirectory()) {
		System.out.printf("Nombre: %s, es fichero?: %b, es directorio?:"
				+ "%b %n", archivos3[i], f2.isFile(), f2.isDirectory());
		}else {
			System.out.println("No es un directorio");
		}
		}
	}

}
