package tarea5Bxml;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.StreamResult;

public class Tarea5B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//Creamos documento
			 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder = factory.newDocumentBuilder();
	            Document document = builder.newDocument();
	            
	            //Creamos estructura del documento
	            Element alumnos = document.createElement("Alumnos");
	            document.appendChild(alumnos);
	            //Datos metidos a mano
	            Scanner scanner = new Scanner(System.in);
	            System.out.print("Ingrese la cantidad de alumnos: ");
	            int numAlumnos = scanner.nextInt();
	            
	            for (int i = 1; i <= numAlumnos; i++) {
	            	Element alumnoElement = document.createElement("alumno");
	                alumnos.appendChild(alumnoElement);
	                
	                System.out.print("Nombre del alumno " + i + ": ");
	                String nombreAlumno = scanner.next();
	                alumnoElement.setAttribute("nombre", nombreAlumno);
	                
	                System.out.print("Cantidad de materias: ");
	                int numMaterias = scanner.nextInt();
	                Element materiasElement = document.createElement("Materias");
	                alumnoElement.appendChild(materiasElement);

	                for (int j = 1; j <= numMaterias; j++) {
	                    Element materiaElement = document.createElement("materia");
	                    materiasElement.appendChild(materiaElement);

	                    System.out.print("Nombre de la materia " + j + ": ");
	                    String nombreMateria = scanner.next();
	                    materiaElement.setAttribute("nombre", nombreMateria);

	                    System.out.print("Nota de la materia " + j + ": ");
	                    double notaMateria = scanner.nextDouble();
	                    Element notaElement = document.createElement("nota");
	                    notaElement.appendChild(document.createTextNode(String.valueOf(notaMateria)));
	                    materiaElement.appendChild(notaElement);     
	                }
	            }
	            //Datos por codigo
	            Element alumnoElement = document.createElement("alumno");
                alumnos.appendChild(alumnoElement);
                alumnoElement.setAttribute("nombre", "Paco");
                Element materiasElement = document.createElement("Materias");
                alumnoElement.appendChild(materiasElement);
                Element materiaElement = document.createElement("materia");
                materiasElement.appendChild(materiaElement);
                materiaElement.setAttribute("nombre", "SGE");
                Element notaElement = document.createElement("nota");
                notaElement.appendChild(document.createTextNode(String.valueOf(0)));
                materiaElement.appendChild(notaElement);     
                
	            //Datos por fichero de texto
                String nombre="";
                String nombreM="";
                Integer nota=0;
                try {
                	BufferedReader f=new BufferedReader(new FileReader("alumno.txt"));
        			String linea;
        			while((linea=f.readLine()) !=null) {
        				nombre=linea;
        				linea=f.readLine();
        				nombreM=linea;
        				linea=f.readLine();
        				nota=Integer.parseInt(linea);
        			}
        			f.close();
                }catch(IOException e) {
                	e.printStackTrace();
                }
                Element alumnoElement2 = document.createElement("alumno");
                alumnos.appendChild(alumnoElement2);
                alumnoElement2.setAttribute("nombre", nombre);
                Element materiasElement2 = document.createElement("Materias");
                alumnoElement2.appendChild(materiasElement2);
                Element materiaElement2 = document.createElement("materia");
                materiasElement2.appendChild(materiaElement2);
                materiaElement2.setAttribute("nombre", nombreM);
                Element notaElement2 = document.createElement("nota");
                notaElement2.appendChild(document.createTextNode(String.valueOf(nota)));
                materiaElement2.appendChild(notaElement2);   
                
                //Listar los elementos 
	            System.out.println("Lista de elementos:");
	            Element rootElement = document.getDocumentElement();
	            NodeList alumnoss = rootElement.getElementsByTagName("alumno");

	            for (int i = 0; i < alumnoss.getLength(); i++) {
	                Element alumnoElemento = (Element) alumnoss.item(i);
	                String nombreAlumno = alumnoElemento.getAttribute("nombre");
	                System.out.println("Alumno: " + nombreAlumno);

	                Element materiasElemento = (Element) alumnoElemento.getElementsByTagName("Materias").item(0);
	                NodeList materias = materiasElemento.getElementsByTagName("materia");

	                for (int j = 0; j < materias.getLength(); j++) {
	                    Element materiaElemento = (Element) materias.item(j);
	                    String nombreMateria = materiaElemento.getAttribute("nombre");
	                    String notaMateria = materiaElemento.getElementsByTagName("nota").item(0).getTextContent();
	                    System.out.println("  Materia: " + nombreMateria + ", Nota: " + notaMateria);
	                }
	            }
	            //Guarda el archivo 
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

	            DOMSource source = new DOMSource(document);
	            StreamResult result = new StreamResult(new File("Alumnos.xml"));
	            transformer.transform(source, result);

		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
