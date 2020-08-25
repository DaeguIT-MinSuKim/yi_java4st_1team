package hairrang.dto;

import java.util.Date;

public class Guest {
	private int guestNo;
	private String guestName;
	private Date birthday;
	private Date joinDay;
	private String phone;
	private int gender;
	private String guestNote;
	
	

	public Guest() {
		
	}

	public Guest(int guestNo) {
		super();
		this.guestNo = guestNo;
	}
	
	
	public Guest(String guestName) {
		super();
		this.guestName = guestName;
	}

	public Guest(int guestNo, String guestName, Date birthday, Date joinDay, String phone, int gender,
			String guestNote) {
		super();
		this.guestNo = guestNo;
		this.guestName = guestName;
		this.birthday = birthday;
		this.joinDay = joinDay;
		this.phone = phone;
		this.gender = gender;
		this.guestNote = guestNote;
	}

	public int getGuestNo() {
		return guestNo;
	}

	public void setGuestNo(int guestNo) {
		this.guestNo = guestNo;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getJoinDay() {
		return joinDay;
	}

	public void setJoinDay(Date joinDay) {
		this.joinDay = joinDay;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getGuestNote() {
		return guestNote;
	}

	public void setGuestNote(String guestNote) {
		this.guestNote = guestNote;
	}

	@Override
	public String toString() {
		return "Guest [guestNo=" + guestNo + ", guestName=" + guestName + ", birthday=" + birthday + ", joinDay="
				+ joinDay + ", phone=" + phone + ", gender=" + gender + ", guestNote=" + guestNote + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + guestNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return this.guestNo == ((Guest) obj).guestNo;
	}


}
