package search;

import java.sql.Date;

public class DaiDien {
	private int id;
	private String type;
	private int bed;
	private int price;
	private String name;
	private Date start;
	private Date end;
	
	public DaiDien(int id, String type, int bed, int price, String name, Date start, Date end) {
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
	
}
