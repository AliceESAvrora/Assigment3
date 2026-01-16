import javax.management.ObjectName;
import java.util.Objects;
import java.sql.Connection;

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

    public void testConnection() {
        try (Connection conn = DB.getConnection()) {
            System.out.println("Connection successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return name + " (" + country + ", " + yearOfBirth + ")";
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
