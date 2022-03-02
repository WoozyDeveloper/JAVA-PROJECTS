
public class Room {
	private String name;//the name of the room
	private RoomType room_type;//the type of the room
	private int capacity;// the capacity of the room
	
	//contructor where we set the name,capacity and type of a room when we create a new one
	public Room(String name, int capacity, RoomType type)
	{
		this.setName(name);
		this.setType(type);
		this.setCapacity(capacity);
	}
	
	
	//overriding the toString() function so it converts all the data of the room to a big string with all the information
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + "(cap=" + this.capacity + "," 
				+ this.room_type + ")";
	}

	//set/get methods for name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//set/get methods for the type of the room
	public RoomType getType() {
		return room_type;
	}
	public void setType(RoomType type) {
		this.room_type = type;
	}

	//set/get methods for the capacity of the room
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
}
