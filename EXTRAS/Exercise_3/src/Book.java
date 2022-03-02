import java.util.Objects;

public class Book implements Comparable<Book>{
    private String title;
    private String author;
    private int nCopies;
    private int nCopiesLoaned;

    public Book(String title, String author, int nCopies, int nCopiesLoaned) {
        this.title = title;
        this.author = author;
        this.nCopies = nCopies;
        this.nCopiesLoaned = nCopiesLoaned;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getnCopies() {
        return nCopies;
    }

    public void setnCopies(int nCopies) {
        this.nCopies = nCopies;
    }

    public int getnCopiesLoaned() {
        return nCopiesLoaned;
    }

    public void setnCopiesLoaned(int nCopiesLoaned) {
        this.nCopiesLoaned = nCopiesLoaned;
    }

    @Override
    public String toString() {
        return String.format("Book: %s, Author: %s, Number of Copies: %d, Number of Copies loaned: %d \n",title,author,nCopies,nCopiesLoaned);
    }

    @Override
    public int compareTo(Book o) {
        return title.compareTo(o.title);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title);
    }
}
