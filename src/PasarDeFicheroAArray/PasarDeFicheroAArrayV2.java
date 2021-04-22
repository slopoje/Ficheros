package PasarDeFicheroAArray;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
 * Segunda forma: recorro el fichero una vez contando las líneas de texto que
 * tiene y creo un aray con ese número de posiciones. Utilizo mark() y reset()
 * para volver al principio del fichero.
 *
 *
 * @author Sebastián López
 * @version abril/2021
 */
public class PasarDeFicheroAArrayV2 {
    
    static final int MAX_NUMERO_CARACTERES=10000; //Máximo tamaño (en caracteres) del fichero que soporta nuestro programa.

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nombreFichero;
        int contadorLineas;
        String[] arrayLineas;

        System.out.print("Introduce el nombre del fichero de texto:");
        nombreFichero = teclado.nextLine();
        try {
            FileReader fr = new FileReader(nombreFichero); //Abro el fichero para lectura
            BufferedReader br = new BufferedReader(fr);    //Creo un flujo (stream) sobre el fichero abierto
            br.mark(MAX_NUMERO_CARACTERES); //Establece una marca en la primera línea del fichero
            
            contadorLineas = 0;               //Se inicializa el contado de líneas a 0
            String cadena = br.readLine();    //se lee la primera línea del fichero
            while (cadena != null) {          //mientras no se llegue al final del fichero                   
                cadena = br.readLine();       //se lee la siguiente línea del fichero  
                contadorLineas++;             //se incrementa el contador de líneas del fichero de texto
            }

            arrayLineas = new String[contadorLineas]; //Creo array con tamaño contadorLineas

            br.reset(); //Reposiciona el puntero del líneas del fichero a la marca anterior
            //Recorro el fichero de texto y voy pasando el contenido de las líneas a posiciones del array
            for (int i = 0; i < contadorLineas; ++i) {
                arrayLineas[i] = br.readLine();
            }

            //Cierro el fichero y el flujo porque no me van a hacer falta más.
            br.close();
            fr.close();

            //Recorro el array empezando por el final para que las líneas se impriman en orden inverso
            for (int i = contadorLineas - 1; i >= 0; i--) {
                System.out.println(arrayLineas[i]);
            }

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: fichero no encontrado.");
        } catch (IOException ex) {
            System.out.println("ERROR: no se puede leer el fichero");
        }
    }
}
