import java.nio.charset.StandardCharsets;
import java.util.*;

public class PaisesService {
    Scanner input = new Scanner(System.in, StandardCharsets.ISO_8859_1).useDelimiter("\n").useLocale(Locale.US);
    ArrayList<Pais> paises = new ArrayList<Pais>();

    public Pais crearPais(){
        System.out.println("Ingrese el pais: ");
        return new Pais(input.next());
    }

    public void agregarPais(){
        Pais p = crearPais();
        if(!buscarPais(p.getNombre())){
            paises.add(p);
        }else{
            System.out.printf("El pais %s ya se encuentra registrado\n",p.getNombre());
        }
    }

    public void preguntar(){
        int op;
        do{
            System.out.println("Desea agregar un pais. 1)Si, 2)No");
            op = input.nextInt();

            if(op == 1){
               agregarPais();
            }else if(op == 2){
                mostrarPaises();
            }
        }while(op != 2);
    }

    public void mostrarPaises() {
        Collections.sort(paises);
        System.out.println("PAISES:");
        for (Pais p : paises) {
            System.out.println(p.getNombre());
        }
    }

    public void eliminarPais(String pais){
        Iterator<Pais> iterator = paises.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getNombre().equalsIgnoreCase(pais)){
                iterator.remove();
            }
        }
    }

    public boolean buscarPais(String pais){
        for (Pais p : paises) {
           if (p.getNombre().equalsIgnoreCase(pais)){
               return true;
           }
        }
        return false;
    }

    public void pedirPais(){
        System.out.println("Ingrese el pais a eliminar:");
        String pais = input.next();
        if (buscarPais(pais)){
            eliminarPais(pais);
        }else{
            System.out.println("No se encuentra registrado el pais ingresado");
        }
        mostrarPaises();
    }



}
