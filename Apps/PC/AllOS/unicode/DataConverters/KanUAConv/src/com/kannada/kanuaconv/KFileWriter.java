package com.kannada.kanuaconv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class KFileWriter {
	public static void main(String args[])
	  {
	  try{
	  // Create file 
	  FileWriter fstream = new FileWriter("out1.txt");
	  BufferedWriter out = new BufferedWriter(fstream);
	  File file = new File("out.txt");
	  //Charset encoding = Charset.;

	  try {
	      FileInputStream fis = new FileInputStream(file);
	      char current;
	      while (fis.available() > 0) {
	        current = (char)fis.read();
	        out.write("ಷ್ಟ್ರೀ");
	      }
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  
	  //out.write("ಷ್ಟ್ರೀ");
	  //Close the output stream
	  out.close();
	  }catch (Exception e){//Catch exception if any
	  System.err.println("Error: " + e.getMessage());
	  }
	  }
}
