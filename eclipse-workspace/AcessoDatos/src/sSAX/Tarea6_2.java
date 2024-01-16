package sSAX;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class Tarea6_2 {

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
			InputSource fileXML=new InputSource("rss.xml");
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
