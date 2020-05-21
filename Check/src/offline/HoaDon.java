package offline;

import java.sql.Date;

public class HoaDon {
	private String email;
	private int id;
	private String type;
	private int bed;
	private Date start;
	private Date end;
	private int price1;
	private int price2;
	private int night;
	
	public HoaDon(int id, String type, int bed, Date start, Date end, int night, int price1, int price2, String email) {
		this.id = id;
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

}
