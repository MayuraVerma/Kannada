/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kannada.Converter;

import com.kannada.kanuaconv.maps.ConversionMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 *
 * @author dell amd
 */
public class WordFileConverter implements FileConverter{
    
    
 public  void convert(String inFile,String outFile){
//
//        int startOffset;
//        int endOffset;
//        int runIndex;
//        int textLength = 0;
//            String filesname = inFile;
//            POIFSFileSystem fs = null;
//            fs = new POIFSFileSystem(new FileInputStream(filesname));
//            HWPFDocument doc = new HWPFDocument(fs);
//            Range r = doc.getRange();
//            startOffset = r.getStartOffset();
//            endOffset = r.getEndOffset();
//           
//            ConversionMap.initializeMaps();
//            runIndex = startOffset;
// 
//            WordExtractor wordExtract=new WordExtractor(doc); // import  org.apache.poi.hwpf.extractor.WordExtractor
//            String [] dataArray =wordExtract.getParagraphText();
//            // dataArray stores the each line from the document
//           StringBuilder  tempWord = new StringBuilder();
//           String replacingText = new String();
//           int wi = 0;
//           
//            for(int i=0;i<dataArray.length;i++)
//            {
//                String s = dataArray[i];
//                //for(int ci=0;ci<s.length();ci++){
//                	wi = 0;
////                	 tempWord = new StringBuilder();
////                	while(s.charAt(ci+wi)!=' ' && s.length()>ci+wi && s.charAt(ci+wi)!='\r' && s.charAt(ci+wi)!='\n' &&
////                              s.charAt(ci+wi)!='\t' && s.charAt(ci+wi)!='\n' && s.charAt(ci+wi)!='\r'  && s.charAt(ci+wi)!='\0'  
////                                ){
////                		tempWord.append(s.charAt(ci+wi));
////                	wi++;
////                	}
////                        if(s.charAt(ci+wi)!=' ' && s.length()>ci+wi && s.charAt(ci+wi)!='\r' && s.charAt(ci+wi)!='\n' &&
////                              s.charAt(ci+wi)!='\t' && s.charAt(ci+wi)!='\n' && s.charAt(ci+wi)!='\r'){
////                              tempWord.append(s.charAt(ci+wi++));
////                        }
//                    //char c = s.charAt(ci);
//                    CommonStrings.uniStringList = new  ArrayList<Map<String, String>>();
//                    replacingText = convertString(s);
//                    //if(c == 'e'){
//                    if(replacingText!=null && replacingText.length()>0)
//                    {
//                        System.out.println("The replacing text is "+replacingText+" replaced text is "+tempWord.toString()+" at "+textLength);
//                        r.replaceText(s,replacingText,textLength);
//                    }
//                    //}
////                    if(wi>0)
////                    	ci = ci+wi-1;
//                    
//                    if(replacingText!=null && replacingText.length()>0)
//                    textLength = textLength+replacingText.length();
//                    else  //if(s.charAt(ci+wi)!=' ' && s.length()>ci+wi && s.charAt(ci+wi)!='\r' && s.charAt(ci+wi)!='\n' &&
////                              s.charAt(ci+wi)!='\t' && s.charAt(ci+wi)!='\n' && s.charAt(ci+wi)!='\r')
//                    	textLength = textLength+1;
////                    }
//            //}
//                //ci = replacingText.length()+ci;
//            //System.out.println("\n"+dataArray[i]);
//               
//            //printing lines from the array
//            }
//            doc.write(new FileOutputStream(new File(outFile)));
//             //closing fileinputstream
//    
    }
}