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

public class Actividad2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		try {
            File inputFile = new File("Productos.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList productos = doc.getElementsByTagName("Producto");
            for (int i = 0; i < productos.getLength(); i++) {
                Node producto = productos.item(i);
                if (producto.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoProducto = (Element) producto;
                    int stock = Integer.parseInt(elementoProducto.getElementsByTagName("Stock").item(0).getTextContent().trim());
                    String aLaVenta = elementoProducto.getAttribute("aLaVenta");

                    if (stock < 5 && "true".equals(aLaVenta)) {
                        elementoProducto.setAttribute("aLaVenta", "false");
                    }
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("NuevoDoc.xml"));
            transformer.transform(source, result);    
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
