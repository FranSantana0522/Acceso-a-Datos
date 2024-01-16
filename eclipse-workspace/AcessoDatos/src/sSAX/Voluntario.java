package sSAX;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class Voluntario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SAXParserFactory parseFactory=SAXParserFactory.newInstance();
		parseFactory.setNamespaceAware(true);
		SAXParser parser;
		try {
			parser=parseFactory.newSAXParser();
			XMLReader procesadorXML=parser.getXMLReader();
			GestionEj1 gestor=new GestionEj1();
			procesadorXML.setContentHandler(gestor);
			InputSource fileXML=new InputSource("ej1.xml");
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
class GestionEj1 extends DefaultHandler{
	boolean si=false;
	boolean si2=false;
	public GestionEj1() {

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
		if(nombreC.equals("Address")) {
			si=true;
		}else if(nombreC.equals("Town")){
			si2=true;
		}
	}
	@Override
	public void endElement(String uri,String nombre,String nombreC) {
	}
	@Override
	public void characters(char [] ch,int inicio,int longitud)throws SAXException {
		if(si) {
			String car=new String(ch,inicio,longitud);
			car=car.replaceAll("[\t\n]", "");
			System.out.printf("\t Address: %s %n", car);
			si=false;
		}
		if(si2) {
			String car=new String(ch,inicio,longitud);
			car=car.replaceAll("[\t\n]", "");
			System.out.printf("\t Town: %s %n", car);
			si2=false;
		}
	}
}
