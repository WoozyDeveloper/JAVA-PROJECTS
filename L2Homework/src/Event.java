/**
 * @author Onofrei Adrian-Mihai 2E3
 */
import java.util.Objects;

public class Event {
	private String name;//name of the event
	private int event_size;//the capacity of the event (the number of people that can attend)
	private int start_time;//starting time of the event
	private int end_time;//ending time of the event
	
	/**
	 * This constructor adds an Event with the following informations:
	 * @param name storing the name of the event
	 * @param event_size storing the size of the event
	 * @param start_time storing the starting time of the event
	 * @param end_time storing the end of the event
	 */
	//constructor where we set the name, event_size (capacity), start_time and end_time of the event
	public Event(String name, int event_size, int start_time, int end_time)
	{
		this.setName(name);
		this.setEventSize(event_size);
		this.start_time = start_time;
		this.setEnd_time(end_time);
	}


	/**
	 * overriding the equals() method to identify if 2 events are equal or not
	 */
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
	
	/**
	 * Getter for the name
	 * @return the name of the event
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets the name of the event
	 * @param name the given name for the event
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the size of the event
	 * @return the size of the event
	 */
	public int getEventSize() {
		return event_size;
	}
	/**
	 * Sets the size of the event
	 * @param event_size the size that the event has
	 */
	public void setEventSize(int event_size) {
		this.event_size = event_size;
	}

	/**
	 * Gets the starting time of the event
	 * @return the start time of the event
	 */
	public int getStart_time() {
		return start_time;
	}
	/**
	 * Sets the start time of the event
	 * @param start_time the starting time of the event
	 */
	public void setStart_time(int start_time) {
		this.start_time = start_time;
	}

	/**
	 * Gets the end time of the event
	 * @return the end time of the event
	 */
	public int getEnd_time() {
		return end_time;
	}
	/**
	 * Sets the end time of the event
	 * @param end_time the end time of the event
	 */
	public void setEnd_time(int end_time) {
		this.end_time = end_time;
	}
}
