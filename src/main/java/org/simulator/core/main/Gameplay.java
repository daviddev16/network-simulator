package org.simulator.core.main;

import org.simulator.core.render.layering.LayerManager;
import org.simulator.gameplay.DevicesLayer;
import org.simulator.gameplay.UIElement;
import org.simulator.gameplay.UILayer;
import org.simulator.gameplay.impl.Computer;

/* gameplay workflow here */
public class Gameplay {
	
	private static final LayerManager LAYERS = LayerManager.getLayerManager();
	
	Gameplay() {}
	
	public void onStart() {
		
		DevicesLayer devicesLayer = new DevicesLayer();
		UILayer uiLayer = new UILayer();
		uiLayer.insert(new UIElement(100, 100, 100, 100));
		
		
		Computer computer = new Computer(20, 20, 20, 20);
		computer.setName("Device#1");
		devicesLayer.insert(computer);
		
		LAYERS.insert(uiLayer);
		LAYERS.insert(devicesLayer);
	
		setupDefaultLayers();
	}
	
	
	public void setupDefaultLayers() {
		
	}
	
	public void onEnd() {
		System.out.println("gaming ending");
	}
	
}
