/**This is the main class
 * @author Onofrei Adrian-Mihai 2E3
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Main {
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
		
		Activity activity = new Activity();
		
		//add all the events to our array that stores the events
		activity.addEvent(C1);activity.addEvent(C1);
		activity.addEvent(C2);
		activity.addEvent(L1);activity.addEvent(L1);
		activity.addEvent(L2);
		activity.addEvent(L3);
		
		//add all the rooms to our array that stores the rooms
		activity.addRoom(R401);activity.addRoom(R401);
		activity.addRoom(R403);
		activity.addRoom(R405);
		activity.addRoom(R309);
		
		//print the available events
		System.out.println("Events: " + C1 + ", " + C2 + ", " + L1 + ", " + L2 + ", " + L3);
		
		//print the available rooms
		System.out.println("Rooms: " + R401 + ", " + R403 + ", " + R405 + ", " + R309);

		Solution sol = new Solution(activity);
		sol.repartitions();
	}

}
