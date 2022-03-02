import java.nio.charset.StandardCharsets;
import java.util.*;

public class Library {
    private HashSet<Book> books;
    private Scanner input;

    public Library(){
        this.books = new HashSet<>();
        input = new Scanner(System.in, StandardCharsets.ISO_8859_1).useDelimiter("\n").useLocale(Locale.US);
    }

    public Scanner getInput() {
        return input;
    }

    public HashSet<Book> getBooks() {
        return books;
    }

    public void setBooks(HashSet<Book> books) {
        this.books = books;
    }

    public Book createBook() {
        System.out.println("Enter the title of the book: ");
        String title = input.next().toLowerCase();
        System.out.println("Enter the author: ");
        String author = input.next().toLowerCase();
        System.out.println("Enter the number of copies: ");
        int nCopies = input.nextInt();

        return new Book(title,author,nCopies,0);
    }

    public HashSet<Book> addBook(){
        Book b = createBook();

        if(!books.contains(b)){
            books.add(b);
            System.out.println("Successfully registered");
        }else{
            System.out.println("The book is already registered");
        }
        return books;
    }

    public void showBooks() {
        ArrayList<Book> list = new ArrayList<Book>(books);
        Collections.sort(list);
        if(!list.isEmpty()) {
            for (Book book : list) {
                System.out.println(book);
            }
        }else{
            System.out.println("There no registered books");
        }
    }

    public boolean loadLoan(Book b){
        int cont = b.getnCopiesLoaned();
        if((b.getnCopies() > 0) && (b.getnCopiesLoaned() < b.getnCopies())){
            cont++;
            b.setnCopiesLoaned(cont);
            return true;
        }
        return false;
    }

    public void loan(){
        System.out.println("Enter the book for the loan: ");
        String book = input.next().toLowerCase();
        boolean ba = false;

        for (Book b : books) {
            if(b.getTitle().equalsIgnoreCase(book)){
                ba = loadLoan(b);
                break;
            }
        }

        if(ba) {
            System.out.println("The loan was made correctly");
        }else{
            System.out.println("No copies available");
        }

    }

    public boolean loadDevolution(Book b){
        int cont = b.getnCopiesLoaned();
        if(b.getnCopiesLoaned() > 0){
            cont--;
            b.setnCopiesLoaned(cont);
            return true;
        }
        return false;
    }

    public void devolution(){
        System.out.println("Enter the book for the devolution: ");
        String book = input.next().toLowerCase();
        boolean ba = false;

        for (Book b : books) {
            if(b.getTitle().equalsIgnoreCase(book)){
                ba = loadDevolution(b);
                break;
            }
        }

        if(ba) {
            System.out.println("The devolution was made correctly");
        }else{
            System.out.println("No borrowed copies");
        }
    }


}
