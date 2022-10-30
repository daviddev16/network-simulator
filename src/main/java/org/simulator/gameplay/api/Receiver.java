package org.simulator.gameplay.api;

public interface Receiver<E> {

	public void receive(E data);
	
}
