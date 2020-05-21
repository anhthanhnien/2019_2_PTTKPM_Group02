package offline;

import java.sql.*;
import java.util.ArrayList;

public class Intermediate {
	
	public static boolean bookOffline(String id, String email, String start) {
		String[] code = id.split(",\\s*");
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i < code.length; ++i) {
			arr.add(Integer.parseInt(code[i]));
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/luffy", "root", "cuongdz123");
			PreparedStatement query = c.prepareStatement("select distinct id from booking");
			ResultSet rs = query.executeQuery();
			while(rs.next()) {
				if(arr.contains(rs.getInt(1))) {
					return false;
				}
			}
			for(int i = 0; i < arr.size(); ++i) {
				query = c.prepareStatement("select price from room where id = ?");
				query.setInt(1, arr.get(i));
				rs = query.executeQuery();
				rs.next();
				rs.getInt(1);
			}
			query = c.prepareStatement("set foreign_key_checks = 0");
			query.execute();
			for(int i = 0; i < arr.size(); ++i) {
				query = c.prepareStatement("insert into booking(email, id, start) values(?, ?, ?)");
				query.setString(1, email);
				query.setInt(2, arr.get(i));
				query.setDate(3, Date.valueOf(start));
				query.executeUpdate();
			}
			query = c.prepareStatement("set foreign_key_checks = 1");
			query.execute();
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public static ArrayList<HoaDon> getHoaDon(String id, String email, String end, String night) {
		ArrayList<HoaDon> arr = new ArrayList<HoaDon>();
		String[] code = id.split(",\\s*");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/luffy", "root", "cuongdz123");
			PreparedStatement query = null;
			ResultSet rs = null;
			for(int i = 0; i < code.length; ++i) {
				query = c.prepareStatement("select booking.id, room.type, room.bed, booking.start, room.price, booking.email from booking join room on booking.id = room.id where booking.id = ? and booking.email = ?");
				query.setInt(1, Integer.parseInt(code[i]));
				query.setString(2, email);
				rs = query.executeQuery();
				rs.next();
				arr.add(new HoaDon(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), Date.valueOf(end), Integer.parseInt(night), rs.getInt(5), Integer.parseInt(night) * rs.getInt(5), rs.getString(6)));
			}
		}
		catch(Exception e) {
			return null;
		}
		return arr;
	}
	
	public static void checkOut(ArrayList<HoaDon> arr) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/luffy", "root", "cuongdz123");
			PreparedStatement query = null;
			ResultSet rs = null;
			for(int i = 0; i < arr.size(); ++i) {
				query = c.prepareStatement("insert into turnover(email, id, start, end, night, price) values(?, ?, ?, ?, ?, ?)");
				query.setString(1, arr.get(i).getEmail());
				query.setInt(2, arr.get(i).getId());
				query.setDate(3, arr.get(i).getStart());
				query.setDate(4, arr.get(i).getEnd());
				query.setInt(5, arr.get(i).getNight());
				query.setInt(6, arr.get(i).getPrice2());
				query.executeUpdate();
			}
			for(int i = 0; i < arr.size(); ++i) {
				query = c.prepareStatement("delete from booking where id = ? and email = ?");
				query.setInt(1, arr.get(i).getId());
				query.setString(2, arr.get(i).getEmail());
				query.executeUpdate();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
























