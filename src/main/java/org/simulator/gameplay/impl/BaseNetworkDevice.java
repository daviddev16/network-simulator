package org.simulator.gameplay.impl;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import org.simulator.gameplay.api.NetworkDevice;
import org.simulator.gameplay.api.NetworkInterface;

import static org.simulator.core.main.Engine.RANDOM;

public abstract class BaseNetworkDevice extends BaseDevice implements NetworkDevice {

	private long id;
	private String name;
	private Set<NetworkInterface> networkInterfaces;
	
	public BaseNetworkDevice(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.networkInterfaces = new LinkedHashSet<>();
		this.name = "BaseNetworkDevice (" + RANDOM.nextInt() * 1024 + ")" ;
		this.id = -1;
	}
	
	@Override
	public void setName(String name) {
		this.name = Objects.requireNonNull(name, "Name cannot be null");
	}
	
	@Override
	public Set<NetworkInterface> getNetworkInterfaces() {
		return networkInterfaces;
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
