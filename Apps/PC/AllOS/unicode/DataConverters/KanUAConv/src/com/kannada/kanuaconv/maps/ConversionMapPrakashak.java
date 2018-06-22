/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kannada.kanuaconv.maps;

import java.util.Arrays;

/**
 *
 * @author dell amd
 */
public class ConversionMapPrakashak extends ConversionMap implements CharacterMap{
    
        public static CHARMAP[] charMap=new CHARMAP[141];
        
          public  ConversionMapPrakashak(){
      initializeMap();
  }
          public void initializeMap(){
charMap[0]	=new CHARMAP("!"	,	"C"); 
charMap[1]	=new CHARMAP("q"	,	"D"); 
charMap[2]	=new CHARMAP("#"	,	"E"); 
charMap[3]	=new CHARMAP("$"	,	"F"); 
charMap[4]	=new CHARMAP("%"	,	"G"); 
charMap[5]	=new CHARMAP("&"	,	"H"); 
charMap[6]	=new CHARMAP("M"	,	"I"); 
charMap[7]	=new CHARMAP("("	,	"J"); 
charMap[8]	=new CHARMAP(")"	,	"K"); 
charMap[9]	=new CHARMAP("*"	,	"L"); 
charMap[10]	=new CHARMAP("+"	,	"M"); 
charMap[11]	=new CHARMAP("ø"	,	"N"); 
charMap[12]	=new CHARMAP("ò"	,	"O"); 
charMap[13]	=new CHARMAP("à"	,	"A"); 
charMap[14]	=new CHARMAP("/"	,	"B"); 
charMap[15]	=new CHARMAP("Ó"	,	"P"); 
charMap[16]	=new CHARMAP("ù"	,	"PÀ"); 
charMap[17]	=new CHARMAP("R"	,	"Q"); 
charMap[18]	=new CHARMAP("ú"	,	"PÉ"); 
charMap[19]	=new CHARMAP("x"	,	"Ì"); 
charMap[20]	=new CHARMAP("G"	,	"R"); 
charMap[21]	=new CHARMAP("î"	,	"S"); 
charMap[22]	=new CHARMAP("S"	,	"T"); 
charMap[23]	=new CHARMAP("¡"	,	"Í"); 
charMap[24]	=new CHARMAP("Ô"	,	"U"); 
charMap[25]	=new CHARMAP("T"	,	"V"); 
charMap[26]	=new CHARMAP("¢"	,	"Î"); 
charMap[27]	=new CHARMAP("Õ"	,	"W"); 
charMap[28]	=new CHARMAP("ö"	,	"X"); 
charMap[29]	=new CHARMAP("£"	,	"Ï"); 
charMap[30]	=new CHARMAP("H"	,	"Y"); 
charMap[31]	=new CHARMAP("¤"	,	"Ð"); 
charMap[32]	=new CHARMAP("Ö"	,	"Z"); 
charMap[33]	=new CHARMAP("U"	,	"a"); 
charMap[34]	=new CHARMAP("¥"	,	"Ñ"); 
charMap[35]	=new CHARMAP(","	,	"Ò"); 
charMap[36]	=new CHARMAP("I"	,	"d"); 
charMap[37]	=new CHARMAP("Ø"	,	"e"); 
charMap[38]	=new CHARMAP("W"	,	"f"); 
charMap[39]	=new CHARMAP("§"	,	"Ó"); 
charMap[40]	=new CHARMAP("Ï"	,	"gÉhÄ");        
charMap[41]	=new CHARMAP("."	,	"Ô"); 
charMap[42]	=new CHARMAP("J"	,	"k"); 
charMap[43]	=new CHARMAP("©"	,	"Õ"); 
charMap[44]	=new CHARMAP("K"	,	"l"); 
charMap[45]	=new CHARMAP("Ù"	,	"m"); 
charMap[46]	=new CHARMAP("X"	,	"n"); 
charMap[47]	=new CHARMAP("ª"	,	"Ö"); 
charMap[48]	=new CHARMAP("«"	,	"×"); 
charMap[49]	=new CHARMAP("Û"	,	"q"); 
charMap[50]	=new CHARMAP("Z"	,	"r"); 
charMap[51]	=new CHARMAP("†"	,	"Ø"); 
charMap[52]	=new CHARMAP("L"	,	"t"); 
charMap[53]	=new CHARMAP("Ü"	,	"u"); 
charMap[54]	=new CHARMAP("@"	,	"tÂ"); 
charMap[55]	=new CHARMAP("®"	,	"Ú"); 
charMap[56]	=new CHARMAP(":"	,	"v"); 
charMap[57]	=new CHARMAP("\\",   "w"); 
charMap[58]	=new CHARMAP("‰"	,	"Û"); 
charMap[59]	=new CHARMAP("°"	,	"Ü"); 
charMap[60]	=new CHARMAP(";"	,	"z"); 
charMap[61]	=new CHARMAP("]"	,	"¢"); 
charMap[62]	=new CHARMAP("Š"	,	"Ý"); 
charMap[63]	=new CHARMAP("<"	,	"£"); 
charMap[64]	=new CHARMAP("^"	,	"¤"); 
charMap[65]	=new CHARMAP("‹"	,	"ß"); 
charMap[66]	=new CHARMAP("="	,	"¥"); 
charMap[67]	=new CHARMAP("_"	,	"¦"); 
charMap[68]	=new CHARMAP("Œ"	,	"à"); 
charMap[69]	=new CHARMAP("í"	,	"¥s"); 
charMap[70]	=new CHARMAP("‘"	,	"á"); 
charMap[71]	=new CHARMAP("N"	,	"§"); 
charMap[72]	=new CHARMAP("æ"	,	"¨"); 
charMap[73]	=new CHARMAP("v"	,	"©"); 
charMap[74]	=new CHARMAP("’"	,	"â"); 
charMap[75]	=new CHARMAP("¶"	,	"ä"); 
charMap[76]	=new CHARMAP("O"	,	"AiÀ");
charMap[77]	=new CHARMAP("h"	,	"¬"); 
charMap[78]	=new CHARMAP("Ò"	,	"AiÉ");
charMap[79]	=new CHARMAP("Ç"	,	"å"); 
charMap[80]	=new CHARMAP("Ú"	,	"g"); 
charMap[81]	=new CHARMAP("Y"	,	"j"); 
charMap[82]	=new CHARMAP("P"	,	"®"); 
charMap[83]	=new CHARMAP("?"	,	"¯"); 
charMap[84]	=new CHARMAP("b"	,	"°"); 
charMap[85]	=new CHARMAP("š"	,	"è"); 
charMap[86]	=new CHARMAP("A"	,	"ª"); 
charMap[87]	=new CHARMAP("a"	,	"«"); 
charMap[88]	=new CHARMAP("º"	,	"é"); 
charMap[89]	=new CHARMAP("B"	,	"±"); 
charMap[90]	=new CHARMAP("i"	,	"²"); 
charMap[91]	=new CHARMAP("»"	,	"ê"); 
charMap[92]	=new CHARMAP("C"	,	"µ"); 
charMap[93]	=new CHARMAP("c"	,	"¶"); 
charMap[94]	=new CHARMAP("›"	,	"ë"); 
charMap[95]	=new CHARMAP("D"	,	"¸"); 
charMap[96]	=new CHARMAP("d"	,	"¹"); 
charMap[97]	=new CHARMAP("œ"	,	"ì"); 
charMap[98]	=new CHARMAP("E"	,	"º"); 
charMap[99]	=new CHARMAP("e"	,	"»"); 
charMap[100]	=new CHARMAP("À"	,	"í"); 
charMap[101]	=new CHARMAP("è"	,	"¼"); 
charMap[102]	=new CHARMAP("f"	,	"½"); 
charMap[103]	=new CHARMAP("¿"	,	"î"); 
charMap[104]	=new CHARMAP("j"	,	"À"); 
charMap[105]	=new CHARMAP("o"	,	"Á"); 
charMap[106]	=new CHARMAP("p"	,	"Â"); 
charMap[107]	=new CHARMAP("|"	,	"Ã"); 
charMap[108]	=new CHARMAP(" "	,	"Ä"); 
charMap[109]	=new CHARMAP("û"	,	"Å"); 
charMap[110]	=new CHARMAP("{"	,	"i"); 
charMap[111]	=new CHARMAP("s"	,	"h"); 
charMap[112]	=new CHARMAP("r"	,	"Æ"); 
charMap[113]	=new CHARMAP("Ñ"	,	"Ç"); 
charMap[114]	=new CHARMAP("t"	,	"Æ"); 
charMap[115]	=new CHARMAP("â"	,	"È"); 
charMap[116]	=new CHARMAP("y"	,	"ñ"); 
charMap[117]	=new CHARMAP("u"	,	"É"); 
charMap[118]	=new CHARMAP("Î"	,	"É"); 
charMap[119]	=new CHARMAP("w"	,	"õÉ"); 
charMap[120]	=new CHARMAP("`"	,	"ÉÃ"); 
charMap[121]	=new CHARMAP("ã"	,	"Ê"); 
charMap[122]	=new CHARMAP(" "	,	"ÉÆ"); 
charMap[123]	=new CHARMAP("z"	,	"Ë"); 
charMap[124]	=new CHARMAP("}"	,	"ï"); 
charMap[125]	=new CHARMAP("~"	,	"ð"); 
charMap[126]	=new CHARMAP("ç"	,	"ò"); 
charMap[127]	=new CHARMAP("·"	,	"Ûöå");
charMap[128]	=new CHARMAP("¸"	,	"Ûç"); 
charMap[129]	=new CHARMAP("Â"	,	"Ìø"); 
charMap[130]	=new CHARMAP("Ã"	,	"ÑöÊ");
charMap[131]	=new CHARMAP("Ä"	,	"Öç"); 
charMap[132]	=new CHARMAP("Å"	,	"Ûø"); 
charMap[133]	=new CHARMAP("Æ"	,	"ÛöÊ");
charMap[134]	=new CHARMAP("É"	,	"àç"); 
charMap[135]	=new CHARMAP("Ê"	,	"æöÊ");
charMap[136]	=new CHARMAP("Ë"	,	"ìç"); 
charMap[137]	=new CHARMAP("Ì"	,	"Ìöë");
charMap[138]	=new CHARMAP("Í"	,	"Ìç"); 
charMap[139]	=new CHARMAP("é"	,	"Ûç"); 
charMap[140]	=new CHARMAP("ê"	,	"Ûöå");
Arrays.sort(charMap, new CharMapComparator());
}
          
@Override 
public String Convert(String inText) {
		// TODO Auto-generated method stub
	char buffer[] = inText.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i =0;
        int k = 0;
        StringBuilder temp = null;
        
        //System.out.println("Anu test is"+inText);
        while(k<inText.length())
			{
				boolean found = false;
                                
                                temp = new StringBuilder();
                                temp.append(buffer[k]);
                
				for(i=0;i<charMap.length && found == false ;i++)
				{
					if( charMap[i].textProp.equals(temp.toString())) 
						{  
							found = true ;
							sb.append(charMap[i].textStd);
						}
				}
				if(found == false)
					{
						sb.append(buffer[k]);
					}
                                System.out.println("K is"+k);
                                k++;
			 }
                         return sb.toString();
            }
 
}
