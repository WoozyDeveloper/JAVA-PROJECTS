import java.util.Objects;

public abstract class Room {
	protected String name;//the name of the room
	protected int capacity;// the capacity of the room
	
	
	//contructor where we set the name,capacity and type of a room when we create a new one
	public Room(String name, int capacity)
	{
		this.setName(name);
		this.setCapacity(capacity);
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return capacity == other.capacity && Objects.equals(name, other.name);
	}


	//overriding the toString() function so it converts all the data of the room to a big string with all the information
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + "(cap=" + this.capacity + ")";
	}

	//set/get methods for name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//set/get methods for the capacity of the room
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
}
