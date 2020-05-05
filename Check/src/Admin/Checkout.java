package Admin;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Checkout {
	private String email;
	private int id;
	private String name;
	private String type;
	private int bed;
	private Date start;
	private Date end;
	private int price1;
	private int price2;
	private int night;
	
	public Checkout(int id, String type, int bed, Date start, Date end, int night, int price1, int price2, String name, String email) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.bed = bed;
		this.start = start;
		this.end = end;
		this.price1 = price1;
		this.price2 = price2;
		this.night = night;
		this.email = email;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getType() {
		return this.type;
	}
	
	public int getBed() {
		return this.bed;
	}
	
	public Date getStart() {
		return this.start;
	}
	
	public Date getEnd() {
		return this.end;
	}
	
	public int getPrice1() {
		return this.price1;
	}
	
	public int getPrice2() {
		return this.price2;
	}
	
	public int getNight() {
		return this.night;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public static ArrayList<Checkout> check(String id, String email) {
		ArrayList<Checkout> arr = new ArrayList<Checkout>();
		String[] ele = id.split(", |,");
 		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/luffy", "root", "cuongdz123");
			PreparedStatement query = null;
			ResultSet rs = null;
			for(int i = 0; i < ele.length; ++i) {
				query = c.prepareStatement("select booking.id, room.type, room.bed, booking.start, booking.end, booking.night, room.price, booking.price, user.full_name, booking.email from booking join user on booking.email = user.email join room on booking.id = room.id where booking.id = ? and booking.email = ?");
				query.setInt(1, Integer.parseInt(ele[i]));
				query.setString(2, email);
			    rs = query.executeQuery();
			    rs.next();
			    arr.add(new Checkout(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDate(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10)));
			}
		}
		catch(Exception e) {
			arr = null;
			return arr;
		}
		return arr;
	}
}

















