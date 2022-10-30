package org.simulator.core.util;

import java.util.Random;

public class Utility {

	public static String generateRandomMACAddress() {
		Random random = new Random();
		StringBuilder macAddress = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			macAddress.append('-').append(Integer.toHexString(random.nextInt() * 16).substring(0, 2));
		}		
		return macAddress.substring(1).toUpperCase();
	}
	
}
