/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import lexer.Lexer;
import lexer.Tokens;
import z80.Registers;

/**
 *
 * @author Camilo
 */
public class Compiler {
    private static String initialMemory;
    public static void codeToBits() throws FileNotFoundException, IOException{
        int actualMemory;
        ArrayList<String> programMemory = new ArrayList<>();
        OpCode opCode = OpCode.getOpCode();
        String result = "";
        String file = "programs\\sum.txt";
        Codes codes = Codes.getCodes();
        Registers registers = Registers.getRegisters();
        String sumResult;
        
        BufferedReader reader = new BufferedReader( new FileReader( file ) );
        Lexer lexer = new Lexer( reader );
        while( true ){
            Tokens tokens = lexer.yylex();
            if( tokens == null ){
                //writer.write( result );
                //writer.flush();
                //writer.close();
                break;
            }
            switch( tokens ){
                case NOP:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                            codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    break;
                case ORG:
                    initialMemory = Integer.toHexString(
                            Integer.parseInt(
                                lexer.lexeme.split(" ")[1].toLowerCase(),16));
                    programMemory.add(initialMemory);
                    break;
                case LD1:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                case LD2:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(
                            lexer.lexeme.split(",")[0] + ",*") +
                            lexer.lexeme.split(",")[1] + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(
                        lexer.lexeme.split(",")[0] + ",*") + 
                        lexer.lexeme.split(",")[1]);
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 2;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                case LD3:
                    result += programMemory.get(programMemory.size() - 1) +  "|" +
                        codes.getCodeMap().get(
                        lexer.lexeme.split(",")[0] + ",**") + 
                        lexer.lexeme.split(",")[1] + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(
                        lexer.lexeme.split(",")[0] + ",**") + 
                        lexer.lexeme.split(",")[1]);
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 3;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                case LD4:
                    result += programMemory.get(programMemory.size() - 1) +  "|" +
                        codes.getCodeMap().get(
                        lexer.lexeme.split(" ")[0] + " (**),A" ) + 
                        lexer.lexeme.split(" ")[1].split(",")[0].replace("(", "").replace(")", "")
                        + "\n";
                    opCode.getOpCodeArray().add( codes.getCodeMap().get(
                            lexer.lexeme.split(" ")[0] + " (**),A" ) + 
                        lexer.lexeme.split(" ")[1].split(",")[0].replace("(", "").replace(")", ""));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 3;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                case LD5:
                    result += programMemory.get(programMemory.size() - 1) +  "|" +
                        codes.getCodeMap().get(
                        lexer.lexeme.split(" ")[0] + " (**),HL" ) + 
                        lexer.lexeme.split(" ")[1].split(",")[0].replace("(", "").replace(")", "")
                        + "\n";
                    opCode.getOpCodeArray().add( codes.getCodeMap().get(
                            lexer.lexeme.split(" ")[0] + " (**),HL" ) + 
                        lexer.lexeme.split(" ")[1].split(",")[0].replace("(", "").replace(")", ""));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 3;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                case ADD1:
                    result += programMemory.get(programMemory.size() - 1) +  "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                case ADD2:
                    result += programMemory.get(programMemory.size() - 1) +  "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                case ADD3:
                    result += programMemory.get(programMemory.size() - 1) +  "|" +
                        codes.getCodeMap().get(lexer.lexeme.split(",")[0] + ",*") + 
                        lexer.lexeme.split(",")[1] + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme.split(",")[0] + ",*") + 
                        lexer.lexeme.split(",")[1]);
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 2;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                    
                case AND1:
                    result += 
                        programMemory.get(programMemory.size() - 1) +  "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                case AND2:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                case AND3:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme.split(" ")[0] + " *") + 
                        lexer.lexeme.split(" ")[1] + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme.split(" ")[1]) + 
                        lexer.lexeme.split(",")[1]);
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 2;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                    
                case OR1:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                case OR2:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                case OR3:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme.split(" ")[0] + " *") + 
                        lexer.lexeme.split(" ")[1] + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme.split(" ")[1]) + 
                        lexer.lexeme.split(",")[1]);
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 2;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                    
                case XOR1:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                case XOR2:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                case XOR3:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme.split(" ")[0] + " *") + 
                        lexer.lexeme.split(" ")[1] + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme.split(" ")[1]) + 
                        lexer.lexeme.split(",")[1]);
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 2;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                    
                case INC1:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                case INC2:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                    
                case DEC1:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                case DEC2:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                    
                case SUB1:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                case SUB2:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                case SUB3:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme.split(",")[0] + ",*") + 
                        lexer.lexeme.split(",")[1] + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme.split(",")[0] + ",*") + 
                        lexer.lexeme.split(",")[1]);
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 2;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                case HALT:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                case RLCA:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                case RRCA:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                case CPL:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                case NEG:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                    
                case IN:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                    
                case OUT:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory));
                    break;
                case Other:
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        System.out.println(result);
    }
}
