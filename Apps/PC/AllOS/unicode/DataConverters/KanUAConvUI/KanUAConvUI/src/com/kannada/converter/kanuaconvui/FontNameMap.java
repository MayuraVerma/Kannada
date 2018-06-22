/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kannada.converter.kanuaconvui;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dell amd
 */
public class FontNameMap {
    public static Map NameMap = new HashMap();
 
    static {
                NameMap.put("GOK (Kuvempu Nudi Baraha)","default" );
                NameMap.put("Anu Fonts","_anu"); 
                NameMap.put("Srilipi","_sriLipi");
                NameMap.put("Surabhi","_surabhi");
                NameMap.put("WinKey-95","_srg1");
                NameMap.put("WinKey-98","_srg2");
                NameMap.put("Kannada Unicode To Braille", "_kanUni");
                NameMap.put("Kannada ASCII To Braille", "_kanASCII");
                NameMap.put("Kannada Braille to Kannada Unicode", "_kanBraille");
    }
    
    
}
