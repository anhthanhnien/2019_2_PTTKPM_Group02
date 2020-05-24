package search;

import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;


public class Intermediate {
	
	public static ArrayList<DaiDien> search(String option) {
		ArrayList<DaiDien> arr = new ArrayList<DaiDien>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/luffy", "root", "cuongdz123");
			PreparedStatement query = c.prepareStatement("select room.id, room.type, room.bed, room.price, user.full_name, booking.start, booking.end from room left join booking on room.id = booking.id left join user on booking.email = user.email where room.id = ?");
			query.setString(1, option);
			ResultSet rs = query.executeQuery();
			while(rs.next()) {
				arr.add(new DaiDien(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getDate(6), rs.getDate(7)));
			}
		}
		catch(Exception e) {
			return null;
		}
		return arr;
	}

}
