/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z80;

/**
 *
 * @author Camilo
 */
public class ALU {
    private static ALU alu;
    public static ALU getALU(){
        if( alu == null ){
            alu = new ALU();
        }
        return alu;
    }
    private ALU(){
        
    }
    public String sum( String hexaA, String hexaSecond ){
        int decimal = Integer.parseInt(hexaA,16) + Integer.parseInt(hexaSecond,16);
        return Integer.toHexString(decimal).toUpperCase();
    }
}
