package yi_java4st_1team.dto;

public class Hairgoods {
	private int hairCode;
	private String hairName;
	private int hairPrice;
	
	public Hairgoods() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Hairgoods(int haircode, String hairname, int hairprice) {
		super();
		this.hairCode = haircode;
		this.hairName = hairname;
		this.hairPrice = hairprice;
	}
	
	public int getHairCode() {
		return hairCode;
	}
	public void setHairCode(int haircode) {
		this.hairCode = haircode;
	}
	public String getHairName() {
		return hairName;
	}
	public void setHairName(String hairname) {
		this.hairName = hairname;
	}
	public int getHairPrice() {
		return hairPrice;
	}
	public void setHairPrice(int hairprice) {
		this.hairPrice = hairprice;
	}
	
	@Override
	public String toString() {
		return "hairgoods [haircode=" + hairCode + ", hairname=" + hairName + ", hairprice=" + hairPrice + "]";
	}
	
	
}
