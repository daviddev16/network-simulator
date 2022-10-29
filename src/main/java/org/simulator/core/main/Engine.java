package org.simulator.core.main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.Random;

import org.simulator.core.enums.SimulationState;
import org.simulator.core.essential.Behaviour;
import org.simulator.core.exception.SingletonException;
import org.simulator.core.render.layering.Layer;
import org.simulator.core.render.layering.LayerManager;

public final class Engine implements Runnable {

	public static final Random RANDOM = new Random();

	private static Engine instance;
	
	private SimulationWindow window;
	
	private Thread thread;
	
	private SimulationState currentState = SimulationState.STOPPED;
	
	private final LayerManager layerManager;
	private Gameplay gameplayManager;
	
	public Engine(String title) throws SingletonException {

		if(instance != null)
			throw new SingletonException(Engine.class);

		thread = new Thread();
		window = new SimulationWindow(title);
		window.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				stop();
			}
		});
		layerManager = new LayerManager();
		instance = this;
	}
	
	private void render() {
		BufferStrategy strategy = window.getCanvas().getBufferStrategy();
		if (strategy == null) {
			 window.getCanvas().createBufferStrategy(3);
			return; 
		}
		Graphics2D g2d = (Graphics2D) strategy.getDrawGraphics();
		g2d.setColor(new Color(0, 0, 0));
		g2d.fillRect(0, 0, SimulationWindow.WIDTH, SimulationWindow.HEIGHT);
		renderLayers(g2d);
		strategy.show();
	}
	
	private void tick() {
		for (Layer layer : layerManager.getLayers()) {
			layer.tick();
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;    
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();
		window.requestFocus();
		while(currentState != SimulationState.STOPPED) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			if(delta >= 1) {
				Engine.getEngine().tick();
				render();
				frames++;
				delta--;
			}
			if(System.currentTimeMillis() - timer >= 1000) {
				System.out.println("Fps: " + frames);
				frames = 0;
				timer += 1000;
			}
		}
	}
	
	public void start() {
		if (thread != null && thread.isAlive())
			throw new RuntimeException("Simulation already started.");

		changeSimulationState(SimulationState.RUNNING);
		onStart();
		thread.start();
		window.setVisible(true);
	}

	public void stop() {
		if (thread != null && !thread.isAlive())
			throw new RuntimeException("Simulation already stopped.");

		changeSimulationState(SimulationState.STOPPED);
		onEnd();
		thread.interrupt();
		window.dispose();
	}
	
	public void onEnd() {
		for (Layer layer : layerManager.getLayers()) {
			layer.onEnd();
		}
		gameplayManager.onEnd();
	}
	
	public void onStart() {
		System.out.println("Loading gameplay manager and starting game...");
		gameplayManager = new Gameplay();
		gameplayManager.onStart();
		for (Layer layer : layerManager.getLayers()) {
			layer.onStart();
		}
	}
	
	public void changeSimulationState(SimulationState newState) {
		if (currentState != newState)
			currentState = newState;
	}
	
	public void renderLayers(Graphics2D g2d) {
		for (Layer layer : layerManager.getLayers()) {
			layer.render(g2d);
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
