/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;

/**
 *
 * @author Camilo
 */
public class OpCode {
    private static OpCode opCode;
    private ArrayList<String> opCodeArray;
    private OpCode(){
        opCodeArray = new ArrayList<>();
    }
    public static OpCode getOpCode(){
        if( opCode == null ){
            opCode = new OpCode();
        }
        return opCode;
    }
    public ArrayList<String> getOpCodeArray(){
        return opCodeArray;
    }
}
