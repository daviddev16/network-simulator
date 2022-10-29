package org.simulator.core.render;

import java.awt.Graphics2D;

import org.simulator.core.Base2DElement;


/* parent cannot be null */
public interface Renderer {

	public void drawOn(Graphics2D g2d);
	
	public void setParent(Base2DElement element);
	
	public Base2DElement getParent();
	
}
