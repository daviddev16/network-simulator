package org.simulator.core.main;

import org.simulator.core.render.layering.LayerManager;
import org.simulator.gameplay.DevicesLayer;
import org.simulator.gameplay.impl.Computer;

public class Gameplay {
	
	private static final LayerManager LAYERS = LayerManager.getLayerManager();
	
	Gameplay() {}
	
	public void onStart() {

		DevicesLayer devicesLayer = new DevicesLayer();

		devicesLayer.insert(new Computer(20, 20, 20, 20));
		
		LAYERS.insert(devicesLayer);
	
	}
	
	public void onEnd() {
		System.out.println("gaming ending");
	}
	
}
