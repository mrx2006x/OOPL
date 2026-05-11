import java.sql.*;
import java.util.Scanner;

public class StudentManagement {

    static final String URL =
        "jdbc:mysql://localhost:3306/STUDENT_DB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    static final String USER = "sid";
    static final String PASSWORD = "3112sk";

    public static void main(String[] args) {

        try {

            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            Scanner sc = new Scanner(System.in);

            System.out.println("Connected Successfully!\n");

            while (true) {

                System.out.println("===== STUDENT MANAGEMENT =====");
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Search Student");
                System.out.println("4. Update Student");
                System.out.println("5. Delete Student");
                System.out.println("6. Exit");

                System.out.print("Choose: ");
                int choice = sc.nextInt();

                switch (choice) {

                    // ADD STUDENT
                    case 1:

                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Age: ");
                        int age = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();

                        System.out.print("Enter Marks: ");
                        double marks = sc.nextDouble();

                        String insertQuery =
                            "INSERT INTO students(name, age, course, marks) VALUES (?, ?, ?, ?)";

                        PreparedStatement psAdd =
                            conn.prepareStatement(insertQuery);

                        psAdd.setString(1, name);
                        psAdd.setInt(2, age);
                        psAdd.setString(3, course);
                        psAdd.setDouble(4, marks);

                        psAdd.executeUpdate();

                        System.out.println("Student Added Successfully!\n");

                        break;

                    // VIEW STUDENTS
                    case 2:

                        String selectQuery = "SELECT * FROM students";

                        PreparedStatement psView =
                            conn.prepareStatement(selectQuery);

                        ResultSet rs = psView.executeQuery();

                        System.out.println("\nID\tName\tAge\tCourse\tMarks");
                        System.out.println("------------------------------------------------");

                        while (rs.next()) {

                            System.out.println(
                                rs.getInt("id") + "\t" +
                                rs.getString("name") + "\t" +
                                rs.getInt("age") + "\t" +
                                rs.getString("course") + "\t" +
                                rs.getDouble("marks")
                            );
                        }

                        System.out.println();

                        break;

                    // SEARCH STUDENT
                    case 3:

                        System.out.print("Enter Student ID: ");
                        int searchId = sc.nextInt();

                        String searchQuery =
                            "SELECT * FROM students WHERE id=?";

                        PreparedStatement psSearch =
                            conn.prepareStatement(searchQuery);

                        psSearch.setInt(1, searchId);

                        ResultSet student = psSearch.executeQuery();

                        if (student.next()) {

                            System.out.println("\nStudent Details");
                            System.out.println("----------------------");

                            System.out.println(
                                "ID: " + student.getInt("id")
                            );

                            System.out.println(
                                "Name: " + student.getString("name")
                            );

                            System.out.println(
                                "Age: " + student.getInt("age")
                            );

                            System.out.println(
                                "Course: " + student.getString("course")
                            );

                            System.out.println(
                                "Marks: " + student.getDouble("marks")
                            );

                            System.out.println();

                        } else {

                            System.out.println("Student Not Found!\n");
                        }

                        break;

                    // UPDATE STUDENT
                    case 4:

                        System.out.print(
                            "Enter Student ID to Update: "
                        );

                        int updateId = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter New Age: ");
                        int newAge = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter New Course: ");
                        String newCourse = sc.nextLine();

                        System.out.print("Enter New Marks: ");
                        double newMarks = sc.nextDouble();

                        String updateQuery =
                            "UPDATE students SET age=?, course=?, marks=? WHERE id=?";

                        PreparedStatement psUpdate =
                            conn.prepareStatement(updateQuery);

                        psUpdate.setInt(1, newAge);
                        psUpdate.setString(2, newCourse);
                        psUpdate.setDouble(3, newMarks);
                        psUpdate.setInt(4, updateId);

                        int rowsUpdated = psUpdate.executeUpdate();

                        if (rowsUpdated > 0) {

                            System.out.println(
                                "Student Updated Successfully!\n"
                            );

                        } else {

                            System.out.println(
                                "Student Not Found!\n"
                            );
                        }

                        break;

                    // DELETE STUDENT
                    case 5:

                        System.out.print(
                            "Enter Student ID to Delete: "
                        );

                        int deleteId = sc.nextInt();

                        String deleteQuery =
                            "DELETE FROM students WHERE id=?";

                        PreparedStatement psDelete =
                            conn.prepareStatement(deleteQuery);

                        psDelete.setInt(1, deleteId);

                        int rowsDeleted = psDelete.executeUpdate();

                        if (rowsDeleted > 0) {

                            System.out.println(
                                "Student Deleted Successfully!\n"
                            );

                        } else {

                            System.out.println(
                                "Student Not Found!\n"
                            );
                        }

                        break;

                    // EXIT
                    case 6:

                        System.out.println("Exiting Program...");

                        conn.close();
                        sc.close();

                        return;

                    default:

                        System.out.println("Invalid Choice!\n");
                }
            }

        } catch (Exception e) {

            System.out.println(
                "Database Error: " + e.getMessage()
            );
        }
    }
}





mysql:

CREATE DATABASE STUDENT_DB;
USE STUDENT_DB;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT,
    course VARCHAR(100),
    marks DOUBLE
);



command:

javac -cp .;mysql-connector-j-9.6.0.jar StudentManagement.java

java -cp .;mysql-connector-j-9.6.0.jar StudentManagement
