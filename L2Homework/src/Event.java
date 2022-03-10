import java.util.Objects;

public class Event {
	private String name;//name of the event
	private int event_size;//the capacity of the event (the number of people that can attend)
	private int start_time;//starting time of the event
	private int end_time;//ending time of the event
	
	//constructor where we set the name, event_size (capacity), start_time and end_time of the event
	public Event(String name, int event_size, int start_time, int end_time)
	{
		this.setName(name);
		this.setEventSize(event_size);
		this.start_time = start_time;
		this.setEnd_time(end_time);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		return end_time == other.end_time && event_size == other.event_size && Objects.equals(name, other.name)
				&& start_time == other.start_time;
	}

	@Override
	public String toString() {
		return this.name + "(size=" + this.event_size + ",start=" + this.start_time + 
				",end=" + this.end_time + ")";
	}
	
	//set/get methods for the name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	//set/get methods for the size of the event (capacity)
	public int getEventSize() {
		return event_size;
	}
	public void setEventSize(int event_size) {
		this.event_size = event_size;
	}

	//set/get methods for the starting time of the event
	public int getStart_time() {
		return start_time;
	}
	public void setStart_time(int start_time) {
		this.start_time = start_time;
	}

	//set/get methods for the ending time of the event
	public int getEnd_time() {
		return end_time;
	}
	public void setEnd_time(int end_time) {
		this.end_time = end_time;
	}
}
