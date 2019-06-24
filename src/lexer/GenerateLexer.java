/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexer;

import java.io.File;

/**
 *
 * @author Fabián Ordóñez
 * Jair Villalba
 * Luis Guzman
 */
//Con esta clase se toma el archivo .flex y se genera el archivo correspondiente .java
public class GenerateLexer {

    private static final String path = "src\\lexer\\lexer.flex";
    public static void main(String[] args) {
        generateLexer( path );
    }
    public static void generateLexer( String path ){
        File file = new File( path );
        jflex.Main.generate( file );
    }
}