package service;

import modelo.Pelicula;
import modelo.PeliculaComparadores;

import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class PeliculaService {

    Scanner input = new Scanner(System.in, StandardCharsets.ISO_8859_1).useDelimiter("\n").useLocale(Locale.US);
    ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();

    public Pelicula crearPelicula(){
        int hor = 0, min = 0, sec = 0;
        System.out.println("Ingrese el titulo de la pelicula: ");
        String titulo = input.next();
        System.out.println("Ingrese el director de la pelicula:");
        String director = input.next();

        do{
            System.out.println("Ingrese la duracion de la pelicula:");
            System.out.print("HORAS: "); hor = input.nextInt();
            System.out.print("MINUTOS: "); min = input.nextInt();
            System.out.print("SEGUNDOS: "); sec = input.nextInt();

            if((hor < 0 || hor > 23) || (min < 0 || min > 60 ) || ( sec < 0 || sec > 60)){
                System.out.println("ERROR: Ingrese una duracion valida");
            }
        }while ((hor < 0 || hor > 23) || (min < 0 || min > 60 ) || ( sec < 0 || sec > 60));

        return new Pelicula(titulo, director, LocalTime.of(hor,min,sec));
    }

    public void agregarPelicula(Pelicula peli){
        if(!peliculas.contains(peli)){
            peliculas.add(peli);
        }else{
            System.out.println("No se pudo agregar porque ya existe un registro");
        }
    }

    public void mostrarPeliculas(){
        if(!peliculas.isEmpty()) {
            System.out.println("\n------------------------------------");
            for (Pelicula p : peliculas) {
                System.out.println(p);
            }
            System.out.println("------------------------------------");
        }else{
            System.out.println("No hay registros cargados");
        }
    }

    public void mostrarPeliculasConMayorDuracion(){
        if(!peliculas.isEmpty()) {
            System.out.println("\n------------------------------------");
            for (Pelicula p : peliculas) {
                if (p.getDuracion().getHour() >= 1) {
                    System.out.println(p);
                }
            }
            System.out.println("------------------------------------");
        }else{
            System.out.println("No hay registros cargados");
        }
    }

    public void mostrarPeliculasxDuracionDesc(){
        Collections.sort(peliculas,  PeliculaComparadores.ordenarxDuracion);
        if(!peliculas.isEmpty()) {
            System.out.println("------------------------------------");
            for (Pelicula p : peliculas) {
                System.out.println(p);
            }
            System.out.println("------------------------------------");
        }else{
            System.out.println("No hay registros cargados");
        }
    }

    public void mostrarPeliculasxDuracionAsc(){
        Collections.sort(peliculas,  PeliculaComparadores.ordenarxDuracion);
        Collections.reverse(peliculas);
        if(!peliculas.isEmpty()) {
            System.out.println("------------------------------------");
            for (Pelicula p : peliculas) {
                System.out.println(p);
            }
            System.out.println("------------------------------------");
        }else{
            System.out.println("No hay registros cargados");
        }
    }

    public void mostrarPeliculasxTitulo(){
        Collections.sort(peliculas,  PeliculaComparadores.ordenarxTitulo);
        if(!peliculas.isEmpty()) {
            System.out.println("------------------------------------");
            for (Pelicula p : peliculas) {
                System.out.println(p);
            }
            System.out.println("------------------------------------");
        }else{
            System.out.println("No hay registros cargados");
        }
    }

    public void mostrarPeliculasxDirector(){
        Collections.sort(peliculas,  PeliculaComparadores.ordenarxDirector);
        if(!peliculas.isEmpty()) {
            System.out.println("------------------------------------");
            for (Pelicula p : peliculas) {
                System.out.println(p);
            }
            System.out.println("------------------------------------");
        }else{
            System.out.println("No hay registros cargados");
        }
    }

}
