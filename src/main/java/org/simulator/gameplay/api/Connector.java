package org.simulator.gameplay.api;

import org.simulator.gameplay.ConnectorType;

public interface Connector<E> {

	public E getParent();
	
	public ConnectorType getType();
	
	public long getId();

}
