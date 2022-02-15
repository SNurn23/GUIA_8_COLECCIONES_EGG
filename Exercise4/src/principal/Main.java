package principal;

import service.PeliculaService;

public class Main {
    public static void main(String[] args) {
        PeliculaService peliculaService = new PeliculaService();
        peliculaService.crearPelicula();
    }
}
