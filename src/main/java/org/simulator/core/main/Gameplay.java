package org.simulator.core.main;

import org.simulator.core.render.layering.LayerManager;
import org.simulator.core.util.Utility;
import org.simulator.gameplay.DevicesLayer;
import org.simulator.gameplay.UIElement;
import org.simulator.gameplay.UILayer;
import org.simulator.gameplay.devices.BasicComputer;
import org.simulator.gameplay.interfaces.GenericComputerNetworkInterface;

/* gameplay workflow here */
public class Gameplay {

	private static final LayerManager LAYERS = LayerManager.getLayerManager();

	Gameplay() {}

	public void onStart() {

		DevicesLayer devicesLayer = new DevicesLayer();
		UILayer uiLayer = new UILayer();
		uiLayer.insert(new UIElement(20,100, SimulationWindow.WIDTH, SimulationWindow.HEIGHT)); /* devices */

		BasicComputer computer = new BasicComputer(100, 100);
		computer.getNetworkInterfaces().add(new GenericComputerNetworkInterface(Utility.generateRandomMACAddress()));
		computer.setName("Device#" +100);
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
