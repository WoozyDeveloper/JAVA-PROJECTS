package com.adionofrei.l3h; /**
 * 
 * @author Onofrei Adrian-Mihai 2E3
 *
 */

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
			List<Node> nodes = new ArrayList<Node>();

			/**
			 * Create the nodes and add them
			 */
			Node n1 = new Computer("1","1FF2232F13",20); nodes.add(n1);
			Node n2 = new Router("2","1F1F1F");	         	 nodes.add(n2);
			Node n3 = new Switch("3","11001BBB2");	     		 nodes.add(n3);
			Node n4 = new Router("4","11FC3564A");	     		 nodes.add(n4);
			Node n5 = new Computer("5","32D665DE41",21); nodes.add(n5);
			Node n6 = new Switch("6","114E00C");	     		 nodes.add(n6);


			n1.setCost(n2,10);
			n1.setCost(n3,50);

			n2.setCost(n1,40);
			n2.setCost(n3,20);
			n2.setCost(n4,20);

			n3.setCost(n1,50);
			n3.setCost(n2,20);
			n3.setCost(n4,10);

			n4.setCost(n2,20);
			n4.setCost(n3,10);
			n4.setCost(n5,30);
			n4.setCost(n6,10);

			n5.setCost(n2,20);
			n5.setCost(n5,30);
			n5.setCost(n6,20);

			n6.setCost(n2,20);
			n6.setCost(n4,10);

			Network network = new Network(nodes);
			System.out.println(network);
			network.printNetworkSortedByAdress();

			network.dijkstra(n1.getName());
		}

}
