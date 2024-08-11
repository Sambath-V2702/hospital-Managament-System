package hospital_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientManagement {
    private static final String URL = "jdbc:mysql://localhost:3306/hospital_management";
    private static final String USERNAME = "root"; // Replace with your MySQL username
    private static final String PASSWORD = "12345"; // Replace with your MySQL password

    public void addPatient(String name, int age, String gender, String disease) {
        String query = "INSERT INTO patients (name, age, gender, disease) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, gender);
            statement.setString(4, disease);
            statement.executeUpdate();
            System.out.println("A new patient was added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewPatients() {
        String query = "SELECT * FROM patients";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                String disease = resultSet.getString("disease");
                System.out.printf("ID: %d, Name: %s, Age: %d, Gender: %s, Disease: %s%n", id, name, age, gender, disease);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePatient(int id, String name, int age, String gender, String disease) {
        String query = "UPDATE patients SET name = ?, age = ?, gender = ?, disease = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, gender);
            statement.setString(4, disease);
            statement.setInt(5, id);
            statement.executeUpdate();
            System.out.println("Patient record updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePatient(int id) {
        String query = "DELETE FROM patients WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Patient record deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}