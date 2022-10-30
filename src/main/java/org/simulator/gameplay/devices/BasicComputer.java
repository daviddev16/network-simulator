package org.simulator.gameplay.devices;

import org.simulator.core.render.Renderer;
import org.simulator.gameplay.impl.BaseNetworkDevice;
import org.simulator.gameplay.renderer.BasicComputerRenderer;

public class BasicComputer extends BaseNetworkDevice {

	public BasicComputer(int x, int y) {
		super(x, y, 13, 15);
	}

	@Override
	public Renderer<BasicComputer> getRenderer() {
		return new BasicComputerRenderer(this);
	}
	
}
