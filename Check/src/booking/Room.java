package booking;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Room {
	private int id;
	private int bed;
	private String type;
	private int price;
	
	public Room(int id, int bed, String type, int price) {
		this.id = id;
		this.bed = bed;
		this.type = type;
		this.price = price;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getBed() {
		return this.bed;
	}
	
	public String getType() {
		return this.type;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public static ArrayList<Room> getRoom(int quantity, String type, String start, String end) {
		ArrayList<Room> list = new ArrayList<Room>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/luffy", "root", "cuongdz123");
			PreparedStatement query = c.prepareStatement("select room.id, room.type, room.bed, room.price from room left join booking on room.id = booking.id where (room.type = ? and room.bed = ? and booking.end < ? and booking.end is not null) or (room.type = ? and room.bed = ? and booking.end is null and booking.start is null) or (room.type = ? and room.bed = ? and booking.start > ?)");
			java.sql.Date date1 = Date.valueOf(start);
			java.sql.Date date2 = Date.valueOf(end);
			query.setDate(3, date1);
			query.setString(1, type);
			query.setInt(2, quantity);
			query.setString(4, type);
			query.setInt(5, quantity);
			query.setString(6, type);
			query.setInt(7, quantity);
			query.setDate(8, date2);
			ResultSet rs = query.executeQuery();
			while(rs.next()) {
				list.add(new Room(rs.getInt(1), rs.getInt(3), rs.getString(2), rs.getInt(4)));
			}
			query.close();
			rs.close();
		}
		catch(Exception e) {
			list = null;
			return list;
		}
		return list;
	}
}



























