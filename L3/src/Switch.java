/**
 * 
 * @author Onofrei Adrian-Mihai 2E3
 *
 */

public class Switch extends Node implements Identifiable {
	private String address;

	@Override
	public String toString() {
		return "Switch [name=" + name + ", address= " + address + "]";
	}
	
	public Switch(String name, String address) {
		super(name);
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}
}
