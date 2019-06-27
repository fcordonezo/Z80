/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import z80.Processor;

/**
 *
 * @author Fabián Ordóñez
 * Jair Villalba
 * Luis Guzman
 */

//Con esta clase se toma el archivo .flex y se genera el archivo correspondiente .java
public class Main {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String file = "programs\\sum.txt";
        Processor processor = Processor.getProcessor();
        Compiler.codeToBits();
        processor.process();
    }
}
