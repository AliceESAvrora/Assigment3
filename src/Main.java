import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Artist artist1 = new Artist("Lion Fox", "UK", 1991);
        Artist artist2 = new Artist("Bonjour Boguette", "France", 1988);
        Artist artist3 = new Artist("Bonjour Boguette", "France", 1988);



        Artwork artwork1 = new Painting("Fire in hole", 2016, 4500, artist1);
        Artwork artwork2 = new Painting("Push mid", 2017, 690, artist1);
        Artwork artwork3 = new Painting("I LOVE Paris", 2020, 1020, artist2);

        ArtGallery gallery = new ArtGallery("London Art Gallery", "London");
        gallery.addArtwork(artwork1);
        gallery.addArtwork(artwork2);
        gallery.addArtwork(artwork3);
        System.out.println(artist1);
        System.out.println(artwork1.getType());

        artist1.testConnection();


        System.out.println(artist2.equals(artist3));
        gallery.sortByPrice();

        System.out.println("All artworks:");
        gallery.showAll();

        System.out.print("Enter title to search: ");
        String title = scanner.nextLine();

        Artwork found = gallery.findByTitle(title);
        System.out.println(found != null ? found : "Not found");

        System.out.print("Enter Artist to search: ");
        String artistname = scanner.nextLine();
        List<Artwork> result = gallery.filterByArtist(artistname);
        for (Artwork a : result)
        {
            System.out.println(a);
        }

    }
}