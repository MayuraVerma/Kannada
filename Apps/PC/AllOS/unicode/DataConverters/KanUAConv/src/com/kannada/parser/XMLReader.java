/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kannada.parser;

import com.kannada.kanuaconv.maps.CharMapComparator;
import com.kannada.kanuaconv.maps.CharacterMap;
import java.io.IOException;
import java.util.Arrays;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author dell amd
 */
public class XMLReader {
    
    Document dom = null;
    public XMLReader(){
        
    }
    
    public CharacterMap.CHARMAP[] parserXML(String xmlFile){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        
               try {
			//Using factory get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();
			//parse using builder to get DOM representation of the XML file
			dom = db.parse(xmlFile);
                    }catch(ParserConfigurationException pce) {
                            pce.printStackTrace();
                    }catch(SAXException se) {
                            se.printStackTrace();
                    }catch(IOException ioe) {
                            ioe.printStackTrace();
                    }
//            }
//    
//    private void parseDocument(){
		//get the root element
		Element docEle = dom.getDocumentElement();

		NodeList nl = docEle.getElementsByTagName("charmap");
                
                CharacterMap.CHARMAP[] charMap=new CharacterMap.CHARMAP[nl.getLength()];
                
		if(nl != null && nl.getLength() > 0) {
			for(int i = 0 ; i < nl.getLength();i++) {
				//get the employee element
				Element el = (Element)nl.item(i);
				//get the Employee object
				CharacterMap.CHARMAP cMap = getCharMap(el);
				//add it to list
				charMap[i] = cMap;
			}
		}
                
                Arrays.sort(charMap,new CharMapComparator());
                
                return charMap;
	}
    
    private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}

		return textVal;
	}
    
    private int getIntValue(Element ele, String tagName) {
		return Integer.parseInt(getTextValue(ele,tagName));
	}
        
    private CharacterMap.CHARMAP getCharMap(Element  eMap){
        	String textProp = getTextValue(eMap,"textProp");
		String textStd = getTextValue(eMap,"textStd");
		//Create a new Employee with the value read from the xml nodes
		CharacterMap.CHARMAP cMap = new CharacterMap.CHARMAP(textProp,textStd);
		return cMap;
    }
            
}
