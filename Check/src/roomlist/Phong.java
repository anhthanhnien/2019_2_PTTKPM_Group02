package roomlist;

public class Phong {
	private int id;
	private String type;
	private int bed;
	private int price;
	private String image;
	
	public Phong(int id, String type, int bed, int price) {
		this.id = id;
		this.type = type;
		this.bed = bed;
		this.price = price;
	}
	
	public Phong(int id, String type, int bed, int price, String image) {
		this.id = id;
		this.type = type;
		this.bed = bed;
		this.price = price;
		this.image = image;
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
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getImage() {
		return this.image;
	}
	
}















