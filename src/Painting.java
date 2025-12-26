public class Painting extends Artwork {

    public Painting(String title, int year, double price, Artist artist) {
        super(title, year, price, artist);
    }

    @Override
    public String getType() {
        return "Painting";
    }
}