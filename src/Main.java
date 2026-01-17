import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Artist artist1 = new Artist("Lion Fox", "UK", 1991);
        Artist artist2 = new Artist("Bonjour Boguette", "France", 1988);
        Artist artist3 = new Artist("Bonjour Boguettessa", "France", 1989);
        Artist artist4 = new Artist("Adolve Himmel", "Germany", 1945);

        Artwork artwork1 = new Painting("Fire in hole", 2016, 4500, artist1);
        Artwork artwork2 = new Painting("Push mid", 2017, 690, artist1);
        Artwork artwork3 = new Painting("I LOVE Paris", 2020, 1020, artist2);

        ArtGallery gallery = new ArtGallery("London Art Gallery", "London");
        gallery.addArtwork(artwork1);
        gallery.addArtwork(artwork2);
        gallery.addArtwork(artwork3);
        System.out.println(artist1);
        System.out.println(artwork1.getType());

        ArtistDM artistDM = new ArtistDM();

        artistDM.testConnection();

        List<Artist> result1 = artistDM.readAllArtistsOrdered();
        for (Artist a : result1)
        {
            System.out.println(a);
        }

        boolean running = true;

        while (running) {

            System.out.print("1 - update | 2 - delete | 3 - exit | Input: ");
            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter ArtistID to update country: ");
                    int artistIdUp = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter country: ");
                    String countryUp = scanner.nextLine();
                    artistDM.updateArtistCountry(artistIdUp, countryUp);
                    break;

                case 2:
                    System.out.print("Enter ArtistID to delete: ");
                    int artistIdDel = Integer.parseInt(scanner.nextLine());
                    artistDM.deleteArtist(artistIdDel);
                    break;

                case 3:
                    running = false;
                    break;

                default:
                    System.out.println("Wrong option!");
            }
        }

        List<Artist> result2 = artistDM.readAllArtists();
        for (Artist a : result2)
        {
            System.out.println(a);
        }
    }
}