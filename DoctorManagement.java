package hospital_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorManagement {
    private static final String URL = "jdbc:mysql://localhost:3306/hospital_management";
    private static final String USERNAME = "root"; // Replace with your MySQL username
    private static final String PASSWORD = "12345"; // Replace with your MySQL password

    public void addDoctor(String name, String specialty, String contactInfo) {
        String sql = "INSERT INTO doctors (name, specialty, contact_information) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, specialty);
            pstmt.setString(3, contactInfo);
            pstmt.executeUpdate();
            System.out.println("Doctor added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewDoctors() {
        String sql = "SELECT * FROM doctors";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.printf("ID: %d, Name: %s, Specialty: %s, Contact Info: %s%n",
                        rs.getInt("id"), rs.getString("name"), rs.getString("specialty"), rs.getString("contact_information"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDoctor(int id, String name, String specialty, String contactInfo) {
        String sql = "UPDATE doctors SET name = ?, specialty = ?, contact_information = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, specialty);
            pstmt.setString(3, contactInfo);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
            System.out.println("Doctor record updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDoctor(int id) {
        String sql = "DELETE FROM doctors WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Doctor record deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}