package org.simulator.core.main;

import java.awt.Graphics2D;

import org.simulator.core.essential.Behaviour;
import org.simulator.core.exception.SingletonException;
import org.simulator.core.render.layering.Layer;
import org.simulator.core.render.layering.LayerManager;

public final class Engine implements Behaviour {

	private static Engine instance;
	
	private final LayerManager layerManager;
	private Gameplay gameplayManager;
	
	public Engine() throws SingletonException {

		if(instance != null)
			throw new SingletonException(Engine.class);

		layerManager = new LayerManager();
		instance = this;
	}

	@Override
	public void onStart() {
		System.out.println("Loading gameplay manager and starting game...");
		gameplayManager = new Gameplay();
		gameplayManager.onStart();
		for (Layer layer : layerManager.getLayers()) {
			layer.onStart();
		}
	}
	
	@Override
	public void onEnd() {
		for (Layer layer : layerManager.getLayers()) {
			layer.onEnd();
		}
		gameplayManager.onEnd();
	}

	@Override
	public void render(Graphics2D g2d) {
		for (Layer layer : layerManager.getLayers()) {
			layer.render(g2d);
		}
	}
	
	public void tick() {
		for (Layer layer : layerManager.getLayers()) {
			layer.tick();
		}
	}
	
	public LayerManager gerLayerManager() {
		return layerManager;
	}

	public static Engine getEngine() {
		return instance;
	}
	
	
	public Gameplay getGameplayManager() {
		return gameplayManager;
	}
	
}
