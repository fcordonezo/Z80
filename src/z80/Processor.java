/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z80;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import main.OpCode;

/**
 *
 * @author Fabián Ordóñez
 * Jair Villalba
 * Luis Guzman
 */
public class Processor {
    private static Flags flags;
    public static String portIN;
    public static String portOUT;
    private static OpCode opCode;
    private static Memory memory;
    private static Processor processor;
    private static ALU alu;
    private static Registers registers;
    
    public static Processor getProcessor(){
        if(processor == null){
            processor = new Processor();
        }
        return processor;
    }
    private Processor(){
        portIN = "";
        portOUT = "";
        flags = Flags.getFlags();
        alu = ALU.getALU();
        opCode = OpCode.getOpCode();
        memory = Memory.getMemory();
        registers = Registers.getRegisters();
    }
    
    public String getPortIN(){
        return portIN;
    }
    public void setPortIN( String portIN ){
        this.portIN = portIN;
    }
    
    public String getPortOUT(){
        return portOUT;
    }
    
    public Memory getMemory(){
        return memory;
    }
    public Registers getRegisters(){
        return registers;
    }

    public void process() throws FileNotFoundException, IOException{
        ArrayList<String> setMemory = new ArrayList<>();
        setMemory.addAll(Arrays.asList(memory.getMemoryHash().keySet().toArray(new String[0])));
        Collections.sort(setMemory);
        String PC = registers.getRegistersHash().get("PC");
        String BR;
        String IR;
        String HL;
        String resultRegisters;
        String resultMemory;
        String resultFlags;
        String byte_;
        int i = 0;
        resultRegisters = "[REGISTROS: ";
        resultMemory = "[MEMORIA: ";
        resultFlags = "[BANDERAS: ";
        resultRegisters += "A = " + registers.getRegistersHash().get("A") + ", ";
        resultRegisters += "B = " + registers.getRegistersHash().get("B") + ", ";
        resultRegisters += "C = " + registers.getRegistersHash().get("C") + ", ";
        resultRegisters += "D = " + registers.getRegistersHash().get("D") + ", ";
        resultRegisters += "E = " + registers.getRegistersHash().get("E") + ", ";
        resultRegisters += "H = " + registers.getRegistersHash().get("H") + ", ";
        resultRegisters += "L = " + registers.getRegistersHash().get("L") + ", ";
        resultRegisters += "IX = " + registers.getRegistersHash().get("IX") + ", ";
        resultRegisters += "IY = " + registers.getRegistersHash().get("IY") + ", ";
        resultRegisters += "SP = " + registers.getRegistersHash().get("SP") + ", ";
        resultRegisters += "PC = " + registers.getRegistersHash().get("PC") + "]";
        resultFlags += "P/V = " + flags.getFlagsMap().get("P/V") + ", ";
        resultFlags += "S = " + flags.getFlagsMap().get("S") + ", ";
        resultFlags += "Z = " + flags.getFlagsMap().get("Z") + ", ";
        resultFlags += "AC = " + flags.getFlagsMap().get("AC") + ", ";
        resultFlags += "C = " + flags.getFlagsMap().get("C") + "]";
        resultMemory += memory.getMemoryHash() + "]\n";
        System.out.println(resultRegisters);
        System.out.println(resultFlags);
        System.out.println(resultMemory);

        do{
            resultRegisters = "[REGISTROS: ";
            resultMemory = "[MEMORIA: ";
            resultFlags = "[BANDERAS: ";
            switch( memory.getMemoryHash().get(PC).substring(0, 2) ){
                case "00": //NOP
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    break; 
                case "7F": //LD A,A
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "A", registers.getRegistersHash().get("A") );
                    break;
                case "78": //LD A,B
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "A", registers.getRegistersHash().get("B") );
                    break;
                case "79": //LD A,C
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "A", registers.getRegistersHash().get("C") );
                    break;
                case "7A": //LD A,D
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "A", registers.getRegistersHash().get("D") );
                    break;
                case "7B": //LD A,E
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "A", registers.getRegistersHash().get("E") );
                    break;
                case "7C": //LD A,H
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "A", registers.getRegistersHash().get("H") );
                    break;
                case "7D": //LD A,L
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "A", registers.getRegistersHash().get("L") );
                    break;
                case "3E": //LD A,*
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "A", opCode.getOpCodeArray().get(i).substring(2, 4) );
                    break;
                case "47": //LD B,A
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "B", registers.getRegistersHash().get("A") );
                    break;
                case "40": //LD B,B
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "B", registers.getRegistersHash().get("B") );
                    break;
                case "41": //LD B,C
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "B", registers.getRegistersHash().get("C") );
                    break;
                case "42": //LD B,D
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "B", registers.getRegistersHash().get("D") );
                    break;
                case "43": //LD B,E
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "B", registers.getRegistersHash().get("E") );
                    break;
                case "44": //LD B,H
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "B", registers.getRegistersHash().get("H") );
                    break;
                case "45": //LD B,L
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "B", registers.getRegistersHash().get("L") );
                    break;
                case "06": //LD B,*
                    
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "B", opCode.getOpCodeArray().get(i).substring(2, 4) );
                    break;
                    
                case "4F": //LD C,A
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "C", registers.getRegistersHash().get("A") );
                    break;
                case "48": //LD C,B
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "C", registers.getRegistersHash().get("B") );
                    break;
                case "49": //LD C,C
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "C", registers.getRegistersHash().get("C") );
                    break;
                case "4A": //LD C,D
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "C", registers.getRegistersHash().get("D") );
                    break;
                case "4B": //LD C,E
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "C", registers.getRegistersHash().get("E") );
                    break;
                case "4C": //LD C,H
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "C", registers.getRegistersHash().get("H") );
                    break;
                case "4D": //LD C,L
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "C", registers.getRegistersHash().get("L") );
                    break;
                case "0E": //LD C,*
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "C", opCode.getOpCodeArray().get(i).substring(2, 4) );
                    break;
                    
                case "57": //LD D,A
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "D", registers.getRegistersHash().get("A") );
                    break;
                case "50": //LD D,B
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "D", registers.getRegistersHash().get("B") );
                    break;
                case "51": //LD D,C
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "D", registers.getRegistersHash().get("C") );
                    break;
                case "52": //LD D,D
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "D", registers.getRegistersHash().get("D") );
                    break;
                case "53": //LD D,E
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "D", registers.getRegistersHash().get("E") );
                    break;
                case "54": //LD D,H
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "D", registers.getRegistersHash().get("H") );
                    break;
                case "55": //LD D,L
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "D", registers.getRegistersHash().get("L") );
                    break;
                case "16": //LD D,*
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "D", opCode.getOpCodeArray().get(i).substring(2, 4) );
                    break;
                    
                case "5F": //LD E,A
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "E", registers.getRegistersHash().get("A") );
                    break;
                case "58": //LD E,B
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "E", registers.getRegistersHash().get("B") );
                    break;
                case "59": //LD E,C
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "E", registers.getRegistersHash().get("C") );
                    break;
                case "5A": //LD E,D
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "E", registers.getRegistersHash().get("D") );
                    break;
                case "5B": //LD E,E
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "E", registers.getRegistersHash().get("E") );
                    break;
                case "5C": //LD E,H
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "E", registers.getRegistersHash().get("H") );
                    break;
                case "5D": //LD E,L
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "E", registers.getRegistersHash().get("L") );
                    break;
                case "1E": //LD E,*
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "E", opCode.getOpCodeArray().get(i).substring(2, 4) );
                    break;
                    
                case "67": //LD H,A
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "H", registers.getRegistersHash().get("A") );
                    break;
                case "60": //LD H,B
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "H", registers.getRegistersHash().get("B") );
                    break;
                case "61": //LD H,C
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "H", registers.getRegistersHash().get("C") );
                    break;
                case "62": //LD H,D
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "H", registers.getRegistersHash().get("D") );
                    break;
                case "63": //LD H,E
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "H", registers.getRegistersHash().get("E") );
                    break;
                case "64": //LD H,H
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "H", registers.getRegistersHash().get("H") );
                    break;
                case "65": //LD H,L
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "H", registers.getRegistersHash().get("L") );
                    break;
                case "26": //LD H,*
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "H", opCode.getOpCodeArray().get(i).substring(2, 4) );
                    break;
                    
                case "6F": //LD L,A
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "L", registers.getRegistersHash().get("A") );
                    break;
                case "68": //LD L,B
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "L", registers.getRegistersHash().get("B") );
                    break;
                case "69": //LD L,C
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "L", registers.getRegistersHash().get("C") );
                    break;
                case "6A": //LD L,D
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "L", registers.getRegistersHash().get("D") );
                    break;
                case "6B": //LD L,E
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "L", registers.getRegistersHash().get("E") );
                    break;
                case "6C": //LD L,H
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "L", registers.getRegistersHash().get("H") );
                    break;
                case "6D": //LD L,L
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "L", registers.getRegistersHash().get("L") );
                    break;
                case "2E": //LD L,*
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "L", opCode.getOpCodeArray().get(i).substring(2, 4) );
                    break;
                    
                case "01": //LD (BC),**
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "C", opCode.getOpCodeArray().get(i).substring(2, 4) );
                    registers.getRegistersHash().put(
                        "B", opCode.getOpCodeArray().get(i).substring(4, 6) );
                    break;
                case "11": //LD (DE),**
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "E", opCode.getOpCodeArray().get(i).substring(2, 4) );
                    registers.getRegistersHash().put(
                        "D", opCode.getOpCodeArray().get(i).substring(4, 6) );
                    break;
                case "21": //LD (HL),**
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "D", opCode.getOpCodeArray().get(i).substring(2, 4) );
                    registers.getRegistersHash().put(
                        "L", opCode.getOpCodeArray().get(i).substring(4, 6) );
                    break;
                case "31": //LD (SP),**
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put(
                        "SP", opCode.getOpCodeArray().get(i).substring(2, 6) );
                    break;
                    
                case "32": //LD (**),A
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    memory.getMemoryHash().put(
                        opCode.getOpCodeArray().get(i).substring(2, 6),
                        registers.getRegistersHash().get("A"));
                    break;
                case "22": //LD (**),HL
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    memory.getMemoryHash().put(
                        opCode.getOpCodeArray().get(i).substring(2, 6),
                        registers.getRegistersHash().get("H") + 
                            registers.getRegistersHash().get("L"));
                    break;
                    
                case "87": //ADD A,A
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.add(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("A")));
                    
                    break;
                case "80": //ADD A,B
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.add(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("B")));
                    break;
                case "81": //ADD A,C
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.add(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("C")));
                    break;
                case "82": //ADD A,D
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.add(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("D")));
                    break;
                case "83": //ADD A,E
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.add(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("E")));
                    break;
                case "84": //ADD A,H
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.add(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("H")));
                    break;
                case "85": //ADD A,L
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.add(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("L")));
                    break;
                case "86": //ADD A,(HL)
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.add(registers.getRegistersHash().get("A"),
                            memory.getMemoryHash().get(
                                registers.getRegistersHash().get("H") + 
                                    registers.getRegistersHash().get("L"))));
                    break;
                case "C6": //ADD A,*
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.add(registers.getRegistersHash().get("A"),
                            opCode.getOpCodeArray().get(i).substring(2, 4)));
                    break;
                    
                case "97": //SUB A,A
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.sub(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("A")));
                    break;
                case "90": //SUB A,B
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.sub(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("B")));
                    break;
                case "91": //SUB A,C
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.sub(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("C")));
                    break;
                case "92": //SUB A,D
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.sub(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("D")));
                    break;
                case "93": //SUB A,E
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.sub(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("E")));
                    break;
                case "94": //SUB A,H
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.sub(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("H")));
                    break;
                case "95": //SUB A,L
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.sub(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("L")));
                    break;
                case "96": //SUB A,(HL)
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.sub(registers.getRegistersHash().get("A"),
                            memory.getMemoryHash().get(
                                registers.getRegistersHash().get("H") + 
                                    registers.getRegistersHash().get("L"))));
                    break;
                case "D6": //SUB A,*
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.sub(registers.getRegistersHash().get("A"),
                            opCode.getOpCodeArray().get(i).substring(2, 4)));
                    break;
                    
                case "A7": //AND A,A
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.and(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("A")));
                    break;
                case "A0": //AND A,B
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.and(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("B")));
                    break;
                case "A1": //AND A,C
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.and(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("C")));
                    break;
                case "A2": //AND A,D
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.and(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("D")));
                    break;
                case "A3": //AND A,E
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.and(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("E")));
                    break;
                case "A4": //AND A,H
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.and(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("H")));
                    break;
                case "A5": //AND A,L
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.and(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("L")));
                    break;
                case "A6": //AND A,(HL)
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.and(registers.getRegistersHash().get("A"),
                            memory.getMemoryHash().get(
                                registers.getRegistersHash().get("H") + 
                                    registers.getRegistersHash().get("L"))));
                    break;
                case "E6": //AND A,*
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.and(registers.getRegistersHash().get("A"),
                            opCode.getOpCodeArray().get(i).substring(2, 4)));
                    break;
                    
                case "B7": //OR A,A
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.or(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("A")));
                    break;
                case "B0": //OR A,B
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.or(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("B")));
                    break;
                case "B1": //OR A,C
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.or(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("C")));
                    break;
                case "B2": //OR A,D
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.or(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("D")));
                    break;
                case "B3": //OR A,E
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.or(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("E")));
                    break;
                case "B4": //OR A,H
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.or(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("H")));
                    break;
                case "B5": //OR A,L
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.or(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("L")));
                    break;
                case "B6": //OR A,(HL)
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.or(registers.getRegistersHash().get("A"),
                            memory.getMemoryHash().get(
                                registers.getRegistersHash().get("H") + 
                                    registers.getRegistersHash().get("L"))));
                    break;
                case "F6": //OR A,*
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.or(registers.getRegistersHash().get("A"),
                            opCode.getOpCodeArray().get(i).substring(2, 4)));
                    break;
                    
                case "AF": //XOR A,A
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.xor(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("A")));
                    break;
                case "A8": //XOR A,B
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.xor(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("B")));
                    break;
                case "A9": //XOR A,C
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.xor(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("C")));
                    break;
                case "AA": //XOR A,D
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.xor(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("D")));
                    break;
                case "AB": //XOR A,E
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.xor(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("E")));
                    break;
                case "AC": //XOR A,H
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.xor(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("H")));
                    break;
                case "AD": //XOR A,L
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.xor(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("L")));
                    break;
                case "AE": //XOR A,(HL)
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.xor(registers.getRegistersHash().get("A"),
                            memory.getMemoryHash().get(
                                registers.getRegistersHash().get("H") + 
                                    registers.getRegistersHash().get("L"))));
                    break;
                case "EE": //XOR A,*
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.or(registers.getRegistersHash().get("A"),
                            opCode.getOpCodeArray().get(i).substring(2, 4)));
                    break;
                    
                case "3C": //INC A
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.inc(registers.getRegistersHash().get("A")));
                    break;
                case "04": //INC B
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("B",
                        alu.inc(registers.getRegistersHash().get("B")));
                    break;
                case "0C": //INC C
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("C",
                        alu.inc(registers.getRegistersHash().get("C")));
                    break;
                case "14": //INC D
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("D",
                        alu.inc(registers.getRegistersHash().get("D")));
                    break;
                case "1C": //INC E
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("E",
                        alu.inc(registers.getRegistersHash().get("E")));
                    break;
                case "24": //INC H
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("H",
                        alu.inc(registers.getRegistersHash().get("H")));
                    break;
                case "2C": //INC L
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("L",
                        alu.inc(registers.getRegistersHash().get("L")));
                    break;
                case "34": //INC (HL)
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    HL = registers.getRegistersHash().get("H") + 
                        registers.getRegistersHash().get("L");
                    HL = alu.inc(HL);
                    registers.getRegistersHash().put("H",
                        HL.substring(0, 2));
                    registers.getRegistersHash().put("L",
                        HL.substring(2, 4));
                    break;
                    
                case "3D": //DEC A
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.dec(registers.getRegistersHash().get("A")));
                    break;
                case "05": //DEC B
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("B",
                        alu.dec(registers.getRegistersHash().get("B")));
                    break;
                case "0D": //DEC C
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("C",
                        alu.inc(registers.getRegistersHash().get("C")));
                    break;
                case "15": //DEC D
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("D",
                        alu.dec(registers.getRegistersHash().get("D")));
                    break;
                case "1D": //DEC E
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("E",
                        alu.dec(registers.getRegistersHash().get("E")));
                    break;
                case "25": //DEC H
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("H",
                        alu.dec(registers.getRegistersHash().get("H")));
                    break;
                case "2D": //DEC L
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("L",
                        alu.dec(registers.getRegistersHash().get("L")));
                    break;
                case "35": //DEC (HL)
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    HL = registers.getRegistersHash().get("H") + 
                        registers.getRegistersHash().get("L");
                    HL = alu.dec(HL);
                    registers.getRegistersHash().put("H",
                        HL.substring(0, 2));
                    registers.getRegistersHash().put("L",
                        HL.substring(2, 4));
                    break;
                    
                case "DB": //IN A,(*)
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A", portIN);
                    break;
                case "D3": //OUT (*),A
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    portOUT = registers.getRegistersHash().get("A");
                    break;
                case "76":
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    break;
                case "2F":
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.cpl(registers.getRegistersHash().get("A")));
                    break;
                case "ED":
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    switch(opCode.getOpCodeArray().get(i).substring(2, 4)){
                        case "44":
                            registers.getRegistersHash().put("A",
                                alu.neg(registers.getRegistersHash().get("A")));
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                    break;
                case "18": //JR *
                    i = setMemory.indexOf(PC);
                    byte_ = Integer.toBinaryString(
                        Integer.parseInt(
                            opCode.getOpCodeArray().get(setMemory.indexOf(PC)).substring(2), 16));
                    PC = Integer.toHexString(Integer.parseInt(PC,16) + 1).toUpperCase();
                    
                    if(byte_.substring(0, 1).equals("1") && byte_.length() == 8){
                        int aux = Integer.parseInt(opCode.getOpCodeArray().get(i), 16);
                        aux = -aux;
                        aux = Integer.parseInt(
                            Integer.toHexString(aux).substring(
                                Integer.toHexString(aux).length() - 2),16);
                        
                        PC = Integer.toHexString(
                            Integer.parseInt(PC, 16) - aux).toUpperCase();
                    }
                    else{
                        
                        PC = Integer.toHexString(Integer.parseInt(PC, 16) +
                            Integer.parseInt(
                                opCode.getOpCodeArray().get(i).substring(2), 16)).toUpperCase();
                    }
                    
                    registers.getRegistersHash().put("PC",PC);
                    break;
                case "28": //JR Z,*
                    if(flags.getFlagsMap().get("Z").equals("1")){
                       i = setMemory.indexOf(PC);
                        byte_ = Integer.toBinaryString(
                            Integer.parseInt(
                                opCode.getOpCodeArray().get(setMemory.indexOf(PC)).substring(2), 16));
                        PC = Integer.toHexString(Integer.parseInt(PC,16) + 1).toUpperCase();

                        if(byte_.substring(0, 1).equals("1") && byte_.length() == 8){
                            int aux = Integer.parseInt(opCode.getOpCodeArray().get(i), 16);
                            aux = -aux;
                            aux = Integer.parseInt(
                                Integer.toHexString(aux).substring(
                                    Integer.toHexString(aux).length() - 2),16);

                            PC = Integer.toHexString(
                                Integer.parseInt(PC, 16) - aux).toUpperCase();
                        }
                        else{
                            PC = Integer.toHexString(Integer.parseInt(PC, 16) +
                                Integer.parseInt(
                                    opCode.getOpCodeArray().get(i).substring(2), 16)).toUpperCase();
                        } 
                    }
                    else
                        PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    break;
                case "38": //JR C,*
                    if(flags.getFlagsMap().get("C").equals("1")){
                       i = setMemory.indexOf(PC);
                        byte_ = Integer.toBinaryString(
                            Integer.parseInt(
                                opCode.getOpCodeArray().get(setMemory.indexOf(PC)).substring(2), 16));
                        PC = Integer.toHexString(Integer.parseInt(PC,16) + 1).toUpperCase();

                        if(byte_.substring(0, 1).equals("1") && byte_.length() == 8){
                            int aux = Integer.parseInt(opCode.getOpCodeArray().get(i), 16);
                            aux = -aux;
                            aux = Integer.parseInt(
                                Integer.toHexString(aux).substring(
                                    Integer.toHexString(aux).length() - 2),16);

                            PC = Integer.toHexString(
                                Integer.parseInt(PC, 16) - aux).toUpperCase();
                        }
                        else{
                            PC = Integer.toHexString(Integer.parseInt(PC, 16) +
                                Integer.parseInt(
                                    opCode.getOpCodeArray().get(i).substring(2), 16)).toUpperCase();
                        } 
                    }
                    else
                        PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    break;
                case "20": //JR NZ,*
                    if(!flags.getFlagsMap().get("Z").equals("1")){
                       i = setMemory.indexOf(PC);
                        byte_ = Integer.toBinaryString(
                            Integer.parseInt(
                                opCode.getOpCodeArray().get(setMemory.indexOf(PC)).substring(2), 16));
                        PC = Integer.toHexString(Integer.parseInt(PC,16) + 1).toUpperCase();

                        if(byte_.substring(0, 1).equals("1") && byte_.length() == 8){
                            int aux = Integer.parseInt(opCode.getOpCodeArray().get(i), 16);
                            aux = -aux;
                            aux = Integer.parseInt(
                                Integer.toHexString(aux).substring(
                                    Integer.toHexString(aux).length() - 2),16);

                            PC = Integer.toHexString(
                                Integer.parseInt(PC, 16) - aux).toUpperCase();
                        }
                        else{
                            PC = Integer.toHexString(Integer.parseInt(PC, 16) +
                                Integer.parseInt(
                                    opCode.getOpCodeArray().get(i).substring(2), 16)).toUpperCase();
                        } 
                    }
                    else
                        PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    break;
                case "30": //JR NC,*
                    if(!flags.getFlagsMap().get("C").equals("1")){
                       i = setMemory.indexOf(PC);
                        byte_ = Integer.toBinaryString(
                            Integer.parseInt(
                                opCode.getOpCodeArray().get(setMemory.indexOf(PC)).substring(2), 16));
                        PC = Integer.toHexString(Integer.parseInt(PC,16) + 1).toUpperCase();

                        if(byte_.substring(0, 1).equals("1") && byte_.length() == 8){
                            int aux = Integer.parseInt(opCode.getOpCodeArray().get(i), 16);
                            aux = -aux;
                            aux = Integer.parseInt(
                                Integer.toHexString(aux).substring(
                                    Integer.toHexString(aux).length() - 2),16);

                            PC = Integer.toHexString(
                                Integer.parseInt(PC, 16) - aux).toUpperCase();
                        }
                        else{
                            PC = Integer.toHexString(Integer.parseInt(PC, 16) +
                                Integer.parseInt(
                                    opCode.getOpCodeArray().get(i).substring(2), 16)).toUpperCase();
                        } 
                    }
                    else
                        PC = setMemory.get(setMemory.indexOf(PC) + 1);
                    registers.getRegistersHash().put("PC",PC);
                    break;
                case "0F":
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.rrca(registers.getRegistersHash().get("A")));
                    break;
                case "07":
                    PC = setMemory.get(setMemory.indexOf(PC) + 1);                     
                    registers.getRegistersHash().put("PC",PC);
                    registers.getRegistersHash().put("A",
                        alu.rlca(registers.getRegistersHash().get("A")));
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            resultRegisters += "A = " + registers.getRegistersHash().get("A") + ", ";
            resultRegisters += "B = " + registers.getRegistersHash().get("B") + ", ";
            resultRegisters += "C = " + registers.getRegistersHash().get("C") + ", ";
            resultRegisters += "D = " + registers.getRegistersHash().get("D") + ", ";
            resultRegisters += "E = " + registers.getRegistersHash().get("E") + ", ";
            resultRegisters += "H = " + registers.getRegistersHash().get("H") + ", ";
            resultRegisters += "L = " + registers.getRegistersHash().get("L") + ", ";
            resultRegisters += "IX = " + registers.getRegistersHash().get("IX") + ", ";
            resultRegisters += "IY = " + registers.getRegistersHash().get("IY") + ", ";
            resultRegisters += "SP = " + registers.getRegistersHash().get("SP") + ", ";
            resultRegisters += "PC = " + registers.getRegistersHash().get("PC") + "]";
            resultFlags += "P/V = " + flags.getFlagsMap().get("P/V") + ", ";
            resultFlags += "S = " + flags.getFlagsMap().get("S") + ", ";
            resultFlags += "Z = " + flags.getFlagsMap().get("Z") + ", ";
            resultFlags += "AC = " + flags.getFlagsMap().get("AC") + ", ";
            resultFlags += "C = " + flags.getFlagsMap().get("C") + "]";
            resultMemory += memory.getMemoryHash() + "]\n";
            System.out.println(resultRegisters);
            System.out.println(resultFlags);
            System.out.println(resultMemory);
            i ++;
        }while(!memory.getMemoryHash().get(PC).equals("76"));
    }
}
