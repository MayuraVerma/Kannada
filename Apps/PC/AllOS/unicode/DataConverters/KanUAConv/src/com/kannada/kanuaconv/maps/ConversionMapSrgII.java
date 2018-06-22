package com.kannada.kanuaconv.maps;

import com.kannada.kanuaconv.maps.CharacterMap.CHARMAP;
import java.util.Arrays;

public class ConversionMapSrgII extends ConversionMapSRG {

public static CHARMAP[] charMap=new CHARMAP[245];

public ConversionMapSrgII(){
    initializeMap();
}
public void initializeMap() {
	        charMap[0]=new CHARMAP( " ", " ");
			charMap[1]=new CHARMAP( "!", "!");
			charMap[2]=new CHARMAP( "\"", "J");
			charMap[3]=new CHARMAP( "#", "Ûø" );
			charMap[4]=new CHARMAP( "$", "æöÊ");
			charMap[5]=new CHARMAP( "%", "%");
			charMap[6]=new CHARMAP( "&", "×");
			charMap[7]=new CHARMAP( "\'" , "O");
			charMap[8]=new CHARMAP( "(", "(");
			charMap[9]=new CHARMAP( ")", ")");
			charMap[10]=new CHARMAP( "*", "*");
			charMap[11]=new CHARMAP( "+", "+");
			charMap[12]=new CHARMAP( "-", "-");
			charMap[13]=new CHARMAP( ".", ".");
			charMap[14]=new CHARMAP( "/", "/");
			charMap[15]=new CHARMAP( "0", "0");
			charMap[16]=new CHARMAP( "1", "1");
			charMap[17]=new CHARMAP( "2", "2");
			charMap[18]=new CHARMAP( "3", "3");
			charMap[19]=new CHARMAP( "4", "4");
			charMap[20]=new CHARMAP( "5", "5");
			charMap[21]=new CHARMAP( "6", "6");
			charMap[22]=new CHARMAP( "7", "7");
			charMap[23]=new CHARMAP( "8", "8");
			charMap[24]=new CHARMAP( "9", "9");
			charMap[25]=new CHARMAP( ":", ":");
			charMap[26]=new CHARMAP( ";", ";");
			charMap[27]=new CHARMAP( "<", "‘");
			charMap[28]=new CHARMAP( "=", "=");
			charMap[29]=new CHARMAP( ">", "’");
			charMap[30]=new CHARMAP( "?", "?");
			charMap[31]=new CHARMAP( "@", "¢");
			charMap[32]=new CHARMAP( "A", "Á");
			charMap[33]=new CHARMAP( "B", "É");
			charMap[34]=new CHARMAP( "C", "Ã");
			charMap[35]=new CHARMAP( "D", "Ä");
			charMap[36]=new CHARMAP( "E", "Ê");
			charMap[37]=new CHARMAP( "F", "ï");
			charMap[38]=new CHARMAP( "G", "É");
			charMap[39]=new CHARMAP( "H", "Ë");
			charMap[40]=new CHARMAP( "I", "A");
			charMap[41]=new CHARMAP( "J", "B");
			charMap[42]=new CHARMAP( "K", "i");
			charMap[43]=new CHARMAP( "L", "h");
			charMap[44]=new CHARMAP( "M", "Û");
			charMap[45]=new CHARMAP( "N", "ß");
			charMap[46]=new CHARMAP( "O", "ä");
			charMap[47]=new CHARMAP( "P", "Æ");
			charMap[48]=new CHARMAP( "Q", "å");
			charMap[49]=new CHARMAP( "R", "æ");
			charMap[50]=new CHARMAP( "S", "è");
			charMap[51]=new CHARMAP( "T", "ð");
			charMap[52]=new CHARMAP( "U", "ò");
			charMap[53]=new CHARMAP( "V", "È");
			charMap[54]=new CHARMAP( "W", "AiÉÄ" );
			charMap[55]=new CHARMAP( "Y", "Å");
			charMap[56]=new CHARMAP( "Z", "Ç");
			charMap[57]=new CHARMAP( "[", "Ûæ" );
			charMap[58]=new CHARMAP( "\\","èç");
			charMap[59]=new CHARMAP("]",  "iï" );
			charMap[60]=new CHARMAP( "^", "ñ");
			charMap[61]=new CHARMAP( "_", "IÄ");
			charMap[62]=new CHARMAP("`",  "P");
			charMap[63]=new CHARMAP( "a", "U");
			charMap[64]=new CHARMAP( "b", "Z");
			charMap[65]=new CHARMAP( "c", "o");
			charMap[66]=new CHARMAP( "d", "q");
			charMap[67]=new CHARMAP( "e", "u");
			charMap[68]=new CHARMAP( "f", "v");
			charMap[69]=new CHARMAP( "g", "x");
			charMap[70]=new CHARMAP( "h", "z");
			charMap[71]=new CHARMAP( "i", "£");
			charMap[72]=new CHARMAP( "j", "¥");
			charMap[73]=new CHARMAP( "k", "g");
			charMap[74]=new CHARMAP( "l", "ª");
			charMap[75]=new CHARMAP( "m", "±");
			charMap[76]=new CHARMAP( "n", "µ");
			charMap[77]=new CHARMAP( "o", "¸");
			charMap[78]=new CHARMAP( "p", "º");
			charMap[79]=new CHARMAP( "q", "¼");
			charMap[80]=new CHARMAP( "r", "b");
			charMap[81]=new CHARMAP( "s", "qs" );
			charMap[82]=new CHARMAP( "t", "zs");
			charMap[83]=new CHARMAP("u", "¥s");
			charMap[84]=new CHARMAP("v", "¨s" );
			charMap[85]=new CHARMAP( "w", "Pë");
			charMap[86]=new CHARMAP("x", "ÐÕ");
			charMap[87]=new CHARMAP("y",  "Í");
			charMap[88]=new CHARMAP( "z", "R");
			charMap[89]=new CHARMAP( "x", "Ð");
			charMap[90]=new CHARMAP( "|", "ÀÛöå");
			charMap[91]=new CHARMAP( "}", "æ");
			charMap[92]=new CHARMAP( "~", "a");
			charMap[93]=new CHARMAP( "", "D");
			charMap[94]=new CHARMAP( "", "IÆ");
			charMap[95]=new CHARMAP("",  "ªÉÄ" );
			charMap[96]=new CHARMAP( "", "X");
			charMap[97]=new CHARMAP( " ", "a");
			charMap[98]=new CHARMAP( "¡", "Ó");
			charMap[99]=new CHARMAP( "¢", "d");
			charMap[100]=new CHARMAP( "£", "f");
			charMap[101]=new CHARMAP( "¤"   ,   "Ö" );
			charMap[102]=new CHARMAP( "¥", "l");
			charMap[103]=new CHARMAP( "¦", "n");
			charMap[104]=new CHARMAP( "§", "×");
			charMap[105]=new CHARMAP( "¨", "oÀ");
			charMap[106]=new CHARMAP("©",  "p");
			charMap[107]=new CHARMAP( "ª", "Ø");
			charMap[108]=new CHARMAP( "«", "qÀ");
			charMap[109]=new CHARMAP("¬",  "r");
			charMap[110]=new CHARMAP( "­", "Ú");
			charMap[111]=new CHARMAP( "®", "t");
			charMap[112]=new CHARMAP( "¯", "tÂ" );
			charMap[113]=new CHARMAP( "°", "vÀ");
			charMap[114]=new CHARMAP("±",  "w");
			charMap[115]=new CHARMAP( "²", "Ü");
			charMap[116]=new CHARMAP( "³", "xÀ");
			charMap[117]=new CHARMAP("´" , "y");
			charMap[118]=new CHARMAP( "µ", "Ý");
			charMap[119]=new CHARMAP( "¶", "zÀ");
			charMap[120]=new CHARMAP("¸", "£À");
			charMap[121]=new CHARMAP("¹",  "¤");
			charMap[122]=new CHARMAP( "º", "à");
			charMap[123]=new CHARMAP( "»", "¥À");
			charMap[124]=new CHARMAP("¼", "¦");
			charMap[125]=new CHARMAP( "½", "â");
			charMap[126]=new CHARMAP( "¾", "§");
			charMap[127]=new CHARMAP( "¿", "©");
			charMap[128]=new CHARMAP( "À", "ªÀÄ" );
			charMap[129]=new CHARMAP( "Á", "«Ä");
			charMap[130]=new CHARMAP("Â", "AiÀÄ" );
			charMap[131]=new CHARMAP( "Ã", "¬Ä");
			charMap[132]=new CHARMAP("Ä", "gÀ");
			charMap[133]=new CHARMAP("Å", "j");
			charMap[134]=new CHARMAP( "Æ", "®");
			charMap[135]=new CHARMAP( "Ç", "°");
			charMap[136]=new CHARMAP( "È", "é");
			charMap[137]=new CHARMAP( "É", "ªÀ");
			charMap[138]=new CHARMAP("Ê", "«");
			charMap[139]=new CHARMAP( "Ë", "±À" );
			charMap[140]=new CHARMAP( "Ì", "²");
			charMap[141]=new CHARMAP( "Í", "ë");
			charMap[142]=new CHARMAP( "Î", "µÀ" );
			charMap[143]=new CHARMAP( "Ï", "¶");
			charMap[144]=new CHARMAP( "Ð", "ì" );
			charMap[145]=new CHARMAP( "Ñ", "¸À" );
			charMap[146]=new CHARMAP( "Ò", "¹");
			charMap[147]=new CHARMAP( "Ó", "í");
			charMap[148]=new CHARMAP( "Ô", "ºÀ" );
			charMap[149]=new CHARMAP( "Õ", "»");
			charMap[150]=new CHARMAP( "Ö","î");
			charMap[151]=new CHARMAP( "×", "¼À" );
			charMap[152]=new CHARMAP( "Ø", "½");
			charMap[153]=new CHARMAP( "Ù", "dÕ");
			charMap[154]=new CHARMAP("Ú", "ªÀÅ" );
			charMap[155]=new CHARMAP( "Û", "¥ÀÅ" );
			charMap[156]=new CHARMAP( "Ü", "á");
			charMap[157]=new CHARMAP( "Ý", "bÀ" );
			charMap[158]=new CHARMAP( "Þ", "c");
			charMap[159]=new CHARMAP( "ß", "Ù");
			charMap[160]=new CHARMAP( "à", "qsÀ" );
			charMap[161]=new CHARMAP( "á", "rü");
			charMap[162]=new CHARMAP("â", "Þ");
			charMap[163]=new CHARMAP( "ã", "zsÀ" );
			charMap[164]=new CHARMAP( "ä", "¢ü");
			charMap[165]=new CHARMAP("å", "á");
			charMap[166]=new CHARMAP( "æ", "¥sÀ" );
			charMap[167]=new CHARMAP( "ç", "¦ü");
			charMap[168]=new CHARMAP("è", "ã");
			charMap[169]=new CHARMAP( "é", "¨sÀ" );
			charMap[170]=new CHARMAP( "ê", "©ü");
			charMap[171]=new CHARMAP("ë", "gÀhÄ" );
			charMap[172]=new CHARMAP( "ì", "jhÄ" );
			charMap[173]=new CHARMAP( "í", "PÀë" );
			charMap[174]=new CHARMAP( "î", "Që" );
			charMap[175]=new CHARMAP( "ï", "|");
			charMap[176]=new CHARMAP( "ð", "k");
			charMap[177]=new CHARMAP( "ñ", "Y");
			charMap[178]=new CHARMAP( "ò", "Õ");
			charMap[179]=new CHARMAP( "ó", "ê");
			charMap[180]=new CHARMAP( "ô", "WÀ");
			charMap[181]=new CHARMAP("õ", "Ô");
			charMap[182]=new CHARMAP( "ö", "Öç" );
			charMap[183]=new CHARMAP( "÷", "²ç");
			charMap[184]=new CHARMAP("ø", "ªÀÇ" );
			charMap[185]=new CHARMAP( "ù", "ZÀ" );
			charMap[186]=new CHARMAP( "ú", "¥ÀÆ" );
			charMap[187]=new CHARMAP( "û", "m");
			charMap[188]=new CHARMAP( "ü", "¥sÀÅ" );
			charMap[189]=new CHARMAP( "ý", "¥sÀÇ" );
			charMap[190]=new CHARMAP( "þ", "C");
			charMap[191]=new CHARMAP( "ÿ", "„");
			charMap[192]=new CHARMAP( "Œ", "IÄ");
			charMap[193]=new CHARMAP("œ", "WÀ");
			charMap[194]=new CHARMAP("Š", "N");
			charMap[195]=new CHARMAP( "š", "V");
			charMap[196]=new CHARMAP( "Ÿ", "ZÀ");
			charMap[197]=new CHARMAP("ƒ", "F");
			charMap[198]=new CHARMAP( "ˆ", "L");
			charMap[199]=new CHARMAP( "˜", "Î");
			charMap[200]=new CHARMAP( "–", "R");
			charMap[201]=new CHARMAP( "—", "T");
			charMap[202]=new CHARMAP( "‘", "AiÉÄ" );
			charMap[203]=new CHARMAP( "’", "Ì");
			charMap[204]=new CHARMAP( "‚", "E");
			charMap[205]=new CHARMAP( "“", "PÀ" );
			charMap[206]=new CHARMAP( "”", "Q");
			charMap[207]=new CHARMAP( "„", "G");
			charMap[208]=new CHARMAP( "†", "J");
			charMap[209]=new CHARMAP( "‡", "K");
			charMap[210]=new CHARMAP( "•", "Í");
			charMap[211]=new CHARMAP( "…", "H");
			charMap[212]=new CHARMAP( "‰", "M");
			charMap[213]=new CHARMAP( "‹", "O");
			charMap[214]=new CHARMAP( "›", "Ï");
			charMap[215]=new CHARMAP( "™", "UÀ" );
			charMap[216]=new CHARMAP( "·", "¢");
			charMap[217]=new CHARMAP( "X", " ");
			charMap[218]=new CHARMAP( "ÿ", "„");
			charMap[219]=new CHARMAP( "€", "C");
			charMap[220]=new CHARMAP( "ž", "Ñ");
			charMap[221]=new CHARMAP( "Ž", "W");
                        
                        charMap[224]=new CHARMAP("","M");
                      charMap[225]=new CHARMAP("","V");
                      charMap[226]=new CHARMAP("","PÀ");
                      charMap[227]=new CHARMAP("","F");
                      
                      charMap[228]=new CHARMAP("","ZÀ");
                      charMap[229]=new CHARMAP("Ö","F");
                      charMap[230]=new CHARMAP("","Ñ");
                      charMap[231]=new CHARMAP("","L");
                      
                      charMap[232]=new CHARMAP("™","UÀ");
                      charMap[233]=new CHARMAP("˜","Î");
                      charMap[234]=new CHARMAP("’","Ì");
                      charMap[235]=new CHARMAP("†","J");
                      charMap[236]=new CHARMAP("‚","E");
                      charMap[237]=new CHARMAP(" "," ");
                      charMap[238]=new CHARMAP("”","Q");
                      
                      
                       charMap[239]=new CHARMAP("\b","\b");
                       charMap[240]=new CHARMAP("\t","\t");
                      // charMap[242]=new CHARMAP("\v","\v");
                       charMap[241]=new CHARMAP("\f","\f");
                       charMap[242]=new CHARMAP("\r","\r");
                       charMap[243]=new CHARMAP("\0","\0");
                       //charMap[246]=new CHARMAP("\c","\c");
                       //charMap[247]=new CHARMAP("\a","\a");
                       //charMap[248]=new CHARMAP("\s","\s");
                       //charMap[249]=new CHARMAP("\e","\e");
                       charMap[244]=new CHARMAP("\n","\n");
                       
                       Arrays.sort(charMap, new CharMapComparator());
}

@Override
	public String Convert(String inText) {
		// TODO Auto-generated method stub
	char buffer[] = inText.toCharArray();
	boolean madeOfMoreChars = true;
	int k = 0; // INDEX FOR BUFFER TRAVERSING 
	boolean found = false;
	StringBuilder sb = new StringBuilder();
        StringBuilder temp = null;
        
			while(buffer[k]!= -1)
			{
				found = false;
				madeOfMoreChars = false;

							//–	A	 G	H 
							if( (char)buffer[k] == '–' && ( (char)buffer[k+1] == 'A' || 
															(char)buffer[k+1] == 'G' || 
															(char)buffer[k+1] == 'H'
														  )
							  ) 
							{
								found = true; ;
								sb.append("S");
								madeOfMoreChars = true;
								k = k+1;
							}else
							//–	V
							if( (char)buffer[k] == '–' && (char)buffer[k+1] == 'V'  
							  ) 
							{
								found = true; ;
								sb.append("SÈ");
								madeOfMoreChars = true;
								k = k+2;
							}else
							//¢	A	 G	H		¢	V
							if( (char)buffer[k] == '¢' && ( (char)buffer[k+1] == 'A' || 
															(char)buffer[k+1] == 'G' || 
															(char)buffer[k+1] == 'H'
														  )
							  ) 
							{
								found = true; ;
								sb.append("e");
								madeOfMoreChars = true;
								k = k+1;
							}else
							//V
							if( (char)buffer[k] == '¢' && (char)buffer[k+1] == 'V'  
							  ) 
							{
								found = true; ;
								sb.append("eÈ");
								madeOfMoreChars = true;
								k = k+2;
							}else
							//¾	A	 G	H		¾	V
							if( (char)buffer[k] == '¾' && ( (char)buffer[k+1] == 'A' || 
															(char)buffer[k+1] == 'G' || 
															(char)buffer[k+1] == 'H'
														  )
							  ) 
							{
								found = true; ;
								sb.append("¨");
								madeOfMoreChars = true;
								k = k+1;
							}else
							//V
							if( (char)buffer[k] == '¾' && (char)buffer[k+1] == 'V'  
							  ) 
							{
								found = true; ;
								sb.append("¨È");
								madeOfMoreChars = true;
								k = k+2;
							}else
							//Æ	A	 G	H		Æ	V
							if( (char)buffer[k] == 'Æ' && ( (char)buffer[k+1] == 'A' || 
															(char)buffer[k+1] == 'G' || 
															(char)buffer[k+1] == 'H'
														  )
							  ) 
							{
								found = true; ;
								sb.append("¯");
								madeOfMoreChars = true;
								k = k+1;
							}else
							//V
							if( (char)buffer[k] == 'Æ' && (char)buffer[k+1] == 'V' 
							  ) 
							{
								found = true; ;
								sb.append("¯È");
								madeOfMoreChars = true;
								k = k+2;
							}else
							//Ù	A	 G	H		Ù	V
							if( (char)buffer[k] == 'Ù' && ( (char)buffer[k+1] == 'A' || 
															(char)buffer[k+1] == 'G' || 
															(char)buffer[k+1] == 'H'
														  )
							  ) 
							{
								found = true; ;
								sb.append("eÕ");
								madeOfMoreChars = true;
								k = k+1;
							}else
							//V
							if( (char)buffer[k] == 'Ù' && (char)buffer[k+1] == 'V'  
							  ) 
							{
								found = true; ;
								sb.append("eÕÈ");
								madeOfMoreChars = true;
								k = k+2;
							}else
							//w	A	 G	H		í	V
							if( (char)buffer[k] == 'w' && ( (char)buffer[k+1] == 'A' || 
															(char)buffer[k+1] == 'G' || 
															(char)buffer[k+1] == 'H'
														  )
							  ) 
							{
								found = true; ;
								sb.append("Pë");
								madeOfMoreChars = true;
								k = k+1;
							}else
							//V
							if( (char)buffer[k] == 'w' && (char)buffer[k+1] == 'V'  
							  ) 
							{
								found = true; ;
								sb.append("PëÈ");
								madeOfMoreChars = true;
								k = k+2;
							}else
							//Â		A	 G	H		í	V
							if( (char)buffer[k] == 'Â' && ( (char)buffer[k+1] == 'A' )
							  ) 
							{
								found = true; ;
								sb.append("AiÀi");  //Á
								madeOfMoreChars = true;
								k = k+1;
							}else
							//ëA
							if( (char)buffer[k] == 'ë' && (char)buffer[k+1] == 'A' 
							  ) 
							{
								found = true; ;
								sb.append("gÀhiÁ");
								madeOfMoreChars = true;
								k = k+2;
							}else
							//ÀA
							if( (char)buffer[k] == 'À' && (char)buffer[k+1] == 'A'  
							  ) 
							{
								found = true; ;
								sb.append("ªÀiÁ");
								madeOfMoreChars = true;
								k = k+2;
							}else
							//ÁA 
							if( (char)buffer[k] == 'Á' && (char)buffer[k+1] == 'A' 
														  ) 
							{
								found = true; ;
								sb.append("«iÁ");
								madeOfMoreChars = true;
								k = k+2;
							}else
							//[ 
							if( (char)buffer[k] == '[') 
							{
								found = true; ;
								sb.append("Ûç");
								madeOfMoreChars = true;
								k = k+2;
							}else
							// ËRD  ËRD
							if( (char)buffer[k] == 'Ë' &&  (char)buffer[k+1] == 'R' && (char)buffer[k+2] == 'D' ) 
							{
								found = true; ;
								sb.append("±ÀÄæ");
								madeOfMoreChars = true;
								k = k+3;
							}else
							//<<
							if( (char)buffer[k] == '<' &&  (char)buffer[k+1] == '<') 
							{
								found = true; ;
								sb.append("“");
								madeOfMoreChars = true;
								k = k+2;
							}else//>>
							if( (char)buffer[k] == '>' &&  (char)buffer[k+1] == '>') 
							{
								found = true; ;
								sb.append("”");
								madeOfMoreChars = true;
								k = k+2;
							}else///////////////////////////if not in above case ie; if character is not made of 2 characters
                                                        {
                                                        temp = new StringBuilder();
                                                        temp.append(buffer[k]);
                                                        for(int i=0;i<charMap.length;i++)
                                                        {
                                                                if( charMap[i].textProp.equals(temp.toString())) 
                                                                        {  
                                                                                found = true ;
                                                                                sb.append(charMap[i].textStd);
                                                                        }
                                                        }
                                                        }
				if(!found)
                                {
                                        sb.append(buffer[k]); //If not in Table
                                }

                                if(madeOfMoreChars != true)
                                {
                                        k++;//Set to next element in buffer
                                }
			 }
                        return sb.toString();
            }
}
