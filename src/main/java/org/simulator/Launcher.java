package org.simulator;

import java.util.Random;

import org.simulator.core.Simulation;
import org.simulator.core.exception.EngineException;

public class Launcher {

	public static void main(String[] args) throws EngineException {
		
		Simulation simulation = new Simulation("Network Simulation");
		simulation.start();
		
		System.out.println(generateRandomMACAddress());
		
	}
	public static String generateRandomMACAddress() {
		Random random = new Random();
		StringBuilder macAddress = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			macAddress.append('-').append(Integer.toHexString(random.nextInt() * 16).substring(0, 2));
		}		
		return macAddress.substring(1).toUpperCase();
	}
	
}