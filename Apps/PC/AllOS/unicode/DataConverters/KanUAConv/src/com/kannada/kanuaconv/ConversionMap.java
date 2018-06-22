package com.kannada.kanuaconv;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConversionMap {
	
	static Map<String, String> kuvToUniCMap = new HashMap<String, String>();

	public static boolean initializeMaps(){
		
		kuvToUniCMap.put("C","ಅ");
		return true;
	}
	
}
