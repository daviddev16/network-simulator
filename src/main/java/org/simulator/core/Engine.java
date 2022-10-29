package org.simulator.core;

import java.awt.Color;
import java.awt.Graphics2D;

import org.simulator.core.exception.SingletonException;
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
		g2d.setColor(Color.RED);
		g2d.drawRect(20, 20, 10, 20);
	}
	
	public void tick() {}
	
}
