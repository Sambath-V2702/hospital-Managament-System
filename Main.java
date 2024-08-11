package hospital_management;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static PatientManagement patientManagement = new PatientManagement();
    private static DoctorManagement doctorManagement = new DoctorManagement();
    private static AdminManagement adminManagement = new AdminManagement();

    public static void main(String[] args) {
        System.out.println("Welcome to the Hospital Management System");
        displayMenu();
    }

    private static void displayMenu() {
        while (true) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Manage Patients");
            System.out.println("2. Manage Doctors");
            System.out.println("3. Manage Admins");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    managePatients();
                    break;
                case 2:
                    manageDoctors();
                    break;
                case 3:
                    manageAdmins();
                    break;
                case 4:
                    System.out.println("Exiting the system.");
                    return; // Exit the program
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void managePatients() {
        while (true) {
            System.out.println("\nPatient Management:");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Go Back");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    patientManagement.viewPatients();
                    break;
                case 3:
                    updatePatient();
                    break;
                case 4:
                    deletePatient();
                    break;
                case 5:
                    return; // Go back to the main menu
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addPatient() {
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Gender: ");
        String gender = scanner.next();
        System.out.print("Enter Disease: ");
        String disease = scanner.next();

        patientManagement.addPatient(name, age, gender, disease);
    }

    private static void updatePatient() {
        System.out.print("Enter Patient ID to update: ");
        int id = scanner.nextInt();
        System.out.print("Enter New Name: ");
        String name = scanner.next();
        System.out.print("Enter New Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter New Gender: ");
        String gender = scanner.next();
        System.out.print("Enter New Disease: ");
        String disease = scanner.next();

        patientManagement.updatePatient(id, name, age, gender, disease);
    }

    private static void deletePatient() {
        System.out.print("Enter Patient ID to delete: ");
        int id = scanner.nextInt();
        patientManagement.deletePatient(id);
    }

    private static void manageDoctors() {
        while (true) {
            System.out.println("\nDoctor Management:");
            System.out.println("1. Add Doctor");
            System.out.println("2. View Doctors");
            System.out.println("3. Update Doctor");
            System.out.println("4. Delete Doctor");
            System.out.println("5. Go Back");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addDoctor();
                    break;
                case 2:
                    doctorManagement.viewDoctors();
                    break;
                case 3:
                    updateDoctor();
                    break;
                case 4:
                    deleteDoctor();
                    break;
                case 5:
                    return; // Go back to the main menu
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addDoctor() {
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter Specialty: ");
        String specialty = scanner.next();
        System.out.print("Enter Contact Info: ");
        String contactInfo = scanner.next();

        doctorManagement.addDoctor(name, specialty, contactInfo);
    }

    private static void updateDoctor() {
        System.out.print("Enter Doctor ID to update: ");
        int id = scanner.nextInt();
        System.out.print("Enter New Name: ");
        String name = scanner.next();
        System.out.print("Enter New Specialty: ");
        String specialty = scanner.next();
        System.out.print("Enter New Contact Info: ");
        String contactInfo = scanner.next();

        doctorManagement.updateDoctor(id, name, specialty, contactInfo);
    }

    private static void deleteDoctor() {
        System.out.print("Enter Doctor ID to delete: ");
        int id = scanner.nextInt();
        doctorManagement.deleteDoctor(id);
    }

    private static void manageAdmins() {
        while (true) {
            System.out.println("\nAdmin Management:");
            System.out.println("1. Add Admin");
            System.out.println("2. View Admins");
            System.out.println("3. Update Admin");
            System.out.println("4. Delete Admin");
            System.out.println("5. Go Back");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addAdmin();
                    break;
                case 2:
                    adminManagement.getAllAdmins().forEach(System.out::println);
                    break;
                case 3:
                    updateAdmin();
                    break;
                case 4:
                    deleteAdmin();
                    break;
                case 5:
                    return; // Go back to the main menu
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addAdmin() {
        System.out.print("Enter Username: ");
        String username = scanner.next();
        System.out.print("Enter Password: ");
        String password = scanner.next();

        adminManagement.addAdmin(username, password);
    }

    private static void updateAdmin() {
        System.out.print("Enter Admin ID to update: ");
        int id = scanner.nextInt();
        System.out.print("Enter New Username: ");
        String username = scanner.next();
        System.out.print("Enter New Password: ");
        String password = scanner.next();

        adminManagement.updateAdmin(id, username, password);
    }

    private static void deleteAdmin() {
        System.out.print("Enter Admin ID to delete: ");
        int id = scanner.nextInt();
        adminManagement.deleteAdmin(id);
    }
}