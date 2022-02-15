package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> razas = new ArrayList<String>();
        int op = 0;

        do{
            System.out.println("Ingrese la raza del perro");
            razas.add(input.next());

            System.out.println("Quiere seguir agregando razas de perro. 1)SI, 2)NO");
            op = input.nextInt();
        }while(op != 2);

        System.out.print("RAZAS: ");
        for (String r : razas) {
            System.out.print(r +"| ");
        }
    }
}