/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kannada.kanuaconv.maps;

import java.util.Comparator;

/**
 *
 * @author dell amd
 */
public class CharMapComparator implements Comparator<CharacterMap.CHARMAP> {
     @Override
        public int compare(CharacterMap.CHARMAP o1, CharacterMap.CHARMAP o2) {
        return (o1.textPropLength>o2.textPropLength ? -1 : (o1.textPropLength==o2.textPropLength ? 0 : 1));
       }
}
