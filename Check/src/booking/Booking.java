package booking;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class Booking {
	
	public static void book(ArrayList<Room> temp, String email, String start, String end, int night, ArrayList<Integer> price) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/luffy", "root", "cuongdz123");
			PreparedStatement query = null;
			java.sql.Date date1 = null;
			java.sql.Date date2 = null;
			for(int i = 0; i < temp.size(); ++i) {
				query = c.prepareStatement("insert into booking(email, id, start, end, night, price) values(?, ?, ?, ?, ?, ?)");
				date1 = Date.valueOf(start);
				date2 = Date.valueOf(end);
				query.setString(1, email);
				query.setInt(2, temp.get(i).getId());
				query.setDate(3, date1);
				query.setDate(4, date2);
				query.setInt(5, night);
				query.setInt(6, price.get(i));
				query.executeUpdate();
			}
			query.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
