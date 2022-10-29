package org.simulator.gameplay.impl;

import java.util.Set;

import org.simulator.core.Base2DElement;
import org.simulator.gameplay.api.device.IDevice;
import org.simulator.gameplay.api.networking.INetworkInterface;

public class ComputerEntity extends Base2DElement implements IDevice {

	private String name;
	private long computerId;
	
	public ComputerEntity(int computerId) {
		super(objectId);
	}

	public String getName() {
		return null;
	}

	@Override
	public Set<INetworkInterface> getNetworkInterfaces() {
		return null;
	}
	
	

}
