import java.util.*;

public class ArtGallery {
    private String name;
    private String location;
    private List<Artwork> artworks = new ArrayList<>();

    public ArtGallery(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public void addArtwork(Artwork artwork) {
        artworks.add(artwork);
    }


   public Artwork findByTitle(String title){
        for (Artwork a : artworks) {
            if (a.getTitle().equalsIgnoreCase(title))
            {
                return a;
            }
        }
        return null;
   }


    public List<Artwork> filterByArtist(String artistName) {
        List<Artwork> result = new ArrayList<>();
        for (Artwork a : artworks) {
            if (a.getArtist().getName().equalsIgnoreCase(artistName)) {
                result.add(a);
            }
        }
        return result;
    }

    public void sortByPrice() {
        artworks.sort(Comparator.comparingDouble(Artwork::getPrice));
    }

    public void showAll() {
        for (Artwork a : artworks) {
            System.out.println(a);
        }
    }
}