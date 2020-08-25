package hairrang.dto;

import java.sql.Date;
import java.util.List;

public class Sales {
	private int salesNo;
	private Date salesDay;
	private Guest guestNo;
	private Event eventNo;
	private Hair hairNo;
	private List<Hair> list;
	public Sales() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sales(int salesNo, Date salesDay, Guest guestNo, Event eventNo, Hair hairNo) {
		super();
		this.salesNo = salesNo;
		this.salesDay = salesDay;
		this.guestNo = guestNo;
		this.eventNo = eventNo;
		this.hairNo = hairNo;
	}
	
	public List<Hair> getList() {
		return list;
	}
	public void setList(List<Hair> list) {
		this.list = list;
	}
	public Sales(int salesNo) {
		super();
		this.salesNo = salesNo;
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
	public Hair getHairNo() {
		return hairNo;
	}
	public void setHairNo(Hair hairNo) {
		this.hairNo = hairNo;
	}
	@Override
	public String toString() {
		return "Sales [salesNo=" + salesNo + ", salesDay=" + salesDay + ", guestNo=" + guestNo + ", eventNo=" + eventNo
				+ ", hairNo=" + hairNo + "]";
	}
	

	
}
