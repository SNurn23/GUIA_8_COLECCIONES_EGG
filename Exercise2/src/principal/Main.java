package principal;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            HashSet<String> razas = new HashSet<String>();
            int op = 0;

            do {
                System.out.println("----------------------------------");
                System.out.println("MENU");
                System.out.println("1- Agregar raza");
                System.out.println("2- Mostrar razas");
                System.out.println("3- Eliminar raza");
                System.out.println("4- Salir");
                System.out.print("\nOpcion: "); op = input.nextInt();
                System.out.println("----------------------------------");
                switch (op) {
                    case 1:
                        agregarRaza(razas, input);
                        break;
                    case 2:
                        mostrarRazas(razas);
                        break;
                    case 3:
                        eliminarRaza(razas, input);
                        break;
                }

            }while(op != 4);
    }

    public static void agregarRaza(HashSet<String> razas, Scanner input) {
        System.out.println("\nIngrese la raza del perro");
        razas.add(input.next());
    }

    public static void mostrarRazas(HashSet<String> razas){
        System.out.println("\nRazas de perros: ");
        if (!razas.isEmpty()){
            for(String r : razas){
                System.out.printf("* %s \n",r);
            }
        }else{
            System.out.println("\nNo hay registros cargados");
        }
    }

    public static void eliminarRaza(HashSet<String> razas,  Scanner input){
        Iterator<String> iterator =  razas.iterator();
        boolean b = false;

        System.out.println("\nIngrese la raza a eliminar:");
        String raza = input.next();

        while(iterator.hasNext()){
            if(iterator.next().equalsIgnoreCase(raza)){
                iterator.remove();
                b = true;
            }
        }

        if(!b){
            System.out.println("\nERROR: Registro no encontrado");
        }else{
            System.out.println("Eliminado");
        }
    }
}
