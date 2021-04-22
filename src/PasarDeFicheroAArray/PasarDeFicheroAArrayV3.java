package PasarDeFicheroAArray;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Enunciado: Programa Java que pide al usuario un nombre de fichero de texto,
 * lo busca en el disco, lee su contenido y pasa las líneas de texto del fichero
 * a un array de String de 1 dimensión. Finalmente im prime en pantalla las
 * líneas del fichero en orden inverso.
 *
 * Problema: El número de líneas del fichero es indeterminado, pero el array
 * debe crearse con un número de posiciones fijo. ¿Cómo ajustar la longitud del
 * fichero a la longitud del array?
 *
 * Tercera forma: se utiliza una lista (List) en lugar de un array.
 *
 *
 * @author Sebastián López
 * @version abril/2021
 * @see
 * <a href=https://www.javatpoint.com/difference-between-array-and-arraylist>Comparativa
 * entre Array y ArrayList</a>
 */
public class PasarDeFicheroAArrayV3 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nombreFichero, linea;
        List<String> listaLineas = new ArrayList<String>();

        System.out.print("Introduce el nombre del fichero de texto:");
        nombreFichero = teclado.nextLine();
        try {
            FileReader fr = new FileReader(nombreFichero);     //Abro el fichero para lectura
            BufferedReader br = new BufferedReader(fr);        //Creo un flujo (stream) sobre el fichero abierto

            linea = br.readLine();            //se lee la primera línea del fichero
            while (linea != null) {           //mientras no se llegue al final del fichero    
                listaLineas.add(linea);       //se añade la linea leída a la lista
                linea = br.readLine();        //se leen las lineas del fichero
            }

            //Cierro el fichero y el flujo porque no me van a hacer falta más.
            br.close();
            fr.close();

            for(int i=listaLineas.size()-1;i>=0;--i){
                System.out.println(listaLineas.get(i)); //Se imprime el elemento "i" de la lista
            }          

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: fichero no encontrado.");
        } catch (IOException ex) {
            System.out.println("ERROR: no se puede leer el fichero");
        }
    }
}
