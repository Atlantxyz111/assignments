import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerDAO {

    // Add a new player
    public static void addPlayer(String name, int age, int sportId) {
        String query = "INSERT INTO players (name, age, sport_id) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setInt(3, sportId);
            stmt.executeUpdate();
            System.out.println("Player added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding player: " + e.getMessage());
        }
    }

    // Show all players
    public static void getAllPlayers() {
        String query = "SELECT players.id, players.name, players.age, " +
                "COALESCE(sports.name, 'No Sport Assigned') AS sport_name " +
                "FROM players LEFT JOIN sports ON players.sport_id = sports.id";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("ID | Name         | Age | Sport");
            System.out.println("------------------------------------");
            while (rs.next()) {
                System.out.printf("%-3d| %-12s| %-4d| %-20s\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("sport_name"));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching players: " + e.getMessage());
        }
    }

    // Update a player's sport
    public static void updatePlayerSport(int playerId, int newSportId) {
        String query = "UPDATE players SET sport_id = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, newSportId);
            stmt.setInt(2, playerId);
            stmt.executeUpdate();
            System.out.println("Player's sport updated successfully!");
        } catch (SQLException e) {
            System.out.println("Error updating player's sport: " + e.getMessage());
        }
    }

    // Delete a player
    public static void deletePlayer(int playerId) {
        String query = "DELETE FROM players WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, playerId);
            stmt.executeUpdate();
            System.out.println("Player deleted successfully!");
        } catch (SQLException e) {
            System.out.println("Error deleting player: " + e.getMessage());
        }
    }
}
