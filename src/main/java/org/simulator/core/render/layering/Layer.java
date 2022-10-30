package org.simulator.core.render.layering;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.simulator.core.essential.Behaviour;
import org.simulator.core.render.Base2DElement;
import org.simulator.gameplay.impl.BaseDevice;
import org.simulator.gameplay.impl.BaseNetworkDevice;

public abstract class Layer implements Comparable<Layer>, Behaviour {

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

	@Override
	public void onStart() {
		for (Base2DElement element : elements) {
			element.onStart();
		}
	}

	@Override
	public void onEnd() {
		for (Base2DElement element : elements) {
			element.onEnd();
		}
	}

	@Override
	public void tick() {
		for (Base2DElement element : elements) {
			element.tick();
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

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (Base2DElement element : elements) {
			if (element instanceof BaseNetworkDevice) {
				String name = "";
				buffer.append( ((BaseNetworkDevice)element).getName() + " ");
				if(!((BaseNetworkDevice)element).getNetworkInterfaces().isEmpty()) {
					((BaseNetworkDevice)element).getNetworkInterfaces().forEach(e -> buffer.append("-> " + e.getMacAddress() + " "));
				}
				buffer.append("\n");
			}
		}
		return buffer.toString();
	}

}
