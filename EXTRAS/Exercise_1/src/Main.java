import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Integer> loadList(Scanner input){
        int num;
        ArrayList<Integer> list = new ArrayList<>();

        do{
            System.out.println("Enter a number");
            num = input.nextInt();

            if(num != -99){
                list.add(num);
            }

        }while(num != -99);

        return list;
    }

    public static int sumNumbers(ArrayList<Integer> list){
        int result = 0;

        for (Integer n : list) {
            result += n;
        }

        return result;
    }

    public static void showNumbers(ArrayList<Integer> list){
        System.out.println("Numbers: ");
        for (Integer n : list) {
            System.out.print(n+"|");
        }
    }

    public static double calculateAverage(ArrayList<Integer> list){
        return (double) (sumNumbers(list)/list.size());
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = loadList(input);
        showNumbers(list);
        System.out.printf("\nThe sum of the list is %d\n", sumNumbers(list));
        System.out.printf("The average is %.2f\n",calculateAverage(list));
    }
}
