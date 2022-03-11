/**
 * @author Onofrei Adrian-Mihai 2E3
 */
import java.util.Objects;

public abstract class Room {
	protected String name;//the name of the room
	protected int capacity;// the capacity of the room
	
	
	/**
	 * Constructor that sets the name and the capacity of the room
	 * @param name name of the room
	 * @param capacity size of the room
	 */
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

	/**
	 * Gets the name of the room
	 * @return the name of the room
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets the name of the room
	 * @param name the name of the room
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the capacity of the room
	 * @return the capacity of the room
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * Sets the capacity of the room
	 * @param capacity the size of the room
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
}
