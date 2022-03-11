/**
 * @author Onofrei Adrian-Mihai 2E3
 */
public class ComputerLab extends Room {

	private String operatingSystemUsed;
	
	/**
	 * Contructor of a computer lab setting its name and capacity and the OS default to 'Linux'
	 * @param name the name of the computer laboratory
	 * @param capacity the capacity of the laboratory
	 */
	public ComputerLab(String name,int capacity)
	{
		super(name, capacity);
		this.operatingSystemUsed = "Linux";
	}
	
	/**
	 * Constructor that sets name, capacity and OS of the computer laboratory
	 * @param name the name of the computer laboratory
	 * @param capacity the capacity of the laboratory
	 * @param OS the OS that the computer have in the laboratory
	 */
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

	/**
	 * Gets the Operating System of the computers
	 * @return the operating system name
	 */
	public String getOperatingSystem() {
		return operatingSystemUsed;
	}

	/**
	 * Sets the operating system of the computers in the laboratory
	 * @param operatingSystemUsed the name of the operating system
	 */
	public void setOperatingSystem(String operatingSystemUsed) {
		this.operatingSystemUsed = operatingSystemUsed;
	}


}
