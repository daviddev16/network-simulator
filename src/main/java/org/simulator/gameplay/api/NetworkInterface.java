package org.simulator.gameplay.api;

import java.util.Set;

public interface NetworkInterface {

	public String getMacAddress();
	
	public Set<Connector<NetworkInterface>> getConnectors();
	
}
