package org.simulator.core;

import java.awt.Graphics2D;

import org.simulator.core.exception.SingletonException;
import org.simulator.core.render.layering.Layer;
import org.simulator.core.render.layering.LayerManager;

public final class Engine {

	private static Engine instance;

	private final LayerManager layerManager;
	
	public Engine() throws SingletonException {

		if(instance != null)
			throw new SingletonException(Engine.class);

		layerManager = new LayerManager();
		instance = this;
	}
	
	public LayerManager gerLayerManager() {
		return layerManager;
	}

	public static Engine getEngine() {
		return instance;
	}
	
	public void render(Graphics2D g2d) {
		for (Layer layer : layerManager.getLayers()) {
			layer.render(g2d);
		}
	}
	
	public void onStart() {
		
	}
	
	public void onStop() {
		
	}
	
	public void tick() {
		System.out.println("ticking");
	}
	
}
