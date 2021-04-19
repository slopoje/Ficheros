package OperacionesBasicas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Leer {

    public static void main(String[] args) {

        try {
            FileReader fr = new FileReader("nuevoFichero.txt");
            BufferedReader br = new BufferedReader(fr);
            String cadena = br.readLine();    //se lee la primera línea del fichero
            while (cadena != null) {               //mientras no se llegue al final del fichero                   
                System.out.println(cadena);        //se nuestra por pantalla
                cadena = br.readLine();       //se lee la siguiente línea del fichero                        
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Fichero no encontrado.");
        } catch (IOException ex) {
            System.out.println("ERROR: no se puede leer el fichero");
        }
    }
}
