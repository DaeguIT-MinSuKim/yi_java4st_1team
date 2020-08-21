package hairrang.dto;

public class Event {
	private int eventNo;
	private String eventName;
	private double sale;
	
	public Event() {
		super();
	}
	
	public int getEventNo() {
		return eventNo;
	}
	public void setEventNo(int eventNo) {
		this.eventNo = eventNo;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public double getSale() {
		return sale;
	}
	public void setSale(double eventSale) {
		this.sale = eventSale;
	}
	
	public Event(int eventCode, String eventName, double eventSale) {
		super();
		this.eventNo = eventCode;
		this.eventName = eventName;
		this.sale = eventSale;
	}
	
	@Override
	public String toString() {
		return "event [eventNo=" + eventNo + ", eventName=" + eventName + ", Sale=" + sale + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eventNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return this.eventNo == ((Event)obj).eventNo;
	}
	
	
}
