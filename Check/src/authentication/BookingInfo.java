package authentication;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class BookingInfo {
	private int id;
	private String type;
	private int bed;
	private int night;
	private int price;
	private Date start;
	private Date end;
	
	public BookingInfo(int id, String type, int bed, int night, int price, Date start, Date end) {
		this.id = id;
		this.type = type;
		this.bed = bed;
		this.night = night;
		this.price = price;
		this.start = start;
		this.end = end;
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
	
	public static Vector<Vector<BookingInfo>> getInfo(String email) {
		Vector<Vector<BookingInfo>> arr = new Vector<Vector<BookingInfo>>();
		ArrayList<Time> date = new ArrayList<Time>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/luffy", "root", "cuongdz123");
			PreparedStatement query = c.prepareStatement("select distinct start, end from booking where email = ? order by start, end");
			query.setString(1, email);
			ResultSet rs = query.executeQuery();
			while(rs.next()) {
				date.add(new Time(rs.getDate(1), rs.getDate(2)));
			}
			for(int i = 0; i < date.size(); ++i) {
				Vector<BookingInfo> temp = new Vector<BookingInfo>();
				query = c.prepareStatement("select room.id, room.type, room.bed, booking.night, booking.price, booking.start, booking.end from room join booking on room.id = booking.id where booking.email = ? and booking.start = ? and booking.end = ?");
				query.setString(1, email);
				query.setDate(2, date.get(i).getStart());
				query.setDate(3, date.get(i).getEnd());
				rs = query.executeQuery();
				while(rs.next()) {
					temp.add(new BookingInfo(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getDate(6), rs.getDate(7)));
				}
				arr.add(temp);
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
























