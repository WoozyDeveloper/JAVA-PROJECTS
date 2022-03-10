/**
 * 
 * @author Onofrei Adrian-Mihai 2E3
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Network {
	private List<Node> nodes = new ArrayList<>();

	@Override
	public String toString() {
		Collections.sort(nodes);
		return "Network [nodes=" + nodes + "]";
	}
	
	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public void addNode(Node node) {
		nodes.add(node);
	}

	public Network(List<Node> nodes) {
		this.nodes = nodes;
	}

	
}