/**
 * 
 * @author Onofrei Adrian-Mihai 2E3
 *
 */

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Node> nodes = new ArrayList<>();
		
		Node n1 = new Computer("A","1FF2232F13",20); nodes.add(n1);
		Node n2 = new Router("B","1F1F1F");	         nodes.add(n2);
		Node n3 = new Switch("C","11001BBB2");	     nodes.add(n3);
		Node n4 = new Router("A","11FC3564A");	     nodes.add(n4);
		Node n5 = new Computer("B","32D665DE41",21); nodes.add(n5);
		Node n6 = new Switch("C","114E00C");	     nodes.add(n6);
		
		Network network = new Network(nodes);
		System.out.println(network);
	}

}
