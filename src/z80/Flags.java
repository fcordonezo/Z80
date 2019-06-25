/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z80;

import java.util.HashMap;

/**
 *
 * @author Camilo
 */
class Flags {
    private static Flags flags;
    private static HashMap<String, String> flagsMap;
    private Flags(){
        flagsMap = new HashMap<>();
        flagsMap.put("P/V", "");
        flagsMap.put("S", "");
        flagsMap.put("Z", "");
        flagsMap.put("AC", "");
        flagsMap.put("C", "");
    }
    public static Flags getFlags(){
        if( flags == null ){
            flags = new Flags();
        }
        return flags;
    }
    public HashMap<String, String> getFlagsMap(){
        return flagsMap;
    }
}
