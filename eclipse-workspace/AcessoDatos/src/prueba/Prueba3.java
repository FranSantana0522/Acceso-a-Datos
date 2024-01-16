package prueba;

import java.io.File;
import java.io.IOException;

public class Prueba3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String dir="NUEVODIR";
		File f = new File("/home/usuario/eclipse-workspace/AcessoDatos/src/"+dir);
		if(f.mkdir()) {
			File f2=new File(f,"Archivo original");
			System.out.println("Se ha creado el directorio "+dir);
			f=new File(f,"archivo1");
			f.createNewFile();
			System.out.println("Se ha creado el archivo "+ f);
			f.renameTo(f2);
			System.out.println("Se ha renombrado ha " +f2);
			f=new File("/home/usuario/eclipse-workspace/AcessoDatos/src/"+dir+"/archivo2");
			f.createNewFile();
			System.out.println("Se ha creado el archivo "+ f);
			f.delete();
			System.out.println("Se ha borrado el archivo "+ f);
		}else {
			System.out.println("No se ha creado el directorio "+dir);
		}
		
	}

}
