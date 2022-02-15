package service;

import modelo.Pelicula;

import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Scanner;

public class PeliculaService {

    Scanner input = new Scanner(System.in, StandardCharsets.ISO_8859_1).useDelimiter("\n").useLocale(Locale.US);

    public Pelicula crearPelicula(){
        System.out.println("Ingrese el titulo de la pelicula: ");
        String titulo = input.next();
        System.out.println("Ingrese el director de la pelicula:");
        String director = input.next();
        System.out.println("Ingrese la duracion de la pelicula. |Formato a ingresar: Hora:Minutos:Segundos|");
        String d = input.next();
        LocalTime duracion = LocalTime.parse(d);
        return new Pelicula(titulo, director, duracion);
    }



}
