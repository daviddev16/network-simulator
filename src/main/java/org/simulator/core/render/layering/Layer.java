package org.simulator.core.render.layering;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.simulator.core.Base2DElement;

public abstract class Layer implements Comparable<Layer> {
	
	private final int order;

	private List<Base2DElement> elements;
	
	public Layer(int order) {
		this.order = order;
		this.elements = new ArrayList<>();
	}
	
	public void render(Graphics2D g2d) {
		for (Base2DElement element : elements) {
			element.render(g2d);
		}
	}

	public void insert(Base2DElement element) {
		elements.add(Objects.requireNonNull(element));
	}
 	
	public int compareTo(Layer layer) {
		return Integer.compare(order, layer.order);
	}
	
	public int getOrder() {
		return order;
	}
	
}
