import java.util.Objects;

public class Artist{
    private String name;
    private String country;
    private int yearOfBirth;

    public Artist(String name, String country, int yearOfBirth)
    {
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
        return name + " (" + country + ", " + yearOfBirth + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Artist)) return false;
        Artist artist = (Artist) o;
        return yearOfBirth == artist.yearOfBirth &&
                Objects.equals(name, artist.name) &&
                Objects.equals(country, artist.country);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, country, yearOfBirth);
    }

}
