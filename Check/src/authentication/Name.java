package authentication;

import java.sql.*;

public class Name {
    
	public static void changeName(String newName, String email) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/luffy", "root", "cuongdz123");
			PreparedStatement query = c.prepareStatement("update user set full_name = ? where email = ?");
			query.setString(1, newName);
			query.setString(2, email);
			query.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
