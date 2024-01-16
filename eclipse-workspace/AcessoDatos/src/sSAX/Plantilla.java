package sSAX;

import java.awt.im.InputContext;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class Plantilla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SAXParserFactory parseFactory=SAXParserFactory.newInstance();
		parseFactory.setNamespaceAware(true);
		SAXParser parser;
		try {
			parser=parseFactory.newSAXParser();
			XMLReader procesadorXML=parser.getXMLReader();
			GestionContenido gestor=new GestionContenido();
			procesadorXML.setContentHandler(gestor);
			InputSource fileXML=new InputSource("Alumnos.xml");
			procesadorXML.parse(fileXML);
		}catch(ParserConfigurationException e) {
			e.printStackTrace();
		}catch(SAXException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
class GestionContenido extends DefaultHandler{
		public GestionContenido() {
			super();
		}
		@Override
		public void startDocument() {
			System.out.println("Comienzo del Documento XML");
		}
		@Override
		public void endDocument() {
			System.out.println("Final del Documento XML");
		}
		@Override
		public void startElement(String uri,String nombre,String nombreC,Attributes atts) {
			System.out.printf("\t Principio Elemento: %s %n", nombre);
		}
		@Override
		public void endElement(String uri,String nombre,String nombreC) {
			System.out.printf("\tFin elemento: %s %n",nombre);
		}
		@Override
		public void characters(char [] ch,int inicio,int longitud)throws SAXException {
			String car=new String(ch,inicio,longitud);
			car=car.replaceAll("[\t\n]", "");
			System.out.printf("\t Caracteres: %s %n", car);
		}
}









