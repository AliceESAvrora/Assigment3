import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDM {

    public void testConnection() {
        try (Connection conn = DB.getConnection()) {
            System.out.println("Connection successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeArtist(Artist artist) {
        String sql = "INSERT INTO artist (name, country, year_of_birth) VALUES (?, ?, ?)";

        try (Connection conn = DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, artist.getName());
            ps.setString(2, artist.getCountry());
            ps.setInt(3, artist.getYearOfBirth());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Artist> readAllArtists() {
        List<Artist> artists = new ArrayList<>();
        String sql = "SELECT * FROM artist";

        try (Connection conn = DB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Artist artist = new Artist(
                        rs.getInt("artist_id"),
                        rs.getString("name"),
                        rs.getString("country"),
                        rs.getInt("year_of_birth")
                );
                artists.add(artist);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return artists;
    }

    public List<Artist> readAllArtistsOrderedByName() {
        List<Artist> artists = new ArrayList<>();
        String sql = "SELECT * FROM artist ORDER BY name ASC";

        try (Connection conn = DB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Artist artist = new Artist(
                        rs.getInt("artist_id"),
                        rs.getString("name"),
                        rs.getString("country"),
                        rs.getInt("year_of_birth")
                );
                artists.add(artist);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return artists;
    }

    public List<Artist> findArtistByCountry(String findCountry) {
        List<Artist> artists = new ArrayList<>();
        String sql = "SELECT * FROM artist WHERE country = ?";

        try (Connection conn = DB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, findCountry);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Artist artist = new Artist(
                            rs.getInt("artist_id"),
                            rs.getString("name"),
                            rs.getString("country"),
                            rs.getInt("year_of_birth")
                    );
                    artists.add(artist);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return artists;
    }



    public void updateArtistCountry(int artistId, String newCountry) {
        String sql = "UPDATE artist SET country = ? WHERE artist_id = ?";

        try (Connection conn = DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, newCountry);
            ps.setInt(2, artistId);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteArtist(int artistId) {
        String sql = "DELETE FROM artist WHERE artist_id = ?";

        try (Connection conn = DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, artistId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
