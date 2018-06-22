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
public class ConversionMapSurabhi extends ConversionMap implements CharacterMap{
    
    public static CHARMAP[] charMap=new CHARMAP[143];
    public ConversionMapSurabhi(){
    initializeMap();
}
    public void initializeMap(){
        				 charMap[0]	=new CHARMAP("A"	,	"C" );			
					 charMap[1]	=new CHARMAP("B"	,	"D" );			
					 charMap[2]	=new CHARMAP("C"	,	"E" );			
					 charMap[3]	=new CHARMAP("D"	,	"F" );			
					 charMap[4]	=new CHARMAP("E"	,	"G" );			
					 charMap[5]	=new CHARMAP("F"	,	"H" );			
					 charMap[6]	=new CHARMAP("G"	,	"I" );			
					 charMap[7]	=new CHARMAP("H"	,	"J" );			
					 charMap[8]	=new CHARMAP("I"	,	"K" );			
					 charMap[9]	=new CHARMAP("J"	,	"L" );			
					 charMap[10]	=new CHARMAP("K"	,	"M" );			
					 charMap[11]	=new CHARMAP("L"	,	"N" );			
					 charMap[12]	=new CHARMAP("M"	,	"O" );			
					 charMap[13]	=new CHARMAP("N"	,	"A" );			
					 charMap[14]	=new CHARMAP("O"	,	"B" );			
					 charMap[15]	=new CHARMAP("P"	,	"P" );			
					 charMap[16]	=new CHARMAP("Q"	,	"Q" );			
					 charMap[17]	=new CHARMAP("R"	,	"Ì" );			
					 charMap[18]	=new CHARMAP("S"	,	"Ìø");	
					 charMap[19]	=new CHARMAP("T"	,	"Ìç");	
					 charMap[20]	=new CHARMAP("U"	,	"R" );			
					 charMap[21]	=new CHARMAP("V"	,	"S" );			
					 charMap[22]	=new CHARMAP("W"	,	"T" );			
					 charMap[23]	=new CHARMAP("X"	,	"Í" );			
					 charMap[24]	=new CHARMAP("Y"	,	"U" );			
					 charMap[25]	=new CHARMAP("Z"	,	"V" );			
					 charMap[26]	=new CHARMAP("a"	,	"Î" );			
					 charMap[27]	=new CHARMAP("b"	,	"W" );			
					 charMap[28]	=new CHARMAP("c"	,	"X" );			
					 charMap[29]	=new CHARMAP("d"	,	"Ï" );			
					 charMap[30]	=new CHARMAP("e"	,	"Y" );			
					 charMap[31]	=new CHARMAP("f"	,	"Ð" );			
					 charMap[32]	=new CHARMAP("g"	,	"Z" );			
					 charMap[33]	=new CHARMAP("h"	,	"a" );			
					 charMap[34]	=new CHARMAP("i"	,	"Ñ" );			
					 charMap[35]	=new CHARMAP("j"	,	"ÑÊ");	
					 charMap[36]	=new CHARMAP("k"	,	"b" );			
					 charMap[37]	=new CHARMAP("l"	,	"c" );			
					 charMap[38]	=new CHARMAP("m"	,	"Ò" );			
					 charMap[39]	=new CHARMAP("n"	,	"d" );			
					 charMap[40]	=new CHARMAP("o"	,	"e" );			
					 charMap[41]	=new CHARMAP("p"	,	"f" );			
					 charMap[42]	=new CHARMAP("q"	,	"Ó" );			
					 charMap[43]	=new CHARMAP("r"	,	"h" );			
					 charMap[44]	=new CHARMAP("s"	,	"Ô" );			
					 charMap[45]	=new CHARMAP("t"	,	"k" );			
					 charMap[46]	=new CHARMAP("u"	,	"Õ" );			
					 charMap[47]	=new CHARMAP("v"	,	"l" );			
					 charMap[48]	=new CHARMAP("w"	,	"m" );			
					 charMap[49]	=new CHARMAP("x"	,	"n" );			
					 charMap[50]	=new CHARMAP("y"	,	"Ö" );			
					 charMap[51]	=new CHARMAP("z"	,	"Öç");	
					 charMap[52]	=new CHARMAP("¡"	,	"o" );			
					 charMap[53]	=new CHARMAP("¢"	,	"p" );			
					 charMap[54]	=new CHARMAP("£"	,	"×" );			
					 charMap[55]	=new CHARMAP("¤"	,	"q" );			
					 charMap[56]	=new CHARMAP("¥"	,	"r" );			
					 charMap[57]	=new CHARMAP("¦"	,	"Ø" );			
					 charMap[58]	=new CHARMAP("§"	,	"t" );			
					 charMap[59]	=new CHARMAP("¨"	,	"u" );			
					 charMap[60]	=new CHARMAP("ª"	,	"tÂ");	
					 charMap[61]	=new CHARMAP("«"	,	"Ú" );			
					 charMap[62]	=new CHARMAP("¬"	,	"v" );			
					 charMap[63]	=new CHARMAP("®"	,	"w" );			
					 charMap[64]	=new CHARMAP("¯"	,	"Û" );			
					 charMap[65]	=new CHARMAP("°"	,	"Ûø");	
					 charMap[66]	=new CHARMAP("±"	,	"ÛÊ");	
					 charMap[67]	=new CHARMAP("²"	,	"Ûå");	
					 charMap[68]	=new CHARMAP("³"	,	"Ûç");	
					 charMap[69]	=new CHARMAP("´"	,	"ÛÑ");	
					 charMap[70]	=new CHARMAP("µ"	,	"x" );			
					 charMap[71]	=new CHARMAP("¶"	,	"y" );			
					 charMap[72]	=new CHARMAP("¸"	,	"Ü" );			
					 charMap[73]	=new CHARMAP("¹"	,	"z" );			
					 charMap[74]	=new CHARMAP("º"	,	"¢" );			
					 charMap[75]	=new CHARMAP("»"	,	"Ý" );			
					 charMap[76]	=new CHARMAP("¼"	,	"£" );			
					 charMap[77]	=new CHARMAP("½"	,	"¤" );			
					 charMap[78]	=new CHARMAP("¾"	,	"ß" );			
					 charMap[79]	=new CHARMAP("¿"	,	"¥" );			
					 charMap[80]	=new CHARMAP("À"	,	"¦" );			
					 charMap[81]	=new CHARMAP("Á"	,	"à" );			
					 charMap[82]	=new CHARMAP("Â"	,	"àç");	
					 charMap[83]	=new CHARMAP("Ã"	,	"§" );			
					 charMap[84]	=new CHARMAP("Ä"	,	"¨" );			
					 charMap[85]	=new CHARMAP("Å"	,	"©" );			
					 charMap[86]	=new CHARMAP("Æ"	,	"â" );			
					 charMap[87]	=new CHARMAP("Ç"	,	"ä" );			
					 charMap[88]	=new CHARMAP("È"	,	"¬" );			
					 charMap[89]	=new CHARMAP("É"	,	"å" );			
					 charMap[90]	=new CHARMAP("Ê"	,	"g" );			
					 charMap[91]	=new CHARMAP("Ë"	,	"j" );			
					 charMap[92]	=new CHARMAP("Ì"	,	"ð" );			
					 charMap[93]	=new CHARMAP("Í"	,	"æ" );			
					 charMap[94]	=new CHARMAP("Î"	,	"ç" );			
					 charMap[95]	=new CHARMAP("Ï"	,	"æÊ");	
					 charMap[96]	=new CHARMAP("Ð"	,	"®" );			
					 charMap[97]	=new CHARMAP("Ñ"	,	"¯" );			
					 charMap[98]	=new CHARMAP("Ò"	,	"°" );			
					 charMap[99]	=new CHARMAP("Ó"	,	"è" );			
					 charMap[100]	=new CHARMAP("Ô"	,	"ª" );			
					 charMap[101]	=new CHARMAP("Õ"	,	"«" );			
					 charMap[102]	=new CHARMAP("Ö"	,	"é" );			
					 charMap[103]	=new CHARMAP("×"	,	"¿" );			
					 charMap[104]	=new CHARMAP("Ø"	,	"ú" );			
					 charMap[105]	=new CHARMAP("Ù"	,	"±" );			
					 charMap[106]	=new CHARMAP("Ú"	,	"²" );			
					 charMap[107]	=new CHARMAP("Û"	,	"ê" );			
					 charMap[108]	=new CHARMAP("Ü"	,	"²æ");	
					 charMap[109]	=new CHARMAP("Ý"	,	"µ" );			
					 charMap[110]	=new CHARMAP("Þ"	,	"¶" );			
					 charMap[111]	=new CHARMAP("ß"	,	"ë" );			
					 charMap[112]	=new CHARMAP("à"	,	"¸" );			
					 charMap[113]	=new CHARMAP("á"	,	"¹" );			
					 charMap[114]	=new CHARMAP("â"	,	"ì" );			
					 charMap[115]	=new CHARMAP("ã"	,	"ìç");	
					 charMap[116]	=new CHARMAP("ä"	,	"º" );			
					 charMap[117]	=new CHARMAP("å"	,	"»" );			
					 charMap[118]	=new CHARMAP("æ"	,	"í" );			
					 charMap[119]	=new CHARMAP("ç"	,	"¼" );			
					 charMap[120]	=new CHARMAP("è"	,	"½" );			
					 charMap[121]	=new CHARMAP("é"	,	"î" );			
					 charMap[122]	=new CHARMAP("ê"	,	"¾" );			
					 charMap[123]	=new CHARMAP("ë"	,	"ù" );			
					 charMap[124]	=new CHARMAP("î"	,	"À" );			
					 charMap[125]	=new CHARMAP("ï"	,	"i" );			
					 charMap[126]	=new CHARMAP("ð"	,	"õ" );			
					 charMap[127]	=new CHARMAP("ñ"	,	"Á" );			
					 charMap[128]	=new CHARMAP("ò"	,	"Â" );			
					 charMap[129]	=new CHARMAP("ó"	,	"Ã"	);			
					 charMap[130]	=new CHARMAP("ô"	,	"Ä" );			
					 charMap[131]	=new CHARMAP("õ"	,	"Å" );			
					 charMap[132]	=new CHARMAP("ö"	,	"Æ" );			
					 charMap[133]	=new CHARMAP("÷"	,	"Ç" );			
					 charMap[134]	=new CHARMAP("ø"	,	"È" );			
					 charMap[135]	=new CHARMAP("ù"	,	"ñ" );			
					 charMap[136]	=new CHARMAP("ú"	,	"É" );			
					 charMap[137]	=new CHARMAP("û"	,	"Ê" );			
					 charMap[138]	=new CHARMAP("ü"	,	"Ë" );			
					 charMap[139]	=new CHARMAP("ý"	,	"ï" );			
					 charMap[140]	=new CHARMAP("þ"	,	"ò" );			
					 charMap[141]	=new CHARMAP("ÿ"	,	"|" );			
					 charMap[142]	=new CHARMAP("ì"	,	"s" );
                                         Arrays.sort(charMap, new CharMapComparator());
    }
    @Override 
	public String Convert(String inText) {
		// TODO Auto-generated method stub
	char buffer[] = (inText+"     ").toCharArray();

        StringBuilder sb = new StringBuilder();
        boolean madeOfMoreChars = true;

        int k = 0; // INDEX FOR BUFFER TRAVERSING
        boolean found = false;
			while(k < inText.length())
			{
				found = false;
				madeOfMoreChars = false;
						if((char)buffer[k] == '¤' && (char)buffer[k+1] == 'ì')
							{
								sb.append((char)113);
                                                                sb.append((char)115);
								madeOfMoreChars = true;
								k = k+2;
							}
							else
							if((char)buffer[k] == '¥' && (char)buffer[k+1] == 'ì')
							{
								sb.append((char)114);
                                                                sb.append((char)252);
								madeOfMoreChars = true;
								k = k+2;
							//	::MessageBox(NULL,"fdvfdv","fdvdvf",MB_OK);
							}
							else
							if((char)buffer[k] == '¹' && (char)buffer[k+1] == 'ì')
							{
								sb.append((char)122);
                                                                sb.append((char)115);
								madeOfMoreChars = true;
								k = k+2;
							}
							else
							if((char)buffer[k] == 'º' && (char)buffer[k+1] == 'ì')
							{
								sb.append((char)162);
                                                                sb.append((char)252);
								madeOfMoreChars = true;
								k = k+2;
							//	::MessageBox(NULL,"fdvfdv","fdvdvf",MB_OK);
							}
							else
							if((char)buffer[k] == 'Ã' && (char)buffer[k+1] == 'ì')
							{
								sb.append((char)168);
                                                                sb.append((char)115);
								madeOfMoreChars = true;
								k = k+2;
							}
							else
							if((char)buffer[k] == 'Å' && (char)buffer[k+1] == 'ì')
							{
								sb.append((char)169);
                                                                sb.append((char)252);
								madeOfMoreChars = true;
								k = k+2;
							}
							else
							if((char)buffer[k] == '¿' && (char)buffer[k+1] == 'ì')
							{
								sb.append((char)165);
                                                                sb.append((char)115);
								madeOfMoreChars = true;
								k = k+2;
							}
							else
							if((char)buffer[k] == 'À' && (char)buffer[k+1] == 'ì')
							{
								sb.append((char)166);
                                                                sb.append((char)252);
								madeOfMoreChars = true;
								k = k+2;
							}
							else
							if((char)buffer[k] == '¦' && (char)buffer[k+1] == 'í')
							{
								sb.append((char)217);
								madeOfMoreChars = true;
								k = k+2;
							}
							else
							
							if((char)buffer[k] == '»' && (char)buffer[k+1] == 'í')
							{
								sb.append((char)222);
								madeOfMoreChars = true;
								k = k+2;
							}
							else
							if((char)buffer[k] == 'Á' && (char)buffer[k+1] == 'í')
							{
								sb.append((char)225);
								madeOfMoreChars = true;
								k = k+2;
							}
							else
							if((char)buffer[k] == 'Æ' && (char)buffer[k+1] == 'í')
							{
								sb.append((char)227);
								madeOfMoreChars = true;
								k = k+2;
							}
							else
							if((char)buffer[k] == 'à' && (char)buffer[k+1] == 'í')
							{
								sb.append((char)104);
								madeOfMoreChars = true;
								k = k+2;
							}
							else///////////////////////////if not in above case ie; if character is not made of 2 characters
                                                        {
                                                              StringBuilder temp = null;                                                            
                                                              temp = new StringBuilder();
                                                              temp.append(buffer[k]);
                                                            for(int i=0;i<charMap.length && found == false ;i++)
                                                            {
								if( charMap[i].textProp.equals(temp.toString())) 
									{ 
										found = true ;
										int j=0;
										int flag = 0;
                                                                                sb.append(charMap[i].textStd);
									}
                                                            }
                                                        }
			
				if(!found)
				{
					sb.append(buffer[k]); //If not in Table
				}

				if(madeOfMoreChars != true)
				k++;//Set to next element in buffer
			 }
                        return sb.toString();
}
}
