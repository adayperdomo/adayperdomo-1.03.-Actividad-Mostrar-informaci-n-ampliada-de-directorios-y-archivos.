/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.accesodatos;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
/**
 *
 * @author Usuario
 */
public class AccesoDatos {

    public static void main(String[] args) {
        String nombreArchivo = "C:\\Users\\Usuario\\OneDrive\\Documentos\\GitHub\\pm-dashboard\\squaads-pm-dashboard";
        File file = new File(nombreArchivo);

        if (!file.exists()) {
            System.out.println("El archivo no existe");
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            
            if (file.isDirectory()) {
                System.out.println("Es un directorio. Contenido: ");
                File[] files = file.listFiles();
                if (files != null) {
                    for (File f : files) {
                        String fechaMod = sdf.format(new Date(f.lastModified()));
                        if (f.isDirectory()) {
                            System.out.println("\\" + f.getName() + fechaMod);
                        } else {
                            System.out.println(" " + f.getName() + " / " + f.length() + " bytes / " + fechaMod);
                        }
                    }
                }
            }
        }
    }
}
