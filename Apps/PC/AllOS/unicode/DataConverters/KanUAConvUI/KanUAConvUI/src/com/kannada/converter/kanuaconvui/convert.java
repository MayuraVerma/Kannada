/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kannada.converter.kanuaconvui;

import com.kannada.kanuaconv.Test;
import java.io.File;
import java.io.IOException;
import javax.swing.JTextField;

/**
 *
 * @author dell amd
 */
public class convert {
    
    public convert(){
        
    }
    
    
    public void startConversion(JTextField jTextFieldSrcFile,JTextField jTextFieldDstFile,String dataFormatSelected){
         Test ti = new Test();
         String inFilePath = null;
         String outFilePath = null;
         String fileFormat  = null;
         String outFileFormat = null;
         boolean errorOccured = false;
         ConversionProgress cp = new ConversionProgress();
         
              inFilePath = jTextFieldSrcFile.getText().toString();
              outFilePath = jTextFieldDstFile.getText().toString();
              
         fileFormat = inFilePath.substring(inFilePath.lastIndexOf(".")+1, inFilePath.length());
         try{
         outFileFormat = outFilePath.substring(outFilePath.lastIndexOf(".")+1, outFilePath.length());
         }catch(Exception e){
             outFileFormat = "na";
         }
         
         if(!fileFormat.equalsIgnoreCase(outFileFormat)){
             if(fileFormat.equalsIgnoreCase("txt") && outFileFormat.equalsIgnoreCase("docx")){
                 fileFormat = "texttodocx";
             }else  if(fileFormat.equalsIgnoreCase("txt") && outFileFormat.equalsIgnoreCase("doc")){
                 fileFormat = "texttodoc";
             
             }
                 
         }
         
                          System.out.println("Conversion Started");
                          
         if(new File(jTextFieldSrcFile.getText().toString()).canRead() 
                 && jTextFieldSrcFile.getText().toString().length()>0 && jTextFieldDstFile.getText().toString().length() >0
                 && !(jTextFieldSrcFile.getText().toString().equals(jTextFieldDstFile.getText().toString()))
            )
         {

              if(outFilePath == null || outFilePath.equals("") || outFilePath.length() <=0){
                   outFilePath = inFilePath.substring(0, inFilePath.lastIndexOf("."))+"_Converted_"+inFilePath.substring(inFilePath.lastIndexOf("."), inFilePath.length());
              }
              if(outFileFormat.equalsIgnoreCase("na")){
                  {
                      outFilePath = outFilePath.concat(fileFormat);
                  }
 
              
                 }
             if(fileFormat.equalsIgnoreCase("doc")){
                 fileFormat = "word";
             }if(fileFormat.equalsIgnoreCase("xls")){
                 fileFormat = "excel";
             }if(fileFormat.equalsIgnoreCase("docx")){
                 fileFormat = "wordx";
             }if(fileFormat.equalsIgnoreCase("xlsx")){
                 fileFormat = "excelx";
             }if(fileFormat.equalsIgnoreCase("txt")){
                 fileFormat = "text";
             }if(fileFormat.equalsIgnoreCase("texttodocx")){
                 fileFormat = "texttodocx";
             }if(fileFormat.equalsIgnoreCase("texttodoc")){
                 fileFormat = "texttodoc";
             }
             try{
                   System.out.println(dataFormatSelected);
                 ti.ConvertAll(inFilePath, outFilePath, (String)FontNameMap.NameMap.get(dataFormatSelected), fileFormat);
             }catch(IOException iOE){
                 //cp.stopProgress();
                 iOE.printStackTrace();
                 errorOccured = true;
                 CommonMessage cm = new CommonMessage("ಕಡತದ ಹೆಸರುಗಳನ್ನು ಸರಿಯಾಗಿ ಹೊಂದಿಸಲಾಗಿಲ್ಲ. ಕಡತ ಗಳನ್ನು ಪರಿಶೀಲಿಸಿ.");
                 cm.execute("ಕಡತದ ಹೆಸರುಗಳನ್ನು ಸರಿಯಾಗಿ ಹೊಂದಿಸಲಾಗಿಲ್ಲ. ಕಡತ ಗಳನ್ನು ಪರಿಶೀಲಿಸಿ.");
                 //ce.
             }catch(Exception e){
                 //cp.stopProgress();
                 errorOccured = true;
                 CommonMessage cm = new CommonMessage("ಪರಿವರ್ತಿಸುವ ಸಂದರ್ಭದಲ್ಲಿ ಡೇಟಾ ದೋಷ ಸಂಭವಿಸಿದೆ. ದಯವಿಟ್ಟು. ವರದಿ ಮಾಡಿ");
                 cm.execute("ಪರಿವರ್ತಿಸುವ ಸಂದರ್ಭದಲ್ಲಿ ಡೇಟಾ ದೋಷ ಸಂಭವಿಸಿದೆ. ದಯವಿಟ್ಟು. ವರದಿ ಮಾಡಿ");
                 e.printStackTrace();
             }
             if(errorOccured){
                 //cp.stopProgress();
                 CommonMessage cm = new CommonMessage("ಪರಿವರ್ತಿಸುವ ಒಂದು ದೋಷ ಕಂಡುಬಂದಿದೆ. ದಯವಿಟ್ಟು. ವರದಿ ಮಾಡಿ");
                 cm.execute("ಪರಿವರ್ತಿಸುವ ಒಂದು ದೋಷ ಕಂಡುಬಂದಿದೆ. ದಯವಿಟ್ಟು. ವರದಿ ಮಾಡಿ");
            }else{
                 //cp.stopProgress();
                 ConversionCompletion cm = new ConversionCompletion();
                 cm.execute();
             }
         }else{
            CommonMessage cm = new CommonMessage("ಕಡತದ ಹೆಸರುಗಳನ್ನು ಸರಿಯಾಗಿ ಹೊಂದಿಸಲಾಗಿಲ್ಲ. ಕಡತ ಗಳನ್ನು ಪರಿಶೀಲಿಸಿ.");
            cm.execute("ಕಡತದ ಹೆಸರುಗಳನ್ನು ಸರಿಯಾಗಿ ಹೊಂದಿಸಲಾಗಿಲ್ಲ. ಕಡತ ಗಳನ್ನು ಪರಿಶೀಲಿಸಿ.");
           }
    }
    
}
