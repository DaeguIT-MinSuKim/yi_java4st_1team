package hairrang.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking {
	
	private int bookNo;
	private Guest guestNo;
	private Date bookDate;
	private String bookDateStr;
	private String bookTimeStr;
	private Hair hairNo;
	private String bookNote;
	
	
	public Booking() {
	}

	public Booking(int bookNo) {
		this.bookNo = bookNo;
	}

	public Booking(int bookNo, Guest guestNo, Date bookDate, Hair hairNo, String bookNote) {
		this.bookNo = bookNo;
		this.guestNo = guestNo;
		this.bookDate = bookDate;
		this.hairNo = hairNo;
		this.bookNote = bookNote;
		
		setBookDateStr(bookDate);
		setBookTimeStr(bookDate);
	}

	public Date getBookDate() {
		return bookDate;
	}

	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
		setBookDateStr(bookDate);
		setBookTimeStr(bookDate);
	}

	public String getBookDateStr() {
		return bookDateStr;
	}

	
	public void setBookDateStr(Date bookDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		this.bookDateStr = dateFormat.format(bookDate);
	}
	
	public void setBookDateStr(String bookDateStr) {
		this.bookDateStr = bookDateStr;
	}

	public String getBookTimeStr() {
		return bookTimeStr;
	}

	public void setBookTimeStr(Date bookDate) {
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		this.bookTimeStr = timeFormat.format(bookDate);
	}
	
	public void setBookTimeStr(String bookTimeStr) {
		this.bookTimeStr = bookTimeStr;
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
		return String.format("Booking [bookNo=%s, guestNo=%s, bookDate=%s, bookDateStr=%s, bookTimeStr=%s, hairNo=%s, bookNote=%s]", bookNo,
				guestNo, bookDate, bookDateStr, bookTimeStr, hairNo, bookNote);
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
