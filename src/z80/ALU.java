/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z80;

/**
 *
 * @author Fabián Ordóñez
 * Jair Villalba
 * Luis Guzman
 */
class ALU {
    private static Flags flags;
    private static ALU alu;
    public static ALU getALU(){
        if( alu == null ){
            alu = new ALU();
        }
        return alu;
    }
    private ALU(){
        flags = Flags.getFlags();
    }
    public String add( String hexaA, String hexaSecond ){
        String bit = flags.getFlagsMap().get("C") + "00000000";
        int decimal = Integer.parseInt(bit, 2) + 
            Integer.parseInt(hexaA,16) + 
            Integer.parseInt(hexaSecond,16);
        bit = Integer.toBinaryString(decimal);
        Boolean zeros = true;
        if( Integer.toBinaryString( Integer.parseInt(hexaA,16) ).charAt(0) == '1'
            && Integer.toBinaryString( Integer.parseInt(hexaSecond,16) ).charAt(0) == '1' ) 
            flags.getFlagsMap().put("C", "1");
        else
            flags.getFlagsMap().put("C", "");
        for( char c : bit.toCharArray() )
            if( c == '1' )
                zeros = false;
        if( zeros )
            flags.getFlagsMap().put("Z", "1");
        else
            flags.getFlagsMap().put("Z", "");
        if(bit.charAt(0) == '1')
            flags.getFlagsMap().put("S", "1");
        else
            flags.getFlagsMap().put("S", "");
        while( bit.length() > 8 ){
            bit = bit.substring(1);
        }
        
        decimal = Integer.parseInt(bit,2);
        return Integer.toHexString(decimal).toUpperCase();
    }
    public String sub( String hexaA, String hexaSecond ){
        int decimal = Integer.parseInt(hexaA,16) - Integer.parseInt(hexaSecond,16);
        String bit = Integer.toBinaryString(decimal);
        Boolean zeros = true;
        if( Integer.toBinaryString( Integer.parseInt(hexaA,16) ).charAt(0) == '0'
            && Integer.toBinaryString( Integer.parseInt(hexaSecond,16) ).charAt(0) == '1' ) 
            flags.getFlagsMap().put("C", "1");
        else
            flags.getFlagsMap().put("C", "");
        for( char c : bit.toCharArray() )
            if( c == '1' )
                zeros = false;
        if( zeros )
            flags.getFlagsMap().put("Z", "1");
        else
            flags.getFlagsMap().put("Z", "");
        if(bit.charAt(0) == '1')
            flags.getFlagsMap().put("S", "1");
        else
            flags.getFlagsMap().put("S", "");
        while( bit.length() > 8 ){
            bit = bit.substring(1);
        }
        decimal = Integer.parseInt(bit,2);
        return Integer.toHexString(decimal).toUpperCase();
    }
    public String and( String hexaA, String hexaSecond ){
        int decimal = Integer.parseInt(hexaA,16) & Integer.parseInt(hexaSecond,16);
        String bit = Integer.toBinaryString(decimal);
        Boolean zeros = true;
        for( char c : bit.toCharArray() )
            if( c == '1' )
                zeros = false;
        if( zeros )
            flags.getFlagsMap().put("Z", "1");
        else
            flags.getFlagsMap().put("Z", "");
        if(bit.charAt(0) == '1')
            flags.getFlagsMap().put("S", "1");
        else
            flags.getFlagsMap().put("S", "");
        while( bit.length() > 8 ){
            bit = bit.substring(1);
        }
        decimal = Integer.parseInt(bit,2);
        return Integer.toHexString(decimal).toUpperCase();
    }
    public String or( String hexaA, String hexaSecond ){
        int decimal = Integer.parseInt(hexaA,16) | Integer.parseInt(hexaSecond,16);
        String bit = Integer.toBinaryString(decimal);
        Boolean zeros = true;
        for( char c : bit.toCharArray() )
            if( c == '1' )
                zeros = false;
        if( zeros )
            flags.getFlagsMap().put("Z", "1");
        else
            flags.getFlagsMap().put("Z", "");
        if(bit.charAt(0) == '1')
            flags.getFlagsMap().put("S", "1");
        else
            flags.getFlagsMap().put("S", "");
        while( bit.length() > 8 ){
            bit = bit.substring(1);
        }
        decimal = Integer.parseInt(bit,2);
        return Integer.toHexString(decimal).toUpperCase();
    }
    public String xor( String hexaA, String hexaSecond ){
        int decimal = Integer.parseInt(hexaA,16) ^ Integer.parseInt(hexaSecond,16);
        String bit = Integer.toBinaryString(decimal);
        Boolean zeros = true;
        for( char c : bit.toCharArray() )
            if( c == '1' )
                zeros = false;
        if( zeros )
            flags.getFlagsMap().put("Z", "1");
        else
            flags.getFlagsMap().put("Z", "");
        if(bit.charAt(0) == '1')
            flags.getFlagsMap().put("S", "1");
        else
            flags.getFlagsMap().put("S", "");
        while( bit.length() > 8 ){
            bit = bit.substring(1);
        }
        decimal = Integer.parseInt(bit,2);
        return Integer.toHexString(decimal).toUpperCase();
    }
    public String inc( String hexaA ){
        int decimal = Integer.parseInt(hexaA,16) + 1;
        String bit = Integer.toBinaryString(decimal);
        Boolean zeros = true;
        for( char c : bit.toCharArray() )
            if( c == '1' )
                zeros = false;
        if( zeros )
            flags.getFlagsMap().put("Z", "1");
        else
            flags.getFlagsMap().put("Z", "");
        if(bit.charAt(0) == '1')
            flags.getFlagsMap().put("S", "1");
        else
            flags.getFlagsMap().put("S", "");
        while( bit.length() > 8 ){
            bit = bit.substring(1);
        }
        decimal = Integer.parseInt(bit,2);
        return Integer.toHexString(decimal).toUpperCase();
    }
    public String dec( String hexaA ){
        int decimal = Integer.parseInt(hexaA,16) - 1;
        String bit = Integer.toBinaryString(decimal);
        Boolean zeros = true;
        for( char c : bit.toCharArray() )
            if( c == '1' )
                zeros = false;
        if( zeros )
            flags.getFlagsMap().put("Z", "1");
        else
            flags.getFlagsMap().put("Z", "");
        if(bit.charAt(0) == '1')
            flags.getFlagsMap().put("S", "1");
        else
            flags.getFlagsMap().put("S", "");
        while( bit.length() > 8 ){
            bit = bit.substring(1);
        }
        decimal = Integer.parseInt(bit,2);
        return Integer.toHexString(decimal).toUpperCase();
    }
    public String cpl( String hexaA ){
        int decimal = ~Integer.parseInt(hexaA,16);
        String bit = Integer.toBinaryString(decimal);
        Boolean zeros = true;
        for( char c : bit.toCharArray() )
            if( c == '1' )
                zeros = false;
        if( zeros )
            flags.getFlagsMap().put("Z", "1");
        else
            flags.getFlagsMap().put("Z", "");
        if(bit.charAt(0) == '1')
            flags.getFlagsMap().put("S", "1");
        else
            flags.getFlagsMap().put("S", "");
        while( bit.length() > 8 ){
            bit = bit.substring(1);
        }
        decimal = Integer.parseInt(bit,2);
        return Integer.toHexString(decimal).toUpperCase();
    }
    public String neg( String hexaA ){
        int decimal = 0 - Integer.parseInt(hexaA,16);
        String bit = Integer.toBinaryString(decimal);
        Boolean zeros = true;
        for( char c : bit.toCharArray() )
            if( c == '1' )
                zeros = false;
        if( zeros )
            flags.getFlagsMap().put("Z", "1");
        else
            flags.getFlagsMap().put("Z", "");
        if(bit.charAt(0) == '1')
            flags.getFlagsMap().put("S", "1");
        else
            flags.getFlagsMap().put("S", "");
        while( bit.length() > 8 ){
            bit = bit.substring(1);
        }
        decimal = Integer.parseInt(bit,2);
        return Integer.toHexString(decimal).toUpperCase();
    }
    public String rlca(String hexaA){
        int decimal = Integer.parseInt(hexaA,16);
        String bit = Integer.toBinaryString(decimal);
        decimal = decimal << 1;
        if( Integer.toBinaryString(decimal).charAt(0) == '1' ) 
            flags.getFlagsMap().put("C", "1");
        else
            flags.getFlagsMap().put("C", "");
        bit = Integer.toBinaryString(decimal).substring(0, 
                Integer.toBinaryString(decimal).length() - 1 ) 
                    + bit.substring(bit.length());
        
        Boolean zeros = true;
        for( char c : bit.toCharArray() )
            if( c == '1' )
                zeros = false;
        if( zeros )
            flags.getFlagsMap().put("Z", "1");
        else
            flags.getFlagsMap().put("Z", "");
        if(bit.charAt(0) == '1')
            flags.getFlagsMap().put("S", "1");
        else
            flags.getFlagsMap().put("S", "");
        while( bit.length() > 8 ){
            bit = bit.substring(1);
        }
        decimal = Integer.parseInt(bit,2);
        return Integer.toHexString(decimal).toUpperCase();
    }
    public String rrca(String hexaA){
        int decimal = Integer.parseInt(hexaA,16);
        String bit = Integer.toBinaryString(decimal);
        decimal = decimal >> 1;
        if( Integer.toBinaryString(decimal).charAt(0) == '1' ) 
            flags.getFlagsMap().put("C", "1");
        else
            flags.getFlagsMap().put("C", "");
        bit = Integer.toBinaryString(decimal).substring(0, 
                Integer.toBinaryString(decimal).length() - 1 ) 
                    + bit.substring(bit.length());
        
        Boolean zeros = true;
        for( char c : bit.toCharArray() )
            if( c == '1' )
                zeros = false;
        if( zeros )
            flags.getFlagsMap().put("Z", "1");
        else
            flags.getFlagsMap().put("Z", "");
        if(bit.charAt(0) == '1')
            flags.getFlagsMap().put("S", "1");
        else
            flags.getFlagsMap().put("S", "");
        while( bit.length() > 8 ){
            bit = bit.substring(1);
        }
        decimal = Integer.parseInt(bit,2);
        return Integer.toHexString(decimal).toUpperCase();
    }
}
