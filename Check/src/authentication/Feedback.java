package authentication;

import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;

public class Feedback {
    
	public static void saveFeedback(String fb, String rate, String email, String name) {
		try {
			Calendar cd = Calendar.getInstance();
			int month = cd.get(Calendar.MONTH) + 1;
			String time = cd.get(Calendar.YEAR) + "-" + month + "-" + cd.get(Calendar.DAY_OF_MONTH) + " " + cd.get(Calendar.HOUR_OF_DAY) + ":" + cd.get(Calendar.MINUTE) + ":" + cd.get(Calendar.SECOND);
			String file_name = "C:/Users/Admin/eclipse-workspace/Check/WebContent/WEB-INF/feedback/" + email + ".txt";
			FileWriter out = new FileWriter(file_name, true);
			out.write("\n\n" + "Time: " + time + "\n" + "Content: " + fb + "\n" + "Rate: " + rate + "/10" + "\n" + "Customer's name: " + name);
			FileReader in = new FileReader(file_name);
			out.close();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/luffy", "root", "cuongdz123");
			PreparedStatement query = c.prepareStatement("insert into feedback(content, rate, email) values(?, ?, ?)");
			query.setCharacterStream(1, in);
			query.setInt(2, Integer.parseInt(rate));
			query.setString(3, email);
			query.executeUpdate();
			query.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
