package FicherosTexto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class LeerJFileChooser {

    public static void main(String[] args) {

        JFileChooser fileChooser = new JFileChooser();
        int valor = fileChooser.showOpenDialog(fileChooser);
        if (valor == JFileChooser.APPROVE_OPTION) {
            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
            try {
                FileReader fr = new FileReader(ruta);
                BufferedReader br = new BufferedReader(fr);
                String cadena = br.readLine();    //se lee la primera línea del fichero
                while (cadena != null) {               //mientras no se llegue al final del fichero                   
                    System.out.println(cadena);        //se nuestra por pantalla
                    cadena = br.readLine();       //se lee la siguiente línea del fichero                        
                }
            } catch (FileNotFoundException e) {
                System.out.println("ERROR: Fichero no encontrado.");
            } catch (IOException ex) {
                Logger.getLogger("ERROR: Leyendo el fichero.");
            }
        }else{
            System.out.println("No se ha seleccionado ningún fichero.");
        }
    }
}
