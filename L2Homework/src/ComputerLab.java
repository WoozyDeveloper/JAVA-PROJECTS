
public class ComputerLab extends Room {

	private String operatingSystemUsed;
	
	public ComputerLab(String name,int capacity)
	{
		super(name, capacity);
		this.operatingSystemUsed = "Linux";
	}
	
	public ComputerLab(String name,int capacity, String OS)
	{
		super(name, capacity);
		this.operatingSystemUsed = OS;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + "(cap=" + this.capacity + ", lab)";
	}

	public String getOperatingSystem() {
		return operatingSystemUsed;
	}

	public void setOperatingSystem(String operatingSystemUsed) {
		this.operatingSystemUsed = operatingSystemUsed;
	}


}
