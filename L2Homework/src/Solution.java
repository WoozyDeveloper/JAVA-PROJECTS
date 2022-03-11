/**In this class we find a solution for the problem
 * @author Onofrei Adrian-Mihai 2E3
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;


public class Solution {
			private static ArrayList<Event> events = new ArrayList<Event>();
			private static ArrayList<Room>  rooms  = new ArrayList<Room>();
			
			public Solution(Activity activity)
			{
				events = activity.getEvents();
				rooms = activity.getRooms();
			}
	
			//make the repartition for the events
			public void repartitions()
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
							for(Room r2 : rooms)
							{
								if(r.getName().compareTo(r2.getName()) < 0)
								{
									
								}
							}
						}
					}
					System.out.println();
				}
			}
			
			public void repartitions2()
			{
				Collections.sort(events, new Comparator<Event>() {
					@Override
					public int compare(Event e1, Event e2)
					{
						if(e1.getStart_time() == e2.getStart_time())
							return 0;
						else if(e1.getStart_time() < e2.getStart_time())
							return -1;
						return 1;
					}
				});
				
				
				for(Event e : events)
				{
					System.out.print(e.getName() + " -> ");
					for(Room r : rooms)
					{
						if(r.getCapacity() >= e.getEventSize())
						{
							for(Room r2 : rooms)
							{
								
							}
						}
					}
					System.out.println();
				}
			}
}
