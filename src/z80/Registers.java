/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z80;

import java.util.HashMap;

/**
 *
 * @author Fabián Ordóñez
 * Jair Villalba
 * Luis Guzman
 */
public class Registers {
    private static Registers registers;
    private static HashMap<String, String> registersHash;
    private Registers(){
        registersHash = new HashMap<>();
        registersHash.put("A", "");
        registersHash.put("B", "");
        registersHash.put("C", "");
        registersHash.put("D", "");
        registersHash.put("E", "");
        registersHash.put("F", "");
        registersHash.put("H", "");
        registersHash.put("L", "");
        registersHash.put("IR", "");
        registersHash.put("IX", "");
        registersHash.put("IY", "");
        registersHash.put("SP", "");
        registersHash.put("BR", "");
        registersHash.put("PC", "");
    }
    public static Registers getRegisters(){
        if( registers == null ){
            registers = new Registers();
        }
        return registers;
    }
    public HashMap<String, String> getRegistersHash(){
        return registersHash;
    }
}
