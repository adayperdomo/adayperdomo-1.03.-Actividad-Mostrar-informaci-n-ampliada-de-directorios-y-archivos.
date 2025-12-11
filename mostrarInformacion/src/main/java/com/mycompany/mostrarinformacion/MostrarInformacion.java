package com.mycompany.mostrarinformacion;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MostrarInformacion {

    public static void main(String[] args) {

        // Si no se pasan argumentos usar directorio actual
        File file;
        if (args.length == 0) {
            file = new File("C:\\Users\\Usuario\\OneDrive\\Documentos\\NetBeansProjects\\examProyect");  // directorio desde el que se ejecuta
        } else {
            file = new File(args[0]);
        }

        if (!file.exists()) {
            System.out.println("El archivo o directorio no existe.");
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        // Si es un archivo mostrar solo su información
        if (file.isFile()) {
            String fechaMod = sdf.format(new Date(file.lastModified()));
            System.out.println("Archivo: " + file.getName());
            System.out.println("Tamaño: " + file.length() + " bytes");
            System.out.println("Última modificación: " + fechaMod);
            return;
        }

        // Si es un directorio listar contenido
        if (file.isDirectory()) {
            System.out.println("Directorio: " + file.getAbsolutePath());
            System.out.println("Contenido:\n");

            File[] files = file.listFiles();

            if (files != null) {
                for (File f : files) {
                    String fechaMod = sdf.format(new Date(f.lastModified()));

                    if (f.isDirectory()) {
                        System.out.println("[D] " + f.getName() + "   " + fechaMod);
                    } else {
                        System.out.println("[F] " + f.getName() + "   " + f.length() + " bytes   " + fechaMod);
                    }
                }
            }
        }
    }
}

