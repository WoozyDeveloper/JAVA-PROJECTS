package com.adionofrei.l3h;

/**
 * 
 * @author Onofrei Adrian-Mihai 2E3
 *
 */
public interface Storage {
	int getStorageCapacity();

	default int convertMB(int gb){
		return 1024 * gb;
	}

	default int convertKB(int gb){
		return 1024 * 1024 * gb;
	}

	default int convertBYTE(int gb){
		return 1024 * 1024 * 1024 * gb;
	}
}
