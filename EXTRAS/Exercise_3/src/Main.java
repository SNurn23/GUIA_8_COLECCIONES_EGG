import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String op;
        HashSet<Book> books = new HashSet<>();
        Library library = new Library();
        Scanner input = library.getInput();

        do{
            System.out.println("\t\tMENU");
            System.out.println("-------------------");
            System.out.println("1- Add book");
            System.out.println("2- Show books");
            System.out.println("3- Register a loan");
            System.out.println("4- Register a devolution");
            System.out.println("5- Exit");
            System.out.println("-------------------");
            System.out.print("\nOption: "); op = input.next();

            switch (op) {
                case "1":
                    books = library.addBook();
                    break;
                case "2":
                    library.showBooks();
                    break;
                case "3":
                    library.loan();
                    break;
                case "4":
                    library.devolution();
                    break;
                case "5":
                    System.out.println("Closing menu. Bye!");
                    break;
                default:
                    System.out.println("Enter a correct option");
                    break;
            }
        }while(!op.equalsIgnoreCase("5"));
    }
}
