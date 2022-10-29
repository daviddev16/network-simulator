package org.simulator.gameplay.api;

public interface Hardware {

	public String getName();
	
	public void setName(String name);
	
	/* should be unique tho */
	public long getId();
	
}
