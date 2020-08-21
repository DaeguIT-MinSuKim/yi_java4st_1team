package hairrang.dto;

public class Hair {
	private int hairNo;
	private String hairName;
	private int price;
	
	public Hair() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Hair(int hairNo) {
		super();
		this.hairNo = hairNo;
	}



	public Hair(int hairNo, String hairName, int hairPrice) {
		super();
		this.hairNo = hairNo;
		this.hairName = hairName;
		this.price = hairPrice;
	}
	
	public int getHairNo() {
		return hairNo;
	}
	public void setHairNo(int hairNo) {
		this.hairNo = hairNo;
	}
	public String getHairName() {
		return hairName;
	}
	public void setHairName(String hairName) {
		this.hairName = hairName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Hair [hairNo=" + hairNo + ", hairName=" + hairName + ", price=" + price + "]";
	}
	
	
}
