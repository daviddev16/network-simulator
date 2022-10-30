package org.simulator.gameplay.interfaces;

import java.util.Set;

import org.simulator.gameplay.api.Connector;
import org.simulator.gameplay.api.NetworkInterface;

public class GenericComputerNetworkInterface implements NetworkInterface {

	private String macAddress;
	private Set<Connector<NetworkInterface>> connectors;
	
	public GenericComputerNetworkInterface(String macAddress) {
		this.macAddress = macAddress;
	}
	
	@Override
	public String getMacAddress() {
		return this.macAddress;
	}

	@Override
	public Set<Connector<NetworkInterface>> getConnectors() {
		return connectors;
	}

}
