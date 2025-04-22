package bankmanagementsystem;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            // Attempt to load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL Driver loaded successfully.");

            // Attempt to establish the connection
            c = DriverManager.getConnection("jdbc:mysql://localhost:3308/bankmanagementsystem", "root", "root123");
            System.out.println("Database connected successfully.");

            // Create a Statement object
            s = c.createStatement();
            System.out.println("Statement created successfully.");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found.");
            e.printStackTrace();  // Print the stack trace for debugging

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();  // Print the stack trace for debugging

        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();  // Print the stack trace for debugging
        }
    }

    public static void main(String[] args) {
        new Conn();  // Initialize the connection and statement
    }
}
