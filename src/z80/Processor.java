/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z80;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author Camilo
 */
public class Processor {
    private HashMap<String, String> registers;
    private HashMap<String, String> memory;
    private String file;
    private static Processor processor;
    private ALU alu = ALU.getALU();
    private String opCode;
    public static Processor getProcessor( String file ){
        if(processor == null){
            processor = new Processor(file);
        }
        return processor;
    }
    private Processor( String file ){
        registers = new HashMap<>();
        memory = new HashMap<>();
        this.file = file;
        this.opCode = "";
    }
    public HashMap<String, String> getRegisters(){
        return this.registers;
    }
    public HashMap<String, String> getMemory(){
        return this.memory;
    }
    public void process() throws FileNotFoundException, IOException{
        String sumResult;
        registers.put( "A", "" );
        registers.put( "B", "" );
        registers.put( "C", "" );
        registers.put( "D", "" );
        registers.put( "E", "" );
        registers.put( "H", "" );
        registers.put( "L", "" );
        registers.put( "Init" , "" ); 
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
                    break;
                case ORG:
                    registers.put( "Init", lexer.lexeme.split(" ")[1] );
                    break;
                case LD1:
                    //System.out.println(lexer.lexeme);
                    registers.put( lexer.lexeme.split( " " )[1].split( "," )[0], 
                        registers.get( lexer.lexeme.split( " " )[1].split( "," )[1] ) );
                    break;
                case LD2:
                    System.out.println(lexer.lexeme);
                    registers.put(lexer.lexeme.split(" ")[1].split(",")[0],
                        lexer.lexeme.split(" ")[1].split(",")[1]);
                    break;
                case LD3:
                    //System.out.println(lexer.lexeme);
                    registers.put(lexer.lexeme.split(" ")[1].split(",")[0].substring(0, 1), 
                        registers.get(lexer.lexeme.split(" ")[1].split(",")[1].substring(2, 3)));
                    registers.put(lexer.lexeme.split(" ")[1].split(",")[0].substring(1, 2), 
                        registers.get(lexer.lexeme.split(" ")[1].split(",")[1].substring(0, 1)));
                    break;
                case LD4:
                    //System.out.println(lexer.lexeme);
                    memory.put(lexer.lexeme.split(" ")[1].split(",")[0].replace("(", "").replace(")", ""), 
                        lexer.lexeme.split(" ")[1].split(",")[1]);
                    break;
                case LD5:
                    //System.out.println(lexer.lexeme);
                    memory.put(lexer.lexeme.split(" ")[1].split(",")[0].replace("(", "").replace(")", "").substring(0, 2), 
                        lexer.lexeme.split(" ")[1].split(",")[1].substring(2, 4));
                    memory.put(lexer.lexeme.split(" ")[1].split(",")[0].replace("(", "").replace(")", "").substring(2, 4), 
                        lexer.lexeme.split(" ")[1].split(",")[1].substring(0, 2)); 
                    break;
                case ADD1:
                    sumResult = alu.sum(registers.get("A"), 
                        registers.get(lexer.lexeme.split(" ")[1].split(",")[1]));
                    registers.put("A", sumResult);
                    break;
                case ADD2:
                    sumResult = alu.sum(registers.get("A"), 
                        memory.get(registers.get("H") + registers.get("L")));
                    registers.put("A",sumResult);
                    break;
                case ADD3:
                    sumResult = alu.sum(registers.get("A"), 
                        lexer.lexeme.split(" ")[1].split(",")[1]);
                    registers.put("A",sumResult);
                    break;
                case Other:
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        
    }
}
