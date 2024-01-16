package tarea5xml;

import java.util.Scanner;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.StreamResult;

public class Actividad1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder	=factory.newDocumentBuilder();
			Document document=builder.parse(new File("peliculas.xml"));
			document.getDocumentElement().normalize();
			System.out.printf("Elemento raiz: %s %n",document.getDocumentElement().getNodeName());
			NodeList peliculas=document.getElementsByTagName("Pelicula");
			System.out.printf("Nodos empleado a recorrer: %d %n",peliculas.getLength());
			for(int i=0;i<peliculas.getLength();i++) {
				Node pelis=peliculas.item(i);
				if(pelis.getNodeType()==Node.ELEMENT_NODE) {
					Element elemento=(Element) pelis;
					System.out.printf("Pelicula = %s %n",elemento.getElementsByTagName("Titulo").item(0).getTextContent());
					System.out.printf(" * Fecha = %s %n",elemento.getElementsByTagName("Fecha").item(0).getTextContent());
					System.out.printf(" * Director = %s %n",elemento.getElementsByTagName("Director").item(0).getTextContent());
					NodeList actores=elemento.getElementsByTagName("Actores");
					for(int j=0;j<actores.getLength();j++) {
						Node actor=actores.item(j);
						if(actor.getNodeType()==Node.ELEMENT_NODE) {
							Element elemento2=(Element) actor;
							System.out.printf(" * Actor = %s %n",elemento2.getTextContent());
						}
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
