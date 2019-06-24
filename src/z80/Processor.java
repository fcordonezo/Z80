/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z80;
import lexer.Tokens;
import lexer.Lexer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Fabián Ordóñez
 * Jair Villalba
 * Luis Guzman
 */
public class Processor {
    private static HashMap<String, String> memory;
    private static HashMap<String, String> codeMap;
    private static HashMap<String, String> registersHash;
    private String file;
    private static Processor processor;
    private static ALU alu = ALU.getALU();
    private static ArrayList<String> opCode;
    private static Registers registers;
    
    public static Processor getProcessor( String file ){
        if(processor == null){
            processor = new Processor(file);
        }
        return processor;
    }
    private Processor( String file ){
        memory = new HashMap<>();
        codeMap = new HashMap<>();
        this.file = file;
        this.opCode = new ArrayList<>();
        registers = Registers.getRegisters();
        registersHash = registers.getRegistersHash();
        codeMap.put("NOP", "00");
        
        codeMap.put("LD A,A", "7F");
        codeMap.put("LD A,B", "78");
        codeMap.put("LD A,C", "79");
        codeMap.put("LD A,D", "7A");
        codeMap.put("LD A,E", "7B");
        codeMap.put("LD A,H", "7C");
        codeMap.put("LD A,L", "7D");
        codeMap.put("LD A,*", "3E");
        
        codeMap.put("LD B,A", "47");
        codeMap.put("LD B,B", "40");
        codeMap.put("LD B,C", "41");
        codeMap.put("LD B,D", "42");
        codeMap.put("LD B,E", "43");
        codeMap.put("LD B,H", "44");
        codeMap.put("LD B,L", "45");
        codeMap.put("LD B,*", "06");
        
        codeMap.put("LD C,A", "4F");
        codeMap.put("LD C,B", "48");
        codeMap.put("LD C,C", "49");
        codeMap.put("LD C,D", "4A");
        codeMap.put("LD C,E", "4B");
        codeMap.put("LD C,H", "4C");
        codeMap.put("LD C,L", "4D");
        codeMap.put("LD C,*", "0E");
        
        codeMap.put("LD D,A", "57");
        codeMap.put("LD D,B", "50");
        codeMap.put("LD D,C", "51");
        codeMap.put("LD D,D", "52");
        codeMap.put("LD D,E", "53");
        codeMap.put("LD D,H", "54");
        codeMap.put("LD D,L", "55");
        codeMap.put("LD D,*", "16");
        
        codeMap.put("LD E,A", "5F");
        codeMap.put("LD E,B", "58");
        codeMap.put("LD E,C", "59");
        codeMap.put("LD E,D", "5A");
        codeMap.put("LD E,E", "5B");
        codeMap.put("LD E,H", "5C");
        codeMap.put("LD E,L", "5D");
        codeMap.put("LD E,*", "1E");
        
        codeMap.put("LD H,A", "67");
        codeMap.put("LD H,B", "60");
        codeMap.put("LD H,C", "61");
        codeMap.put("LD H,D", "62");
        codeMap.put("LD H,E", "63");
        codeMap.put("LD H,H", "64");
        codeMap.put("LD H,L", "65");
        codeMap.put("LD H,*", "26");
        
        codeMap.put("LD L,A", "6F");
        codeMap.put("LD L,B", "68");
        codeMap.put("LD L,C", "69");
        codeMap.put("LD L,D", "6A");
        codeMap.put("LD L,E", "6B");
        codeMap.put("LD L,H", "6C");
        codeMap.put("LD L,L", "6D");
        codeMap.put("LD L,*", "2E");
        
        codeMap.put("LD (BC),**", "01");
        codeMap.put("LD (DE),**", "11");
        codeMap.put("LD (HL),**", "21");
        codeMap.put("LD (SP),**", "31");
        
        codeMap.put("LD (**),A", "32");
        codeMap.put("LD (**),HL", "22");
        
        codeMap.put("ADD A,A", "87");
        codeMap.put("ADD A,B", "80");
        codeMap.put("ADD A,C", "81");
        codeMap.put("ADD A,D", "82");
        codeMap.put("ADD A,E", "83");
        codeMap.put("ADD A,H", "84");
        codeMap.put("ADD A,L", "85");
        codeMap.put("ADD A,(HL)", "86");
        codeMap.put("ADD A,*", "C6");
    }
    public HashMap<String, String> getRegisters(){
        return registersHash;
    }
    public HashMap<String, String> getMemory(){
        return memory;
    }
    public ArrayList<String> getOpCode(){
        return opCode;
    }
    public void process() throws FileNotFoundException, IOException{
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
                    break;
                case ORG:
                    registersHash.put("Init", lexer.lexeme.split(" ")[1]);
                    break;
                case LD1:
                    registersHash.put(lexer.lexeme.split(" ")[1].split(",")[0], 
                        registersHash.get(lexer.lexeme.split(" ")[1].split(",")[1]));
                    opCode.add(codeMap.get(lexer.lexeme));
                    break;
                case LD2:
                    registersHash.put(lexer.lexeme.split(" ")[1].split(",")[0],
                        lexer.lexeme.split(" ")[1].split(",")[1]);
                    opCode.add(codeMap.get(
                        lexer.lexeme.split(",")[0] + "," + "*") + 
                        lexer.lexeme.split(" ")[1].split(",")[1]);
                    break;
                case LD3:
                    registersHash.put(lexer.lexeme.split(" ")[1].split(",")[0].substring(0, 1), 
                        registersHash.get(lexer.lexeme.split(" ")[1].split(",")[1].substring(2, 3)));
                    registersHash.put(lexer.lexeme.split(" ")[1].split(",")[0].substring(1, 2), 
                        registersHash.get(lexer.lexeme.split(" ")[1].split(",")[1].substring(0, 1)));
                    opCode.add(codeMap.get(
                        lexer.lexeme.split(",")[0] + "," + "**") + 
                        lexer.lexeme.split(" ")[1].split(",")[1]);
                    break;
                case LD4:
                    memory.put(lexer.lexeme.split(" ")[1].split(",")[0].replace("(", "").replace(")", ""), 
                        registersHash.get("A"));
                    opCode.add( codeMap.get(
                            lexer.lexeme.split(" ")[0] + " (**),A" ) + 
                        lexer.lexeme.split(" ")[1].split(",")[0].replace("(", "").replace(")", ""));
                    break;
                case LD5:
                    memory.put(lexer.lexeme.split(" ")[1].split(",")[0].replace("(", "").replace(")", "").substring(0, 2), 
                        memory.get(registersHash.get("L")));
                    memory.put(lexer.lexeme.split(" ")[1].split(",")[0].replace("(", "").replace(")", "").substring(2, 4), 
                        memory.get(registersHash.get("H"))); 
                    opCode.add( codeMap.get(
                            lexer.lexeme.split(" ")[0] + " (**),HL" ) + 
                        lexer.lexeme.split(" ")[1].split(",")[0].replace("(", "").replace(")", ""));
                    break;
                case ADD1:
                    sumResult = alu.sum(registersHash.get("A"), 
                        registersHash.get(lexer.lexeme.split(" ")[1].split(",")[1]));
                    registersHash.put("A", sumResult);
                    break;
                case ADD2:
                    sumResult = alu.sum(registersHash.get("A"), 
                        memory.get(registersHash.get("H") + registersHash.get("L")));
                    registersHash.put("A",sumResult);
                    break;
                case ADD3:
                    sumResult = alu.sum(registersHash.get("A"), 
                        lexer.lexeme.split(" ")[1].split(",")[1]);
                    registersHash.put("A",sumResult);
                    break;
                case Other:
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }  
    }
}
