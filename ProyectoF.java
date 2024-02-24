package Proyecto_POO_New;

import static java.lang.System.exit;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import java.util.Calendar;
import javax.print.*;
import java.awt.print.PrinterJob;
import java.awt.*;

public class ProyectoF {
    static Calendar fecha = Calendar.getInstance();

    public static void imprimirTexto(String texto) {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new PrintTexto(texto));
        if (job.printDialog()) {
            try {
                job.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean comprobarSiExiste(int nGrupo, Gestor managerGrupos){
        boolean existe = false;
        String nGrupoS = Integer.toString(nGrupo);
        String leeG = managerGrupos.leer();
        StringTokenizer leerGr = new StringTokenizer(leeG,"\n");
        while(leerGr.hasMoreTokens()){
            String leeG2 = leerGr.nextToken();
            StringTokenizer leerGr2 = new StringTokenizer(leeG2,"|");
            String numGrup = leerGr2.nextToken();
            if(numGrup.equals(nGrupoS)){
                existe = true;
            }
        }

        return existe;
    }

    public static void hallarGrupo(String nGrupo, Gestor manager, Gestor managerGrupos) {
        boolean grupoExiste = false;
        boolean alumnosEnGrupo = false;
        String leeG = managerGrupos.leer();
        String leeA = manager.leer();
        StringTokenizer leerGr = new StringTokenizer(leeG,"\n");
        StringTokenizer leerAl = new StringTokenizer (leeA,"\n");
        String listaAlumnos [] = new String[30];
        int contador = 0;
        while(leerGr.hasMoreTokens()){
            String leeG2 = leerGr.nextToken();
            StringTokenizer leerGr2 = new StringTokenizer(leeG2,"|");
            String numGrup = leerGr2.nextToken();
            String campoMateria = leerGr2.nextToken();
            String campoProfe = leerGr2.nextToken();
            String campoHorario = leerGr2.nextToken();
            String campoAula = leerGr2.nextToken();
            if(numGrup.equals(nGrupo)){
                grupoExiste = true;
                while (leerAl.hasMoreTokens()) {
                    String leeA2 = leerAl.nextToken();
                    StringTokenizer leerAl2 = new StringTokenizer(leeA2,"|");
                    String numGrupoA = leerAl2.nextToken();
                    if (numGrup.equals(numGrupoA) && contador<listaAlumnos.length) {
                        alumnosEnGrupo = true;
                        
                        listaAlumnos[contador] = leeA2;
                        
                        contador++;
                    }
                }
            }

            if(numGrup.equals(nGrupo)&&alumnosEnGrupo){
                System.out.println("Grupo "+numGrup+": ");
                System.out.println("Materia: "+campoMateria);
                System.out.println("Profe: "+campoProfe);
                System.out.println("Horario: "+campoHorario);
                System.out.println("Aula: "+campoAula);
            }
        }
        if (grupoExiste && alumnosEnGrupo) {
            for(int i = 0;i<listaAlumnos.length;i++){
                if(listaAlumnos[i] != null){
                    System.out.println(listaAlumnos[i]);
                }
                
            }
            JOptionPane.showMessageDialog(null, "Se hallo un grupo con exito, revise consola: ");
            
        } else if (!grupoExiste) {
            JOptionPane.showMessageDialog(null, "No se encontro grupo "+nGrupo+" busque otro grupo o añadalo!");
        } else if(grupoExiste && !alumnosEnGrupo){
            JOptionPane.showMessageDialog(null, "Se halló un grupo, pero no tiene alumnos!");
        }
    }

    public static void hallarxNombre(String name, Gestor manager) {
        boolean encontrado = false;
        String lectura = manager.leer();
        StringTokenizer hallarxn = new StringTokenizer(lectura, "\n");

        while (hallarxn.hasMoreTokens() == true) {
            String hxn = hallarxn.nextToken();

            StringTokenizer hallarxn2 = new StringTokenizer(hxn, "|");
            String campoGrupohxn = hallarxn2.nextToken();
            String campoNombrehxn = hallarxn2.nextToken();
            String campoNchxn = hallarxn2.nextToken();
            String campoEdadhxn = hallarxn2.nextToken();
            String campoPromediohxn = hallarxn2.nextToken();

            if (campoNombrehxn.equals(name)) {
                System.out.println("\nGrupo: " + campoGrupohxn);
                System.out.println("Nombre: " + campoNombrehxn);
                System.out.println("Numero control: " + campoNchxn);
                System.out.println("Edad: " + campoEdadhxn);
                System.out.println("Promedio: " + campoPromediohxn);
                String calsxN[] = new String[hallarxn2.countTokens()];
                for (int i = 0; i < calsxN.length; i++) {
                    String calN = hallarxn2.nextToken();
                    StringTokenizer hallarxn3 = new StringTokenizer(calN, "|");
                    calsxN[i] = hallarxn3.nextToken();
                    System.out.println("Calificación " + (i + 1) + ": " + calsxN[i]);
                }
                encontrado = true;

            }

        }
        if (encontrado) {
            JOptionPane.showMessageDialog(null, "Se encontro con exito! Revise consola");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró alumno, favor intentar otra vez");
        }

    }

    public static void hallarxNCC(String nocont, Gestor manager) {
        boolean encontrado = false;
        String lectura = manager.leer();
        StringTokenizer hallarxnc = new StringTokenizer(lectura, "\n");

        while (hallarxnc.hasMoreTokens() == true) {
            String hxnc = hallarxnc.nextToken();

            StringTokenizer hallarxnc2 = new StringTokenizer(hxnc, "|");
            String campoGrupohxnc = hallarxnc2.nextToken();
            String campoNombrehxnc = hallarxnc2.nextToken();
            String campoNchxnc = hallarxnc2.nextToken();
            String campoEdadhxnc = hallarxnc2.nextToken();
            String campoPromediohxnc = hallarxnc2.nextToken();

            if (campoNchxnc.equals(nocont)) {
                System.out.println("\nGrupo: " + campoGrupohxnc);
                System.out.println("Nombre: " + campoNombrehxnc);
                System.out.println("Numero control: " + campoNchxnc);
                System.out.println("Edad: " + campoEdadhxnc);
                System.out.println("Promedio: " + campoPromediohxnc);
                String calsxNc[] = new String[hallarxnc2.countTokens()];
                for (int i = 0; i < calsxNc.length; i++) {
                    String calNc = hallarxnc2.nextToken();
                    StringTokenizer hallarxnc3 = new StringTokenizer(calNc, "|");
                    calsxNc[i] = hallarxnc3.nextToken();
                    System.out.println("Calificación " + (i + 1) + ": " + calsxNc[i]);
                }
                encontrado = true;

            }

        }
        if (encontrado) {
            JOptionPane.showMessageDialog(null, "Se encontro con exito! Revise consola");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró alumno, favor intentar otra vez");
        }

    }

    public static void main(String[] args) {
        int dia = fecha.get(Calendar.DATE);
        int mes = fecha.get(Calendar.MONTH) + 1;
        int año = fecha.get(Calendar.YEAR);
        String date = dia + "/" + mes + "/" + año;
        /******************************************************** */
        int agLink = Integer.parseInt(JOptionPane.showInputDialog("Deseas agregar tu propia ruta? \n1. Sí   2. No"));
        while(agLink != 1 && agLink != 2){
            JOptionPane.showMessageDialog(null, "Lo sentimos, esa no es una opción válida intente otra vez");
            agLink = Integer.parseInt(JOptionPane.showInputDialog("Deseas agregar tu propia ruta? \n1. Sí   2. No"));
        }
        String archivo = "C:\\Users\\hfyh\\OneDrive\\Documentos\\Proyecto Final final\\poo.txt";
        String archivoGrupos = "C:\\Users\\hfyh\\OneDrive\\Documentos\\Proyecto Final final\\grupos.txt";
        if(agLink == 1){
            archivo = JOptionPane.showInputDialog("Ingrese una ruta: ");
            archivoGrupos=archivo+"\\grupos.txt";
            archivo+="\\archivo.txt";
        }
        /************************************************************* */
        Gestor manager = new Gestor(archivo);
        Gestor managerGrupos = new Gestor(archivoGrupos);

        int cantCalificaciones = 0;
        for (;;) {
            int opcion;
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa una opción:"
                        + "\n1. Crear alumnos de cero\n2. Ver alumnos\n3. Añadir alumno\n4. Imprimir o PDF"
                        + "\n5.Eliminar grupo\n6. Buscar grupo\n7.Buscar alumno por nombre\n"
                        + "8. Buscar alumno por número de control.\n9. Eliminar alumno\n10. Salir"
                        +"\n11. Crear grupos de cero\n12. Añadir grupo\n13. Ver grupos (Sin alumnos)"));
            } catch (NumberFormatException e) {
                System.out.println("\nERROR: Escribe una opcion numerica: " + e.getMessage() + "\n");
                opcion = 0;
            }
            switch (opcion) {
                case 1: /// CREAR
                    int grupoc, ncc, edadc;

                    do {
                        try {
                            grupoc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de grupo: "));
                        } catch (NumberFormatException e) {
                            System.out.println("ERROR: Escribe una opcion numerica: " + e.getMessage() + "\n");
                            grupoc = 0;
                        }
                        if (grupoc < 0) {
                            System.out.println("Agrega un numero mayor a cero.\n");
                        }else if(!comprobarSiExiste(grupoc, managerGrupos)){
                            System.out.println("El grupo ingresado no existe, agregue a uno existente o cree un grupo");
                        }

                    } while (grupoc <= 0 || !comprobarSiExiste(grupoc, managerGrupos));
                    String nombrec = JOptionPane.showInputDialog("Ingrese nombre: ");

                    do {
                        try {
                            ncc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese noControl: "));
                        } catch (NumberFormatException e) {
                            System.out.println("ERROR: Escribe una opcion numerica: " + e.getMessage() + "\n");
                            ncc = 0;
                        }
                        if (ncc < 0) {
                            System.out.println("Agrega un numero de control mayor a cero.\n");
                        }
                    } while (ncc <= 0);
                    do {
                        try {
                            edadc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad: "));
                        } catch (NumberFormatException e) {
                            System.out.println("ERROR: Escribe una opcion numerica: " + e.getMessage() + "\n");
                            edadc = 0;
                        }
                        if (edadc < 0) {
                            System.out.println("Agrega una edad mayor a cero.\n");
                        }
                    } while (edadc <= 0);

                    do {
                        try {
                            cantCalificaciones = Integer
                                    .parseInt(JOptionPane.showInputDialog("Cuantas calificaciones quieres añadir? "));
                        } catch (NumberFormatException e) {
                            System.out.println("ERROR: Escribe una opcion numerica: " + e.getMessage() + "\n");
                            cantCalificaciones = 0;
                        }
                        if (cantCalificaciones < 0) {
                            System.out.println("Agrega un numero mayor a cero.\n");
                        }
                    } while (cantCalificaciones <= 0);

                    int calificacionesc[] = new int[cantCalificaciones];
                    int calTotalc = 0;
                    String textoCalc = "";

                    for (int i = 0; i < calificacionesc.length; i++) {
                        try {
                            calificacionesc[i] = Integer
                                    .parseInt(JOptionPane.showInputDialog("Ingrese calificacion: "));
                        } catch (NumberFormatException e) {
                            System.out.println("ERROR: Escribe una opcion numerica: " + e.getMessage() + "\n");
                            i--;
                        }
                        if (i >= 0) {
                            calTotalc += calificacionesc[i];
                            textoCalc += calificacionesc[i] + "|";
                        }
                    }
                    int promedioc = calTotalc / calificacionesc.length;

                    manager.crear(grupoc + "|" + nombrec + "|" + ncc + "|" + edadc + "|" + promedioc + "|" + textoCalc);
                    break;
                case 2: /// Leer
                    System.out.println(date + "\n");
                    String r = manager.leer();
                    StringTokenizer str = new StringTokenizer(r, "\n");

                    while (str.hasMoreTokens() == true) {
                        String f = str.nextToken();

                        StringTokenizer str2 = new StringTokenizer(f, "|");

                        String campoGrupo = str2.nextToken();
                        String campoNombre = str2.nextToken();
                        String campoNc = str2.nextToken();
                        String campoEdad = str2.nextToken();
                        String campoPromedio = str2.nextToken();

                        System.out.print("\nGrupo: " + campoGrupo+", ");
                        System.out.print("Nombre: " + campoNombre + ", ");
                        System.out.print("NC: " + campoNc + ", ");
                        System.out.print("Edad: " + campoEdad + ", ");
                        System.out.print("Promedio: " + campoPromedio + ", ");

                        String cals[] = new String[str2.countTokens()];

                        for (int i = 0; i < cals.length; i++) {
                            String c = str2.nextToken();
                            StringTokenizer str3 = new StringTokenizer(c, "|");
                            cals[i] = str3.nextToken();

                            System.out.print("Calificación " + (i + 1) + ": " + cals[i]);
                            if (i < cals.length - 1) {
                                System.out.print(", ");
                            }
                        }
                    }
                    break;

                case 3: // Añadir
                    int grupo, nc, edad;
                    do {
                        try {
                            grupo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de grupo: "));
                        } catch (NumberFormatException e) {
                            System.out.println("ERROR: Escribe una opcion numerica: " + e.getMessage() + "\n");
                            grupo = 0;
                        }
                        if (grupo < 0) {
                            System.out.println("Agrega un numero mayor a cero.\n");
                        } else if(!comprobarSiExiste(grupo, managerGrupos)){
                            System.out.println("El grupo ingresado no existe, agregue a uno existente o cree un grupo");
                        }

                    } while (grupo <= 0 || !comprobarSiExiste(grupo, managerGrupos));
                    String nombre = JOptionPane.showInputDialog("Ingrese nombre: ");

                    do {
                        try {
                            nc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese noControl: "));
                        } catch (NumberFormatException e) {
                            System.out.println("ERROR: Escribe una opcion numerica: " + e.getMessage() + "\n");
                            nc = 0;
                        }
                        if (nc < 0) {
                            System.out.println("Agrega un numero de control mayor a cero.\n");
                        }
                    } while (nc <= 0);

                    do {
                        try {
                            edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad: "));
                        } catch (NumberFormatException e) {
                            System.out.println("ERROR: Escribe una opcion numerica: " + e.getMessage() + "\n");
                            edad = 0;
                        }
                        if (edad < 0) {
                            System.out.println("Agrega una edad mayor a cero.\n");
                        }
                    } while (edad <= 0);

                    do {
                        try {
                            cantCalificaciones = Integer
                                    .parseInt(JOptionPane.showInputDialog("Cuantas calificaciones quieres añadir? "));
                        } catch (NumberFormatException e) {
                            System.out.println("ERROR: Escribe una opcion numerica: " + e.getMessage() + "\n");
                            cantCalificaciones = 0;
                        }
                        if (cantCalificaciones < 0) {
                            System.out.println("Agrega una calificacion mayor a cero.\n");
                        }
                    } while (cantCalificaciones <= 0);
                    int calificaciones[] = new int[cantCalificaciones];
                    int calTotal = 0;
                    String textoCal = "";

                    for (int i = 0; i < calificaciones.length; i++) {
                        try {
                            calificaciones[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese calificacion: "));
                        } catch (NumberFormatException e) {
                            System.out.println("ERROR: Escribe una opcion numerica: " + e.getMessage() + "\n");
                            i--;
                        }
                        if (i >= 0) {
                            calTotal += calificaciones[i];
                            textoCal += calificaciones[i] + "|";
                        }
                    }
                    int promedio = calTotal / calificaciones.length;
                    manager.añadir(grupo + "|" + nombre + "|" + nc + "|" + edad + "|" + promedio + "|" + textoCal);
                    break;
                case 4:
                    String textImp = manager.leer();
                    imprimirTexto(textImp);
                    break;
                

                case 5: // Eliminar grupo
                    String numeroGrupoAEliminar = JOptionPane.showInputDialog("Ingrese el número de grupo a eliminar: ");
                    manager.eliminarGrupo(numeroGrupoAEliminar);
                    managerGrupos.eliminarGrupo(numeroGrupoAEliminar);
                    break;

                case 6: // Ver por grupo
                    System.out.println(date + "\n");
                    String nGrupo = JOptionPane.showInputDialog("Que grupo quieres revisar? ");
                    hallarGrupo(nGrupo, manager, managerGrupos);

                    break;
                case 7:
                    String name = JOptionPane.showInputDialog("Ingresa nombre a buscar: ");
                    System.out.println("");
                    hallarxNombre(name, manager);
                    break;

                case 8:
                    String numcont = JOptionPane.showInputDialog("Ingresa numero de control a buscar: ");
                    hallarxNCC(numcont, manager);
                    break;
                case 9:
                    String valor = JOptionPane.showInputDialog("Ingresa el nombre o numero de control del alumno: ");
                    manager.eliminarAlumno(valor);
                    break;
                case 10:
                    exit(0);
                    break;
                case 11: //Crear grupos
                    int seguro; 
                    do{
                        try{
                            seguro = Integer.parseInt(JOptionPane.showInputDialog("Seguro? Se eliminaran los alumnos existentes\n1. Si\t  2. No"));
                        } catch (NumberFormatException e) {
                            System.out.println("ERROR: Escribe una opcion numerica: " + e.getMessage() + "\n");
                            seguro = 0;
                        }
                        if (seguro == 1) {
                            manager.reiniciarArchivo();
                            int numGrupoc = Integer.parseInt(JOptionPane.showInputDialog("Numero del grupo a crear: "));
                            String materiac = JOptionPane.showInputDialog("Nombre de la materia");
                            String profec = JOptionPane.showInputDialog("Nombre del profesor: ");
                            String horarioc = JOptionPane.showInputDialog("Ingrese el horario: \nEjemplo: 11:00 - 12:00");
                            String aulac = JOptionPane.showInputDialog("Cual es el aula? ");
                            managerGrupos.crear(numGrupoc+"|"+materiac+"|"+profec+"|"+horarioc+"|"+aulac);
                        } else if (seguro == 2){
                            JOptionPane.showMessageDialog(null, "Cancelado! ");
                        } else{
                            JOptionPane.showMessageDialog(null, "Opción no válida, intente de nuevo");
                        }
                    } while (seguro!=1 && seguro!=2);
                    
                    
                    break;
                case 12: //Añadir grupo
                    int numGrupo;
                    do{
                        numGrupo = Integer.parseInt(JOptionPane.showInputDialog("Numero del grupo a añadir: "));
                        if(comprobarSiExiste(numGrupo, managerGrupos)){
                            JOptionPane.showMessageDialog(null, "El grupo ya existe, ingrese otro numero de grupo!");
                        }
                    } while (comprobarSiExiste(numGrupo, managerGrupos));
                    String materia = JOptionPane.showInputDialog("Nombre de la materia");
                    String profe = JOptionPane.showInputDialog("Nombre del profesor: ");
                    String horario = JOptionPane.showInputDialog("Ingrese el horario: \nEjemplo: 11:00 - 12:00");
                    String aula = JOptionPane.showInputDialog("Cual es el aula? ");
                    managerGrupos.añadir(numGrupo+"|"+materia+"|"+profe+"|"+horario+"|"+aula);
                    break;
                case 13: // Leer grupos (no alumnos)
                    System.out.println(date + "\n");
                    String lectorGrupo = managerGrupos.leer();
                    System.out.println(lectorGrupo);
                    StringTokenizer lecG = new StringTokenizer(lectorGrupo,"\n");
                    while (lecG.hasMoreTokens()) {
                        String lectorG2 = lecG.nextToken();
                        StringTokenizer lecG2 = new StringTokenizer(lectorG2, "|");
                        String campoNumG = lecG2.nextToken();
                        String campoMateria = lecG2.nextToken();
                        String campoProfe = lecG2.nextToken();
                        String campoHorario = lecG2.nextToken();
                        String campoAula = lecG2.nextToken();
                        
                    }
                    break;
                default:
                    System.out.println("");
                    System.out.println("Opciòn no valida");
            }

        }
    }

}
