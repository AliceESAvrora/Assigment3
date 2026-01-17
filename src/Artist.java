import java.util.Objects;
import java.sql.*;

public class Artist{
    private int artistId;
    private String name;
    private String country;
    private int yearOfBirth;

    public Artist(String name, String country, int yearOfBirth)
    {
        this.name = name;
        this.country = country;
        this.yearOfBirth = yearOfBirth;
    }

    public Artist(int artistId, String name, String country, int yearOfBirth)
    {
        this.artistId = artistId;
        this.name = name;
        this.country = country;
        this.yearOfBirth = yearOfBirth;
    }

    public void alterName(String name) {
        this.name = name;
    }
    public void alterCountry(String country) {
        this.country = country;
    }
    public void alterYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getArtistId()
    {
        return artistId;
    }
    public String getName()
    {
        return name;
    }
    public String getCountry()
    {
        return country;
    }
    public int getYearOfBirth()
    {
        return yearOfBirth;
    }

    @Override
    public String toString() {
        return artistId + ": " + name + " (" + country + ", " + yearOfBirth + ")";
    }

    @Override
    public boolean equals(Object a)
    {
        if (this == a) return true;
        if (!(a instanceof Artist)) return false;
        Artist artist = (Artist) a;
        return yearOfBirth == artist.yearOfBirth && Objects.equals(name, artist.name)
                && Objects.equals(country, artist.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, yearOfBirth);
    }

}
