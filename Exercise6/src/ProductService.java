import java.nio.charset.StandardCharsets;
import java.util.*;


public class ProductService {
    Scanner input = new Scanner(System.in, StandardCharsets.ISO_8859_1).useDelimiter("\n").useLocale(Locale.US);
    HashMap<String, Double> products = new HashMap<>();

    public void createProduct(){
        System.out.println("Enter the name of the product: ");
        String name = input.next().toLowerCase();
        System.out.println("Enter the price of the product: ");
        double price = input.nextDouble();

        addProduct(name,price);
    }

    public void addProduct(String name, double price){
        products.put(name,price);
    }

    public void modifyProduct(){
        System.out.println("Enter the name of the product to modify: ");
        String product = input.next().toLowerCase();
        System.out.println("Enter the new price of the product: ");
        double newPrice = input.nextDouble();

        if(products.containsKey(product)){
            addProduct(product, newPrice);
            System.out.println("Successfully modified product!");
        }else{
            System.out.println("Product not found");
        }
    }

    public void deleteProduct(){
        System.out.println("Enter the name of the product to delete: ");
        String product = input.next().toLowerCase();

        if(products.remove(product) != null){
            System.out.println("Product was removed");
        }else{
            System.out.println("Product not found");
        }
    }

    public void showProducts(){
        TreeMap<String, Double> ps = new TreeMap<>(products);
        if (!ps.isEmpty()){
            for(Map.Entry<String, Double> p : ps.entrySet()){
                System.out.printf("Product: %s, Price:$%.2f\n",p.getKey(),p.getValue());
            }
        }else{
            System.out.println("There are no registered products");
        }

    }

    public void menu(){
        String op;
        do{
            System.out.println("\t\tMENU");
            System.out.println("-------------------");
            System.out.println("1- Add product");
            System.out.println("2- Show products");
            System.out.println("3- Modify Product");
            System.out.println("4- Remove Product");
            System.out.println("5- Exit");
            System.out.println("-------------------");
            System.out.print("\nOption: "); op = input.next();

            switch (op) {
                case "1":
                    createProduct();
                    break;
                case "2":
                    showProducts();
                    break;
                case "3":
                    modifyProduct();
                    break;
                case "4":
                    deleteProduct();
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
