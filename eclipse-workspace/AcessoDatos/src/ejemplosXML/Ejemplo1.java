package ejemplosXML;

import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.StreamResult;

public class Ejemplo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		
		Integer id,dep;
		Double salario;
		String apellido;
		
		DocumentBuilder builder;
		try {
			builder=factory.newDocumentBuilder();
			DOMImplementation implementation=builder.getDOMImplementation();
			Document document=implementation.createDocument(null, "Empleados", null);
			document.setXmlVersion("1.0");
			System.out.println("¿Cuantos empleados vas a introducir?");
			int numEmple=sc.nextInt();
			for(int i=0;i<numEmple;i++) {
				System.out.println("Id del empleado:");
				id=sc.nextInt();
				System.out.println("Apellido del empleado");
				apellido=sc.next();
				System.out.println("Numero departamento");
				dep=sc.nextInt();
				System.out.println("Salario del empleado");
				salario=sc.nextDouble();
				if(id>0) {
					Element raiz =document.createElement("Empleado");
					document.getDocumentElement().appendChild((Node) raiz);
					
					crearElemento("id",Integer.toString(id),raiz,document);
					crearElemento("apellido",apellido.trim(),raiz,document);
					crearElemento("dep",Integer.toString(dep),raiz,document);
					crearElemento("salario",Double.toString(salario),raiz,document);
				}
			}
			Source source=new DOMSource(document);
			Result result=new StreamResult(new java.io.File("Empleados.xml"));
			Transformer transformer=TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
		}catch(ParserConfigurationException e) {
			e.printStackTrace();
		}catch(TransformerConfigurationException e) {
			e.printStackTrace();
		}catch(TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		}catch(TransformerException e) {
			e.printStackTrace();
		}
	}
	static void crearElemento(String datoEmple, String valor, Element raiz,Document document) {
		Element elem=document.createElement(datoEmple);
		Text text=document.createTextNode(valor);
		raiz.appendChild(elem);
		elem.appendChild(text);
		
	}

}
