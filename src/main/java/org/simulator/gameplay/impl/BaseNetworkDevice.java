package org.simulator.gameplay.impl;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import org.simulator.gameplay.api.NetworkDevice;
import org.simulator.gameplay.api.NetworkInterface;

public abstract class BaseNetworkDevice extends BaseDevice implements NetworkDevice {

	private Set<NetworkInterface> networkInterfaces;
	
	private long id;
	private String name;

	public BaseNetworkDevice(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.networkInterfaces = new LinkedHashSet<>();
		this.name = "BaseNetworkDevice";
		this.id = -1;
	}
	
	@Override
	public Set<NetworkInterface> getNetworkInterfaces() {
		return networkInterfaces;
	}
	
	@Override
	public void setName(String name) {
		this.name = Objects.requireNonNull(name, "Name cannot be null");
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public long getId() {
		return id;
	}

}
