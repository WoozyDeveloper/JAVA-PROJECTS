/**
 * 
 * @author Onofrei Adrian-Mihai 2E3
 *
 */

import java.util.HashMap;
import java.util.Map;

public abstract class Node implements Comparable<Node> {
	protected String name;
	private Map<Node, Integer> cost = new HashMap<>();

	@Override
	public String toString() {
		return "Node [name=" + name + "]";
	}

	@Override
	public int compareTo(Node other) {
		return this.name.compareTo(other.name);
	}
	
	public Node(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Node, Integer> getCost() {
		return cost;
	}

	public void setCost(Map<Node, Integer> cost) {
		this.cost = cost;
	}

}