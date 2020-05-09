package Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

public class TurnOver {
	private Date start;
	private Date end;
	private int total;
	
	public TurnOver(Date start, Date end, int total) {
		this.start = start;
		this.end = end;
		this.total = total;
	}
	
	public Date getStart() {
		return this.start;
	}
	
	public Date getEnd() {
		return this.end;
	}
	
	public int getTotal() {
		return this.total;
	}
	
	public static ArrayList<TurnOver> getTurnOver(String month, String year) {
		ArrayList<TurnOver> arr = new ArrayList<TurnOver>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/luffy", "root", "cuongdz123");
			PreparedStatement query = null;
			if(month.equals("all")) {
				query = c.prepareStatement("select start, end, sum(price) as total from turnover where year(end) = ? group by day(end), month(end) order by month(start), month(end), day(start), day(end)");
				query.setInt(1, Integer.parseInt(year));
				ResultSet rs = query.executeQuery();
				while(rs.next()) {
					arr.add(new TurnOver(rs.getDate(1), rs.getDate(2), rs.getInt(3)));
				}
			}
			else {
				query = c.prepareStatement("select temp.start, temp.end, temp.total from (select start, end, sum(price) as total from turnover group by day(end), month(end)) temp where month(temp.end) = ? and year(temp.end) = ? order by day(temp.start), day(temp.end)");
				query.setInt(1, Integer.parseInt(month));
				query.setInt(2, Integer.parseInt(year));
				ResultSet rs = query.executeQuery();
				while(rs.next()) {
					arr.add(new TurnOver(rs.getDate(1), rs.getDate(2), rs.getInt(3)));
				}
			}
		}
		catch(Exception e) {
			arr = null;
			return arr;
		}
		return arr;
	}
	
//	public static ArrayList<TurnOver> getTurnOver(String month, String year) {
//		ArrayList<TurnOver> arr = new ArrayList<TurnOver>();
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/luffy", "root", "cuongdz123");
//			PreparedStatement query = null;
//			if(month.equals("all")) {
//				query = c.prepareStatement("select start, end, sum(price) as total from booking where year(end) = ? group by day(end), month(end) order by month(start), month(end), day(start), day(end)");
//				query.setInt(1, Integer.parseInt(year));
//				ResultSet rs = query.executeQuery();
//				while(rs.next()) {
//					arr.add(new TurnOver(rs.getDate(1), rs.getDate(2), rs.getInt(3)));
//				}
//			}
//			else {
//				query = c.prepareStatement("select temp.start, temp.end, temp.total from (select start, end, sum(price) as total from booking group by day(end), month(end)) temp where month(temp.end) = ? and year(temp.end) = ? order by day(temp.start), day(temp.end)");
//				query.setInt(1, Integer.parseInt(month));
//				query.setInt(2, Integer.parseInt(year));
//				ResultSet rs = query.executeQuery();
//				while(rs.next()) {
//					arr.add(new TurnOver(rs.getDate(1), rs.getDate(2), rs.getInt(3)));
//				}
//			}
//		}
//		catch(Exception e) {
//			arr = null;
//			return arr;
//		}
//		return arr;
//	}

}
