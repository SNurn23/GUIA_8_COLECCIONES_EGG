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
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        AlumnoService alumnoSe = new AlumnoService();
        Alumno alum = null;
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
                    if(!alumnos.contains(alum)){
                        alumnos.add(alum);
                    }else{
                        System.out.println("No se puedo agregar porque ya existe un registro del alumno");
                    }
                    break;
                case 2:
                    if(!alumnos.isEmpty()){
                        alumnoSe.motrarAlumnos(alumnos);
                    }else{
                        System.out.println("No hay regsitros cargados");
                    }

                    break;
                case 3:
                    System.out.println("Ingrese el nombre del alumno: ");
                    String nombre = input.next();
                    alum = alumnoSe.buscarAlumno(nombre, alumnos);
                    if(alum != null){
                        System.out.printf("La nota final del alumno %s es: %.2f\n",alum.getNombre(),alumnoSe.notaFinal(alum));
                    }else{
                        System.out.println("No existe un alumno registrado con ese nombre");
                    }

                    break;
            }
        }while(op != 4);
    }
}
