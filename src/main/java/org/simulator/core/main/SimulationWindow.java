package org.simulator.core.main;

import java.awt.Dimension;

import javax.swing.JFrame;


public class SimulationWindow extends JFrame {

	private static final long serialVersionUID = 3562214532860259471L;
	
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	
	private SimulationCanvas canvas;
	
	public SimulationWindow(final String title) {
		canvas = new SimulationCanvas(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(WIDTH, HEIGHT));
		setLocationRelativeTo(null);
		setResizable(false);
		add(canvas);
		pack();
	}
	
	public SimulationCanvas getCanvas() {
		return canvas;
	}
}
