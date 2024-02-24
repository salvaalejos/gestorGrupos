package Proyecto_POO_New;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class Gestor {
    private String archivo;

    public Gestor(String archivo) {
        this.archivo = archivo;
    }

    public void añadir(String frase) {
        File objFile = new File(archivo);
        try { // true es para añadir
            FileWriter escritor = new FileWriter(objFile, true);
            BufferedWriter escritorRapido = new BufferedWriter(escritor);
            escritorRapido.write(frase);
            escritorRapido.newLine();
            escritorRapido.flush();
            escritorRapido.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no se pudo crear");
        } catch (IOException ioe) {
            System.out.println("Error de escritura");
        }
    }

    public void crear(String frase) {
        File objFile = new File(archivo);
        try {
            FileWriter escritor = new FileWriter(objFile);
            BufferedWriter escritorRapido = new BufferedWriter(escritor);
            escritorRapido.write(frase);
            escritorRapido.newLine();
            escritorRapido.flush();
            escritorRapido.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no se pudo crear");
        } catch (IOException ioe) {
            System.out.println("Error de escritura");
        }
    }

    public String leer() {
        File objFile = new File(archivo);
        String respuesta = "";
        try {
            FileReader lector = new FileReader(objFile);
            BufferedReader lectorRapido = new BufferedReader(lector);
            String linea = lectorRapido.readLine();
            while (linea != null) {
                respuesta += linea + "\n";
                linea = lectorRapido.readLine();
            }
            lectorRapido.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo inexistente");
        } catch (IOException ioe) {
            System.out.println("Error de lectura");
        }
        return respuesta;
    }

    public void reiniciarArchivo(){
        String frase ="";
        File objFile = new File(archivo);
        try {
            FileWriter escritor = new FileWriter(objFile);
            BufferedWriter escritorRapido = new BufferedWriter(escritor);
            escritorRapido.write(frase);
            escritorRapido.newLine();
            escritorRapido.flush();
            escritorRapido.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no se pudo crear");
        }
    }

    public void escribir(String contenido) throws IOException {
        File objFile = new File(archivo);
        try (BufferedWriter escritorRapido = new BufferedWriter(new FileWriter(objFile))) {
            escritorRapido.write(contenido);
        }
    }

    public void eliminarGrupo(String numeroGrupo) {
        try {
            String contenido = leer();
            String[] lineas = contenido.split("\n");
            StringBuilder nuevoContenido = new StringBuilder();

            for (String linea : lineas) {
                StringTokenizer tokens = new StringTokenizer(linea, "|");
                String numeroGrupoActual = tokens.nextToken();

                if (!numeroGrupoActual.equals(numeroGrupo)) {
                    nuevoContenido.append(linea).append("\n");
                }
            }

            escribir(nuevoContenido.toString());
            System.out.println("Grupo eliminado exitosamente");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al eliminar el grupo.");
        }
    }

    public void eliminarAlumno(String identificador) {
        try {
            String contenido = leer();
            String[] lineas = contenido.split("\n");
            StringBuilder nuevoContenido = new StringBuilder();
    
            for (String linea : lineas) {
                StringTokenizer tokens = new StringTokenizer(linea, "|");
                String numeroGrupoActual = tokens.nextToken();
                String nombre = tokens.nextToken();
                String numeroControl = tokens.nextToken();
                String edad = tokens.nextToken();
                String promedio = tokens.nextToken();
    
                if (!numeroControl.equals(identificador) && !nombre.equals(identificador)) {
                    nuevoContenido.append(linea).append("\n");
                }
            }
    
            escribir(nuevoContenido.toString());
    
            // Muestra un mensaje solo si se eliminó al menos una línea
            if (lineas.length != nuevoContenido.toString().split("\n").length) {
                JOptionPane.showMessageDialog(null, "Alumno eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró al alumno, no se realizó ninguna eliminación.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al eliminar el alumno.");
        }
    }
    
}
