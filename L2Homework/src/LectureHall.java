
public class LectureHall extends Room {

	private boolean hasProjector;
	
	public LectureHall(String name,int capacity)
	{
		super(name, capacity);
		this.hasProjector = true;
	}
	
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

	public boolean getProjector() {
		return hasProjector;
	}

	public void setProjector(boolean hasProjector) {
		this.hasProjector = hasProjector;
	}
	
}
