package com.kannada.kanuaconv.maps;

import java.util.Arrays;

public class ConversionMapSRG extends ConversionMap implements CharacterMap{

public static CHARMAP[] charMap=new CHARMAP[245];

public ConversionMapSRG(){
    initializeMap();
}
public void initializeMap(){
//TODOAuto-generatedmethodstub
		      charMap[0]=new CHARMAP(" "," ");
                      charMap[1]=new CHARMAP("!","!");
                      charMap[2]=new CHARMAP("\"","J");
                      charMap[3]=new CHARMAP("#","K");
                      charMap[4]=new CHARMAP("$","L");
                      charMap[5]=new CHARMAP("%","M");
                      charMap[6]=new CHARMAP("&","N");
                      charMap[7]=new CHARMAP("\'","O");
                      charMap[8]=new CHARMAP("(","E");
                      charMap[9]=new CHARMAP(")","F");
                      charMap[10]=new CHARMAP("*","*");
                      charMap[11]=new CHARMAP("+","G");
                      charMap[12]=new CHARMAP(",",",");
                      charMap[13]=new CHARMAP("-","-");
                      charMap[14]=new CHARMAP(".",".");
                      charMap[15]=new CHARMAP("/","Î");
                      charMap[16]=new CHARMAP("0","0");
                      charMap[17]=new CHARMAP("1","1");
                      charMap[18]=new CHARMAP("2","2");
                      charMap[19]=new CHARMAP("3","3");
                      charMap[20]=new CHARMAP("4","4");
                      charMap[21]=new CHARMAP("5","5");
                      charMap[22]=new CHARMAP("6","6");
                      charMap[23]=new CHARMAP("7","7");
                      charMap[24]=new CHARMAP("8","8");
                      charMap[25]=new CHARMAP("9","9");
                      charMap[26]=new CHARMAP(":",";");
                      charMap[27]=new CHARMAP(";","PÀ");
                      charMap[28]=new CHARMAP("<","‘");
                      charMap[29]=new CHARMAP("=","=");
                      charMap[30]=new CHARMAP(">","’");
                      charMap[31]=new CHARMAP("?","V");
                      charMap[32]=new CHARMAP("@","¢");
                      charMap[33]=new CHARMAP("A","Á");
                      charMap[34]=new CHARMAP("B","É");
                      charMap[35]=new CHARMAP("C","Ã");
                      charMap[36]=new CHARMAP("D","Ä");
                      charMap[37]=new CHARMAP("E","Ê");
                      charMap[38]=new CHARMAP("F","ï");
                      charMap[39]=new CHARMAP("G","É");
                      charMap[40]=new CHARMAP("H","Ë");
                      charMap[41]=new CHARMAP("I","A");
                      charMap[42]=new CHARMAP("J","B");
                      charMap[43]=new CHARMAP("K","i");
                      charMap[44]=new CHARMAP("L","h");
                      charMap[45]=new CHARMAP("M","Û");
                      charMap[46]=new CHARMAP("N","ß");
                      charMap[47]=new CHARMAP("O","ä");
                      charMap[48]=new CHARMAP("P","Æ");
                      charMap[49]=new CHARMAP("Q","å");
                      charMap[50]=new CHARMAP("R","æ");
                      charMap[51]=new CHARMAP("S","è");
                      charMap[52]=new CHARMAP("T","ð");
                      charMap[53]=new CHARMAP("U","ò");
                      charMap[54]=new CHARMAP("V","È");
                      charMap[55]=new CHARMAP("W","AiÉÄ");
                      charMap[56]=new CHARMAP("Y","Å");
                      charMap[57]=new CHARMAP("Z","Ç");
                      charMap[58]=new CHARMAP("[","Ûæ");
                      charMap[59]=new CHARMAP("\'","èç");
                      charMap[60]=new CHARMAP("]","Ï");
                      charMap[61]=new CHARMAP("^","ñ");
                      charMap[62]=new CHARMAP("_","IÄ");
                      charMap[63]=new CHARMAP("`","P");
                      charMap[64]=new CHARMAP("a","U");
                      charMap[65]=new CHARMAP("b","Z");
                      charMap[66]=new CHARMAP("c","o");
                      charMap[67]=new CHARMAP("d","q");
                      charMap[68]=new CHARMAP("e","u");
                      charMap[69]=new CHARMAP("f","v");
                      charMap[70]=new CHARMAP("g","x");
                      charMap[71]=new CHARMAP("h","z");
                      charMap[72]=new CHARMAP("i","£");
                      charMap[73]=new CHARMAP("j","¥");
                      charMap[74]=new CHARMAP("k","g");
                      charMap[75]=new CHARMAP("l","ª");
                      charMap[76]=new CHARMAP("m","±");
                      charMap[77]=new CHARMAP("n","µ");
                      charMap[78]=new CHARMAP("o","¸");
                      charMap[79]=new CHARMAP("p","º");
                      charMap[80]=new CHARMAP("q","¼");
                      charMap[81]=new CHARMAP("r","b");
                      charMap[82]=new CHARMAP("s","qs");
                      charMap[83]=new CHARMAP("t","zs");
                      charMap[84]=new CHARMAP("u","¥s");
                      charMap[85]=new CHARMAP("v","¨s");
                      charMap[86]=new CHARMAP("w","Pë");
                      charMap[87]=new CHARMAP("x","ÐÕ");
                      charMap[88]=new CHARMAP("y","Í");
                      charMap[89]=new CHARMAP("z","R");
                      charMap[90]=new CHARMAP("x","Ð");
                      charMap[91]=new CHARMAP("|","T");
                      charMap[92]=new CHARMAP("}","æ");
                      charMap[93]=new CHARMAP("~","a");
                      charMap[94]=new CHARMAP("","D");
                      charMap[95]=new CHARMAP("","IÆ");
                      charMap[96]=new CHARMAP("","ªÉÄ");
                      charMap[97]=new CHARMAP("","X");
                      charMap[98]=new CHARMAP(" ","a");
                      charMap[99]=new CHARMAP("¡","Ó");
                      charMap[100]=new CHARMAP("¢","d");
                      charMap[101]=new CHARMAP("£","f");
                      charMap[102]=new CHARMAP("¤","Ö");
                      charMap[103]=new CHARMAP("¥","l");
                      charMap[104]=new CHARMAP("¦","n");
                      charMap[105]=new CHARMAP("§","×");
                      charMap[106]=new CHARMAP("¨","oÀ");
                      charMap[107]=new CHARMAP("©","p");
                      charMap[108]=new CHARMAP("ª","Ø");
                      charMap[109]=new CHARMAP("«","qÀ");
                      charMap[110]=new CHARMAP("¬","r");
                      charMap[111]=new CHARMAP("­","Ú");
                      charMap[112]=new CHARMAP("®","t");
                      charMap[113]=new CHARMAP("¯","tÂ");
                      charMap[114]=new CHARMAP("°","vÀ");
                      charMap[115]=new CHARMAP("±","w");
                      charMap[116]=new CHARMAP("²","Ü");
                      charMap[117]=new CHARMAP("³","xÀ");
                      charMap[118]=new CHARMAP("´","y");
                      charMap[119]=new CHARMAP("µ","Ý");
                      charMap[120]=new CHARMAP("¶","zÀ");
                      charMap[121]=new CHARMAP("¸","£À");
                      charMap[122]=new CHARMAP("¹","¤");
                      charMap[123]=new CHARMAP("º","à");
                      charMap[124]=new CHARMAP("»","¥À");
                      charMap[125]=new CHARMAP("¼","¦");
                      charMap[126]=new CHARMAP("½","â");
                      charMap[127]=new CHARMAP("¾","§");
                      charMap[128]=new CHARMAP("¿","©");
                      charMap[129]=new CHARMAP("À","ªÀÄ");
                      charMap[130]=new CHARMAP("Á","«Ä");
                      charMap[131]=new CHARMAP("Â","AiÀÄ");
                      charMap[132]=new CHARMAP("Ã","¬Ä");
                      charMap[133]=new CHARMAP("Ä","gÀ");
                      charMap[134]=new CHARMAP("Å","j");
                      charMap[135]=new CHARMAP("Æ","®");
                      charMap[136]=new CHARMAP("Ç","°");
                      charMap[137]=new CHARMAP("È","é");
                      charMap[138]=new CHARMAP("É","ªÀ");
                      charMap[139]=new CHARMAP("Ê","«");
                      charMap[140]=new CHARMAP("Ë","±À");
                      charMap[141]=new CHARMAP("Ì","²");
                      charMap[142]=new CHARMAP("Í","ë");
                      charMap[143]=new CHARMAP("Î","µÀ");
                      charMap[144]=new CHARMAP("Ï","¶");
                      charMap[145]=new CHARMAP("Ð","ì");
                      charMap[146]=new CHARMAP("Ñ","¸À");
                      charMap[147]=new CHARMAP("Ò","¹");
                      charMap[148]=new CHARMAP("Ó","í");
                      charMap[149]=new CHARMAP("Ô","ºÀ");
                      charMap[150]=new CHARMAP("Õ","»");
                      charMap[151]=new CHARMAP("Ö","î");
                      charMap[152]=new CHARMAP("×","¼À");
                      charMap[153]=new CHARMAP("Ø","½");
                      charMap[154]=new CHARMAP("Ù","dÕ");
                      charMap[155]=new CHARMAP("Ú","ªÀÅ");
                      charMap[156]=new CHARMAP("Û","¥ÀÅ");
                      charMap[157]=new CHARMAP("Ü","á");
                      charMap[158]=new CHARMAP("Ý","bÀ");
                      charMap[159]=new CHARMAP("Þ","c");
                      charMap[160]=new CHARMAP("ß","Ù");
                      charMap[161]=new CHARMAP("à","qsÀ");
                      charMap[162]=new CHARMAP("á","rü");
                      charMap[163]=new CHARMAP("â","Þ");
                      charMap[164]=new CHARMAP("ã","zsÀ");
                      charMap[165]=new CHARMAP("ä","¢ü");
                      charMap[166]=new CHARMAP("å","á");
                      charMap[167]=new CHARMAP("æ","¥sÀ");
                      charMap[168]=new CHARMAP("ç","¦ü");
                      charMap[169]=new CHARMAP("è","ã");
                      charMap[170]=new CHARMAP("é","¨sÀ");
                      charMap[171]=new CHARMAP("ê","©ü");
                      charMap[172]=new CHARMAP("ë","gÀhÄ");
                      charMap[173]=new CHARMAP("ì","jhÄ");
                      charMap[174]=new CHARMAP("í","PÀë");
                      charMap[175]=new CHARMAP("î","Që");
                      charMap[176]=new CHARMAP("ï","|");
                      charMap[177]=new CHARMAP("ð","k");
                      charMap[178]=new CHARMAP("ñ","Y");
                      charMap[179]=new CHARMAP("ò","Õ");
                      charMap[180]=new CHARMAP("ó","ê");
                      charMap[181]=new CHARMAP("ô","WÀ");
                      charMap[182]=new CHARMAP("õ","Ô");
                      charMap[183]=new CHARMAP("ö","Öç");
                      charMap[184]=new CHARMAP("÷","²ç");
                      charMap[185]=new CHARMAP("ø","ªÀÇ");
                      charMap[186]=new CHARMAP("ù","ZÀ");
                      charMap[187]=new CHARMAP("ú","¥ÀÆ");
                      charMap[188]=new CHARMAP("û","m");
                      charMap[189]=new CHARMAP("ü","¥sÀÅ");
                      charMap[190]=new CHARMAP("ý","¥sÀÇ");
                      charMap[191]=new CHARMAP("þ","C");
                      charMap[192]=new CHARMAP("ÿ","„");
                      charMap[193]=new CHARMAP("Œ","IÄ");
                      charMap[194]=new CHARMAP("œ","WÀ");
                      charMap[195]=new CHARMAP("Š","N");
                      charMap[196]=new CHARMAP("š","V");
                      charMap[197]=new CHARMAP("Ÿ","ZÀ");
                      charMap[198]=new CHARMAP("ƒ","F");
                      charMap[199]=new CHARMAP("ˆ","L");
                      charMap[200]=new CHARMAP("","Î");
                      charMap[201]=new CHARMAP("–","R");
                      charMap[202]=new CHARMAP("—","T");
                      charMap[203]=new CHARMAP("‘","AiÉÄ");
                      charMap[204]=new CHARMAP("","Ì");
                      charMap[205]=new CHARMAP("","E");
                      charMap[206]=new CHARMAP("“","PÀ");
                      charMap[207]=new CHARMAP("","Q");
                      charMap[208]=new CHARMAP("„","G");
                      charMap[209]=new CHARMAP("","J");
                      charMap[210]=new CHARMAP("‡","K");
                      charMap[211]=new CHARMAP("•","Í");
                      charMap[212]=new CHARMAP("…","H");
                      charMap[213]=new CHARMAP("‰","M");
                      charMap[214]=new CHARMAP("‹","O");
                      charMap[215]=new CHARMAP("›","Ï");
                      charMap[216]=new CHARMAP("","UÀ");
                      charMap[217]=new CHARMAP("·","¢");
                      charMap[218]=new CHARMAP("X","");
                      charMap[219]=new CHARMAP("ÿ","„");
                      charMap[220]=new CHARMAP("€","C");
                      charMap[221]=new CHARMAP("�","C");
                      charMap[222]=new CHARMAP("ž","Ñ");
                      charMap[223]=new CHARMAP("Ž","W");
                      
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
                       charMap[243]=new CHARMAP("1234","123");
                       //charMap[246]=new CHARMAP("\c","\c");
                       //charMap[247]=new CHARMAP("\a","\a");
                       //charMap[248]=new CHARMAP("\s","\s");
                       //charMap[249]=new CHARMAP("\e","\e");
                       charMap[244]=new CHARMAP("SUDHER","SUDHEER");
                              
//                        for (CHARMAP c: charMap) {
//                             System.out.println(c.textProp+" "+c.textPropLength);
//                         }
                        
                      Arrays.sort(charMap, new CharMapComparator());

//                      for (CHARMAP c: charMap) {
//                             System.out.println(c.textProp+" "+c.textPropLength);
//                         }

}

@Override
	public String Convert(String inText) {
		// TODO Auto-generated method stub
	char buffer[] = inText.concat("     ").toCharArray();
	boolean madeOfMoreChars = true;
	int k = 0; // INDEX FOR BUFFER TRAVERSING 
	boolean found = false;
	StringBuilder sb = new StringBuilder();
        StringBuilder temp = null;
        //System.out.println("At convert "+inText);
	while(k<inText.length())
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
						found = true ;
						sb.append("S");
						madeOfMoreChars = true;
						k = k+1;
					}else
					//–	V
					if( (char)buffer[k] == '–' && (char)buffer[k+1] == 'V'  
					  ) 
					{
						found = true ;
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
						found = true ;
						sb.append("e");
						madeOfMoreChars = true;
						k = k+1;
					}else
					//V
					if( (char)buffer[k] == '¢' && (char)buffer[k+1] == 'V'  
					  ) 
					{
						found = true ;
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
						found = true ;
						sb.append("¨");
						madeOfMoreChars = true;
						k = k+1;
					}else
					//V
					if( (char)buffer[k] == '¾' && (char)buffer[k+1] == 'V'  
					  ) 
					{
						found = true ;
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
						found = true ;
						sb.append("¯");
						madeOfMoreChars = true;
						k = k+1;
					}else
					//V
					if( (char)buffer[k] == 'Æ' && (char)buffer[k+1] == 'V' 
					  ) 
					{
						found = true ;
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
						found = true ;
						sb.append("eÕ");
						madeOfMoreChars = true;
						k = k+1;
					}else
					//V
					if( (char)buffer[k] == 'Ù' && (char)buffer[k+1] == 'V'  
					  ) 
					{
						found = true ;
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
						found = true ;
						sb.append("Pë");
						madeOfMoreChars = true;
						k = k+1;
					}else
					//V
					if( (char)buffer[k] == 'w' && (char)buffer[k+1] == 'V'  
					  ) 
					{
						found = true ;
						sb.append("PëÈ");
						madeOfMoreChars = true;
						k = k+2;
					}else
					//Â		A	 G	H		í	V
					if( (char)buffer[k] == 'Â' && ( (char)buffer[k+1] == 'A' )
					  ) 
					{
						found = true ;
						sb.append("AiÀi");  //Á
						madeOfMoreChars = true;
						k = k+1;
					}else
					//ëA
					if( (char)buffer[k] == 'ë' && (char)buffer[k+1] == 'A' 
					  ) 
					{
						found = true ;
						sb.append("gÀhiÁ");
						madeOfMoreChars = true;
						k = k+2;
					}else
					//ÀA
					if( (char)buffer[k] == 'À' && (char)buffer[k+1] == 'A'  
					  ) 
					{
						found = true ;
						sb.append("ªÀiÁ");
						madeOfMoreChars = true;
						k = k+2;
					}else
					//ÁA 
					if( (char)buffer[k] == 'Á' && (char)buffer[k+1] == 'A' 
												  ) 
					{
						found = true ;
						sb.append("«iÁ");
						madeOfMoreChars = true;
						k = k+2;
					}else
					//[ 
					if( (char)buffer[k] == '[') 
					{
						found = true ;
						sb.append("Ûç");
						madeOfMoreChars = true;
						k = k+2;
					}else
					// ËRD  ËRD
					if( (char)buffer[k] == 'Ë' &&  (char)buffer[k+1] == 'R' && (char)buffer[k+2] == 'D' ) 
					{
						found = true ;
						sb.append("±ÀÄæ");
						madeOfMoreChars = true;
						k = k+3;
					}else
					//<<
					if( (char)buffer[k] == '<' &&  (char)buffer[k+1] == '<') 
					{
						found = true ;
						sb.append("“");
						madeOfMoreChars = true;
						k = k+2;
					}else//>>
					if( (char)buffer[k] == '>' &&  (char)buffer[k+1] == '>') 
					{
						found = true ;
						sb.append("”");
						madeOfMoreChars = true;
						k = k+2;
					}else///////////////////////////if not in above case ie; if character is not made of 2 characters
                                        {
                                            temp = new StringBuilder();
                temp.append(buffer[k]);
                
		for(int i=0;i<charMap.length && found==false;i++)
		{
			if( charMap[i].textProp.equals(temp.toString())) 
				{  
					found = true ;
					//flag = 0;
					System.out.println("Found match for "+temp.toString()+" at "+i);
					sb.append(charMap[i].textStd);
				}
		}
	
		if(found == false)
		{
			sb.append(buffer[k]); //If not in Table
		}

		if(madeOfMoreChars != true)
		{
			k++;//Set to next element in buffer
		}
	 }
        }
		return sb.toString();
	}
}
