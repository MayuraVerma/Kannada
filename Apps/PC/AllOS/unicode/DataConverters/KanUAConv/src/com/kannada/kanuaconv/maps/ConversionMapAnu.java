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
public class ConversionMapAnu extends ConversionMap implements CharacterMap{
    
  public static CHARMAP[] charMap=new CHARMAP[188];
  
  public  ConversionMapAnu(){
      initializeMap();
  }
          
  
 public void initializeMap(){
charMap[0]	=new CHARMAP("!"	,	"!" 				);		
charMap[1]	=new CHARMAP("\""	,	"C" 				);		
charMap[2]	=new CHARMAP("#"	,	"¯");
charMap[3]	=new CHARMAP("$"	,	"E" 				);		
charMap[4]	=new CHARMAP("%"	,	"%" 				);		
charMap[5]	=new CHARMAP("&"	,	"F");
charMap[6]	=new CHARMAP("\'"	,	"G" 			);			
charMap[7]	=new CHARMAP("("	,	"(" 				);		
charMap[8]	=new CHARMAP(")"	,	")");
charMap[9]	=new CHARMAP("*"	,	"À" 				);		
charMap[10]	=new CHARMAP("+"	,	"+" 				);		
charMap[11]	=new CHARMAP(","	,	",");
charMap[12]	=new CHARMAP("."	,	"." 				);		
charMap[13]	=new CHARMAP("/"	,	"/" 				);		
charMap[14]	=new CHARMAP("0"	,	"0");
charMap[15]	=new CHARMAP("1"	,	"1" 				);		
charMap[16]	=new CHARMAP("2"	,	"2" 				);		
charMap[17]	=new CHARMAP("3"	,	"3");
charMap[18]	=new CHARMAP("4"	,	"4" 				);		
charMap[19]	=new CHARMAP("5"	,	"5" 				);		
charMap[20]	=new CHARMAP("6"	,	"6");
charMap[21]	=new CHARMAP("7"	,	"7" 				);		
charMap[22]	=new CHARMAP("8"	,	"8" 				);		
charMap[23]	=new CHARMAP("9"	,	"9");
charMap[24]	=new CHARMAP(":"	,	":" 				);		
charMap[25]	=new CHARMAP(";"	,	";" 				);		
charMap[26]	=new CHARMAP("<"	,	"ë");
charMap[27]	=new CHARMAP("="	,	"=" 				);		
charMap[28]	=new CHARMAP(">"	,	"AiÉ"              );
charMap[29]	=new CHARMAP("?"	,	"?");
charMap[30]	=new CHARMAP("@"	,	"ª" 				);		
charMap[31]	=new CHARMAP("A"	,	"º" 				);		
charMap[32]	=new CHARMAP("B"	,	"ï");
charMap[33]	=new CHARMAP("C"	,	"å" 				);		
charMap[34]	=new CHARMAP("D"	,	"½" 				);		
charMap[35]	=new CHARMAP("E"	,	"d");
charMap[36]	=new CHARMAP("F"	,	"Ë" 				);		
charMap[37]	=new CHARMAP("G"	,	"]" 				);		
charMap[38]	=new CHARMAP("H"	,	"7");
charMap[39]	=new CHARMAP("I"	,	"u" 				);		
charMap[40]	=new CHARMAP("J"	,	"Á" 				);		
charMap[41]	=new CHARMAP("K"	,	"Ó");
charMap[42]	=new CHARMAP("L"	,	"ìæ" 				);
charMap[43]	=new CHARMAP("M"	,	"Ñs" 				);
charMap[44]	=new CHARMAP("N"	,	"1");
charMap[45]	=new CHARMAP("O"	,	"²" 				);		
charMap[46]	=new CHARMAP("P"	,	"¦" 				);		
charMap[47]	=new CHARMAP("Q"	,	"]");
charMap[48]	=new CHARMAP("R"	,	"iÁ" 				);
charMap[49]	=new CHARMAP("W"	,	"«" 				);		
charMap[50]	=new CHARMAP("X"	,	"i" 				);		
charMap[51]	=new CHARMAP("Y"	,	"9");
charMap[52]	=new CHARMAP("Z"	,	"üÇ" 				);
charMap[53]	=new CHARMAP("["	,	"qs" 				);
charMap[54]	=new CHARMAP("\\"	,	"¼"            );
charMap[55]	=new CHARMAP("]"	,	"g" 				);		
charMap[56]	=new CHARMAP("^"	,	"â" 				);		
charMap[57]	=new CHARMAP("_"	,	"Ï");
charMap[58]	=new CHARMAP("`"	,	"ÛÊ" 				);
charMap[59]	=new CHARMAP("a"	,	"Ý" 				);		
charMap[60]	=new CHARMAP("b"	,	"©");
charMap[61]	=new CHARMAP("c"	,	"|" 				);		
charMap[62]	=new CHARMAP("d"	,	"v" 				);		
charMap[63]	=new CHARMAP("e"	,	"V");
charMap[64]	=new CHARMAP("f"	,	"r" 				);		
charMap[65]	=new CHARMAP("g"	,	"H" 				);		
charMap[66]	=new CHARMAP("h"	,	"A");
charMap[67]	=new CHARMAP("i"	,	"Ûæ" 				);
charMap[68]	=new CHARMAP("j"	,	"ç" 				);		
charMap[69]	=new CHARMAP("k"	,	"Õ");
charMap[70]	=new CHARMAP("l"	,	"Ä" 				);		
charMap[71]	=new CHARMAP("m"	,	"®" 				);		
charMap[72]	=new CHARMAP("n"	,	"M");
charMap[73]	=new CHARMAP("o"	,	"Ñ" 				);		
charMap[74]	=new CHARMAP("q"	,	"Öæ" 				);
charMap[75]	=new CHARMAP("r"	,	"è");
charMap[76]	=new CHARMAP("s"	,	"×" 				);		
charMap[77]	=new CHARMAP("t"	,	"R" 				);		
charMap[78]	=new CHARMAP("u"	,	"ê");
charMap[79]	=new CHARMAP("v"	,	"ð" 				);		
charMap[80]	=new CHARMAP("w"	,	"Û" 				);		
charMap[81]	=new CHARMAP("x"	,	"É");
charMap[82]	=new CHARMAP("y"	,	"j" 				);		
charMap[83]	=new CHARMAP("z"	,	"Y" 				);		
charMap[84]	=new CHARMAP("{"	,	"O");
charMap[85]	=new CHARMAP("|"	,	"z" 				);		
charMap[86]	=new CHARMAP("}"	,	"ã" 				);		
charMap[87]	=new CHARMAP("~"	,	"K");
charMap[88]	=new CHARMAP("„"	,	"rü" 				);
charMap[89]	=new CHARMAP("…"	,	"y" 				);		
charMap[90]	=new CHARMAP("†"	,	"¢ü"               );
charMap[91]	=new CHARMAP("‡"	,	"¦üˆ©"              );
charMap[92]	=new CHARMAP("‰"	,	"p" 				);		
charMap[93]	=new CHARMAP("‘"	,	".");
charMap[94]	=new CHARMAP("’"	,	"." 				);		
charMap[95]	=new CHARMAP("–"	,	"-" 				);		
charMap[96]	=new CHARMAP("›"	,	"[");
charMap[97]	=new CHARMAP("¡"	,	"Ù" 				);		
charMap[98]	=new CHARMAP("¢"	,	"Ìø" 				);
charMap[99]	=new CHARMAP("¤"	,	"ì");
charMap[100]	=new CHARMAP("¥"	,	"Æ" 				);		
charMap[101]	=new CHARMAP("¦"	,	"q" 				);		
charMap[102]	=new CHARMAP("§"	,	"¨");
charMap[103]	=new CHARMAP("¨"	,	"m" 				);		
charMap[104]	=new CHARMAP("©"	,	"¸" 				);		
charMap[105]	=new CHARMAP("ª"	,	"&");
charMap[106]	=new CHARMAP("«"	,	"h" 				);		
charMap[107]	=new CHARMAP("¬"	,	"0" 				);		
charMap[108]	=new CHARMAP("­"	,	"ÑÊ"               );
charMap[109]	=new CHARMAP("®"	,	"î" 				);		
charMap[110]	=new CHARMAP("¯"	,	"»" 				);		
charMap[111]	=new CHARMAP("°"	,	"L");
charMap[112]	=new CHARMAP("±"	,	"µ" 				);		
charMap[113]	=new CHARMAP("²"	,	"x" 				);		
charMap[114]	=new CHARMAP("³"	,	"5");
charMap[115]	=new CHARMAP("´"	,	"Ûø" 				);
charMap[116]	=new CHARMAP("µ"	,	"Ü" 				);		
charMap[117]	=new CHARMAP("¶"	,	"D");
charMap[118]	=new CHARMAP("·"	,	"[" 				);		
charMap[119]	=new CHARMAP("¸"	,	"¹" 				);		
charMap[120]	=new CHARMAP("¹"	,	"ä");
charMap[121]	=new CHARMAP("º"	,	"b" 				);		
charMap[122]	=new CHARMAP("»"	,	"k" 				);		
charMap[123]	=new CHARMAP("¼"	,	"T");
charMap[124]	=new CHARMAP("½"	,	"tÂ" 				);
charMap[125]	=new CHARMAP("¾"	,	"zs" 				);
charMap[126]	=new CHARMAP("¿"	,	"ß");
charMap[127]	=new CHARMAP("À"	,	"±" 				);		
charMap[128]	=new CHARMAP("Á"	,	"P" 				);		
charMap[129]	=new CHARMAP("Â"	,	"X");
charMap[130]	=new CHARMAP("Ã"	,	"¶" 				);		
charMap[131]	=new CHARMAP("Ä"	,	"c" 				);		
charMap[132]	=new CHARMAP("Å"	,	"AiÀ"              );
charMap[133]	=new CHARMAP("Æ"	,	"Ú" 				);		
charMap[134]	=new CHARMAP("È"	,	"8" 				);		
charMap[135]	=new CHARMAP("É"	,	"Ã");
charMap[136]	=new CHARMAP("Ë"	,	"Ö" 				);		
charMap[137]	=new CHARMAP("Ì"	,	"¨s" 				);
charMap[138]	=new CHARMAP("Í"	,	"ª");
charMap[139]	=new CHARMAP("Î"	,	"N" 				);		
charMap[140]	=new CHARMAP("Ï"	,	"w" 				);		
charMap[141]	=new CHARMAP("Ñ"	,	"Þ");
charMap[142]	=new CHARMAP("Ò"	,	"é" 				);		
charMap[143]	=new CHARMAP("Ó"	,	"ç" 				);		
charMap[144]	=new CHARMAP("Ô"	,	"Í");
charMap[145]	=new CHARMAP("Õ"	,	"6" 				);		
charMap[146]	=new CHARMAP("Ö"	,	"J");
charMap[147]	=new CHARMAP("×"	,	"çÊ" 				);
charMap[148]	=new CHARMAP("Ø"	,	"S" 				);		
charMap[149]	=new CHARMAP("Ù"	,	"Ô");
charMap[150]	=new CHARMAP("Ú"	,	"4" 				);		
charMap[151]	=new CHARMAP("Û"	,	"B" 				);		
charMap[152]	=new CHARMAP("Ü"	,	"Ò");
charMap[153]	=new CHARMAP("Ý"	,	"¬" 				);		
charMap[154]	=new CHARMAP("Þ"	,	"n" 				);		
charMap[155]	=new CHARMAP("ß"	,	"d");
charMap[156]	=new CHARMAP("à"	,	"Q" 				);		
charMap[157]	=new CHARMAP("á"	,	"á" 				);		
charMap[158]	=new CHARMAP("â"	,	"t");
charMap[159]	=new CHARMAP("ä"	,	"Y" 				);		
charMap[160]	=new CHARMAP("å"	,	"°" 				);		
charMap[161]	=new CHARMAP("æ"	,	"f");
charMap[162]	=new CHARMAP("ç"	,	"U" 				);		
charMap[163]	=new CHARMAP("è"	,	"§" 				);		
charMap[164]	=new CHARMAP("é"	,	"Î");
charMap[165]	=new CHARMAP("ê"	,	"2" 				);		
charMap[166]	=new CHARMAP("ë"	,	"Ê" 				);		
charMap[167]	=new CHARMAP("ì"	,	"Å");
charMap[168]	=new CHARMAP("í"	,	"Z" 				);		
charMap[169]	=new CHARMAP("î"	,	"¥" 				);		
charMap[170]	=new CHARMAP("ï"	,	"WÀ"               );
charMap[171]	=new CHARMAP("ð"	,	"£" 				);		
charMap[172]	=new CHARMAP("ñ"	,	"à" 				);		
charMap[173]	=new CHARMAP("ò"	,	"Ì");
charMap[174]	=new CHARMAP("ó"	,	"l" 				);		
charMap[175]	=new CHARMAP("ô"	,	"a" 				);		
charMap[176]	=new CHARMAP("õ"	,	"¤");
charMap[177]	=new CHARMAP("÷"	,	"ó" 				);		
charMap[178]	=new CHARMAP("ø"	,	"3" 				);		
charMap[179]	=new CHARMAP("ù"	,	"¢");
charMap[180]	=new CHARMAP("ú"	,	"Æ" 				);		
charMap[181]	=new CHARMAP("û"	,	"o" 				);		
charMap[182]	=new CHARMAP("ü"	,	"àæ"               );
charMap[183]	=new CHARMAP("ý"	,	"È" 				);		
charMap[184]	=new CHARMAP("þ"	,	"WÉ" 				);
charMap[185]	=new CHARMAP("ÿ"	,	"W" 				);		
charMap[186]	=new CHARMAP(" "	,	" "               );
charMap[187]	=new CHARMAP("ö"	,	"sÅ" 				);

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
                                //System.out.println("K is"+k);
                                k++;
			 }
                         return sb.toString();
            }
}
