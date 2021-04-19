package UnirFicheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UnirF1F2 {

    public static void main(String[] args) {
        FileReader fr;
        BufferedReader br;
        FileWriter fw;
        PrintWriter pw;
        String cadena;

        try {
            fw = new FileWriter("F3.txt");
            pw = new PrintWriter(fw);

            fr = new FileReader("F1.txt");
            br = new BufferedReader(fr);
            cadena = br.readLine();    //se lee la primera línea del fichero
            while (cadena != null) {               //mientras no se llegue al final del fichero                   
                pw.println(cadena);        //se nuestra por pantalla
                cadena = br.readLine();       //se lee la siguiente línea del fichero                        
            }

            fr = new FileReader("F2.txt");
            br = new BufferedReader(fr);
            cadena = br.readLine();    //se lee la primera línea del fichero
            while (cadena != null) {               //mientras no se llegue al final del fichero                   
                pw.println(cadena);        //se nuestra por pantalla
                cadena = br.readLine();       //se lee la siguiente línea del fichero                        
            }
            
            pw.flush();
            pw.close();
            
            
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Fichero no encontrado.");
        } catch (IOException ex) {
            System.out.println("ERROR: no se puede leer el fichero");
        }
    }
}
