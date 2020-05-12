package authentication;

import java.sql.*;

public class Intermediate {
	
	public static void cancelOrder(String email, String start, String end) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/luffy", "root", "cuongdz123");
			PreparedStatement query = c.prepareStatement("delete from booking where email = ? and start = ? and end = ?");
			query.setString(1, email);
			query.setDate(2, Date.valueOf(start));
			query.setDate(3, Date.valueOf(end));
			query.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
