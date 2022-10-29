package org.simulator.core.render;

import java.awt.Graphics2D;


/* parent cannot be null */
public interface Renderer {

	public void draw(Graphics2D g2d);
	
	public Base2DElement getParent();
	
}
