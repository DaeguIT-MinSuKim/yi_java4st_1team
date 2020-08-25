package hairrang.dto;

public class Event {
	private int eventcode;
	private String eventname;
	private double eventsale;
	
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getEventcode() {
		return eventcode;
	}
	public void setEventcode(int eventcode) {
		this.eventcode = eventcode;
	}
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	public double getEventsale() {
		return eventsale;
	}
	public void setEventsale(double eventsale) {
		this.eventsale = eventsale;
	}
	
	public Event(int eventcode, String eventname, double eventsale) {
		super();
		this.eventcode = eventcode;
		this.eventname = eventname;
		this.eventsale = eventsale;
	}
	
	@Override
	public String toString() {
		return "event [eventcode=" + eventcode + ", eventname=" + eventname + ", eventsale=" + eventsale + "]";
	}
	
}
