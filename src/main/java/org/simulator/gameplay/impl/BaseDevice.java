package org.simulator.gameplay.impl;


import org.simulator.core.render.Base2DElement;
import org.simulator.gameplay.api.Hardware;

public abstract class BaseDevice extends Base2DElement implements Hardware {

	public BaseDevice(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

}
