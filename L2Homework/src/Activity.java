
public class Activity {

	Event event;
	Room room;
	
	public Activity(Event e, Room r)
	{
		this.event = e;
		this.room = r;
	}
	
	public Activity()
	{
		this.event = null;
		this.room = null;
	}
	
	public void Add(Event e)
	{
		this.event = e;
	}
	
	public void Add(Room r)
	{
		this.room = r;
	}
}
