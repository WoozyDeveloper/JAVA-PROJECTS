
public class Main {

	public static void main(String[] args) {
		
		//events
		Event C1 = new Event("C1",100, 8,10);
		Event C2 = new Event("C2",100,10,12);
		Event L1 = new Event("L1", 30, 8,10);
		Event L2 = new Event("L2", 30, 8,10);
		Event L3 = new Event("L3", 30,10,12);
		
		//rooms
		Room R401 = new Room("401", 30,RoomType.lab);
		Room R403 = new Room("403", 30,RoomType.lab);
		Room R405 = new Room("405", 30,RoomType.lab);
		Room R309 = new Room("309",100,RoomType.lecture_hall);
		
		//print the available events
		System.out.println("Events: " + C1 + ", " + C2 + ", " + L1 + ", " + L2 + ", " + L3);
		
		//print the available rooms
		System.out.println("Rooms: " + R401 + ", " + R403 + ", " + R405 + ", " + R309);
	}

}
