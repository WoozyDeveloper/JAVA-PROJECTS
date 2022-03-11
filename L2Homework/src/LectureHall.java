/**
 * @author Onofrei Adrian-Mihai 2E3
 */
public class LectureHall extends Room {

	private boolean hasProjector;
	
	/**
	 * Constructor that sets the name and the capacity of the Lecture Hall setting the option if it has a projector to true.
	 * @param name name of the lecture hall
	 * @param capacity size of the lecture hall
	 */
	public LectureHall(String name,int capacity)
	{
		super(name, capacity);
		this.hasProjector = true;
	}
	
	/**
	 * Contructor that sets the name,capacity and if the room is equipped or not with a projector
	 * @param name the name of the room
	 * @param capacity size of the room
	 * @param projector setting if the room has/doesn't have a projector
	 */
	public LectureHall(String name,int capacity, boolean projector)
	{
		super(name, capacity);
		this.hasProjector = projector;
	}

	//overriding the toString() function so it converts all the data of the room to a big string with all the information
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + "(cap=" + this.capacity + ", lecture hall)";
	}

	
	/**
	 * Gets if the room has a projector
	 * @return true if the room has a projector, false otherwise
	 */
	public boolean getProjector() {
		return hasProjector;
	}

	/**
	 * Sets if the room has a projector
	 * @param hasProjector boolean value representing if the room has or doesn't have a projector
	 */
	public void setProjector(boolean hasProjector) {
		this.hasProjector = hasProjector;
	}
	
}
