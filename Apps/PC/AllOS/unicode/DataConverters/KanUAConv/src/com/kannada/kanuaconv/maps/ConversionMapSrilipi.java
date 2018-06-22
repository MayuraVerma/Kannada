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
public class ConversionMapSrilipi extends ConversionMap implements CharacterMap{
    
    public static CHARMAP[] charMap=new CHARMAP[149];
    
    public  ConversionMapSrilipi(){
    initializeMap();
}
    public void initializeMap(){
//TODOAuto-generatedmethodstub
					 charMap[0]	=new CHARMAP("@" , "AiÀ");
					 charMap[1]	=new CHARMAP("A" , "Y");				
					 charMap[2]	=new CHARMAP("B" , "º");				
					 charMap[3]	=new CHARMAP("C" , "Â");				
					 charMap[4]	=new CHARMAP("D" , "5");				
					 charMap[5]	=new CHARMAP("E" , "Ë");				
					 charMap[6]	=new CHARMAP("F" , "¥");				
					 charMap[7]	=new CHARMAP("G" , "iÁ");		
					 charMap[8]	=new CHARMAP("H" , "Þ");				
					 charMap[9]	=new CHARMAP("I" , "Å");				
					 charMap[10]	=new CHARMAP("J" , "WÀ");		
					 charMap[11]	=new CHARMAP("K" , "W");				
					 charMap[12]	=new CHARMAP("L" , "d");				
					 charMap[13]	=new CHARMAP("M" , "m");				
					 charMap[14]	=new CHARMAP("N" , "à");				
					 charMap[15]	=new CHARMAP("O" , "c");				
					 charMap[16]	=new CHARMAP("P" , "²æ");		
					 charMap[17]	=new CHARMAP("Q" , "Ìø");		
					 charMap[18]	=new CHARMAP("R" , "Ù");				
					 charMap[19]	=new CHARMAP("T" , "í");				
					 charMap[20]	=new CHARMAP("U" , "n");				
					 charMap[21]	=new CHARMAP("V" , "G");				
					 charMap[22]	=new CHARMAP("W" , "ï");				
					 charMap[23]	=new CHARMAP("X" , "Æ");				
					 charMap[24]	=new CHARMAP("Y" , "H");				
					 charMap[25]	=new CHARMAP("Z" , "ä");				
					 charMap[26]	=new CHARMAP("[" , "©");				
					 charMap[27]	=new CHARMAP("\\" , "AiÉ");
					 charMap[28]	=new CHARMAP("]" , "tÂ");		
					 charMap[29]	=new CHARMAP("^" , "C");				
					 charMap[30]	=new CHARMAP("_" , "R");				
					 charMap[31]	=new CHARMAP("`" , "¤");				
					 charMap[32]	=new CHARMAP("a" , "Ü");				
					 charMap[33]	=new CHARMAP("c" , "0");				
					 charMap[34]	=new CHARMAP("d" , "Ø");				
					 charMap[35]	=new CHARMAP("e" , "f");				
					 charMap[36]	=new CHARMAP("f" , "B");				
					 charMap[37]	=new CHARMAP("g" , "X");				
					 charMap[38]	=new CHARMAP("h" , "i");				
					 charMap[39]	=new CHARMAP("j" , "ã");				
					 charMap[40]	=new CHARMAP("k" , "9");				
					 charMap[41]	=new CHARMAP("l" , "h");				
					 charMap[42]	=new CHARMAP("m" , "A");				
					 charMap[43]	=new CHARMAP("n" , "J");				
					 charMap[44]	=new CHARMAP("o" , "T");				
					 charMap[45]	=new CHARMAP("p" , "a");				
					 charMap[46]	=new CHARMAP("q" , "Q");				
					 charMap[47]	=new CHARMAP("r" , "õ");				
					 charMap[48]	=new CHARMAP("s" , "S");				
					 charMap[49]	=new CHARMAP("Ó" , "Ä");				
					 charMap[50]	=new CHARMAP("Ô" , "j");				
					 charMap[51]	=new CHARMAP("Õ" , "Í");				
					 charMap[52]	=new CHARMAP("Ö" , "õÉ");		
					 charMap[53]	=new CHARMAP("Ø" , "Ú");				
					 charMap[54]	=new CHARMAP("Ú" , "Ò");				
					 charMap[55]	=new CHARMAP("Û" , "Ý");				
					 charMap[56]	=new CHARMAP("Ý" , "Z");				
					 charMap[57]	=new CHARMAP("Þ" , "u");				
					 charMap[58]	=new CHARMAP("ß" , "V");				
					 charMap[59]	=new CHARMAP("à" , "F");				
					 charMap[60]	=new CHARMAP("á" , "Ã");				
					 charMap[61]	=new CHARMAP("â" , "Ö");				
					 charMap[62]	=new CHARMAP("ã" , "É");				
					 charMap[63]	=new CHARMAP("ä" , "Ó");				
					 charMap[64]	=new CHARMAP("å" , "Ûø");		
					 charMap[65]	=new CHARMAP("æ" , "Á");				
					 charMap[66]	=new CHARMAP("ç" , "á");				
					 charMap[67]	=new CHARMAP("è" , "WÉ");		
					 charMap[68]	=new CHARMAP("é" , "ÛÊ");		
					 charMap[69]	=new CHARMAP("ê" , "6");				
					 charMap[70]	=new CHARMAP("ë" , "N");				
					 charMap[71]	=new CHARMAP("ì" , "«");				
					 charMap[72]	=new CHARMAP("í" , "®");				
					 charMap[73]	=new CHARMAP("î" , "¨");				
					 charMap[74]	=new CHARMAP("ð" , "L");				
					 charMap[75]	=new CHARMAP("ñ" , "Ûç");		
					 charMap[76]	=new CHARMAP("ò" , "Û");				
					 charMap[77]	=new CHARMAP("ó" , "Õ");				
					 charMap[78]	=new CHARMAP("ô" , "E");				
					 charMap[79]	=new CHARMAP("õ" , "Ï");				
					 charMap[80]	=new CHARMAP("ö" , "P");				
					 charMap[81]	=new CHARMAP("÷" , "»");				
					 charMap[82]	=new CHARMAP("ø" , "°");				
					 charMap[83]	=new CHARMAP("ù" , "è");				
					 charMap[84]	=new CHARMAP("ú" , "v");				
					 charMap[85]	=new CHARMAP("û" , "q");				
					 charMap[86]	=new CHARMAP("ü" , "ë");				
					 charMap[87]	=new CHARMAP("þ" , "w");				
					 charMap[88]	=new CHARMAP("t" , "å");				
					 charMap[89]	=new CHARMAP("u" , "M");				
					 charMap[90]	=new CHARMAP("v" , "æ");				
					 charMap[91]	=new CHARMAP("w" , "t");				
					 charMap[92]	=new CHARMAP("x" , "é");				
					 charMap[93]	=new CHARMAP("y" , "Ì");				
					 charMap[94]	=new CHARMAP("z" , "±");				
					 charMap[95]	=new CHARMAP("{" , "¼");				
					 charMap[96]	=new CHARMAP("|" , "¢");				
					 charMap[97]	=new CHARMAP("}" , "Ê");				
					 charMap[98]	=new CHARMAP("~" , "g");				
					 charMap[99]	=new CHARMAP("¡" , "¦");				
					 charMap[100]	=new CHARMAP("¢" , "ò");				
					 charMap[101]	=new CHARMAP("£" , "Ô");				
					 charMap[102]	=new CHARMAP("¤" , "¯");				
					 charMap[103]	=new CHARMAP("¥" , "×");				
					 charMap[104]	=new CHARMAP("¦" , "r");				
					 charMap[105]	=new CHARMAP("¨" , "3");				
					 charMap[106]	=new CHARMAP("©" , "£");				
					 charMap[107]	=new CHARMAP("ª" , "O");				
					 charMap[108]	=new CHARMAP("«" , "À");				
					 charMap[109]	=new CHARMAP("¬" , "z");				
					 charMap[110]	=new CHARMAP("­" , "ß");				
					 charMap[111]	=new CHARMAP("®" , "-");				
					 charMap[112]	=new CHARMAP("¯" , "4");				
					 charMap[113]	=new CHARMAP("°" , "ìç");		
					 charMap[114]	=new CHARMAP("±" , "D");				
					 charMap[115]	=new CHARMAP("²" , "æø");		
					 charMap[116]	=new CHARMAP("³" , "¸");				
					 charMap[117]	=new CHARMAP("µ" , "k");				
					 charMap[118]	=new CHARMAP("¶" , "àç");		
					 charMap[119]	=new CHARMAP("·" , "U");				
					 charMap[120]	=new CHARMAP("¸" , "§");				
					 charMap[121]	=new CHARMAP("º" , "Î");				
					 charMap[122]	=new CHARMAP("»" , "½");				
					 charMap[123]	=new CHARMAP("¼" , "e");				
					 charMap[124]	=new CHARMAP("½" , "1");				
					 charMap[125]	=new CHARMAP("¾" , "Ûå");		
					 charMap[126]	=new CHARMAP("¿" , "2");				
					 charMap[127]	=new CHARMAP("À" , "l");				
					 charMap[128]	=new CHARMAP("Á" , "Y");				
					 charMap[129]	=new CHARMAP("Â" , "ê");				
					 charMap[130]	=new CHARMAP("Ã" , "ì");				
					 charMap[131]	=new CHARMAP("Ä" , "ª");				
					 charMap[132]	=new CHARMAP("Å" , "¬");				
					 charMap[133]	=new CHARMAP("Ç" , "Ç");				
					 charMap[134]	=new CHARMAP("È" , "È");				
					 charMap[135]	=new CHARMAP("É" , "È");				
					 charMap[136]	=new CHARMAP("Ê" , "î");				
					 charMap[137]	=new CHARMAP("Ë" , "b");				
					 charMap[138]	=new CHARMAP("Ì" , "Öç");		
					 charMap[139]	=new CHARMAP("Í" , "²");				
					 charMap[140]	=new CHARMAP("Î" , "ð");				
					 charMap[141]	=new CHARMAP("Ï" , "I");				
					 charMap[142]	=new CHARMAP("Ð" , "Ñ");				
					 charMap[143]	=new CHARMAP("Ñ" , "ÑÊ");		
					 charMap[144]	=new CHARMAP("Ò" , "K");				
					 charMap[145]	=new CHARMAP("§" , "¹");
					 charMap[146]	=new CHARMAP("b" , " ");				
					 charMap[147]	=new CHARMAP("&" , "†");		
                                         charMap[148]	=new CHARMAP("•" , "U");
                                         
                                         Arrays.sort(charMap, new CharMapComparator());
}

@Override 
	public String Convert(String inText) {
		// TODO Auto-generated method stub
	char buffer[] = (inText+"      ").toCharArray();
        boolean found = false;
	StringBuilder sb = new StringBuilder();

        boolean madeOfMoreChars = true;
			int k = 0; // INDEX FOR BUFFER TRAVERSING 
			while(k<inText.length())
			{
				found = false;
				madeOfMoreChars = false;
							if((char)buffer[k] == 'S' && (char)buffer[k+1] == '|')
							{
								found = true; ;
								sb.append((char)121);
								madeOfMoreChars = true;
								k = k+2;
							}
							else
							if((char)buffer[k] == 'S' && (char)buffer[k+1] == '¬')
							{
								found = true; ;
								sb.append((char)120);
								madeOfMoreChars = true;
								k = k+2;
								//::MessageBox(NULL,"fdvfdv","fdvdvf",MB_OK);
							}
							else
							if((char)buffer[k] == '×' && (char)buffer[k+1] == '¬')
							{
								found = true; ;
								sb.append((char)122);
                                                                sb.append((char)115);
								madeOfMoreChars = true;
								k = k+2;
							}
							else
							if((char)buffer[k] == '×' && (char)buffer[k+1] == '|')
							{
								found = true; ;
								sb.append((char)162);
                                                                sb.append((char)252);
								madeOfMoreChars = true;
								k = k+2;
							//	::MessageBox(NULL,"fdvfdv","fdvdvf",MB_OK);
							}
							else
							if((char)buffer[k] == 'Ü' && (char)buffer[k+1] == '¦')
							{
								found = true; 
								sb.append((char)114);
                                                                sb.append((char)252);
								madeOfMoreChars = true;
								k = k+2;
							}
							else
							if((char)buffer[k] == 'Ü' && (char)buffer[k+1] == 'û')
							{
								found = true; ;
								sb.append((char)113);
                                                                sb.append((char)115);
								madeOfMoreChars = true;
								k = k+2;
							}
							else
							if((char)buffer[k] == '´' && (char)buffer[k+1] == 'î')
							{
								found = true; ;
								sb.append((char)168);
                                                                sb.append((char)115);
								madeOfMoreChars = true;
								k = k+2;
							}
							else
							if((char)buffer[k] == '´' && (char)buffer[k+1] == '[')
							{
								found = true; ;
								sb.append((char)169);
                                                                sb.append((char)252);
								madeOfMoreChars = true;
								k = k+2;
							}
							else
							if((char)buffer[k] == 'i' && (char)buffer[k+1] == 'F')
							{
								found = true; ;
								sb.append((char)165);
                                                                sb.append((char)115);
								madeOfMoreChars = true;
								k = k+2;
							}
							else
							if((char)buffer[k] == 'i' && (char)buffer[k+1] == '¡')
							{
								found = true; ;
								sb.append((char)166);
                                                                sb.append((char)252);
								madeOfMoreChars = true;
								k = k+2;
							}
							else
							if((char)buffer[k] == 'ï' && (char)buffer[k+1] == '~')
							{
								found = true; ;
								sb.append((char)111);
								madeOfMoreChars = true;
								k = k+2;
							}
							else
							if((char)buffer[k] == 'ï' && (char)buffer[k+1] == 'Ô')
							{
								found = true; ;
								sb.append((char)112);
								madeOfMoreChars = true;
								k = k+2;
							}
							else
							if((char)buffer[k] == 'Æ' && (char)buffer[k+1] == 'F')
							{
								found = true; ;
								sb.append((char)181);
								madeOfMoreChars = true;
								k = k+2;
							}
							else
							if((char)buffer[k] == 'Æ' && (char)buffer[k+1] == '¡')
							{
								found = true; ;
								sb.append((char)182);
								madeOfMoreChars = true;
								k = k+2;
							}
							else
							if((char)buffer[k] == 'F' && (char)buffer[k+1] == '«' && (char)buffer[k+2] == 'Ù')
							{
								found = true; ;
								sb.append((char)165);
                                                                sb.append((char)115);
                                                                sb.append((char)192);
                                                                sb.append((char)197);
								madeOfMoreChars = true;
								k = k+3;
							}
							else
							if((char)buffer[k] == 'F' && (char)buffer[k+1] == 'ã' && (char)buffer[k+2] == 'Ù')
							{
								found = true; ;
								sb.append((char)165);
                                                                sb.append((char)115);
                                                                sb.append((char)201);
                                                                sb.append((char)197);
								madeOfMoreChars = true;
								k = k+3;
							}
							else
							if((char)buffer[k] == 'F' && (char)buffer[k+1] == '«'&& (char)buffer[k+2] == '¹')
							{
								found = true; ;
								sb.append((char)165);
                                                                sb.append((char)115);
                                                                sb.append((char)192);
                                                                sb.append((char)199);
								madeOfMoreChars = true;
								k = k+3;
							}
							else
							if((char)buffer[k] == 'F' && (char)buffer[k+1] == 'ã'&& (char)buffer[k+2] == '¹')
							{
								found = true; ;
								sb.append((char)165);
                                                                sb.append((char)115);
                                                                sb.append((char)193);
                                                                sb.append((char)199);
								madeOfMoreChars = true;
								k = k+3;
							}
							else///////////////////////////if not in above case ie; if character is not made of 2 characters
                                                        {
                StringBuilder temp = null;                                                            
		temp = new StringBuilder();
                temp.append(buffer[k]);
                                                            
                                for(int i=0;i<charMap.length && found == false ;i++)
				{
					if(charMap[i].textProp.equals(temp.toString())) 
						{  
                                                       madeOfMoreChars = false;
							found = true; 
							int j=0;
							int flag = 0;
							System.out.println(i+" and "+k);
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

