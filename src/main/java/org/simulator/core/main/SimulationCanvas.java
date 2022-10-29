package org.simulator.core.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

public class SimulationCanvas extends Canvas {

	private static final long serialVersionUID = 6437822946588614518L;
	
	public SimulationCanvas(int width, int height) {
		super();
		setSize(new Dimension(width, height));
		setBackground(Color.black);
	}
	
}
