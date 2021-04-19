package OperacionesBasicas;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastián López
 * @see
 * <a href=https://puntocomnoesunlenguaje.blogspot.com/search?q=ficheros+de+texto>Ficheros
 * Texto</a>
 */
public class Anadir {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        
        try {
            FileWriter fw = new FileWriter("datos.txt",true);
            PrintWriter pw = new PrintWriter(fw);
            String cadena;
            System.out.println("Introduce línea de texto. Para acabar introduce la cadena FIN:");
            cadena = teclado.nextLine();                             //se introduce por teclado una cadena de texto    
            while (!cadena.equalsIgnoreCase("FIN")) {
                pw.println(cadena);                         //se escribe la cadena en el fichero
                cadena = teclado.nextLine();                         //se introduce por teclado una cadena de texto    
            }
            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException ex) {
            System.out.println("ERROR: escribiendo en el fichero.");
        }
    }
}
