package authentication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Password {
	
	public static boolean change(String oldPassword, String newPassword1, String newPassword2, String email) {
		boolean valid = true;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/luffy", "root", "cuongdz123");
			PreparedStatement query = c.prepareStatement("select * from user where password = ? and email = ?");
			query.setString(1, oldPassword);
			query.setString(2, email);
			ResultSet rs = query.executeQuery();
			rs.next();
			rs.getString(1);
			if(!newPassword1.equals(newPassword2)) {
				valid = false;
			}
			else {
				query = c.prepareStatement("update user set password = ? where email = ?");
				query.setString(1, newPassword1);
				query.setString(2, email);
				query.executeUpdate();
			}
		}
		catch(Exception e) {
			valid = false;
			return valid;
		}
		return valid;
	}

}
