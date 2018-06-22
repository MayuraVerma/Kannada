/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kannada.Converter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author dell amd
 */
public class TextFileConverter implements FileConverter{
    
     public  void convert(String inFile,String outFile){
    	
//    	try{
//  		  
//    		  FileReader fr = new FileReader(inFile);
//    		  //BufferedReader br = new BufferedReader(fr); 
//    		  
//    		  Writer out = new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8");
//    		  //Reader in = new InputStreamReader(new FileInputStream(inFile), "ASCII");
//    		  String strLine;
//    		  String outStrLine;
//    		  
//    		  BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(inFile),"windows-1252"));
//    		  
//    		  while ((strLine = in.readLine()) != null)   {
//    		  // Print the content on the console
//    		  //System.out.println ("Origninal String "+strLine);
//    		  outStrLine = convertString(strLine);
//                  CommonStrings.uniStringList = new ArrayList<Map<String, String>>();
//    		    try {
//    		      out.write(outStrLine);
//    		    }catch(IOException ioE){
//    		    	ioE.printStackTrace();
//    		    }
//    		  }
//    		  //Close the input & output stream
//    		  in.close();
//    		  out.close();
//    		    }catch (Exception e){//Catch exception if any
//    		    	e.printStackTrace();
//    		  System.err.println("Error: " + e.getMessage());
//    		  }
//    
    }
}
