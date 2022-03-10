import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

	private static ArrayList<Event> events = new ArrayList<Event>();
	private static ArrayList<Room>  rooms  = new ArrayList<Room>();
	
	
	public static boolean addEvent(Event event)
	{
		if(!events.isEmpty() && events.contains(event))
			return false;
		events.add(event);
		return true;
	}
	
	public static boolean addRoom(Room room)
	{
		if(!rooms.isEmpty() && rooms.contains(room))
			return false;
		rooms.add(room);
		return true;
	}
	
	public static void repartitions()
	{
		boolean passedEvents[] = new boolean[events.size()];
		ArrayList<Event> usedEvents = new ArrayList<Event>();
		for(Event e : events)
		{
			System.out.print(e.getName() + " -> ");
			for(Room r : rooms)
			{
				boolean usedRoom = false;
				for(Event e2 : events)
					if(e.getEnd_time() <= e2.getEnd_time() && e.getEnd_time() >= e2.getStart_time() && !e.equals(e2))
					{
						if(e.getEventSize() <= r.getCapacity())
						{
							usedRoom = true;
							break;
						}
					}
				
				if(usedRoom == false && !usedEvents.contains(e))
				{
					System.out.print(r.getName());
					usedEvents.add(e);
				}
				if(usedRoom == true && !usedEvents.contains(e))
				{
					//System.out.print("ASDSAD");
					for(Room r2 : rooms)
					{
						if(!r.equals(r2) && e.getEventSize() <= r2.getCapacity())
							System.out.print(r2.getName());
					}
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		//events
		Event C1 = new Event("C1",100, 8,10);
		Event C2 = new Event("C2",100,10,12);
		Event L1 = new Event("L1", 30, 8,10);
		Event L2 = new Event("L2", 30, 8,10);
		Event L3 = new Event("L3", 30,10,12);
		
		//rooms
		Room R401 = new ComputerLab("401", 30);
		Room R403 = new LectureHall("403", 30);
		Room R405 = new LectureHall("405", 30);
		Room R309 = new ComputerLab("309",100);
		
		//add all the events to our array that stores the events
		addEvent(C1);addEvent(C1);
		addEvent(C2);
		addEvent(L1);addEvent(L1);
		addEvent(L2);
		addEvent(L3);
		System.out.println("No. of events: " + events.size());
		
		//add all the rooms to our array that stores the rooms
		addRoom(R401);addRoom(R401);
		addRoom(R403);
		addRoom(R405);
		addRoom(R309);
		System.out.println("No. of rooms: " + rooms.size());
		
		//print the available events
		System.out.println("Events: " + C1 + ", " + C2 + ", " + L1 + ", " + L2 + ", " + L3);
		
		Collections.sort(events, new Comparator<Event>() {
			@Override
			public int compare(Event e1, Event e2)
		    {
		        if (e1.getEnd_time() == e2.getEnd_time())
		            return 0;
		        else if (e1.getEnd_time() > e2.getEnd_time())
		            return 1;
		        else
		            return -1;
		    }
		});
		
		//print the available rooms
		System.out.println("Rooms: " + R401 + ", " + R403 + ", " + R405 + ", " + R309);

		
		repartitions();
	}

}
