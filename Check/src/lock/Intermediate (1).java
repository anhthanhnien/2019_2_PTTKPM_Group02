package lock;

import java.sql.*;
import java.sql.DriverManager;

public class Intermediate {
	
	public static void manage(String email, String state) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/luffy", "root", "cuongdz123");
			if(state.equals("locked")) {
				PreparedStatement query = c.prepareStatement("update user set role = 'locked' where email = ?");
				query.setString(1, email);
				query.executeUpdate();
			}
			else {
				PreparedStatement query = c.prepareStatement("update user set role = 'client' where email = ?");
				query.setString(1, email);
				query.executeUpdate();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
