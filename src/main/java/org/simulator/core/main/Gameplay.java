package org.simulator.core.main;

import org.simulator.core.render.layering.LayerManager;
import org.simulator.gameplay.DevicesLayer;
import org.simulator.gameplay.UIElement;
import org.simulator.gameplay.UILayer;
import org.simulator.gameplay.devices.BasicComputer;

/* gameplay workflow here */
public class Gameplay {

	private static final LayerManager LAYERS = LayerManager.getLayerManager();

	Gameplay() {}

	public void onStart() {

		DevicesLayer devicesLayer = new DevicesLayer();
		UILayer uiLayer = new UILayer();
		uiLayer.insert(new UIElement(20,100, SimulationWindow.WIDTH, SimulationWindow.HEIGHT)); /* devices */

		for (int i = 0; i < 50; i++) {
			BasicComputer computer = new BasicComputer((int)(20+i*10), (int)(20+i*10));
			computer.setName("Device#" +i);
			devicesLayer.insert(computer);
		}		
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
