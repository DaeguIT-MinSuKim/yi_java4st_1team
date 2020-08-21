package hairrang.dto;

public class Visit {
	private int visitCode;
	private String visitDay;
	private String visitTime;
	private int customerCode;
	private int hairCode;
	private int eventCode;
	
	public Visit() {
		super();
	}
	
	public int getVisitCode() {
		return visitCode;
	}
	public void setVisitCode(int visitcode) {
		this.visitCode = visitcode;
	}
	public String getVisitDay() {
		return visitDay;
	}
	public void setVisitDay(String visitday) {
		this.visitDay = visitday;
	}
	public String getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(String visittime) {
		this.visitTime = visittime;
	}
	public int getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(int customercode) {
		this.customerCode = customercode;
	}
	public int getHairCode() {
		return hairCode;
	}
	public void setHairCode(int haircode) {
		this.hairCode = haircode;
	}
	public int getEventCode() {
		return eventCode;
	}
	public void setEventCode(int eventcode) {
		this.eventCode = eventcode;
	}
	
	public Visit(int visitcode, String visitday, String visittime, int customercode, int haircode, int eventcode) {
		super();
		this.visitCode = visitcode;
		this.visitDay = visitday;
		this.visitTime = visittime;
		this.customerCode = customercode;
		this.hairCode = haircode;
		this.eventCode = eventcode;
	}
	
	@Override
	public String toString() {
		return "visit [visitcode=" + visitCode + ", visitday=" + visitDay + ", visittime=" + visitTime
				+ ", customercode=" + customerCode + ", haircode=" + hairCode + ", eventcode=" + eventCode + "]";
	}
	
	
}
