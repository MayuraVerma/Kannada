/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kannada.Converter;

import com.kannada.kanuaconv.maps.ConversionMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dell amd
 */
public class CommonStrings {
 
    
      public static  List uniStringList = new ArrayList<Map<String, String>>();
      public static String outString = null;
      
      public String setOutString(String currentString){
    	String retVal = new String();
    	StringBuilder retString = new StringBuilder();
    	int i;
    	int oL = CommonStrings.outString.length();
    	char newOutString[] = new char[65000];
    	
		char tempSubst[] = currentString.toCharArray();

    	if(CommonStrings.outString != null && CommonStrings.outString.length()>0){
        	char outStringChar[] = CommonStrings.outString.toCharArray();
        	char tempC = outStringChar[oL-1];
        	for(int o=0;o<oL;o++){
        		newOutString[o]=outStringChar[o];
        	}
        	
        	if(ConversionMap.gunitakshara.contains((new StringBuilder()).append(outStringChar[oL-1]).toString()) &&
	    			ConversionMap.ottaksharaList.contains(currentString)		
	    	   ){
	    		for(i=0;i<currentString.length();i++){
	    			newOutString[oL-1+i] = tempSubst[i];
	    		}
	    		newOutString[oL-1+i]=tempC;
	    		newOutString[oL+i]='\0';
	    		StringBuilder sb = new StringBuilder();
	    		
	    		for(Integer k=0;newOutString[k] != '\0'; k++){
	    			sb.append(newOutString[k]);
	    		}
	    		retString.append(sb.toString());
	    	}else{
	    		retString.append(outStringChar);
	    		retString.append(currentString);
	    	}
    	}else
    		retString.append(currentString);
    		
    	retVal = retString.toString();
    	return retVal;
    }
    
}
