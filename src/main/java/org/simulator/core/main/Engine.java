package org.simulator.core.main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.management.InstanceAlreadyExistsException;

import org.simulator.core.annotation.StaticLayer;
import org.simulator.core.enums.SimulationState;
import org.simulator.core.exception.SingletonException;
import org.simulator.core.render.Colors;
import org.simulator.core.render.layering.Layer;
import org.simulator.core.render.layering.LayerManager;
import org.simulator.core.resource.SpriteManager;

public final class Engine implements Runnable {

	public static final Random RANDOM = new Random();

	private static Engine instance;
	
	private SimulationWindow window;
	
	private Thread thread;

	private boolean debugMode = false;
	
	private SimulationState currentState = SimulationState.STOPPED;
	
	private Gameplay gameplayManager;
	
	public Engine(String title) throws SingletonException, InstanceAlreadyExistsException {

		if(instance != null)
			throw new SingletonException(Engine.class);

		/* single instance stuff */
		new SpriteManager();
		new LayerManager();
		
		thread = new Thread(this);
		window = new SimulationWindow(title);
		window.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				stop();
			}
		});
		
		try {
			System.out.println("Scanning resource folders...");
			SpriteManager.getSpriteManager().scan(new File("resources"));
			System.out.println("Done");
		} catch (IllegalAccessException | IOException e1) {
			e1.printStackTrace();
		}
		
		instance = this;
	}
	
	private void render() {
		BufferStrategy strategy = window.getCanvas().getBufferStrategy();
		if (strategy == null) {
			 window.getCanvas().createBufferStrategy(3);
			return; 
		}
		Graphics2D g2d = (Graphics2D) strategy.getDrawGraphics();
		((Graphics2D)g2d).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Colors.DARKY);
		g2d.fillRect(0, 0, SimulationWindow.WIDTH, SimulationWindow.HEIGHT);
		g2d.scale(Mouse.wheel,Mouse.wheel);
		g2d.translate(Mouse.offsetX, Mouse.offsetY);
		g2d.setColor(Color.RED);
		//g2d.fillOval(Mouse.mouseX, Mouse.mouseY, 2,2);
		/*TODO: refactor*/
		for (Layer layer : LayerManager.getLayerManager().getLayers()) {
			if (!layer.getClass().isAnnotationPresent(StaticLayer.class)) 
				layer.render(g2d);
		}
		/* reset transformation */
		g2d.setTransform(new AffineTransform());
		for (Layer layer : LayerManager.getLayerManager().getLayers()) {
			if (layer.getClass().isAnnotationPresent(StaticLayer.class)) 
				layer.render(g2d);
		}
		strategy.show();
	}
	
	private void tick() {
		for (Layer layer : LayerManager.getLayerManager().getLayers()) {
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
		if (thread != null && thread.isInterrupted())
			throw new RuntimeException("Simulation already stopped.");

		changeSimulationState(SimulationState.STOPPED);
		onEnd();
		thread.interrupt();
		window.dispose();
	}
	
	public void onEnd() {
		for (Layer layer : LayerManager.getLayerManager().getLayers()) {
			layer.onEnd();
		}
		gameplayManager.onEnd();
	}
	
	public void onStart() {
		System.out.println("Loading gameplay manager and starting game...");
		gameplayManager = new Gameplay();
		gameplayManager.onStart();
		for (Layer layer : LayerManager.getLayerManager().getLayers()) {
			layer.onStart();
		}
	}
	
	public void changeSimulationState(SimulationState newState) {
		if (currentState != newState)
			currentState = newState;
	}
	
	public static Engine getEngine() {
		return instance;
	}
	
	
	public Gameplay getGameplayManager() {
		return gameplayManager;
	}

	public boolean isDebugMode() {
		return debugMode;
	}
	
}
