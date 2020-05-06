package Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RefreshRoom {
	
	public static void refresh(String id, String email) {
		String[] temp = id.split(",");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/luffy", "root", "cuongdz123");
			PreparedStatement query = null;
			ResultSet rs = null;
			for(int i = 0; i < temp.length; ++i)  {
				query = c.prepareStatement("select email, id, start, end, night, price from booking where id = ? and email = ?");
				query.setInt(1, Integer.parseInt(temp[i].trim()));
				query.setString(2, email);
				rs = query.executeQuery();
				while(rs.next()) {
					query = c.prepareStatement("insert into turnover(email, id, start, end, night, price) values(?, ?, ?, ?, ?, ?)");
					query.setString(1, rs.getString(1));
					query.setInt(2, rs.getInt(2));
					query.setDate(3, rs.getDate(3));
					query.setDate(4, rs.getDate(4));
					query.setInt(5, rs.getInt(5));
					query.setInt(6, rs.getInt(6));
					query.executeUpdate();
				}
			}
			for(int i = 0; i < temp.length; ++i) {
				query = c.prepareStatement("delete from booking where id = ? and email = ?");
				query.setInt(1, Integer.parseInt(temp[i].trim()));
				query.setString(2, email);
				query.executeUpdate();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	public static void refresh(String id) {
//		String[] temp = id.split(",| ,");
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/luffy", "root", "cuongdz123");
//			PreparedStatement query = null;
//			for(int i = 0; i < temp.length; ++i) {
//				query = c.prepareStatement("delete from booking where id = ?");
//				query.setInt(1, Integer.parseInt(temp[i]));
//				query.executeUpdate();
//			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//	}

}
