import java.nio.charset.StandardCharsets;
import java.util.*;

public class FamousSingerService {
    Scanner input = new Scanner(System.in, StandardCharsets.ISO_8859_1).useDelimiter("\n").useLocale(Locale.US);
    ArrayList<FamousSinger> famousSingers = new ArrayList<>();

    public FamousSinger createFamous(){
        System.out.println("Enter the name of the famous: ");
        String name = input.next().toLowerCase();
        System.out.println("Enter the best selling album: ");
        String bestseller = input.next().toLowerCase();

        return new FamousSinger(name, bestseller);
    }

    public void add5Famous(){
        int cont = 0;
        while (cont < 5){
            if(addFamous()){
                cont++;
            }
        }
    }

    public boolean addFamous(){
        FamousSinger f = createFamous();
        if(!famousSingers.contains(f)){
            famousSingers.add(f);
            System.out.println("Successfully registered");
            return true;
        }else{
            System.out.println("The famous is already registered");
        }
        return false;
    }

    public void showFamous(){
        Collections.sort(famousSingers);

        for (FamousSinger f: famousSingers) {
            System.out.println(f);
        }
    }

    public void deleteFamous(){
        System.out.println("Enter the name of the famous to delete: ");
        String name = input.next().toLowerCase();
        boolean b = false;

        Iterator<FamousSinger> iterator = famousSingers.iterator();

        while(iterator.hasNext()){
            if (iterator.next().getName().equalsIgnoreCase(name)){
                iterator.remove();
                b = true;
            }
        }

        if(!b){
            System.out.println("\nERROR: Famous not found");
        }else{
            System.out.println("Removed!");
        }
    }

    public void menu(){
        String op;
        add5Famous();
        do{
            System.out.println("\t\tMENU");
            System.out.println("-------------------");
            System.out.println("1- Add famous singer");
            System.out.println("2- Show famous singers");
            System.out.println("3- Remove Product");
            System.out.println("4- Exit");
            System.out.println("-------------------");
            System.out.print("\nOption: "); op = input.next();

            switch (op) {
                case "1":
                    addFamous();
                    break;
                case "2":
                    showFamous();
                    break;
                case "3":
                    deleteFamous();
                    break;
                case "4":
                    showFamous();
                    System.out.println("Closing menu. Bye!");
                    break;
                default:
                    System.out.println("Enter a correct option");
                    break;
            }
        }while(!op.equalsIgnoreCase("4"));
    }
}
