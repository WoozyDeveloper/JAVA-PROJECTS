package com.adionofrei.l3h; /**
 * 
 * @author Onofrei Adrian-Mihai 2E3
 *
 */

import java.util.*;

public class Network {
	private List<Node> nodes = new ArrayList<Node>();
	private List<Node> identifiableObject = new ArrayList<Node>();

	public Node searchNode(String name){
		for(Node node : nodes)
			if(node.getName() == name)
				return node;
		return null;
	}

	public void dijkstra(String name){
		Node start = searchNode(name);
		if(start!=null){
			start.setDistance(0);
			PriorityQueue<Node> queue = new PriorityQueue<>();
			queue.add(start);

			while(!queue.isEmpty()){
				Node node = queue.poll();
				for(Map.Entry<Node, Integer> node2 : node.getCost().entrySet()){
					int distance = node.getDistance() + node2.getValue();
					if(distance < node2.getKey().getDistance()){
						node2.getKey().setDistance(distance);
						queue.add(node2.getKey());
					}
				}
			}
			System.out.print("Dist = ");
			for(Node node : nodes) {
				if(node instanceof Switch)
					System.out.print("SWITCH ");
				else
					System.out.print(node.getDistance() + " ");
			}
		}
	}

	@Override
	public String toString() {
		Collections.sort(nodes);
		return "Network [nodes=" + nodes + "]";
	}

	public void sortByAdress(){
		Collections.sort(identifiableObject, new Comparator<Node>(){
			@Override
			public int compare(Node n1, Node n2){
				return ((Identifiable)n1).getAddress().compareTo(((Identifiable)n2).getAddress());
			}
		});
	}

	public void printNetworkSortedByAdress(){
		sortByAdress();
		for(Node n : identifiableObject)
			System.out.print(n.getName() + "(" + n.getClass().getSimpleName() + ") -" + ((Identifiable)n).getAddress() + "\n");
		System.out.println();
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public void findIdentifiableNodes() {
		for(Node node : nodes)
			if(node instanceof Router || node instanceof Computer) {
				identifiableObject.add(node);
		}
	}

	public void setIndexes(List<Node> nodes){
		int ind = 0;
		for(Node node : nodes){
			node.setIndex(ind++);
		}
	}

	public Network(List<Node> nodes){
		this.nodes = nodes;

		findIdentifiableNodes();
		setIndexes(nodes);
	}
}