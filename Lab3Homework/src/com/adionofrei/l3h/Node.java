package com.adionofrei.l3h; /**
 * 
 * @author Onofrei Adrian-Mihai 2E3
 *
 */

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public abstract class Node implements Comparable<Node>, Comparator<Node> {
	protected String name;
	private int index;
	private Map<Node, Integer> cost = new HashMap<>();
	private int dist = Integer.MAX_VALUE;

	public int getDistance(){
		return this.dist;
	}

	public void setDistance(int d){
		this.dist = d;
	}

	public void setIndex(int index){
		this.index = index;
	}

	public int getIndex(){
		return this.index;
	}

	@Override
	public String toString() {
		return "Node [name=" + name + "]";
	}

	@Override
	public int compareTo(Node other) {
		return this.name.compareTo(other.name);
	}

	@Override
	public int compare(Node node1, Node node2)
	{
		if (cost.get(node1) < cost.get(node2))
			return -1;
		if (cost.get(node1) > cost.get(node2))
			return 1;
		return 0;
	}

	public Node(String name) {
		super();
		this.name = name;
	}

	public void setCost(Node node, int cost){
		this.cost.put(node,cost);
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