package service;

import modelo.Alumno;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class AlumnoService {

    Scanner input = new Scanner(System.in, StandardCharsets.ISO_8859_1).useDelimiter("\n").useLocale(Locale.US);

    public Alumno crearAlumno() {
        ArrayList<Integer> notas = new ArrayList<Integer>();

        System.out.println("Ingrese el nombre completo del alumno");
        String name = input.next();

        for (int i = 0; i < 3; i++) {
            System.out.printf("Ingrese la nota N° %d\n",(i+1));
            notas.add(input.nextInt());
        }
        return new Alumno(name, notas);
    }

    public ArrayList<Alumno> agregarAlumno(Alumno alum) {
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

        if(!alumnos.contains(alum)){
            alumnos.add(alum);
        }else{
            System.out.println("No se pudo agregar porque ya existe un registro del alumno");
        }

        return alumnos;
    }

    public void notaFinal(Alumno alumno){
        double prom = 0;
        for (Integer nota : alumno.getNotas()) {
            prom += nota;
        }
        System.out.printf("La nota final del alumno %s es: %.2f\n",alumno.getNombre(), (prom/3));
    }

    public Alumno buscarAlumno(String nombre, ArrayList<Alumno> alumnos){
        for (Alumno alum : alumnos){
            if(alum.getNombre().equalsIgnoreCase(nombre)){
                return alum;
            }
        }
        return null;
    }

    public void motrarAlumnos(ArrayList<Alumno> alumnos){
        int i = 1;
        if(!alumnos.isEmpty()){
            for (Alumno alum : alumnos){
                System.out.println("\n------------------------------------");
                System.out.printf("ALUMNO/A N° %d:\n", i++);
                System.out.println("--------------------------------------");
                System.out.printf("Nombre completo: %s\n", alum.getNombre());
                System.out.println("Notas: "+ alum.getNotas().toString());
            }
        }else{
            System.out.println("No hay registros cargados");
        }
    }
}
