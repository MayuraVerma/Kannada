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
public class ConversionMapKanBraille extends ConversionMap implements CharacterMap{

	public static List uniBraileStringList = new ArrayList<Map<String, String>>();
	String outBraileString = null;    
        public static CHARMAP[] charMap=new CHARMAP[97];

public ConversionMapKanBraille(){
    initializeMap();
}
    @Override
    public final void initializeMap(){
    //TODOAuto-generatedmethodstub
                    charMap[0]=new CHARMAP("ಂ",";");
                    charMap[1]=new CHARMAP("ಃ",",");
                    charMap[2]=new CHARMAP("ಅ","A");
                    charMap[3]=new CHARMAP("ಆ",">");
                    charMap[4]=new CHARMAP("ಇ","I");
                    charMap[5]=new CHARMAP("ಈ","9");
                    charMap[6]=new CHARMAP("ಉ","U");
                    charMap[7]=new CHARMAP("ಊ","|");
                    charMap[8]=new CHARMAP("ಋ","\"R");
                    charMap[9]=new CHARMAP("ಎ","5");
                    charMap[10]=new CHARMAP("ಏ","E");
                    charMap[11]=new CHARMAP("ಐ","/");
                    charMap[12]=new CHARMAP("ಒ","X");
                    charMap[13]=new CHARMAP("ಓ","O");
                    charMap[14]=new CHARMAP("ಔ","[");
                    charMap[15]=new CHARMAP("ಕ","K");
                    charMap[16]=new CHARMAP("ಖ",".");
                    charMap[17]=new CHARMAP("ಗ","G");
                    charMap[18]=new CHARMAP("ಘ","<");
                    charMap[19]=new CHARMAP("ಙ","K");
                    charMap[20]=new CHARMAP("ಚ","+");
                    charMap[21]=new CHARMAP("ಛ","*");
                    charMap[22]=new CHARMAP("ಜ","J");
                    charMap[23]=new CHARMAP("ಝ","0");
                    charMap[24]=new CHARMAP("ಞ","3");
                    charMap[25]=new CHARMAP("ಟ",")");
                    charMap[26]=new CHARMAP("ಠ","W");
                    charMap[27]=new CHARMAP("ಡ","$");
                    charMap[28]=new CHARMAP("ಢ","=");
                    charMap[29]=new CHARMAP("ಣ","#");
                    charMap[30]=new CHARMAP("ತ","T");
                    charMap[31]=new CHARMAP("ಥ","?");
                    charMap[32]=new CHARMAP("ದ","D");
                    charMap[33]=new CHARMAP("ಧ","!");
                    charMap[34]=new CHARMAP("ನ","N");
                    charMap[35]=new CHARMAP("ಪ","P");
                    charMap[36]=new CHARMAP("ಫ","6");
                    charMap[37]=new CHARMAP("ಬ","B");
                    charMap[38]=new CHARMAP("ಭ","^");
                    charMap[39]=new CHARMAP("ಮ","M");
                    charMap[40]=new CHARMAP("ಯ","Y");
                    charMap[41]=new CHARMAP("ರ","R");
                    charMap[42]=new CHARMAP("ಲ","L");
                    charMap[43]=new CHARMAP("ವ","V");
                    charMap[44]=new CHARMAP("ಶ","%");
                    charMap[45]=new CHARMAP("ಷ","&");
                    charMap[46]=new CHARMAP("ಸ","S");
                    charMap[47]=new CHARMAP("ಹ","H");
                    charMap[48]=new CHARMAP("ಳ","_");
                    charMap[49]=new CHARMAP("್ಕ","@K");
                    charMap[50]=new CHARMAP("್ಖ","@.");
                    charMap[51]=new CHARMAP("್ಗ","@G");
                    charMap[52]=new CHARMAP("್ಘ","@<");
                    charMap[53]=new CHARMAP("್ಙ","@+");
                    charMap[54]=new CHARMAP("್ಚ","@C");
                    charMap[55]=new CHARMAP("್ಛ","@*");
                    charMap[56]=new CHARMAP("್ಜ","@J");
                    charMap[57]=new CHARMAP("್ಝ","@0");
                    charMap[58]=new CHARMAP("್ಞ","@3");
                    charMap[59]=new CHARMAP("್ಟ","@)");
                    charMap[60]=new CHARMAP("್ಠ","@W");
                    charMap[61]=new CHARMAP("್ಡ","@$");
                    charMap[62]=new CHARMAP("್ಢ","@=");
                    charMap[63]=new CHARMAP("್ಣ","@#");
                    charMap[64]=new CHARMAP("್ತ","@T");
                    charMap[65]=new CHARMAP("್ಥ","@?");
                    charMap[66]=new CHARMAP("್ದ","@D");
                    charMap[67]=new CHARMAP("್ಧ","@!");
                    charMap[68]=new CHARMAP("್ನ","@N");
                    charMap[69]=new CHARMAP("್ಪ","@P");
                    charMap[70]=new CHARMAP("್ಫ","@6");
                    charMap[71]=new CHARMAP("್ಬ","@B");
                    charMap[72]=new CHARMAP("್ಭ","@^");
                    charMap[73]=new CHARMAP("್ಮ","@M");
                    charMap[74]=new CHARMAP("್ಯ","@Y");
                    charMap[75]=new CHARMAP("್ರ","@R");
                    charMap[76]=new CHARMAP("್ಲ","@L");
                    charMap[77]=new CHARMAP("್ವ","@V");
                    charMap[78]=new CHARMAP("್ಶ","@%");
                    charMap[79]=new CHARMAP("್ಷ","@&");
                    charMap[80]=new CHARMAP("್ಸ","@S");
                    
                    charMap[81]=new CHARMAP("್ಹ","@H");
                    
                    charMap[82]=new CHARMAP("್ಳ","@_");
                    charMap[83]=new CHARMAP("ೀ","9");
                    charMap[84]=new CHARMAP("ೋ","O");
                    charMap[85]=new CHARMAP("ಾ",">");
                    charMap[86]=new CHARMAP("ಿ","I");
                    charMap[87]=new CHARMAP("ೀ","9");
                    charMap[88]=new CHARMAP("ು","U");
                    charMap[89]=new CHARMAP("ೂ","|");
                    charMap[90]=new CHARMAP("ೃ","\"R");
                    charMap[91]=new CHARMAP("ೆ","5");
                    charMap[92]=new CHARMAP("ೇ","E");
                    charMap[93]=new CHARMAP("ೈ","/");
                    charMap[94]=new CHARMAP("ೊ","X");
                    charMap[95]=new CHARMAP("ೋ","O");
                    charMap[96]=new CHARMAP("ೌ","[");


    }
    
    @Override
	public String Convert(String inText) {
        String retVal = inText;
        
        return retVal;
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

 public String setOutString(String currentString){
    	String retVal = new String();
    	StringBuilder retString = new StringBuilder();
    	int i;
    	int oL = outBraileString.length();
    	char newOutString[] = new char[65000];
    	
		char tempSubst[] = currentString.toCharArray();

       	if(outBraileString != null && outBraileString.length()>0){
        	char outStringChar[] = outBraileString.toCharArray();
        	char tempC = outStringChar[oL-1];
        	for(int o=0;o<oL;o++){
        		newOutString[o]=outStringChar[o];
        	}
        	
        	if("@".equals((new StringBuilder()).append(tempSubst[0]).toString())){
	    			newOutString[oL-1] = '@';
	    		
                
	    		newOutString[oL]=tempC;
               
                        int l=1;
                        for(l=1;l<currentString.length();l++){
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
    	System.out.print(outBraileString);
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
        System.out.println("The input text is "+inText);
    	getReplaceMent(inText);
    	
    	retVal = test();
    	return retVal;
    }
    
}