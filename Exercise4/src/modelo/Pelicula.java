package modelo;

import java.time.LocalTime;
import java.util.Objects;

public class Pelicula {
    private String titulo;
    private String director;
    private LocalTime duracion;

    public Pelicula(String titulo, String director, LocalTime duracion) {
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
    }

    public Pelicula() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalTime getDuracion() {
        return duracion;
    }

    public void setDuracion(LocalTime duracion) {
        this.duracion = duracion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(titulo, pelicula.titulo);
    }

    @Override
    public String toString() {
        return "Pelicula: " +
                "titulo: " + titulo +
                ", director: " + director +
                ", duracion: " + duracion ;
    }
}
