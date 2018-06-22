/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kannada.kanuaconv.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author dell amd
 */
public class ConversionMapBrailleKan extends ConversionMap implements CharacterMap{

	public static List uniBraileStringList = new ArrayList<Map<String, String>>();
	String outBraileString = null;    
        public static CHARMAP[] charMap=new CHARMAP[83];
        public static List<String> gunitakshara = new ArrayList<String>();
        public static Map gunitaksharaSubMap = new HashMap();
        public static List<String> vyanjanaList = new ArrayList<String>();

    public ConversionMapBrailleKan(){
    initializeMap();
}
    @Override
    public final void initializeMap(){
                            charMap[0]=new CHARMAP("\"R","ಋ");
                            charMap[1]=new CHARMAP("@K","್ಕ");
                            charMap[2]=new CHARMAP("@.","್ಖ");
                            charMap[3]=new CHARMAP("@G","್ಗ");
                            charMap[4]=new CHARMAP("@<","್ಘ");
                            charMap[5]=new CHARMAP("@+","್ಙ");
                            charMap[6]=new CHARMAP("@C","್ಚ");
                            charMap[7]=new CHARMAP("@*","್ಛ");
                            charMap[8]=new CHARMAP("@J","್ಜ");
                            charMap[9]=new CHARMAP("@0","್ಝ");
                            charMap[10]=new CHARMAP("@3","್ಞ");
                            charMap[11]=new CHARMAP("@)","್ಟ");
                            charMap[12]=new CHARMAP("@W","್ಠ");
                            charMap[13]=new CHARMAP("@$","್ಡ");
                            charMap[14]=new CHARMAP("@=","್ಢ");
                            charMap[15]=new CHARMAP("@#","್ಣ");
                            charMap[16]=new CHARMAP("@T","್ತ");
                            charMap[17]=new CHARMAP("@?","್ಥ");
                            charMap[18]=new CHARMAP("@D","್ದ");
                            charMap[19]=new CHARMAP("@!","್ಧ");
                            charMap[20]=new CHARMAP("@N","್ನ");
                            charMap[21]=new CHARMAP("@P","್ಪ");
                            charMap[22]=new CHARMAP("@6","್ಫ");
                            charMap[23]=new CHARMAP("@B","್ಬ");
                            charMap[24]=new CHARMAP("@^","್ಭ");
                            charMap[25]=new CHARMAP("@M","್ಮ");
                            charMap[26]=new CHARMAP("@Y","್ಯ");
                            charMap[27]=new CHARMAP("@R","್ರ");
                            charMap[28]=new CHARMAP("@L","್ಲ");
                            charMap[29]=new CHARMAP("@V","್ವ");
                            charMap[30]=new CHARMAP("@%","್ಶ");
                            charMap[31]=new CHARMAP("@&","್ಷ");
                            charMap[32]=new CHARMAP("@S","್ಸ");
                            charMap[33]=new CHARMAP("@H","್ಹ");
                            charMap[34]=new CHARMAP("@_","್ಳ");
                            charMap[35]=new CHARMAP(";","ಂ");
                            charMap[36]=new CHARMAP(",","ಃ");
                            charMap[37]=new CHARMAP("A","ಅ");
                            charMap[38]=new CHARMAP(">","ಆ");
                            charMap[39]=new CHARMAP("I","ಇ");
                            charMap[40]=new CHARMAP("9","ಈ");
                            charMap[41]=new CHARMAP("U","ಉ");
                            charMap[42]=new CHARMAP("|","ಊ");
                            charMap[43]=new CHARMAP("5","ಎ");
                            charMap[44]=new CHARMAP("E","ಏ");
                            charMap[45]=new CHARMAP("/","ಐ");
                            charMap[46]=new CHARMAP("X","ಒ");
                            charMap[47]=new CHARMAP("O","ಓ");
                            charMap[48]=new CHARMAP("[","ಔ");
                            charMap[49]=new CHARMAP("K","ಕ");
                            charMap[50]=new CHARMAP(".","ಖ");
                            charMap[51]=new CHARMAP("G","ಗ");
                            charMap[52]=new CHARMAP("<","ಘ");
                            charMap[53]=new CHARMAP("K","ಙ");
                            charMap[54]=new CHARMAP("+","ಚ");
                            charMap[55]=new CHARMAP("*","ಛ");
                            charMap[56]=new CHARMAP("J","ಜ");
                            charMap[57]=new CHARMAP("0","ಝ");
                            charMap[58]=new CHARMAP("3","ಞ");
                            charMap[59]=new CHARMAP(")","ಟ");
                            charMap[60]=new CHARMAP("W","ಠ");
                            charMap[61]=new CHARMAP("$","ಡ");
                            charMap[62]=new CHARMAP("=","ಢ");
                            charMap[63]=new CHARMAP("#","ಣ");
                            charMap[64]=new CHARMAP("T","ತ");
                            charMap[65]=new CHARMAP("?","ಥ");
                            charMap[66]=new CHARMAP("D","ದ");
                            charMap[67]=new CHARMAP("!","ಧ");
                            charMap[68]=new CHARMAP("N","ನ");
                            charMap[69]=new CHARMAP("P","ಪ");
                            charMap[70]=new CHARMAP("6","ಫ");
                            charMap[71]=new CHARMAP("B","ಬ");
                            charMap[72]=new CHARMAP("^","ಭ");
                            charMap[73]=new CHARMAP("M","ಮ");
                            charMap[74]=new CHARMAP("Y","ಯ");
                            charMap[75]=new CHARMAP("R","ರ");
                            charMap[76]=new CHARMAP("L","ಲ");
                            charMap[77]=new CHARMAP("V","ವ");
                            charMap[78]=new CHARMAP("%","ಶ");
                            charMap[79]=new CHARMAP("&","ಷ");
                            charMap[80]=new CHARMAP("S","ಸ");
                            charMap[81]=new CHARMAP("H","ಹ");
                            charMap[82]=new CHARMAP("_","ಳ");
                            initializeGunitaaksharaList();
                            initializeVyanjanaList();
                            initializeGunitaaksharaSubMap();
    }
    
    
    public static void initializeGunitaaksharaList(){
		gunitakshara.add("ಆ");
                gunitakshara.add("ಇ");
                gunitakshara.add("ಈ");
                gunitakshara.add("ಉ");
                gunitakshara.add("ಊ");
                gunitakshara.add("ಎ");
                gunitakshara.add("ಏ");
                gunitakshara.add("ಐ");
                gunitakshara.add("ಒ");
                gunitakshara.add("ಓ");
                gunitakshara.add("ಔ");
                gunitakshara.add("ಋ");
	}
    
    
        public static void initializeGunitaaksharaSubMap(){
                gunitaksharaSubMap.put("ಆ","ಾ");
                gunitaksharaSubMap.put("ಇ","ಿ");
                gunitaksharaSubMap.put("ಈ","ೀ");
                gunitaksharaSubMap.put("ಉ","ು");
                gunitaksharaSubMap.put("ಊ","ೂ");
                gunitaksharaSubMap.put("ಎ","ೆ");
                gunitaksharaSubMap.put("ಏ","ೇ");
                gunitaksharaSubMap.put("ಐ","ೈ");
                gunitaksharaSubMap.put("ಒ","ೊ");
                gunitaksharaSubMap.put("ಓ","ೋ");
                gunitaksharaSubMap.put("ಔ","ೌ");
                gunitaksharaSubMap.put("ಋ","ೃ");

	}
        
    public static void initializeVyanjanaList(){
                        vyanjanaList.add("ಕ");
                        vyanjanaList.add("ಖ");
                        vyanjanaList.add("ಗ");
                        vyanjanaList.add("ಘ");
                        vyanjanaList.add("ಙ");
                        vyanjanaList.add("ಚ");
                        vyanjanaList.add("ಛ");
                        vyanjanaList.add("ಜ");
                        vyanjanaList.add("ಝ");
                        vyanjanaList.add("ಞ");
                        vyanjanaList.add("ಟ");
                        vyanjanaList.add("ಠ");
                        vyanjanaList.add("ಡ");
                        vyanjanaList.add("ಢ");
                        vyanjanaList.add("ಣ");
                        vyanjanaList.add("ತ");
                        vyanjanaList.add("ಥ");
                        vyanjanaList.add("ದ");
                        vyanjanaList.add("ಧ");
                        vyanjanaList.add("ನ");
                        vyanjanaList.add("ಪ");
                        vyanjanaList.add("ಫ");
                        vyanjanaList.add("ಬ");
                        vyanjanaList.add("ಭ");
                        vyanjanaList.add("ಮ");
                        vyanjanaList.add("ಯ");
                        vyanjanaList.add("ರ");
                        vyanjanaList.add("ಲ");
                        vyanjanaList.add("ವ");
                        vyanjanaList.add("ಶ");
                        vyanjanaList.add("ಷ");
                        vyanjanaList.add("ಸ");
                        vyanjanaList.add("ಹ");
                        vyanjanaList.add("ಳ");
    }
    
     @Override
	public String Convert(String inText) {
        String retVal = inText;
        return retVal;
    }
     
     public String preProcess(String inText){
         String retVal = inText;
         
         char inChar[] = inText.toCharArray();
         
         int k = 0;
         System.out.println("start pre process "+inText.length()+" text is "+inText);
         
         while(k<inText.length()-1){
         System.out.println("K is "+k);             
             if(inChar[k]=='@'){
                 inChar = swap(inChar,k);
                 k = k +2;
             }else
             k++;
         }
         System.out.println("Completed pre process "+new String(inChar));
         
         return retVal = new String(inChar);
     }
     
     public char[] swap(char[] inChar, int pos){
         char temp;
         
         temp = inChar[pos];
         inChar[pos] = inChar[pos+1];
         inChar[pos+1] = temp;
         
         return inChar;
     }
 
     private int getUniText(String buffer) {
		// TODO Auto-generated method stub
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
            	   		uniBraileStringList.add(m);
                   k++;
               }
        }
    	   return uniBraileStringList.size();
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
        	  			if(buffer.length > k+i && len<=buffer.length){
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
        for (i= 0;i<charMap.length;i++)
        { 
            int j = 0;
            j = compsubstr(charMap[i].textProp,buffer,charMap[i].textPropLength,k);
            if(j == 1)
            {
            	//add to converted list
            	m = new HashMap<String, String>();
    	   		m.put(charMap[i].textProp, charMap[i].textStd);
                        //System.out.println("Unicode match"+i);
    	   		uniBraileStringList.add(m);
               return charMap[i].textPropLength;//length of the conversion list 
            }
        }
        return 0;
    }

public String setOutString(String currentString,int a){
    return currentString;
}

 public String setOutString(String currentString){
    	String retVal = new String();
    	StringBuilder retString = new StringBuilder();
    	int i;
        boolean skip = false;
    	int oL = outBraileString.length();
    	char newOutString[] = new char[65000];
    	
		char tempSubst[] = currentString.toCharArray();

       	if(outBraileString != null && outBraileString.length()>0){
        	char outStringChar[] = outBraileString.toCharArray();
        	char tempC = outStringChar[oL-1];
        	for(int o=0;o<oL;o++){
        		newOutString[o]=outStringChar[o];
        	}
        	
        	if(gunitakshara.contains((new StringBuilder()).append(tempSubst[0]).toString())){
                    System.out.println("From map oL "+oL+"The character is "+(new StringBuilder()).append(tempSubst[0]).toString());
                     if(oL > 0){
                         if(vyanjanaList.contains((new StringBuilder()).append(newOutString[oL-1]).toString())){
                             skip = true;
                             String s = (String)gunitaksharaSubMap.get((new StringBuilder()).append(tempSubst[0]).toString());
                             System.out.println("From map"+s);
                             newOutString[oL]= s.charAt(0);
                         }
                     }
                   
                        int im = 0;
                        int l=1;
                        if(skip){
                            im = 1;
                        }else{
                            im = 0;
                        }
                        for(l=im;l<currentString.length();l++){
                         newOutString[oL+l]   = tempSubst[l];
                        }
	    		newOutString[oL+l]='\0';
	    		StringBuilder sb = new StringBuilder();
	    		
	    		for(Integer k=0;newOutString[k] != '\0'; k++){
	    			sb.append(newOutString[k]);
	    		}
    	retVal = sb.toString();
    	return retVal;
        }else{
	    		retString.append(outBraileString);
	    		retString.append(currentString);
	    	}
    }else
    		retString.append(currentString);
    		
    	retVal = retString.toString();
    	return retVal;
 }
 
 public String test(){

    	ConversionMapKanBraille.initializeMaps();
    	
    	outBraileString = new String();
    	Iterator it = uniBraileStringList.iterator();
    	
    	while(it.hasNext()){
    		Map tMap = (Map)it.next();
    		Set s = tMap.keySet();
    		 Iterator it1 = s.iterator();
    		 String currentChar;
    		 
    		 while(it1.hasNext()){
    			 currentChar = tMap.get(it1.next()).toString();
    			 outBraileString  = setOutString(currentChar);
    		 }
    	}
    	System.out.print("The output is"+outBraileString);
    	return outBraileString;
    }
 
 public String getReplaceMent(String inText){
    	
    	String retVal;
    	   retVal = processUniText(getUniText(inText));
    	return inText;
    }

    public String processUniText(int len){
    	String retVal = null;
   	
    	return retVal;
    }
    
    public String convertWord(String inText){
    	String retVal;
    	
        uniBraileStringList = new ArrayList<Map<String, String>>();
        System.out.println("The input text is ==> in ConversionMapBrailleKan"+inText);
    	getReplaceMent(preProcess(inText));
   	
    	retVal = test();
    	return retVal;
    }
}
