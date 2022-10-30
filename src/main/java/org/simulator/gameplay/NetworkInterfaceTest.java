package org.simulator.gameplay;

import java.util.HashSet;
import java.util.Set;

import org.simulator.core.util.Utility;
import org.simulator.gameplay.api.Connector;
import org.simulator.gameplay.api.NetworkInterface;

public class NetworkInterfaceTest implements NetworkInterface {

	@Override
	public String getMacAddress() {
		return Utility.generateRandomMACAddress();
	}

	@Override
	public Set<Connector<NetworkInterface>> getConnectors() {
		return new HashSet<>();
	}

}
