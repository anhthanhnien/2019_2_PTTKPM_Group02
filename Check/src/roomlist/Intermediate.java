package roomlist;

import java.sql.*;
import java.util.ArrayList;

public class Intermediate {
	
	public static ArrayList<Phong> getPhong() {
		ArrayList<Phong> arr = new ArrayList<Phong>();
		Connection c = null;
		PreparedStatement query = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/luffy", "root", "cuongdz123");
			query = c.prepareStatement("select id, type, bed, price, image from room order by bed");
			rs = query.executeQuery();
			while(rs.next()) {
				arr.add(new Phong(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	public static ArrayList<Phong> sortList(String sort) {
		ArrayList<Phong> arr = new ArrayList<Phong>();
		Connection c = null;
		PreparedStatement query = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/luffy", "root", "cuongdz123");
			if(sort.equals("")) {
				query = c.prepareStatement("select id, type, bed, price, image from room order by bed");
				rs = query.executeQuery();
				while(rs.next()) {
					arr.add(new Phong(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
				}
			}
			else {
				query = c.prepareStatement("select id, type, bed, price, image from room " + sort);
				rs = query.executeQuery();
				while(rs.next()) {
					arr.add(new Phong(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

}
