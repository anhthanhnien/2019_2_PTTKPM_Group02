package authentication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Registration {
	private String name;
	private String password;
	private String email;
	private String role;
	
	public Registration(String email, String password, String full_name) {
		this.email = email;
		this.name = full_name;
		this.password = password;
		this.role = "client";
	}
	
	public int register() throws SQLException {
		Connection c = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/luffy", "root", "cuongdz123");
			PreparedStatement query = c.prepareStatement("select email from user where email = ?");
			query.setString(1, this.email);
			ResultSet rs = query.executeQuery();
			rs.next();
			if(rs.getString(1) != null) {
				return 0;
			}
		}
		catch(Exception e) {
			PreparedStatement query = c.prepareStatement("insert into user(email, full_name, password, role) values(?, ?, ?, ?)");
			query.setString(1, this.email);
			query.setString(2, this.name);
			query.setString(3, this.password);
			query.setString(4, this.role);
			query.executeUpdate();
		}
		return 1;
	}

}
