package authentication;
import java.sql.Date;

public class Time {
	private Date start;
	private Date end;
	
	public Time(Date start, Date end) {
		this.start = start;
		this.end = end;
	}
	
	public Date getStart() {
		return this.start;
	}
	
	public Date getEnd() {
		return this.end;
	}

}
