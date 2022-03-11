/**In this class we find a solution for the problem
 * @author Onofrei Adrian-Mihai 2E3
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;


public class Solution {
			private static ArrayList<Event> events = new ArrayList<Event>();
			private static ArrayList<Room>  rooms  = new ArrayList<Room>();
			private static int[][] intervals;
			private static HashMap<Event,Room> correspondation = new HashMap<Event,Room>();
			
			public Solution(Activity activity)
			{
				events = activity.getEvents();
				rooms = activity.getRooms();
				
				intervals = new int[25][25];
				
				Collections.sort(events, new Comparator<Event>() {
					@Override
					public int compare(Event e1, Event e2)
					{
						if(e1.getStart_time() == e2.getStart_time())
							return 0;
						else if(e1.getStart_time() > e2.getStart_time())
							return 1;
						return -1;
					}
				});
				
				Collections.sort(rooms, new Comparator<Room>() {
					@Override
					public int compare(Room r1, Room r2)
					{
						if(r1.getCapacity() == r2.getCapacity())
							return 0;
						else if(r1.getCapacity() < r2.getCapacity())
							return 1;
						return -1;
					}
				});
				
				
				for(int i=0; i < events.size(); i++)
				{
					intervals[i][0] = events.get(i).getStart_time();
					intervals[i][1] = events.get(i).getEnd_time();
				}
			}
	
			//make the repartition for the events
			public void repartitions()
			{
				int minimumRooms = minMeetingRooms(intervals);
				
				System.out.println("we need " + minimumRooms + " rooms for the events");
////				for(int i=0; i < minimumRooms; i++)
////					System.out.print(rooms.get(i).getName() + " ");
				int dim = 0;
				for(Event e : events)
				{
					System.out.println(e.getName() + " ->");
					for(int i = 0 ; i < 25; i++)
					{
						
					}
				}
				
			}
			
			
			public int minMeetingRooms(int[][] intervals) {
			    // Min heap
			    PriorityQueue<Integer> allocator =
			        new PriorityQueue<Integer>(
			            intervals.length,
			            new Comparator<Integer>() {
			              public int compare(Integer a, Integer b) {
			                return a - b;
			              }
			            });

			    Arrays.sort(
			            intervals,
			            new Comparator<int[]>() {
			              public int compare(final int[] a, final int[] b) {
			                return a[0] - b[0];
			              }
			            });
			    
			    // Add the first meeting
			    allocator.add(intervals[0][1]);

			    int dim = 0;
			    int i;
			    for (i = 1; i < intervals.length; i++) {
			      // If the room due to free up the earliest is free, assign that room to this meeting.
			      if (intervals[i][0] >= allocator.peek()) {
			        allocator.poll();
			      }

			      // If a new room is to be assigned, then also we add to the heap,
			      // If an old room is allocated, then also we have to add to the heap with updated end time.
			      allocator.add(intervals[i][1]);
			    }

			    return allocator.size();
			  }
}
