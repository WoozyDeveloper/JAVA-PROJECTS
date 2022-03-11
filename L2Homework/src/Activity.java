/**In this class we store the events and the rooms
 * @author Onofrei Adrian-Mihai 2E3
 */
import java.util.ArrayList;

public class Activity {
		Event event;
		Room room;
		
		private static ArrayList<Event> events = new ArrayList<Event>();
		private static ArrayList<Room>  rooms  = new ArrayList<Room>();
	
		
		public ArrayList<Event> getEvents()
		{
			return events;
		}
	
		public ArrayList<Room> getRooms()
		{
			return rooms;
		}
		
		//add an event to the ArrayList events
		public boolean addEvent(Event event)
		{
			if(!events.isEmpty() && events.contains(event))
				return false;
			events.add(event);
			return true;
		}
		
		//add a room to the ArrayList rooms
		public boolean addRoom(Room room)
		{
			if(!rooms.isEmpty() && rooms.contains(room))
				return false;
			rooms.add(room);
			return true;
		}
}
