package tarea5xml;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class Actividad3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		RecetasAct3 lista=new RecetasAct3(null);
		String titulo="";
		String procedimiento="";
		String tiempo="";
		String cantidad="";
		String ingrediente="";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder	=factory.newDocumentBuilder();
			Document document=builder.parse(new File("RecetaDOM.xml"));
			document.getDocumentElement().normalize();
			System.out.printf("Elemento raiz: %s %n",document.getDocumentElement().getNodeName());
			NodeList peliculas=document.getElementsByTagName("Receta");
			System.out.printf("Nodos empleado a recorrer: %d %n",peliculas.getLength());
			for(int i=0;i<peliculas.getLength();i++) {
				Node pelis=peliculas.item(i);
				if(pelis.getNodeType()==Node.ELEMENT_NODE) {
					Element elemento=(Element) pelis;
					titulo=elemento.getElementsByTagName("titulo").item(0).getTextContent();
					System.out.printf("Titulo = %s %n",elemento.getElementsByTagName("titulo").item(0).getTextContent());
					procedimiento=elemento.getElementsByTagName("procedimiento").item(0).getTextContent();
					System.out.printf(" * Procedimiento = %s %n",elemento.getElementsByTagName("procedimiento").item(0).getTextContent());
					tiempo=elemento.getElementsByTagName("tiempo").item(0).getTextContent();
					System.out.printf(" * Tiempo = %s %n",elemento.getElementsByTagName("tiempo").item(0).getTextContent());
					NodeList actores=elemento.getElementsByTagName("ingrediente");
					for(int j=0;j<actores.getLength();j++) {
						Node actor=actores.item(j);
						if(actor.getNodeType()==Node.ELEMENT_NODE) {
							Element elemento2=(Element) actor;
							cantidad=elemento2.getAttribute("cantidad");
							ingrediente=elemento2.getTextContent();
							System.out.printf(" * ingrediente = %s | %s %n",elemento2.getTextContent(),elemento2.getAttribute("cantidad"));
						}
					}
				}
			}
			IngredientesAct3 listaI=new IngredientesAct3(cantidad, ingrediente);
			//RecetaAct3 listaR=new RecetaAct3(titulo,listaI, procedimiento, tiempo);
			//lista=new RecetasAct3(listaR);
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			
			File inputFile = new File("RecetaDOM.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			RecetaAct3 lista2=new RecetaAct3(null, null, null, null);
			ArrayList<IngredientesAct3> listaIngre=new ArrayList<IngredientesAct3>();
			System.out.println("Titulo receta:");
			String titulo2=sc.next();
			System.out.println("Numero Ingredientes:");
			Integer num=sc.nextInt();
			for(int i=0;i<num;i++) {
				System.out.println("Cantidad:");
				String cantidad2=sc.next();
				System.out.println("Ingredientes:");
				String ingrediente2=sc.next();
				listaIngre.add(new IngredientesAct3(cantidad2, ingrediente2));
			}
			System.out.println("Procedimiento");
			String procedimiento2=sc.next();
			System.out.println("Tiempo");
			String tiempo2=sc.next();
			lista2.setTitulo(titulo2);
			lista2.setIngredientes(listaIngre);
			lista2.setProcedimiento(procedimiento2);
			lista2.setTiempo(tiempo2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void crearElemento(String node, String valor, Element raiz, Document document) {
		Element elem = document.createElement(node);
		Text text = document.createTextNode(valor); 
		raiz.appendChild(elem); 
		elem.appendChild(text); 
	}

}
