import java.util.Comparator;

public class Pais implements Comparable<Pais> {
    private String nombre;

    public Pais(String nombre) {
        this.nombre = nombre;
    }

    public Pais() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Pais o) {
        return nombre.compareTo(o.nombre);
    }
}
