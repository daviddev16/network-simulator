package org.simulator.core.render.layering;

import java.awt.Graphics2D;

public abstract class Layer implements Comparable<Layer> {
	
	private final int order;

	public Layer(int order) {
		this.order = order;
	}
	
	public abstract void render(Graphics2D g2d);

	public int compareTo(Layer layer) {
		return Integer.compare(order, layer.order);
	}
	
	public int getOrder() {
		return order;
	}
	
}
