package PasarDeFicheroAArray;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PasarDeFicheroAArray {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nombreFichero;
        int contadorLineas = 0;
        String[] arrayLineas;

        System.out.println("Introduce el nombre del fichero:");
        nombreFichero = teclado.nextLine();
        try {
            FileReader fr = new FileReader(nombreFichero);
            BufferedReader br = new BufferedReader(fr);

            String cadena = br.readLine();    //se lee la primera línea del fichero
            while (cadena != null) {               //mientras no se llegue al final del fichero                   
                cadena = br.readLine();       //se lee la siguiente línea del fichero  
                contadorLineas++;
            }

            arrayLineas = new String[contadorLineas];


            br.close();
            fr.close();
            fr = new FileReader(nombreFichero);
            br = new BufferedReader(fr);


            for (int i = 0; i < contadorLineas; ++i) {
                arrayLineas[i] = br.readLine();
            }

            br.close();

            for (int i = contadorLineas - 1; i >= 0; i--) {
                System.out.println(arrayLineas[i]);
            }

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Fichero no encontrado.");
        } catch (IOException ex) {
            System.out.println("ERROR: no se puede leer el fichero");
        }
    }
}
