package hairrang.dto;

import java.util.Date;

public class Sales {
	private int salesCode ;
	private String salesDay;	
	private String guestName;
	private String hairName;
	private String eventName;
	private int pirce;
	
	
	public int getSalesCode() {
		return salesCode;
	}
	public void setSalesCode(int salescode) {
		this.salesCode = salescode;
	}
	public String getSalesDay() {
		return salesDay;
	}
	public void setSalesDay(String salesday) {
		this.salesDay = salesday;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestname) {
		this.guestName = guestname;
	}
	public String getHairName() {
		return hairName;
	}
	public void setHairName(String hairname) {
		this.hairName = hairname;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventname) {
		this.eventName = eventname;
	}
	public int getPirce() {
		return pirce;
	}
	public void setPirce(int pirce) {
		this.pirce = pirce;
	}
	@Override
	public String toString() {
		return "sales [salescode=" + salesCode + ", salesday=" + salesDay + ", guestname=" + guestName + ", hairname="
				+ hairName + ", eventname=" + eventName + ", pirce=" + pirce + "]";
	}
	public Sales(int salescode, String salesday, String guestname, String hairname, String eventname, int pirce) {
		super();
		this.salesCode = salescode;
		this.salesDay = salesday;
		this.guestName = guestname;
		this.hairName = hairname;
		this.eventName = eventname;
		this.pirce = pirce;
	}
	
	
	
	
	
}
