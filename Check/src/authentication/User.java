package authentication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User {
	private String name;
	private String role;
	private String email;
	
	public boolean check(String email, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/luffy", "root", "cuongdz123");
			PreparedStatement query = c.prepareStatement("select full_name, role, email from user where email = ? and password = ?");
			query.setString(1, email);
			query.setString(2, password);
			ResultSet rs = query.executeQuery();
			rs.next();
			this.name = rs.getString(1);
			this.role = rs.getString(2);
			this.email = rs.getString(3);
			query.close();
			rs.close();
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

}










