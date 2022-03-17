package com.adionofrei.l3h;

/**
 * 
 * @author Onofrei Adrian-Mihai 2E3
 *
 */


public class Computer extends Node implements Identifiable, Storage {

	private String address;
	private int storageCapacity;

	@Override
	public String toString() {
		return "Computer [name=" + name + ", adress=" + address + ", storage= " + storageCapacity + "]";
	}
	
	public Computer(String name, String address, int storage) {
		super(name);
		this.address = address;
		this.storageCapacity = storage;
		// TODO Auto-generated constructor stub
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStorageCapacity() {
		return storageCapacity;
	}

	public void setStorageCapacity(int storageCapacity) {
		this.storageCapacity = storageCapacity;
	}
}