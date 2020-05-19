package detail;

import java.sql.*;
import java.sql.DriverManager;

public class Intermediate {
	
	public static Zoom getRoom(String id) {
		Connection c = null;
		PreparedStatement query = null;
		ResultSet rs = null;
		Zoom room = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/luffy", "root", "cuongdz123");
			query = c.prepareStatement("select id, type, bed, price, image from room where id = ?");
			query.setInt(1, Integer.parseInt(id));
			rs = query.executeQuery();
			rs.next();
			room = new Zoom(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return room;
	}

}
