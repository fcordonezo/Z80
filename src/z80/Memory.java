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
public class Memory {
    private static Memory memory;
    private static HashMap<String, String> memoryHash;
    private Memory(){
        memoryHash = new HashMap<>();

    }
    public static Memory getMemory(){
        if( memory == null ){
            memory = new Memory();
        }
        return memory;
    }
    public HashMap<String, String> getMemoryHash(){
        return memoryHash;
    }
}
