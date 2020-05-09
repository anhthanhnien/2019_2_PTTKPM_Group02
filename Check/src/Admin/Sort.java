package Admin;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class Sort {
	private int id;
	private String type;
	private int bed;
	private int price;
	private String name;
	private Date start;
	private Date end;
	
	public Sort(int id, String type, int bed, int price, String name, Date start, Date end) {
		this.id = id;
		this.type = type;
		this.bed = bed;
		this.price = price;
		this.name = name;
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
	
	public int getPrice() {
		return this.price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Date getStart() {
		return this.start;
	}
	
	public Date getEnd() {
		return this.end;
	}
	
	public static ArrayList<Sort> sort(String kind, String value, String avail) {
		String sql = "";
		int i = 0;
		ArrayList<Sort> arr = new ArrayList<Sort>();
		ArrayList<String> temp = new ArrayList<String>();
		temp.add(kind);
		temp.add(value);
		temp.add(avail);
		while(i < temp.size()) {
			if(temp.get(i) == null || temp.get(i).equals("none")) {
				temp.remove(i);
			}
			else ++i;
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/luffy", "root", "cuongdz123");
			PreparedStatement query = null;
			if(temp.size() == 3) {
				sql += "select room.id, room.type, room.bed, room.price, user.full_name, booking.start, booking.end from room left join booking on room.id = booking.id left join user on booking.email = user.email order by " + temp.get(0) + ", " + temp.get(1) + ", " + temp.get(2);
				query = c.prepareStatement(sql);
				ResultSet rs = query.executeQuery();
				while(rs.next()) {
					arr.add(new Sort(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getDate(6), rs.getDate(7)));
				}
			}
			else if(temp.size() == 2) {
				sql += "select room.id, room.type, room.bed, room.price, user.full_name, booking.start, booking.end from room left join booking on room.id = booking.id left join user on booking.email = user.email order by " + temp.get(0) + ", " + temp.get(1);
				query = c.prepareStatement(sql);
				ResultSet rs = query.executeQuery();
				while(rs.next()) {
					arr.add(new Sort(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getDate(6), rs.getDate(7)));
				}
			}
			else if(temp.size() == 1) {
				sql += "select room.id, room.type, room.bed, room.price, user.full_name, booking.start, booking.end from room left join booking on room.id = booking.id left join user on booking.email = user.email order by " + temp.get(0);
				query = c.prepareStatement(sql);
				ResultSet rs = query.executeQuery();
				while(rs.next()) {
					arr.add(new Sort(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getDate(6), rs.getDate(7)));
				}
			}
			else {
				query = c.prepareStatement("select room.id, room.type, room.bed, room.price, user.full_name, booking.start, booking.end from room left join booking on room.id = booking.id left join user on booking.email = user.email");
				ResultSet rs = query.executeQuery();
				while(rs.next()) {
					arr.add(new Sort(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getDate(6), rs.getDate(7)));
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

}
































