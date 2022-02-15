package principal;

import modelo.Alumno;
import service.AlumnoService;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in, StandardCharsets.ISO_8859_1).useDelimiter("\n").useLocale(Locale.US);
        AlumnoService alumnoSe = new AlumnoService();
        Alumno alum = null;
        ArrayList<Alumno> alumnos = null;
        int op = 0;

        do{
            System.out.println("----------------------------------");
            System.out.println("MENU");
            System.out.println("1- Agregar alumno");
            System.out.println("2- Mostrar alumnos");
            System.out.println("3- Calcular nota final");
            System.out.println("4- Salir");
            System.out.print("\nOpcion: "); op = input.nextInt();
            System.out.println("----------------------------------");
            switch (op) {
                case 1:
                    alum = alumnoSe.crearAlumno();
                    alumnos = alumnoSe.agregarAlumno(alum);
                    break;
                case 2:
                    alumnoSe.motrarAlumnos(alumnos);
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del alumno: ");
                    String nombre = input.next();

                    alum = alumnoSe.buscarAlumno(nombre, alumnos);

                    if(alum != null){
                        alumnoSe.notaFinal(alum);
                    }else{
                        System.out.println("No existe un alumno registrado con ese nombre");
                    }
                    break;
            }
        }while(op != 4);
    }
}
