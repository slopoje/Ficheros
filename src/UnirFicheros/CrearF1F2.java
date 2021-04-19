package UnirFicheros;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Sebastián López
 * @see
 * <a href=https://puntocomnoesunlenguaje.blogspot.com/search?q=ficheros+de+texto>Ficheros
 * Texto</a>
 */
public class CrearF1F2 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        FileWriter fw;
        PrintWriter pw;
        String cadena;

        try {
            fw = new FileWriter("F1.txt");
            pw = new PrintWriter(fw);
            System.out.println("Creando fichero F1...");
            System.out.println("Introduce línea de texto. FIN para terminar:");
            System.out.print(">>>");
            cadena = teclado.nextLine();                             //se introduce por teclado una cadena de texto    
            while (!cadena.equalsIgnoreCase("FIN")) {
                pw.println(cadena);                         //se escribe la cadena en el fichero
                System.out.print(">>>");
                cadena = teclado.nextLine();                         //se introduce por teclado una cadena de texto    
            }
            pw.flush();
            pw.close();
            fw.close();

            fw = new FileWriter("F2.txt");
            pw = new PrintWriter(fw);
            System.out.println("Creando fichero F2...");
            System.out.println("Introduce línea de texto. FIN para terminar:");
            System.out.print(">>>");
            cadena = teclado.nextLine();                             //se introduce por teclado una cadena de texto    
            while (!cadena.equalsIgnoreCase("FIN")) {
                pw.println(cadena);                         //se escribe la cadena en el fichero
                System.out.print(">>>");
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
