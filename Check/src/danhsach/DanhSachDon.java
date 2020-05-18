package danhsach;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import authentication.Time;

public class DanhSachDon {
	private int id;
	private String type;
	private int bed;
	private int night;
	private int price;
	private Date start;
	private Date end;
	private String email;
	
	public DanhSachDon(int id, String type, int bed, int night, int price, Date start, Date end, String email) {
		this.id = id;
		this.type = type;
		this.bed = bed;
		this.night = night;
		this.price = price;
		this.start = start;
		this.end = end;
		this.email = email;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getType() {
		return this.type;
	}
	
	public int getBed() {
		return this.bed;
	}
	
	public int getNight() {
		return this.night;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public Date getStart() {
		return this.start;
	}

	public Date getEnd() {
		return this.end;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public static Vector<Vector<DanhSachDon>> getInfo() {
		Vector<Vector<DanhSachDon>> arr = new Vector<Vector<DanhSachDon>>();
		ArrayList<Time> date = new ArrayList<Time>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/luffy", "root", "cuongdz123");
			PreparedStatement query = c.prepareStatement("select distinct start, end from booking order by start, end");
			ResultSet rs = query.executeQuery();
			while(rs.next()) {
				date.add(new Time(rs.getDate(1), rs.getDate(2)));
			}
			for(int i = 0; i < date.size(); ++i) {
				Vector<DanhSachDon> temp = new Vector<DanhSachDon>();
				if(date.get(i).getEnd() != null) {
					query = c.prepareStatement("select room.id, room.type, room.bed, booking.night, booking.price, booking.start, booking.end, booking.email from room join booking on room.id = booking.id where booking.start = ? and booking.end = ?");
					query.setDate(1, date.get(i).getStart());
					query.setDate(2, date.get(i).getEnd());
					rs = query.executeQuery();
					while(rs.next()) {
						temp.add(new DanhSachDon(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getDate(6), rs.getDate(7), rs.getString(8)));
					}
					arr.add(temp);
				}
				else {
					query = c.prepareStatement("select room.id, room.type, room.bed, booking.night, booking.price, booking.start, booking.end, booking.email from room join booking on room.id = booking.id where booking.start = ? and booking.end is null");
					query.setDate(1, date.get(i).getStart());
					rs = query.executeQuery();
					while(rs.next()) {
						temp.add(new DanhSachDon(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getDate(6), rs.getDate(7), rs.getString(8)));
					}
					arr.add(temp);
				}
			}
			rs.close();
			query.close();
		}
		catch(Exception e) {
			arr = null;
			return arr;
		}
		return arr;
	}

}
