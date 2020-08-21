package hairrang.dto;

public class Customer {
	private int customercode;
	private String customername;
	private String customeryear;
	private String customerjoin;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(int customernum, String customername, String customeryear, String customerjoin) {
		super();
		this.customercode = customernum;
		this.customername = customername;
		this.customeryear = customeryear;
		this.customerjoin = customerjoin;
	}
	
	@Override
	public String toString() {
		return "customer [customernum=" + customercode + ", customername=" + customername + ", customeryear="
				+ customeryear + ", customerjoin=" + customerjoin + "]";
	}
	
	public int getCustomercode() {
		return customercode;
	}
	public void setCustomecode(int customercode) {
		this.customercode = customercode;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomeryear() {
		return customeryear;
	}
	public void setCustomeryear(String customeryear) {
		this.customeryear = customeryear;
	}
	public String getCustomerjoin() {
		return customerjoin;
	}
	public void setCustomerjoin(String customerjoin) {
		this.customerjoin = customerjoin;
	}
	
	
}
