package com.kannada.kanuaconv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.kannada.kanuaconv.maps.ConversionMap;
import com.kannada.kanuaconv.maps.ConversionMapAnu;
import com.kannada.kanuaconv.maps.ConversionMapBrailleKan;
import com.kannada.kanuaconv.maps.ConversionMapKanBraille;
import com.kannada.kanuaconv.maps.ConversionMapPrakashak;
import com.kannada.kanuaconv.maps.ConversionMapSRG;
import com.kannada.kanuaconv.maps.ConversionMapSrgII;
import com.kannada.kanuaconv.maps.ConversionMapSrilipi;
import com.kannada.kanuaconv.maps.ConversionMapSurabhi;
import java.io.FileWriter;
import java.io.OutputStream;
import javax.swing.JProgressBar;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.docx4j.TraversalUtil;
import org.docx4j.XmlUtils;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.Body;


public class Test {
 
    /**
     * @param args
     * @throws FileNotFoundException
     * @throws IOException
     */
	
	public static List uniStringList = new ArrayList<Map<String, String>>();
        public static  JProgressBar jProgressBar = new JProgressBar();
	String outString = null;
        public void ConvertAll(String inFile,String outFile,String dataFormat,String fileFormat) throws FileNotFoundException, IOException 
            {
                System.out.println(inFile);
                System.out.println(outFile);
                System.out.println(dataFormat);
                System.out.println(fileFormat);
    			ConversionOption.dataFormat = dataFormat;
    			ConversionOption.fileFormat = fileFormat;
    			//String inFile = inFile;
    			//String outFile = outFile;
    			Test ti = new Test();
    			ConversionMap.initializeMaps();
    			if(ConversionOption.fileFormat.equalsIgnoreCase("word")){
                                ti.wordConverter(inFile,outFile);
    			}else if(ConversionOption.fileFormat.equalsIgnoreCase("excel")){
				ti.excelConverter(inFile,outFile);
                        }else if(ConversionOption.fileFormat.equalsIgnoreCase("wordx")){
                                ti.wordXConverter(inFile, outFile);
    			}else if(ConversionOption.fileFormat.equalsIgnoreCase("excelx")){
				ti.excelXConverter(inFile,outFile);
    			}else if(ConversionOption.fileFormat.equalsIgnoreCase("text")){
    				ti.textConverter(inFile, outFile);
    			}else if(ConversionOption.fileFormat.equalsIgnoreCase("texttodocx")){
    				ti.textToDocxConverter(inFile, outFile);
    			}else if(ConversionOption.fileFormat.equalsIgnoreCase("texttodoc")){
    				ti.textToDocConverter(inFile, outFile);
    			}
        System.out.println("Converted Fine");
                        return;
    			//outFile = ti.convertWord("PÀ£ÀßqÀ ºÁ¸À£À gÁµÀÖç  PÀ£ÀßqÀ ªÀÄvÀÄÛ ¸ÀA¸ÀÌøw E¯ÁPÉ");
    	}
     
    public static void main(String args[]) 
            {
    			ConversionOption.dataFormat = "default";
    			ConversionOption.fileFormat = "texttodoc";
    			String inFile = "C:\\Users\\dell amd\\Downloads\\ToMaruthiThamthra\\sample.txt";
    			String outFile =   "C:\\Users\\dell amd\\Downloads\\ToMaruthiThamthra\\samplei1s.doc";
    			Test ti = new Test();
    			ConversionMap.initializeMaps();
                        try{
    			if(ConversionOption.fileFormat.equalsIgnoreCase("word")){
                                ti.wordConverter(inFile,outFile);
    			}else if(ConversionOption.fileFormat.equalsIgnoreCase("excel")){
				ti.excelConverter(inFile,outFile);
                        }else if(ConversionOption.fileFormat.equalsIgnoreCase("wordx")){
                                ti.wordXConverter(inFile, outFile);
    			}else if(ConversionOption.fileFormat.equalsIgnoreCase("excelx")){
				ti.excelXConverter(inFile,outFile);
    			}else if(ConversionOption.fileFormat.equalsIgnoreCase("text")){
    				ti.textConverter(inFile, outFile);
    			}else if(ConversionOption.fileFormat.equalsIgnoreCase("texttodocx")){
    				ti.textToDocxConverter(inFile, outFile);
    			}else if(ConversionOption.fileFormat.equalsIgnoreCase("texttodoc")){
    				ti.textToDocConverter(inFile, outFile);
    			}
                        
                        }catch(Exception e){
                            e.printStackTrace();
                        }
    	}//main
    
    public String convertWord(String inText){
    	String retVal = null;
        boolean skip = false;
    
        jProgressBar.setValue(100);
        System.out.println("Setting Progress");
    	if(ConversionOption.dataFormat.equals(Constants.datFormat._anu.toString())){
    		inText = convertAnu(inText);
    	}else if(ConversionOption.dataFormat.equals(Constants.datFormat._prakashak.toString())){
    		inText = convertPrakashak(inText);
    	}else if(ConversionOption.dataFormat.equals(Constants.datFormat._srg1.toString())){
    		inText = convertSrg1(inText);
        }else if(ConversionOption.dataFormat.equals(Constants.datFormat._srg2.toString())){
    		inText = convertSrg2(inText);                
    	}else if(ConversionOption.dataFormat.equals(Constants.datFormat._surabhi.toString())){
    		inText = convertSurabhi(inText);
    	}else if(ConversionOption.dataFormat.equals(Constants.datFormat._sriLipi.toString())){
    		inText = convertSriLipi(inText);
    	}else if(ConversionOption.dataFormat.equals(Constants.datFormat._prakashak.toString())){
    		inText = convertPrakashak(inText);                
    	}else if(ConversionOption.dataFormat.equals(Constants.datFormat._kanUni.toString())){
            ConversionMapKanBraille cMapKanBraille = new ConversionMapKanBraille();
    		inText = cMapKanBraille.convertWord(inText);
                retVal = inText;
                skip = true;
    	}else if(ConversionOption.dataFormat.equals(Constants.datFormat._kanASCII.toString())){
                getReplaceMent(inText);
                inText = test();
                //System.out.println("Unicode Kannada"+inText);
                ConversionMapKanBraille cMapKanBraille = new ConversionMapKanBraille();
    		inText = cMapKanBraille.convertWord(inText);
                retVal = inText;
                skip = true;
    	}else if(ConversionOption.dataFormat.equals(Constants.datFormat._kanBraille.toString())){
                //getReplaceMent(inText);
                //inText = test();
                //System.out.println("Unicode Kannada"+inText);
                ConversionMapBrailleKan cMapBrailleKan = new ConversionMapBrailleKan();
    		inText = cMapBrailleKan.convertWord(inText);
                retVal = inText;
                skip = true;
    	}    

        System.out.println("The input text is "+inText);
        if(!skip){
    	getReplaceMent(inText);
    	retVal = test();
        }
        
    	return retVal;
    }
    
    public String test(){

    	ConversionMap.initializeMaps();
    	
    	outString = new String();
    	Iterator it = uniStringList.iterator();
   
    	
    	while(it.hasNext()){
    		Map tMap = (Map)it.next();
    		Set s = tMap.keySet();
    		 Iterator it1 = s.iterator();
    		 String currentChar;
    		 
    		 while(it1.hasNext()){
    			 currentChar = tMap.get(it1.next()).toString();
    			 outString  = setOutString(currentChar);
    		 }
    	}
    	System.out.print(outString);
    	return outString;
    }
    
    public String setOutString(String currentString){
    	String retVal = new String();
    	StringBuilder retString = new StringBuilder();
    	int i;
    	int oL = outString.length();
    	char newOutString[] = new char[65000];
    	
		char tempSubst[] = currentString.toCharArray();

    	if(outString != null && outString.length()>0){
        	char outStringChar[] = outString.toCharArray();
        	char tempC = outStringChar[oL-1];
        	for(int o=0;o<oL;o++){
        		newOutString[o]=outStringChar[o];
        	}
        	
                if((new StringBuilder()).append(outStringChar[oL-1]).toString().equals("್") && 
                        ConversionMap.ottaksharaList.contains(currentString)){
                    	for(i=0;i<currentString.length();i++){
	    			newOutString[oL-1+i] = tempSubst[i];
	    		}
	    		newOutString[oL-1+i]=tempC;
                        newOutString[oL+i]='\u200C';
	    		newOutString[oL+i+1]='\0';
	    		StringBuilder sb = new StringBuilder();
	    		
	    		for(Integer k=0;newOutString[k] != '\0'; k++){
	    			sb.append(newOutString[k]);
	    		}
	    		retString.append(sb.toString());
                }
                else
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
    public  void excelConverter(String inFile,String outFile) {
    	    /** --Define a Vector
                --Holds Vectors Of Cells
             */
            Vector cellVectorHolder = new Vector();
            String fileName = inFile;
            try{
            /** Creating Input Stream**/
            //InputStream myInput= ReadExcelFile.class.getResourceAsStream( fileName );
            FileInputStream myInput = new FileInputStream(fileName);
     
            /** Create a POIFSFileSystem object**/
            POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
     
            /** Create a workbook using the File System**/
             HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);
     
             /** Get the first sheet from workbook**/
            HSSFSheet mySheet = myWorkBook.getSheetAt(0);
     
            /** We now need something to iterate through the cells.**/
              Iterator rowIter = mySheet.rowIterator();
     
              while(rowIter.hasNext()){
                  HSSFRow myRow = (HSSFRow) rowIter.next();
                  Iterator cellIter = myRow.cellIterator();
                  Vector cellStoreVector=new Vector();
                  while(cellIter.hasNext()){
                      HSSFCell myCell = (HSSFCell) cellIter.next();
                      //cellStoreVector.addElement(myCell);
                      uniStringList = new  ArrayList<Map<String, String>>();    
                      try{
                      String cValue = myCell.getStringCellValue();
                      String replacingText = convertWord(cValue);
                      CellStyle cs = myCell.getCellStyle();
                      HSSFFont f = myWorkBook.getFontAt(cs.getFontIndex());
                      System.out.println(f.getFontName());
                      myCell.setCellValue(replacingText);
                      }catch(Exception e){
                          System.out.println("Some error happened column"+myCell.getColumnIndex()+1+"row "+myCell.getRowIndex()+1);
                          e.printStackTrace();
                      }
                  }
                  //cellVectorHolder.addElement(cellStoreVector);
              }
              myWorkBook.write(new FileOutputStream(new File(outFile)));
              myInput.close();
              
            }catch (Exception e){
            	e.printStackTrace(); 
            }
            
            

            //return cellVectorHolder;
        }
     
    public  void excelXConverter(String inFile,String outFile){
        
		try{
                Workbook workBook = new SXSSFWorkbook(); 
		workBook = WorkbookFactory.create(new FileInputStream(inFile)); 
		int noOfSheets = workBook.getNumberOfSheets();
		for(int s=0;s<noOfSheets;s++){
		Sheet sheet = workBook.getSheetAt(s);
		if(sheet!=null){
		int totalRows = sheet.getLastRowNum();
		for (int i=0; i<=totalRows; i++) { 
		    Row row = sheet.getRow(i); 
		    if(row != null){
		    int totalCols = row.getLastCellNum();
		    for(int j=0; j<totalCols; j++) { 
		        Cell myCell = row.getCell(j); 
		        if(myCell!=null){
                            uniStringList = new  ArrayList<Map<String, String>>();
                            try{
                            String cValue = myCell.getStringCellValue();
                            String replacingText = convertWord(cValue);
                            myCell.setCellValue(replacingText);
                            }catch(Exception e){
                                System.out.println("Some error happened columen"+myCell.getColumnIndex()+1+"row "+myCell.getRowIndex()+1);
                                e.printStackTrace();
                            }
                        }
		    	} 
		     }
		    }
		  } 
		 }
		
		workBook.write(new FileOutputStream(new File(outFile)));
    }catch(Exception e){
    e.printStackTrace();
    }
   }

public  void wordXConverter(String inFile,String outFile){
  
 
         String inputfilepath =  inFile;
           
         try{
         WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new java.io.File(inputfilepath));
                 
         final MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
                    
         org.docx4j.wml.Document wmlDocumentEl = (org.docx4j.wml.Document) documentPart
                .getJaxbElement();
          Body body = wmlDocumentEl.getBody();
        TraversalUtil traversalUtil = new TraversalUtil(body,new TraversalUtil.Callback()
                                      {
                                         
                                         String indent = "";
                                         
                                         org.docx4j.wml.ObjectFactory factory = new org.docx4j.wml.ObjectFactory();
                                         
                                         org.docx4j.wml.R tmpR = factory.createR();
                                          
                                         org.docx4j.wml.RPr RPr = factory.createRPr();
                                         
                                         public List<Object> apply(Object o)
                                         {
                                            
                                            if (o instanceof org.docx4j.wml.Text)
                                            {
                                                uniStringList = new  ArrayList<Map<String, String>>();
                                                org.docx4j.wml.Text t = (org.docx4j.wml.Text) o; 
                                                Object o1 = t.getParent();
                                                           System.out.println("Text Object is "+t.getValue());
                                                           String replacingText = convertWord(t.getValue());
                                                           t.setValue(replacingText);
                                               
                                            }
                                            
                                            if (o instanceof org.docx4j.wml.Fonts)
                                            {
                                               org.docx4j.wml.Fonts f = (org.docx4j.wml.Fonts) o;
                                               List fonts = f.getFont();
                                            }
                                            
                                            return null;
                                         }
                                         
                                          @Override
                                         public boolean shouldTraverse(Object o)
                                         {
                                            return true;
                                         }
                                         
                                          @Override
                                         public void walkJAXBElements(Object parent)
                                         {
                                            
                                            indent += "    ";            
                                            List children = getChildren(parent);
                                            if (children != null)
                                            {               
                                               for (Object o : children)
                                               {
                                                           
                                                  o = XmlUtils.unwrap(o);
                                                  
                                                  this.apply(o);
                                                  
                                                  if (this.shouldTraverse(o))
                                                  {
                                                     walkJAXBElements(o);
                                                  }
                                                  
                                               }
                                               
                                            }
                                            
                                            indent = indent.substring(0, indent.length() - 4);
                                         }
                                         
                                         public List<Object> getChildren(Object o)
                                         {
                                            return TraversalUtil.getChildrenImpl(o);
                                         }
                                         
                                      }

                                      );
          
         wordMLPackage.save(new File(outFile));
         
         }catch(Exception e){
             e.printStackTrace();
         }
       
}

private void removeParagraphs(XWPFTableCell tableCell) {
    int count = tableCell.getParagraphs().size();
    for(int i = 0; i < count; i++){
    tableCell.removeParagraph(i);
    }
}
public  void wordConverter(String inFile,String outFile)throws FileNotFoundException, IOException{

        int startOffset;
        int endOffset;
        int runIndex;
        int textLength = 0;
            String filesname = inFile;
            POIFSFileSystem fs = null;
            fs = new POIFSFileSystem(new FileInputStream(filesname));
            HWPFDocument doc = new HWPFDocument(fs);
            Range r = doc.getRange();
            startOffset = r.getStartOffset();
            endOffset = r.getEndOffset();
           
            ConversionMap.initializeMaps();
            runIndex = startOffset;
 
            WordExtractor wordExtract=new WordExtractor(doc); 
            String [] dataArray =wordExtract.getParagraphText();
            // dataArray stores the each line from the document
           StringBuilder  tempWord = new StringBuilder();
           String replacingText = new String();
           int wi = 0;
           
            for(int i=0;i<dataArray.length;i++)
            {
                String s = dataArray[i];
                	wi = 0;
                    uniStringList = new  ArrayList<Map<String, String>>();
                    
                    try{
                    replacingText = convertWord(s);
                    if(replacingText!=null && replacingText.length()>0)
                    {
                        System.out.println("The replacing text is "+replacingText+" replaced text is "+tempWord.toString()+" at "+textLength);
                        r.replaceText(s,replacingText,textLength);
                    }
                   
                    if(replacingText!=null && replacingText.length()>0)
                    textLength = textLength+replacingText.length();
                    else 
                        textLength = textLength+1;
                    }catch(Exception e)
                    {
                        
                    }
            }
            doc.write(new FileOutputStream(new File(outFile)));
            //closing fileinputstream
    
    }
   
public  void textToDocConverter(String inFile,String outFile)throws FileNotFoundException, IOException{

        int startOffset;
        int endOffset;
        int runIndex;
        int textLength = 0;
            String filesname = inFile;
            POIFSFileSystem fs = null;
           String dummyFile = "dummy.doc";
           System.out.println("The directory is "+new java.io.File( "." ).getCanonicalPath());
           fs = new POIFSFileSystem(new FileInputStream(dummyFile));
            HWPFDocument doc = new HWPFDocument(fs);
            Range range = doc.getRange();
 
            	try{
  		  String tempFile = outFile+"tmp";
                  textConverter(inFile,tempFile);
                    int len;
                    char[] chr = new char[4096];
                    final StringBuffer buffer = new StringBuffer();
      
                final FileReader reader = new FileReader(tempFile);

                try {
                    while ((len = reader.read(chr)) > 0) {
                        buffer.append(chr, 0, len);
                    }
                } finally {
                    reader.close();
                    new File(tempFile).delete();
                }
               //doc.getParagraphTable()
                CharacterRun run = range.insertAfter(buffer.toString());  
                OutputStream outStream = new  FileOutputStream(outFile);
                doc.write(outStream); 
                outStream.flush();
                outStream.close();
               
    	   }catch (Exception e){//Catch exception if any
    		  e.printStackTrace();
    		  System.err.println("Error: " + e.getMessage());
        }
           
            //closing fileinputstream
    
    }

        public  void textToDocxConverter(String inFile,String outFile)throws FileNotFoundException, IOException{
    	
    	try{
  		  String tempFile = outFile+"tmp";
                  textConverter(inFile,tempFile);
                    int len;
                    char[] chr = new char[4096];
                    final StringBuffer buffer = new StringBuffer();
      
                final FileReader reader = new FileReader(tempFile);

                try {
                    while ((len = reader.read(chr)) > 0) {
                        buffer.append(chr, 0, len);
                    }
                } finally {
                    reader.close();
                    new File(tempFile).delete();
                }
      
                  WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();
                  wordMLPackage.getMainDocumentPart().addParagraphOfText(buffer.toString());
                  wordMLPackage.save(new java.io.File(outFile));
    	   }catch (Exception e){//Catch exception if any
    		  e.printStackTrace();
    		  System.err.println("Error: " + e.getMessage());
        }
    
    }
    
        
    public  void textConverter(String inFile,String outFile)throws FileNotFoundException, IOException{
    	
    	try{
  		  
    		  FileReader fr = new FileReader(inFile);
    		  //BufferedReader br = new BufferedReader(fr); 
    		  BufferedReader in;
                  
    		  Writer out = new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8");
    		  //Reader in = new InputStreamReader(new FileInputStream(inFile), "ASCII");
    		  String strLine;
    		  String outStrLine;
    		  if(ConversionOption.dataFormat.equals(Constants.datFormat._kanUni.toString())){
                       in = new BufferedReader(new InputStreamReader(new FileInputStream(inFile),"UNICODE"));
                  }else
    		   in = new BufferedReader(new InputStreamReader(new FileInputStream(inFile),"windows-1252"));
    		  
    		  while ((strLine = in.readLine()) != null)   {
    		  // Print the content on the console
    		  //System.out.println ("Origninal String "+strLine);
    		  outStrLine = convertWord(strLine);
                  uniStringList = new ArrayList<Map<String, String>>();
    		    try {
                      System.out.println(" \nThe line "+outStrLine);
    		      out.write(outStrLine);
                      out.write("\r\n");
    		    }catch(IOException ioE){
    		    	ioE.printStackTrace();
    		    }
    		  }
    		  //Close the input & output stream
    		  in.close();
    		  out.close();
    		    }catch (Exception e){//Catch exception if any
    		    	e.printStackTrace();
    		  System.err.println("Error: " + e.getMessage());
    		  }
    
    }
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
        buffer = buffer.replaceAll("÷", "");
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
                                uniStringList.add(m);
                   k++;
               }
        }
    	   return uniStringList.size();
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
        try{
        for (i= 0;i<ConversionMap.asciiUniMap.length;i++)
        { 
            int j = 0;
            j = compsubstr(ConversionMap.asciiUniMap[i].textASCII,buffer,ConversionMap.asciiUniMap[i].asciiLength,k);
            if(j == 1)
            {
            	//add to converted list
            	m = new HashMap<String, String>();
                int strLn = uniStringList.size();
    	   		m.put(ConversionMap.asciiUniMap[i].textASCII, ConversionMap.asciiUniMap[i].textUNI);
                        if(buffer.charAt(k)=='ð' && strLn > 0){
                                 //System.out.println("Arkavattu "+buffer.charAt(k)+" "+ConversionMap.asciiUniMap[i].textUNI);
                                 //if arkavattu is not the first character
                                 Map mTemp = new HashMap<String, String>();
                                 mTemp = (Map)uniStringList.get(uniStringList.size()-1);
                                 uniStringList.remove(uniStringList.size()-1);
                                 uniStringList.add(m);
                                 uniStringList.add(mTemp);
                                 mTemp = null;
                                 
                                 //System.out.println("Unicode match"+i);
                                }else{
                                   // System.out.println("Unicode match"+i);
                                    uniStringList.add(m);
                        }
               return ConversionMap.asciiUniMap[i].asciiLength;//length of the conversion list 
            }
        }
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
        return 0;
    }
    
    public String convertAnu(String inText){
    	String retVal = inText;
    	ConversionMap cMap = new ConversionMapAnu();
        retVal = cMap.Convert(inText);
    	return retVal;
    }
    
    public String convertSrg1(String inText){
    	String retVal = inText;
    	ConversionMap cMap = new ConversionMapSRG();
        retVal = cMap.Convert(inText);
    	return retVal;
    }
    
     public String convertSrg2(String inText){
    	String retVal = inText;
    	ConversionMap cMap = new ConversionMapSrgII();
        retVal = cMap.Convert(inText);
    	return retVal;
    }
     
    public String convertPrakashak(String inText){
    	String retVal = inText;
    	ConversionMap cMap = new ConversionMapPrakashak();
        retVal = cMap.Convert(inText);
    	return retVal;
    }
    
    public String convertSriLipi(String inText){
    	String retVal = inText;
    	ConversionMap cMap = new ConversionMapSrilipi();
        retVal = cMap.Convert(inText);
    	return retVal;
    }
    
    public String convertSurabhi(String inText){
    	String retVal = inText;
    	ConversionMap cMap = new ConversionMapSurabhi();
        retVal = cMap.Convert(inText);
    	return retVal;
    }
}
