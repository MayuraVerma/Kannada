/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kannada.Converter;

import com.kannada.kanuaconv.maps.ConversionMap;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dell amd
 */
public class GOKToUnicode {
    
        
   
     public String getReplaceMent(String inText){
    	
    	String retVal;
    	   retVal = processUniText(getUniText(inText));
    	return inText;
    }

    public String processUniText(int len){
    	String retVal = null;
    	
//    	uniStringList.
    	
    	return retVal;
    }
    private int getUniText(String buffer) {
		// TODO Auto-generated method stub
    	StringBuffer in = new StringBuffer();
    	int k = 0;
    	int j = 0;
    	Map m;
    	buffer = buffer.replaceAll("ö", "");
		while(k < buffer.length())
		{
                   j = 0;
                   j = compstr(buffer,k);
              if(j>0)
               {    
                    k = k+j; //change the k to point to current buffer 
               }
               else
               {   
            	   		m = new HashMap<String, String>();
            	   		m.put(buffer.charAt(k), buffer.charAt(k));
            	   		CommonStrings.uniStringList.add(m);
                   k++;
               }
        }
    	   return CommonStrings.uniStringList.size();
	}

	int compsubstr(String inAsciiText,String inASCIIbuffer,int len,int k)
    {
        int i=0;
        
       
        char[]  var = inAsciiText.toCharArray();
        char[] buffer = inASCIIbuffer.toCharArray();
        if(inASCIIbuffer!=null){
        try{
          for (i=0;i<len && buffer.length > i;i++)
         {
        	  			if(buffer.length > k+i){
        	  				if(var != null && var[i]!=buffer[k+i] )
        	  					return 0;
        	  			}else
                          return 0;
         }
        }catch(Exception e){
        	e.printStackTrace();
        }
       }
         return 1;
    }
        
    int compstr(String buffer,int k)
    {
        int i;
        Map m;
        for (i= 0;i<ConversionMap.asciiUniMap.length;i++)
        { 
            int j = 0;
            j = compsubstr(ConversionMap.asciiUniMap[i].textASCII,buffer,ConversionMap.asciiUniMap[i].asciiLength,k);
            if(j == 1)
            {
            	//add to converted list
            	m = new HashMap<String, String>();
    	   		m.put(ConversionMap.asciiUniMap[i].textASCII, ConversionMap.asciiUniMap[i].textUNI);
                        //System.out.println("Unicode match"+i);
    	   		CommonStrings.uniStringList.add(m);
    	   		/*if(i == 551){
    	   			System.out.println(i+" "+ConversionMap.asciiUniMap[i].textASCII+" "+ConversionMap.asciiUniMap[i].textUNI);
    	   		}
    	   		System.out.println(i+" "+ConversionMap.asciiUniMap[i].textASCII+" "+ConversionMap.asciiUniMap[i].textUNI);*/
            	//uniStringList.add(ConversionMap.asciiUniMap[i].textUNI);
                return ConversionMap.asciiUniMap[i].asciiLength;//length of the conversion list 
            }
        }
        return 0;
    }
}
