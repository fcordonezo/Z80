/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z80;
import java.io.FileNotFoundException;
import java.io.IOException;
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
        String HL;
        String resultRegisters;
        String resultMemory;
        String resultFlags;
        for( int i = 0; i < opCode.getOpCodeArray().size(); i++ ){
            resultRegisters = "[REGISTROS: ";
            resultMemory = "[MEMORIA: ";
            resultFlags = "[BANDERAS: ";
            switch( opCode.getOpCodeArray().get(i).substring(0, 2) ){
                case "00": //NOP
                    break; 
                case "7F": //LD A,A
                    registers.getRegistersHash().put(
                        "A", registers.getRegistersHash().get("A") );
                    break;
                case "78": //LD A,B
                    registers.getRegistersHash().put(
                        "A", registers.getRegistersHash().get("B") );
                    break;
                case "79": //LD A,C
                    registers.getRegistersHash().put(
                        "A", registers.getRegistersHash().get("C") );
                    break;
                case "7A": //LD A,D
                    registers.getRegistersHash().put(
                        "A", registers.getRegistersHash().get("D") );
                    break;
                case "7B": //LD A,E
                    registers.getRegistersHash().put(
                        "A", registers.getRegistersHash().get("E") );
                    break;
                case "7C": //LD A,H
                    registers.getRegistersHash().put(
                        "A", registers.getRegistersHash().get("H") );
                    break;
                case "7D": //LD A,L
                    registers.getRegistersHash().put(
                        "A", registers.getRegistersHash().get("L") );
                    break;
                case "3E": //LD A,*
                    registers.getRegistersHash().put(
                        "A", opCode.getOpCodeArray().get(i).substring(2, 4) );
                    break;
                case "47": //LD B,A
                    registers.getRegistersHash().put(
                        "B", registers.getRegistersHash().get("A") );
                    break;
                case "40": //LD B,B
                    registers.getRegistersHash().put(
                        "B", registers.getRegistersHash().get("B") );
                    break;
                case "41": //LD B,C
                    registers.getRegistersHash().put(
                        "B", registers.getRegistersHash().get("C") );
                    break;
                case "42": //LD B,D
                    registers.getRegistersHash().put(
                        "B", registers.getRegistersHash().get("D") );
                    break;
                case "43": //LD B,E
                    registers.getRegistersHash().put(
                        "B", registers.getRegistersHash().get("E") );
                    break;
                case "44": //LD B,H
                    registers.getRegistersHash().put(
                        "B", registers.getRegistersHash().get("H") );
                    break;
                case "45": //LD B,L
                    registers.getRegistersHash().put(
                        "B", registers.getRegistersHash().get("L") );
                    break;
                case "06": //LD B,*
                    registers.getRegistersHash().put(
                        "B", opCode.getOpCodeArray().get(i).substring(2, 4) );
                    break;
                    
                case "4F": //LD C,A
                    registers.getRegistersHash().put(
                        "C", registers.getRegistersHash().get("A") );
                    break;
                case "48": //LD C,B
                    registers.getRegistersHash().put(
                        "C", registers.getRegistersHash().get("B") );
                    break;
                case "49": //LD C,C
                    registers.getRegistersHash().put(
                        "C", registers.getRegistersHash().get("C") );
                    break;
                case "4A": //LD C,D
                    registers.getRegistersHash().put(
                        "C", registers.getRegistersHash().get("D") );
                    break;
                case "4B": //LD C,E
                    registers.getRegistersHash().put(
                        "C", registers.getRegistersHash().get("E") );
                    break;
                case "4C": //LD C,H
                    registers.getRegistersHash().put(
                        "C", registers.getRegistersHash().get("H") );
                    break;
                case "4D": //LD C,L
                    registers.getRegistersHash().put(
                        "C", registers.getRegistersHash().get("L") );
                    break;
                case "0E": //LD C,*
                    registers.getRegistersHash().put(
                        "C", opCode.getOpCodeArray().get(i).substring(2, 4) );
                    break;
                    
                case "57": //LD D,A
                    registers.getRegistersHash().put(
                        "D", registers.getRegistersHash().get("A") );
                    break;
                case "50": //LD D,B
                    registers.getRegistersHash().put(
                        "D", registers.getRegistersHash().get("B") );
                    break;
                case "51": //LD D,C
                    registers.getRegistersHash().put(
                        "D", registers.getRegistersHash().get("C") );
                    break;
                case "52": //LD D,D
                    registers.getRegistersHash().put(
                        "D", registers.getRegistersHash().get("D") );
                    break;
                case "53": //LD D,E
                    registers.getRegistersHash().put(
                        "D", registers.getRegistersHash().get("E") );
                    break;
                case "54": //LD D,H
                    registers.getRegistersHash().put(
                        "D", registers.getRegistersHash().get("H") );
                    break;
                case "55": //LD D,L
                    registers.getRegistersHash().put(
                        "D", registers.getRegistersHash().get("L") );
                    break;
                case "16": //LD D,*
                    registers.getRegistersHash().put(
                        "D", opCode.getOpCodeArray().get(i).substring(2, 4) );
                    break;
                    
                case "5F": //LD E,A
                    registers.getRegistersHash().put(
                        "E", registers.getRegistersHash().get("A") );
                    break;
                case "58": //LD E,B
                    registers.getRegistersHash().put(
                        "E", registers.getRegistersHash().get("B") );
                    break;
                case "59": //LD E,C
                    registers.getRegistersHash().put(
                        "E", registers.getRegistersHash().get("C") );
                    break;
                case "5A": //LD E,D
                    registers.getRegistersHash().put(
                        "E", registers.getRegistersHash().get("D") );
                    break;
                case "5B": //LD E,E
                    registers.getRegistersHash().put(
                        "E", registers.getRegistersHash().get("E") );
                    break;
                case "5C": //LD E,H
                    registers.getRegistersHash().put(
                        "E", registers.getRegistersHash().get("H") );
                    break;
                case "5D": //LD E,L
                    registers.getRegistersHash().put(
                        "E", registers.getRegistersHash().get("L") );
                    break;
                case "1E": //LD E,*
                    registers.getRegistersHash().put(
                        "E", opCode.getOpCodeArray().get(i).substring(2, 4) );
                    break;
                    
                case "67": //LD H,A
                    registers.getRegistersHash().put(
                        "H", registers.getRegistersHash().get("A") );
                    break;
                case "60": //LD H,B
                    registers.getRegistersHash().put(
                        "H", registers.getRegistersHash().get("B") );
                    break;
                case "61": //LD H,C
                    registers.getRegistersHash().put(
                        "H", registers.getRegistersHash().get("C") );
                    break;
                case "62": //LD H,D
                    registers.getRegistersHash().put(
                        "H", registers.getRegistersHash().get("D") );
                    break;
                case "63": //LD H,E
                    registers.getRegistersHash().put(
                        "H", registers.getRegistersHash().get("E") );
                    break;
                case "64": //LD H,H
                    registers.getRegistersHash().put(
                        "H", registers.getRegistersHash().get("H") );
                    break;
                case "65": //LD H,L
                    registers.getRegistersHash().put(
                        "H", registers.getRegistersHash().get("L") );
                    break;
                case "26": //LD H,*
                    registers.getRegistersHash().put(
                        "H", opCode.getOpCodeArray().get(i).substring(2, 4) );
                    break;
                    
                case "6F": //LD L,A
                    registers.getRegistersHash().put(
                        "L", registers.getRegistersHash().get("A") );
                    break;
                case "68": //LD L,B
                    registers.getRegistersHash().put(
                        "L", registers.getRegistersHash().get("B") );
                    break;
                case "69": //LD L,C
                    registers.getRegistersHash().put(
                        "L", registers.getRegistersHash().get("C") );
                    break;
                case "6A": //LD L,D
                    registers.getRegistersHash().put(
                        "L", registers.getRegistersHash().get("D") );
                    break;
                case "6B": //LD L,E
                    registers.getRegistersHash().put(
                        "L", registers.getRegistersHash().get("E") );
                    break;
                case "6C": //LD L,H
                    registers.getRegistersHash().put(
                        "L", registers.getRegistersHash().get("H") );
                    break;
                case "6D": //LD L,L
                    registers.getRegistersHash().put(
                        "L", registers.getRegistersHash().get("L") );
                    break;
                case "2E": //LD L,*
                    registers.getRegistersHash().put(
                        "L", opCode.getOpCodeArray().get(i).substring(2, 4) );
                    break;
                    
                case "01": //LD (BC),**
                    registers.getRegistersHash().put(
                        "C", opCode.getOpCodeArray().get(i).substring(2, 4) );
                    registers.getRegistersHash().put(
                        "B", opCode.getOpCodeArray().get(i).substring(4, 6) );
                    break;
                case "11": //LD (DE),**
                    registers.getRegistersHash().put(
                        "E", opCode.getOpCodeArray().get(i).substring(2, 4) );
                    registers.getRegistersHash().put(
                        "D", opCode.getOpCodeArray().get(i).substring(4, 6) );
                    break;
                case "21": //LD (HL),**
                    registers.getRegistersHash().put(
                        "D", opCode.getOpCodeArray().get(i).substring(2, 4) );
                    registers.getRegistersHash().put(
                        "L", opCode.getOpCodeArray().get(i).substring(4, 6) );
                    break;
                case "31": //LD (SP),**
                    registers.getRegistersHash().put(
                        "SP", opCode.getOpCodeArray().get(i).substring(2, 6) );
                    break;
                    
                case "32": //LD (**),A
                    memory.getMemoryHash().put(
                        opCode.getOpCodeArray().get(i).substring(2, 6),
                        registers.getRegistersHash().get("A"));
                    break;
                case "22": //LD (**),HL
                    memory.getMemoryHash().put(
                        opCode.getOpCodeArray().get(i).substring(2, 6),
                        registers.getRegistersHash().get("H") + 
                            registers.getRegistersHash().get("L"));
                    break;
                    
                case "87": //ADD A,A
                    registers.getRegistersHash().put("A",
                        alu.add(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("A")));
                    
                    break;
                case "80": //ADD A,B
                    registers.getRegistersHash().put("A",
                        alu.add(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("B")));
                    break;
                case "81": //ADD A,C
                    registers.getRegistersHash().put("A",
                        alu.add(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("C")));
                    break;
                case "82": //ADD A,D
                    registers.getRegistersHash().put("A",
                        alu.add(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("D")));
                    break;
                case "83": //ADD A,E
                    registers.getRegistersHash().put("A",
                        alu.add(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("E")));
                    break;
                case "84": //ADD A,H
                    registers.getRegistersHash().put("A",
                        alu.add(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("H")));
                    break;
                case "85": //ADD A,L
                    registers.getRegistersHash().put("A",
                        alu.add(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("L")));
                    break;
                case "86": //ADD A,(HL)
                    registers.getRegistersHash().put("A",
                        alu.add(registers.getRegistersHash().get("A"),
                            memory.getMemoryHash().get(
                                registers.getRegistersHash().get("H") + 
                                    registers.getRegistersHash().get("L"))));
                    break;
                case "C6": //ADD A,*
                    registers.getRegistersHash().put("A",
                        alu.add(registers.getRegistersHash().get("A"),
                            opCode.getOpCodeArray().get(i).substring(2, 4)));
                    break;
                    
                case "97": //SUB A,A
                    registers.getRegistersHash().put("A",
                        alu.sub(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("A")));
                    break;
                case "90": //SUB A,B
                    registers.getRegistersHash().put("A",
                        alu.sub(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("B")));
                    break;
                case "91": //SUB A,C
                    registers.getRegistersHash().put("A",
                        alu.sub(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("C")));
                    break;
                case "92": //SUB A,D
                    registers.getRegistersHash().put("A",
                        alu.sub(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("D")));
                    break;
                case "93": //SUB A,E
                    registers.getRegistersHash().put("A",
                        alu.sub(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("E")));
                    break;
                case "94": //SUB A,H
                    registers.getRegistersHash().put("A",
                        alu.sub(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("H")));
                    break;
                case "95": //SUB A,L
                    registers.getRegistersHash().put("A",
                        alu.sub(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("L")));
                    break;
                case "96": //SUB A,(HL)
                    registers.getRegistersHash().put("A",
                        alu.sub(registers.getRegistersHash().get("A"),
                            memory.getMemoryHash().get(
                                registers.getRegistersHash().get("H") + 
                                    registers.getRegistersHash().get("L"))));
                    break;
                case "D6": //SUB A,*
                    registers.getRegistersHash().put("A",
                        alu.sub(registers.getRegistersHash().get("A"),
                            opCode.getOpCodeArray().get(i).substring(2, 4)));
                    break;
                    
                case "A7": //AND A,A
                    registers.getRegistersHash().put("A",
                        alu.and(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("A")));
                    break;
                case "A0": //AND A,B
                    registers.getRegistersHash().put("A",
                        alu.and(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("B")));
                    break;
                case "A1": //AND A,C
                    registers.getRegistersHash().put("A",
                        alu.and(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("C")));
                    break;
                case "A2": //AND A,D
                    registers.getRegistersHash().put("A",
                        alu.and(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("D")));
                    break;
                case "A3": //AND A,E
                    registers.getRegistersHash().put("A",
                        alu.and(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("E")));
                    break;
                case "A4": //AND A,H
                    registers.getRegistersHash().put("A",
                        alu.and(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("H")));
                    break;
                case "A5": //AND A,L
                    registers.getRegistersHash().put("A",
                        alu.and(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("L")));
                    break;
                case "A6": //AND A,(HL)
                    registers.getRegistersHash().put("A",
                        alu.and(registers.getRegistersHash().get("A"),
                            memory.getMemoryHash().get(
                                registers.getRegistersHash().get("H") + 
                                    registers.getRegistersHash().get("L"))));
                    break;
                case "E6": //AND A,*
                    registers.getRegistersHash().put("A",
                        alu.and(registers.getRegistersHash().get("A"),
                            opCode.getOpCodeArray().get(i).substring(2, 4)));
                    break;
                    
                case "B7": //OR A,A
                    registers.getRegistersHash().put("A",
                        alu.or(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("A")));
                    break;
                case "B0": //OR A,B
                    registers.getRegistersHash().put("A",
                        alu.or(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("B")));
                    break;
                case "B1": //OR A,C
                    registers.getRegistersHash().put("A",
                        alu.or(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("C")));
                    break;
                case "B2": //OR A,D
                    registers.getRegistersHash().put("A",
                        alu.or(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("D")));
                    break;
                case "B3": //OR A,E
                    registers.getRegistersHash().put("A",
                        alu.or(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("E")));
                    break;
                case "B4": //OR A,H
                    registers.getRegistersHash().put("A",
                        alu.or(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("H")));
                    break;
                case "B5": //OR A,L
                    registers.getRegistersHash().put("A",
                        alu.or(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("L")));
                    break;
                case "B6": //OR A,(HL)
                    registers.getRegistersHash().put("A",
                        alu.or(registers.getRegistersHash().get("A"),
                            memory.getMemoryHash().get(
                                registers.getRegistersHash().get("H") + 
                                    registers.getRegistersHash().get("L"))));
                    break;
                case "F6": //OR A,*
                    registers.getRegistersHash().put("A",
                        alu.or(registers.getRegistersHash().get("A"),
                            opCode.getOpCodeArray().get(i).substring(2, 4)));
                    break;
                    
                case "AF": //XOR A,A
                    registers.getRegistersHash().put("A",
                        alu.xor(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("A")));
                    break;
                case "A8": //XOR A,B
                    registers.getRegistersHash().put("A",
                        alu.xor(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("B")));
                    break;
                case "A9": //XOR A,C
                    registers.getRegistersHash().put("A",
                        alu.xor(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("C")));
                    break;
                case "AA": //XOR A,D
                    registers.getRegistersHash().put("A",
                        alu.xor(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("D")));
                    break;
                case "AB": //XOR A,E
                    registers.getRegistersHash().put("A",
                        alu.xor(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("E")));
                    break;
                case "AC": //XOR A,H
                    registers.getRegistersHash().put("A",
                        alu.xor(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("H")));
                    break;
                case "AD": //XOR A,L
                    registers.getRegistersHash().put("A",
                        alu.xor(registers.getRegistersHash().get("A"),
                            registers.getRegistersHash().get("L")));
                    break;
                case "AE": //XOR A,(HL)
                    registers.getRegistersHash().put("A",
                        alu.xor(registers.getRegistersHash().get("A"),
                            memory.getMemoryHash().get(
                                registers.getRegistersHash().get("H") + 
                                    registers.getRegistersHash().get("L"))));
                    break;
                case "EE": //XOR A,*
                    registers.getRegistersHash().put("A",
                        alu.or(registers.getRegistersHash().get("A"),
                            opCode.getOpCodeArray().get(i).substring(2, 4)));
                    break;
                    
                case "3C": //INC A
                    registers.getRegistersHash().put("A",
                        alu.inc(registers.getRegistersHash().get("A")));
                    break;
                case "04": //INC B
                    registers.getRegistersHash().put("B",
                        alu.inc(registers.getRegistersHash().get("B")));
                    break;
                case "0C": //INC C
                    registers.getRegistersHash().put("C",
                        alu.inc(registers.getRegistersHash().get("C")));
                    break;
                case "14": //INC D
                    registers.getRegistersHash().put("D",
                        alu.inc(registers.getRegistersHash().get("D")));
                    break;
                case "1C": //INC E
                    registers.getRegistersHash().put("E",
                        alu.inc(registers.getRegistersHash().get("E")));
                    break;
                case "24": //INC H
                    registers.getRegistersHash().put("H",
                        alu.inc(registers.getRegistersHash().get("H")));
                    break;
                case "2C": //INC L
                    registers.getRegistersHash().put("L",
                        alu.inc(registers.getRegistersHash().get("L")));
                    break;
                case "34": //INC (HL)
                    HL = registers.getRegistersHash().get("H") + 
                        registers.getRegistersHash().get("L");
                    HL = alu.inc(HL);
                    registers.getRegistersHash().put("H",
                        HL.substring(0, 2));
                    registers.getRegistersHash().put("L",
                        HL.substring(2, 4));
                    break;
                    
                case "3D": //DEC A
                    registers.getRegistersHash().put("A",
                        alu.dec(registers.getRegistersHash().get("A")));
                    break;
                case "05": //DEC B
                    registers.getRegistersHash().put("B",
                        alu.dec(registers.getRegistersHash().get("B")));
                    break;
                case "0D": //DEC C
                    registers.getRegistersHash().put("C",
                        alu.inc(registers.getRegistersHash().get("C")));
                    break;
                case "15": //DEC D
                    registers.getRegistersHash().put("D",
                        alu.dec(registers.getRegistersHash().get("D")));
                    break;
                case "1D": //DEC E
                    registers.getRegistersHash().put("E",
                        alu.dec(registers.getRegistersHash().get("E")));
                    break;
                case "25": //DEC H
                    registers.getRegistersHash().put("H",
                        alu.dec(registers.getRegistersHash().get("H")));
                    break;
                case "2D": //DEC L
                    registers.getRegistersHash().put("L",
                        alu.dec(registers.getRegistersHash().get("L")));
                    break;
                case "35": //DEC (HL)
                    HL = registers.getRegistersHash().get("H") + 
                        registers.getRegistersHash().get("L");
                    HL = alu.dec(HL);
                    registers.getRegistersHash().put("H",
                        HL.substring(0, 2));
                    registers.getRegistersHash().put("L",
                        HL.substring(2, 4));
                    break;
                    
                case "DB": //IN A,(*)
                    registers.getRegistersHash().put("A", portIN);
                    break;
                case "D3": //OUT (*),A
                    portOUT = registers.getRegistersHash().get("A");
                    break;
                case "76":
                    break;
                case "2F":
                    registers.getRegistersHash().put("A",
                        alu.cpl(registers.getRegistersHash().get("A")));
                    break;
                case "ED":
                    switch(opCode.getOpCodeArray().get(i).substring(2, 4)){
                        case "44":
                            registers.getRegistersHash().put("A",
                                alu.neg(registers.getRegistersHash().get("A")));
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                    break;
                case "0F":
                    registers.getRegistersHash().put("A",
                        alu.rrca(registers.getRegistersHash().get("A")));
                    break;
                case "07":
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
            
        }  
    }
}
