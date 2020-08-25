package hairrang.dto;

public class Guest {
	int guestCode;
	String guestName;
	String guestBirthday;
	String guestJoinday;
	Boolean guestGender;
	String guestPhone;

	public Guest() {
	}

	public Guest(int guestCode) {
		this.guestCode = guestCode;
	}

	public Guest(int guestCode, String guestName, String guestBirthday) {
		this.guestCode = guestCode;
		this.guestName = guestName;
		this.guestBirthday = guestBirthday;
	}
	
	
	public Guest(int guestCode, String guestName, String guestBirthDay, String guestJoinDay, Boolean guestGender,
			String guestPhone) {
		super();
		this.guestCode = guestCode;
		this.guestName = guestName;
		this.guestBirthday = guestBirthDay;
		this.guestJoinday = guestJoinDay;
		this.guestGender = guestGender;
		this.guestPhone = guestPhone;
	}

	public int getGuestCode() {
		return guestCode;
	}

	public void setGuestCode(int guestCode) {
		this.guestCode = guestCode;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getGuestBirthday() {
		return guestBirthday;
	}

	public void setGuestBirthday(String guestBirthDay) {
		this.guestBirthday = guestBirthDay;
	}

	public String getGuestJoinday() {
		return guestJoinday;
	}

	public void setGuestJoinday(String guestJoinDay) {
		this.guestJoinday = guestJoinDay;
	}

	public Boolean getGuestGender() {
		return guestGender;
	}

	public void setGuestGender(Boolean guestGender) {
		this.guestGender = guestGender;
	}

	public String getGuestPhone() {
		return guestPhone;
	}

	public void setGuestPhone(String guestPhone) {
		this.guestPhone = guestPhone;
	}

	@Override
	public String toString() {
		return String.format(
				"Guest [guestCode=%s, guestName=%s, guestBirthDay=%s, guestJoinDay=%s, guestGender=%s, guestPhone=%s]",
				guestCode, guestName, guestBirthday, guestJoinday, guestGender, guestPhone);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((guestBirthday == null) ? 0 : guestBirthday.hashCode());
		result = prime * result + guestCode;
		result = prime * result + ((guestGender == null) ? 0 : guestGender.hashCode());
		result = prime * result + ((guestJoinday == null) ? 0 : guestJoinday.hashCode());
		result = prime * result + ((guestName == null) ? 0 : guestName.hashCode());
		result = prime * result + ((guestPhone == null) ? 0 : guestPhone.hashCode());
		return result;
	}

	// guestCode로 비교하기 ( indexOf등등 응용 가능)
	@Override
	public boolean equals(Object obj) {
		return this.guestCode == ((Guest) obj).guestCode;
	}
	
	

}
