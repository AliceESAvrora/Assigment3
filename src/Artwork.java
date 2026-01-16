import java.util.Objects;
public abstract class Artwork {
    private String title;
    private int year;
    private double price;
    private Artist artist;

    public Artwork(String title, int year, double price, Artist artist) {
        this.title = title;
        this.year = year;
        this.price = price;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public Artist getArtist() {
        return artist;
    }


    public abstract String getType();
    @Override
    public String toString() {
        return getType() + ": " + title + " (" + year + "), $" + price + ", Artist: " + artist;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Artwork)) return false;
        Artwork artwork = (Artwork) o;
        return year == artwork.year &&
                Double.compare(artwork.price, price) == 0 &&
                Objects.equals(title, artwork.title) &&
                Objects.equals(artist, artwork.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year, price, artist);
    }
}
