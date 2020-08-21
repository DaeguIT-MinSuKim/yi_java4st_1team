package hairrang.dto;

import java.util.Date;

public class Sales {
	private int salesNo;
	private Date salesDay;	
	private Date salesTime;
	private Guest guestNo;
	private Event eventNo;
	
	
	public Sales() {
	}
	
	public Sales(int salesNo) {
		this.salesNo = salesNo;
	}

	public Sales(int salesNo, Date salesDay, Date salesTime, Guest guestNo, Event eventNo) {
		this.salesNo = salesNo;
		this.salesDay = salesDay;
		this.salesTime = salesTime;
		this.guestNo = guestNo;
		this.eventNo = eventNo;
	}

	public int getSalesNo() {
		return salesNo;
	}

	public void setSalesNo(int salesNo) {
		this.salesNo = salesNo;
	}

	public Date getSalesDay() {
		return salesDay;
	}

	public void setSalesDay(Date salesDay) {
		this.salesDay = salesDay;
	}

	public Date getSalesTime() {
		return salesTime;
	}

	public void setSalesTime(Date salesTime) {
		this.salesTime = salesTime;
	}

	public Guest getGuestNo() {
		return guestNo;
	}

	public void setGuestNo(Guest guestNo) {
		this.guestNo = guestNo;
	}

	public Event getEventNo() {
		return eventNo;
	}

	public void setEventNo(Event eventNo) {
		this.eventNo = eventNo;
	}

	@Override
	public String toString() {
		return String.format("Sales [salesNo=%s, salesDay=%s, salesTime=%s, guestNo=%s, eventNo=%s]", salesNo, salesDay,
				salesTime, guestNo, eventNo);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + salesNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return this.salesNo == ((Sales)obj).salesNo;
	}
	
	
}
