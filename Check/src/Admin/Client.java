package Admin;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

public class Client {
	private String name;
	private String email;
	private String role;
	private int code;
	private Date start;
	private Date end;
	private int price;
	
	public Client(String name, String email, String role, int code, Date start, Date end, int price) {
		this.name = name;
		this.email = email;
		this.role = role;
		this.code = code;
		this.start = start;
		this.end = end;
		this.price = price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public Date getStart() {
		return this.start;
	}
	
	public Date getEnd() {
		return this.end;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public static Vector<Vector<Client>> search(String info) {
		Vector<Vector<Client>> arr = new Vector<Vector<Client>>();
		ArrayList<String> email = new ArrayList<String>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/luffy", "root", "cuongdz123");
			PreparedStatement query = c.prepareStatement("select email from user where regexp_like(full_name, ?) and role = ?");
			query.setString(1, info);
			query.setString(2, "client");
			ResultSet rs = query.executeQuery();
			while(rs.next()) {
				email.add(rs.getString(1));
			}
			for(int i = 0; i < email.size(); ++i) {
				Vector<Client> flag = new Vector<Client>();
				query = c.prepareStatement("select user.full_name, user.email, user.role, booking.id, booking.start, booking.end, booking.price from user left join booking on user.email = booking.email where user.email = ? order by booking.start, booking.end");
				query.setString(1, email.get(i));
				rs = query.executeQuery();
				while(rs.next()) {
					flag.add(new Client(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getDate(6), rs.getInt(7)));
				}
				arr.add(flag);
			}
		}
		catch(Exception e) {
			arr = null;
			return arr;
		}
		return arr;
	}

}






























