package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Store {
	private String username;
	private String password;
	Connection con = null;	
	Scanner scanner;
	
	 String jdbcUrl = "jdbc:mysql://localhost:3306/mini";
     String dbUsername = "root";
     String dbPassword = "rootHost#123";
     
     public Store(Scanner scanner) {
         this.scanner = scanner;
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
         } catch (ClassNotFoundException | SQLException e) {
             e.printStackTrace();
         }
     }

	public void registerUser() throws ClassNotFoundException, SQLException {
		 System.out.println("Enter username: ");
	        username = scanner.nextLine();
	        System.out.println("Enter password: ");
	        password = scanner.nextLine();

	        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setString(1, username);
	        stmt.setString(2, password);

	        int rows = stmt.executeUpdate();
	        if (rows > 0) {
	            System.out.println("A new user has been inserted successfully!");
	        }
	    
	}

    public void login() throws SQLException {
        System.out.println("Enter username: ");
        username = scanner.nextLine();
        System.out.println("Enter password: ");
        password = scanner.nextLine();

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed! Incorrect username or password.");
        }
    }
}
	
	
	
