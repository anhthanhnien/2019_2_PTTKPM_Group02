package authentication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookingApplication {
	
	public static int getApplication(String email) {
		int ans = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/luffy", "root", "cuongdz123");
			PreparedStatement query = c.prepareStatement("select count(distinct (start)) from ( select * from booking where email = ?) TEMP group by TEMP.start and TEMP.end");
			query.setString(1, email);
			ResultSet rs = query.executeQuery();
			rs.next();
			ans = rs.getInt(1);
			rs.close();
			query.close();
		}
		catch(Exception e) {
			return ans;
		}
		return ans;
	}

}
