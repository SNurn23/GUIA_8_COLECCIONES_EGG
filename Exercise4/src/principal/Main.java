package principal;

import service.PeliculaService;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in, StandardCharsets.ISO_8859_1).useDelimiter("\n").useLocale(Locale.US);
        PeliculaService peliculaService = new PeliculaService();

        int op = 0;

        do{
            System.out.println("----------------------------------");
            System.out.println("MENU");
            System.out.println("1- Agregar pelicula");
            System.out.println("2- Mostrar peliculas");
            System.out.println("3- Mostrar peliculas con mayor duracion");
            System.out.println("4- Mostrar peliculas ordenada por duracion DESC");
            System.out.println("5- Mostrar peliculas ordenada por duracion ASC");
            System.out.println("6- Mostrar peliculas ordenada por titulo");
            System.out.println("7- Mostrar peliculas ordenada por director");
            System.out.println("8- Salir");
            System.out.print("\nOpcion: "); op = input.nextInt();
            System.out.println("----------------------------------");
            switch (op) {
                case 1:
                    peliculaService.agregarPelicula(peliculaService.crearPelicula());
                    break;
                case 2:
                    peliculaService.mostrarPeliculas();
                    break;
                case 3:
                    peliculaService.mostrarPeliculasConMayorDuracion();
                    break;
                case 4:
                    peliculaService.mostrarPeliculasxDuracionDesc();
                    break;
                case 5:
                    peliculaService.mostrarPeliculasxDuracionAsc();
                    break;
                case 6:
                    peliculaService.mostrarPeliculasxTitulo();
                    break;
                case 7:
                    peliculaService.mostrarPeliculasxDirector();
                    break;
            }
        }while(op != 8);
    }
}
