import java.sql.*;

public class SportDAO {
    public static void addSport(String name, String description) {
        String query = "INSERT INTO sports (name, description) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, description);
            stmt.executeUpdate();
            System.out.println("Sport added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding sport: " + e.getMessage());
        }
    }

    public static void getAllSports() {
        String query = "SELECT * FROM sports";
        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". " + rs.getString("name") + " - " + rs.getString("description"));
            }
        } catch (Exception e) {
            System.out.println("Error fetching sports: " + e.getMessage());
        }
    }

    public static void updateSport(int id, String newName, String newDescription) {
        String query = "UPDATE sports SET name = ?, description = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newName);
            stmt.setString(2, newDescription);
            stmt.setInt(3, id);
            stmt.executeUpdate();
            System.out.println("Sport updated successfully!");
        } catch (SQLException e) {
            System.out.println("Error updating sport: " + e.getMessage());
        }
    }

    public static void deleteSport(int id) {
        String query = "DELETE FROM sports WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Sport deleted successfully!");
        } catch (SQLException e) {
            System.out.println("Error deleting sport: " + e.getMessage());
        }
    }

}
