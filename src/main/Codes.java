/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.HashMap;

/**
 *
 * @author Camilo
 */
class Codes {
    private static Codes codes;
    private HashMap<String, String> codeMap;
    private Codes(){
        codeMap = new HashMap<>();
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
        
        codeMap.put("SUB A,A", "97");
        codeMap.put("SUB A,B", "90");
        codeMap.put("SUB A,C", "91");
        codeMap.put("SUB A,D", "92");
        codeMap.put("SUB A,E", "93");
        codeMap.put("SUB A,H", "94");
        codeMap.put("SUB A,L", "95");
        codeMap.put("SUB A,(HL)", "96");
        codeMap.put("SUB A,*", "D6");
        
        codeMap.put("AND A", "A7");
        codeMap.put("AND B", "A0");
        codeMap.put("AND C", "A1");
        codeMap.put("AND D", "A2");
        codeMap.put("AND E", "A3");
        codeMap.put("AND H", "A4");
        codeMap.put("AND L", "A5");
        codeMap.put("AND (HL)", "A6");
        codeMap.put("AND *", "E6");
        
        codeMap.put("OR A", "B7");
        codeMap.put("OR B", "B0");
        codeMap.put("OR C", "B1");
        codeMap.put("OR D", "B2");
        codeMap.put("OR E", "B3");
        codeMap.put("OR H", "B4");
        codeMap.put("OR L", "B5");
        codeMap.put("OR (HL)", "B6");
        codeMap.put("OR *", "F6");
        
        codeMap.put("XOR A", "AF");
        codeMap.put("XOR B", "A8");
        codeMap.put("XOR C", "A9");
        codeMap.put("XOR D", "AA");
        codeMap.put("XOR E", "AB");
        codeMap.put("XOR H", "AC");
        codeMap.put("XOR L", "AD");
        codeMap.put("XOR (HL)", "AE");
        codeMap.put("XOR *", "EE");
        
        codeMap.put("INC A", "3C");
        codeMap.put("INC B", "04");
        codeMap.put("INC C", "0C");
        codeMap.put("INC D", "14");
        codeMap.put("INC E", "1C");
        codeMap.put("INC H", "24");
        codeMap.put("INC L", "2C");
        codeMap.put("INC (HL)", "34");
        
        codeMap.put("DEC A", "3D");
        codeMap.put("DEC B", "05");
        codeMap.put("DEC C", "0D");
        codeMap.put("DEC D", "15");
        codeMap.put("DEC E", "1D");
        codeMap.put("DEC H", "25");
        codeMap.put("DEC L", "2D");
        codeMap.put("DEC (HL)", "35");
        
        codeMap.put("IN A,(*)", "DB");
        codeMap.put("OUT (*),A", "D3");
        
        codeMap.put("HALT", "76");
        
        codeMap.put("CPL", "2F");
        codeMap.put("NEG", "ED44");
        
        codeMap.put("RRCA", "0F");
        codeMap.put("RLCA", "07");
        
        codeMap.put("JR *", "18");
        codeMap.put("JR Z,*", "28");
        codeMap.put("JR C,*", "38");
        codeMap.put("JR NZ,*", "20");
        codeMap.put("JR NC,*", "30");
    }
    public static Codes getCodes(){
        if(codes == null){
            codes = new Codes();
        }
        return codes;
    }
    public HashMap<String, String> getCodeMap(){
        return codeMap;
    }
}
