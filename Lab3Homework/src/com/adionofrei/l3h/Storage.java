package com.adionofrei.l3h;

/**
 * 
 * @author Onofrei Adrian-Mihai 2E3
 *
 */
public interface Storage {
	int getStorageCapacity();

	default int convertMB(){
		return 1024 * this.getStorageCapacity();
	}

	default int convertKB(){
		return 1024 * 1024 * this.getStorageCapacity();
	}

	default int convertBYTE(){
		return 1024 * 1024 * 1024 * this.getStorageCapacity();
	}
}
