package org.simulator;


import javax.management.InstanceAlreadyExistsException;

import org.simulator.core.exception.EngineException;
import org.simulator.core.exception.SingletonException;
import org.simulator.core.main.Engine;

public class Launcher {

	public static void main(String[] args) throws EngineException, InstanceAlreadyExistsException, SingletonException {
		new Engine("Network Simulator").start();
	}
	
}
