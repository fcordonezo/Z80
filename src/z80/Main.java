/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z80;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import jflex.ErrorMessages;

/**
 *
 * @author Camilo
 */

//Con esta clase se toma el archivo .flex y se genera el archivo correspondiente .java
public class Main {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String file = "programs\\sum.txt";
        Processor processor = Processor.getProcessor(file);
        processor.process();
        System.out.println(processor.getRegisters().get("A"));
    }
}
