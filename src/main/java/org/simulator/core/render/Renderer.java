package org.simulator.core.render;

import java.awt.Graphics2D;

/* parent cannot be null */
public interface Renderer<E extends Base2DElement> {

	public void draw(Graphics2D g2d);
	
	public E getParent();
	
}
