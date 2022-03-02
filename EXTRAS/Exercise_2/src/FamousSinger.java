import java.util.Objects;

public class FamousSinger implements Comparable<FamousSinger>{
    private String name;
    private String bestSellingAlbum;

    public FamousSinger(String name, String bestSellingAlbum) {
        this.name = name;
        this.bestSellingAlbum = bestSellingAlbum;
    }

    public FamousSinger() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBestSellingAlbum() {
        return bestSellingAlbum;
    }

    public void setBestSellingAlbum(String bestSellingAlbum) {
        this.bestSellingAlbum = bestSellingAlbum;
    }

    @Override
    public String toString() {
        return String.format("Singer: %s, Best Selling Album: %s\n",name,bestSellingAlbum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamousSinger that = (FamousSinger) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int compareTo(FamousSinger o) {
        return name.compareTo(o.name);
    }
}
