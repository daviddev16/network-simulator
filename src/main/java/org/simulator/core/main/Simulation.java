package org.simulator.core.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import org.simulator.core.enums.SimulationState;
import org.simulator.core.exception.EngineException;

public class Simulation extends Canvas implements Runnable {

	private static final long serialVersionUID = 3562214532860259471L;

	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;

	private SimulationState currentState = SimulationState.STOPPED;
	private Thread simulationThread;
	private JFrame window;

	public Simulation(final String title) throws EngineException {
		
		if (Engine.getEngine() == null)
			new Engine();

		initializeWindow(title);
		initializeDefaults();
		initializeThread();
	}

	public void start() {
		if (simulationThread != null && simulationThread.isAlive())
			throw new RuntimeException("Simulation already started.");

		changeSimulationState(SimulationState.RUNNING);
		Engine.getEngine().onStart();
		simulationThread.start();
		window.setVisible(true);
	}

	public void stop() {
		if (simulationThread != null && !simulationThread.isAlive())
			throw new RuntimeException("Simulation already stopped.");

		changeSimulationState(SimulationState.STOPPED);
		Engine.getEngine().onEnd();
		simulationThread.interrupt();
		window.dispose();
	}

	public void changeSimulationState(SimulationState newState) {
		if (currentState != newState)
			currentState = newState;
	}

	@Override
	public void run() {
		try {
			while (currentState != SimulationState.STOPPED) {
				Engine.getEngine().tick();
				repaint();
				Thread.sleep(1000/60);
			}
		}
		catch(InterruptedException e) { /* ignore */ }
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		BufferStrategy strategy = getBufferStrategy();

		if (strategy == null)
			createBufferStrategy(3);

		Graphics2D g2d = (Graphics2D) g;
		g2d.clearRect(0, 0, WIDTH, HEIGHT);
		Engine.getEngine().render(g2d);
		g2d.dispose();
	}

	private void initializeDefaults() {
		setBackground(Color.black);
		setSize(new Dimension(WIDTH, HEIGHT));
		setMaximumSize(new Dimension(WIDTH, HEIGHT));
	}

	private void initializeWindow(String title) {
		window = new JFrame(title);
		window.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				stop();
			}
		});
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(new Dimension(WIDTH, HEIGHT));
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.add(this);
	}

	private void initializeThread() {
		simulationThread = new Thread(this);
	}

	public SimulationState getState() {
		return currentState;
	}

	public JFrame getWindow() {
		return window;
	}


	public Thread getThread() {
		return simulationThread;
	}

}
