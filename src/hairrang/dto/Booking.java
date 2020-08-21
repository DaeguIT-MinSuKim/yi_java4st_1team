package hairrang.dto;

import java.util.Date;

public class Booking {
	
	private int bookNo;
	private Guest guestNo;
	private Date bookDay;
	private Date bookTime;
	private Hair hairNo;
	private String bookNote;
	
	
	public Booking() {
	}

	public Booking(int bookNo) {
		this.bookNo = bookNo;
	}

	public Booking(int bookNo, Guest guestNo, Date bookDay, Date bookTime, Hair hairNo, String bookNote) {
		this.bookNo = bookNo;
		this.guestNo = guestNo;
		this.bookDay = bookDay;
		this.bookTime = bookTime;
		this.hairNo = hairNo;
		this.bookNote = bookNote;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public Guest getGuestNo() {
		return guestNo;
	}

	public void setGuestNo(Guest guestNo) {
		this.guestNo = guestNo;
	}

	public Date getBookDay() {
		return bookDay;
	}

	public void setBookDay(Date bookDay) {
		this.bookDay = bookDay;
	}

	public Date getBookTime() {
		return bookTime;
	}

	public void setBookTime(Date bookTime) {
		this.bookTime = bookTime;
	}

	public Hair getHairNo() {
		return hairNo;
	}

	public void setHairNo(Hair hairNo) {
		this.hairNo = hairNo;
	}

	public String getBookNote() {
		return bookNote;
	}

	public void setBookNote(String bookNote) {
		this.bookNote = bookNote;
	}

	@Override
	public String toString() {
		return String.format("Booking [bookNo=%s, guestNo=%s, bookDay=%s, bookTime=%s, hairNo=%s, bookNote=%s]", bookNo,
				guestNo, bookDay, bookTime, hairNo, bookNote);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return this.bookNo == ((Booking) obj).bookNo;
	}
	
	
	
}
