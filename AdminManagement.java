package hospital_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminManagement {
    private static final String URL = "jdbc:mysql://localhost:3306/hospital_management";
    private static final String USERNAME = "root"; // Replace with your MySQL username
    private static final String PASSWORD = "12345"; // Replace with your MySQL password

    public void addAdmin(String username, String password) {
        String sql = "INSERT INTO admins (username, password) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            System.out.println("Admin added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAdmin(int id, String username, String password) {
        String sql = "UPDATE admins SET username = ?, password = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            System.out.println("Admin updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAdmin(int id) {
        String sql = "DELETE FROM admins WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Admin deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllAdmins() {
        String sql = "SELECT * FROM admins";
        List<String> adminList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String adminRecord = "ID: " + rs.getInt("id") + ", Username: " + rs.getString("username");
                adminList.add(adminRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminList;
    }
}