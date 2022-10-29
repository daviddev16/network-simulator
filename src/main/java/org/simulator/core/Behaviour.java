package org.simulator.core;

import java.awt.Graphics2D;

public interface Behaviour {
	
	public void tick();
	
	public void render(Graphics2D g2d);
	
	public void onStart();
	
	public void onEnd();
	
}
