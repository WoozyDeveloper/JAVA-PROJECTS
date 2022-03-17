package com.adionofrei.l3h;

/**
 * 
 * @author Onofrei Adrian-Mihai 2E3
 *
 */

public class Router extends Node implements Identifiable {
	private String address;

	@Override
	public String toString() {
		return "Router [name=" + name + ", address=" + address + "]";
	}
	
	public Router(String name, String address) {
		super(name);
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}
	
	
}
