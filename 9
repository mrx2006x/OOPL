import java.sql.*;
import java.util.Scanner;

public class EmployeeManagement {

    static final String URL = "jdbc:mysql://localhost:3306/EMPLOYEE_DB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASSWORD = "avcoe";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Scanner sc = new Scanner(System.in);

            System.out.println("Connected Successfully!\n");

            while (true) {
                System.out.println("===== EMPLOYEE MANAGEMENT =====");
                System.out.println("1. Add Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Choose: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();

                        String insertQuery = "INSERT INTO employees (name, salary) VALUES (?, ?)";
                        PreparedStatement psAdd = conn.prepareStatement(insertQuery);

                        psAdd.setString(1, name);
                        psAdd.setDouble(2, salary);

                        psAdd.executeUpdate();
                        System.out.println("Employee Added Successfully!\n");

                        break;

                    case 2:
                        String selectQuery = "SELECT * FROM employees";
                        PreparedStatement psView = conn.prepareStatement(selectQuery);
                        ResultSet rs = psView.executeQuery();

                        System.out.println("\nID | Name | Salary");
                        System.out.println("----------------------");

                        while (rs.next()) {
                            System.out.println(
                                    rs.getInt("id") + " | " +
                                    rs.getString("name") + " | " +
                                    rs.getDouble("salary")
                            );
                        }

                        System.out.println();
                        break;

                    case 3:
                        System.out.print("Enter Employee ID to Update: ");
                        int updateId = sc.nextInt();

                        System.out.print("Enter New Salary: ");
                        double newSalary = sc.nextDouble();

                        String updateQuery = "UPDATE employees SET salary = ? WHERE id = ?";
                        PreparedStatement psUpdate = conn.prepareStatement(updateQuery);

                        psUpdate.setDouble(1, newSalary);
                        psUpdate.setInt(2, updateId);

                        int rowsUpdated = psUpdate.executeUpdate();

                        if (rowsUpdated > 0) {
                            System.out.println("Employee Updated Successfully!\n");
                        } else {
                            System.out.println("Employee Not Found!\n");
                        }

                        break;

                    case 4:
                        System.out.print("Enter Employee ID to Delete: ");
                        int deleteId = sc.nextInt();

                        String deleteQuery = "DELETE FROM employees WHERE id = ?";
                        PreparedStatement psDelete = conn.prepareStatement(deleteQuery);

                        psDelete.setInt(1, deleteId);

                        int rowsDeleted = psDelete.executeUpdate();

                        if (rowsDeleted > 0) {
                            System.out.println("Employee Deleted Successfully!\n");
                        } else {
                            System.out.println("Employee Not Found!\n");
                        }

                        break;

                    case 5:
                        System.out.println("Exiting Program...");
                        conn.close();
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid Choice!\n");
                }
            }

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}





mysql:

CREATE DATABASE EMPLOYEE_DB;
USE EMPLOYEE_DB;

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    salary DECIMAL(10, 2),
    action_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );


command:

javac -cp .;mysql-connector-j-9.6.0.jar EmployeeManagement.java

java -cp .;mysql-connector-j-9.6.0.jar EmployeeManagement


