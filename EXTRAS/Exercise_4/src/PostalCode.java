import java.nio.charset.StandardCharsets;
import java.util.*;

public class PostalCode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in, StandardCharsets.ISO_8859_1).useDelimiter("\n").useLocale(Locale.US);
        HashMap<Integer,String> codes = load10Codes(input);
        String op;

        do{
            System.out.println("\t\tMENU");
            System.out.println("-------------------");
            System.out.println("1- Add Postal code");
            System.out.println("2- Show Cities");
            System.out.println("3- Search City");
            System.out.println("4- Delete 3 cities");
            System.out.println("5- Exit");
            System.out.println("-------------------");
            System.out.print("\nOption: "); op = input.next();

            switch (op) {
                case "1":
                    codes = addPostalCode(input);
                    break;
                case "2":
                    showCodes(codes);
                    break;
                case "3":
                    searchCode(input, codes);
                    break;
                case "4":
                    delete3Cities(input,codes);
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

    private static void showCodes(HashMap<Integer, String> codes) {
        TreeMap<Integer, String> map = new TreeMap<>(codes);
        if(!map.isEmpty()) {
            for (Map.Entry<Integer, String> c : map.entrySet()) {
                System.out.printf("Code postal: %d, City: %s \n",c.getKey(),c.getValue());
            }
        }else{
            System.out.println("No data loaded");
        }

    }

    public static HashMap<Integer,String> addPostalCode(Scanner input){
        HashMap<Integer,String> codes = new HashMap<>();

        System.out.println("Enter the postal code");
        int code = input.nextInt();
        System.out.println("Enter the city of the postal code: ");
        String city = input.next();
        codes.put(code,city);

        return codes;
    }

    public static HashMap<Integer,String> load10Codes(Scanner input){
        HashMap<Integer,String> codes = null;

        for (int i = 0; i < 10; i++) {
            codes = addPostalCode(input);
        }

        return codes;
    }

    public static void searchCode(Scanner input, HashMap<Integer, String> codes){
        System.out.println("Enter the code postal to search: ");
        int code = input.nextInt();
        boolean b = false;

        for (Map.Entry<Integer, String> c : codes.entrySet()) {
            if(c.getKey() == code) {
                System.out.printf("Code postal: %d, City: %s \n", c.getKey(), c.getValue());
                b = true;
            }
        }

        if(!b) {
            System.out.println("Postal Code not found");
        }
    }

    public static void deleteCity(int code, HashMap<Integer, String> codes){
        if(codes.containsKey(code)){
            codes.remove(code);
            System.out.println("Removed!");
        }else{
            System.out.println("Postal code not found");
        }
    }
    public static void delete3Cities(Scanner input, HashMap<Integer, String> codes){
        if(!codes.isEmpty() && codes.size() >= 3){
            for (int i = 0; i < 3; i++) {
                System.out.println("Enter the code postal to search: ");
                int code = input.nextInt();
                deleteCity(code,codes);
            }
        }else{
            System.out.println("Not enough data recorded");
        }
    }

}
