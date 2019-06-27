/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import lexer.Lexer;
import lexer.Tokens;
import z80.Memory;
import z80.Registers;

/**
 *
 * @author Camilo
 */
public class Compiler {
    public static void codeToBits() throws FileNotFoundException, IOException{
        int actualMemory;
        String initialMemory;
        Memory memory = Memory.getMemory();
        ArrayList<String> programMemory = new ArrayList<>();
        OpCode opCode = OpCode.getOpCode();
        String result = "";
        String file = "programs\\sum.txt";
        Codes codes = Codes.getCodes();
        Registers registers = Registers.getRegisters();
        String sumResult;
        
        BufferedReader reader = new BufferedReader( new FileReader( file ) );
        BufferedWriter writer = new BufferedWriter( new FileWriter( "out\\sum_result.txt" ) );
        Lexer lexer = new Lexer( reader );
        while( true ){
            Tokens tokens = lexer.yylex();
            if( tokens == null ){
                break;
            }
            switch( tokens ){
                case NOP:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                            codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                case ORG:
                    initialMemory = Integer.toHexString(
                            Integer.parseInt(
                                lexer.lexeme.split(" ")[1].toLowerCase(),16));
                    programMemory.add(initialMemory.toUpperCase());
                    break;
                case LD1:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
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
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
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
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
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
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
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
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                case ADD1:
                    result += programMemory.get(programMemory.size() - 1) +  "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                case ADD2:
                    result += programMemory.get(programMemory.size() - 1) +  "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                case ADD3:
                    result += programMemory.get(programMemory.size() - 1) +  "|" +
                        codes.getCodeMap().get(lexer.lexeme.split(",")[0] + ",*") + 
                        lexer.lexeme.split(",")[1] + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme.split(",")[0] + ",*") + 
                        lexer.lexeme.split(",")[1]);
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 2;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                    
                case AND1:
                    result += 
                        programMemory.get(programMemory.size() - 1) +  "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                case AND2:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                case AND3:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme.split(" ")[0] + " *") + 
                        lexer.lexeme.split(" ")[1] + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme.split(" ")[1]) + 
                        lexer.lexeme.split(",")[1]);
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 2;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                    
                case OR1:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                case OR2:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                case OR3:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme.split(" ")[0] + " *") + 
                        lexer.lexeme.split(" ")[1] + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme.split(" ")[1]) + 
                        lexer.lexeme.split(",")[1]);
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 2;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                    
                case XOR1:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                case XOR2:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                case XOR3:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme.split(" ")[0] + " *") + 
                        lexer.lexeme.split(" ")[1] + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme.split(" ")[1]) + 
                        lexer.lexeme.split(",")[1]);
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 2;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                    
                case INC1:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                case INC2:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                    
                case DEC1:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                case DEC2:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                    
                case SUB1:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                case SUB2:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                case SUB3:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme.split(",")[0] + ",*") + 
                        lexer.lexeme.split(",")[1] + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme.split(",")[0] + ",*") + 
                        lexer.lexeme.split(",")[1]);
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 2;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                case HALT:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add( codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                case RLCA:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                case RRCA:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                case CPL:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                case NEG:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                    
                case IN:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                    
                case OUT:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                        codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 1;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                    
                case JR1:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                    codes.getCodeMap().get(lexer.lexeme.split(" ")[0] + " *") + "\n";
                    opCode.getOpCodeArray().add(
                        codes.getCodeMap().get(lexer.lexeme.split(" ")[0] + " *")
                        + lexer.lexeme.split(" ")[1]);
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 2;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                case JR2:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                    codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 2;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                case JR3:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                    codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 2;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                case JR4:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                    codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 2;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                case JR5:
                    result += programMemory.get(programMemory.size() - 1) + "|" +
                    codes.getCodeMap().get(lexer.lexeme) + "\n";
                    opCode.getOpCodeArray().add(codes.getCodeMap().get(lexer.lexeme));
                    actualMemory = Integer.parseInt(programMemory.get(programMemory.size() - 1),16) + 2;
                    programMemory.add(Integer.toHexString(actualMemory).toUpperCase());
                    break;
                case Other:
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        programMemory.remove(programMemory.size() - 1);
        for( int i = 0; i < programMemory.size(); i++ ){
            memory.getMemoryHash().put(programMemory.get(i), 
                opCode.getOpCodeArray().get(i));
        }
        registers.getRegistersHash().put("PC", programMemory.get(0));
        writer.write( result );
        writer.flush();
        writer.close();
        
    }
}
