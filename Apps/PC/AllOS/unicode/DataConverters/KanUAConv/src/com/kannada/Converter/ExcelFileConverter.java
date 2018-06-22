/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kannada.Converter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 *
 * @author dell amd
 */
public class ExcelFileConverter implements FileConverter{
    
     public  void convert(String inFile,String outFile) {
//    	    /** --Define a Vector
//                --Holds Vectors Of Cells
//             */
//            Vector cellVectorHolder = new Vector();
//            String fileName = inFile;
//            try{
//            /** Creating Input Stream**/
//            //InputStream myInput= ReadExcelFile.class.getResourceAsStream( fileName );
//            FileInputStream myInput = new FileInputStream(fileName);
//     
//            /** Create a POIFSFileSystem object**/
//            POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
//     
//            /** Create a workbook using the File System**/
//             HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);
//     
//             /** Get the first sheet from workbook**/
//            HSSFSheet mySheet = myWorkBook.getSheetAt(0);
//     
//            /** We now need something to iterate through the cells.**/
//              Iterator rowIter = mySheet.rowIterator();
//     
//              while(rowIter.hasNext()){
//                  HSSFRow myRow = (HSSFRow) rowIter.next();
//                  Iterator cellIter = myRow.cellIterator();
//                  Vector cellStoreVector=new Vector();
//                  while(cellIter.hasNext()){
//                      HSSFCell myCell = (HSSFCell) cellIter.next();
//                      //cellStoreVector.addElement(myCell);
//                      CommonStrings.uniStringList = new  ArrayList<Map<String, String>>();
//                      String cValue = myCell.getStringCellValue();
//                      String replacingText = convertString(cValue);
//                      myCell.setCellValue(replacingText);
//                  }
//                  //cellVectorHolder.addElement(cellStoreVector);
//              }
//              myWorkBook.write(new FileOutputStream(new File(outFile)));
//              myInput.close();
//              
//            }catch (Exception e){
//            	e.printStackTrace(); 
//            }
//            
//            
//
//            //return cellVectorHolder;
        }
     
}
