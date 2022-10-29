package org.simulator.core;

import java.awt.Graphics2D;

import org.simulator.core.exception.EngineException;
import org.simulator.core.render.Renderer;

public abstract class Base2DElement implements Behaviour{

	private int x, y, width, height;
	private Renderer renderer;
	
	public Base2DElement(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Base2DElement(int objectId) {
		this(0, 0, 16, 16);
	}
	
	@Override
	public void render(Graphics2D g2d) {
		if (renderer != null)
			renderer.drawOn(g2d);
	}

	public Renderer getRenderer() {
		return this.renderer;
	}
	
	public void setRenderer(Renderer renderer) throws EngineException {
		if (renderer == null)
			throw new EngineException("Invalid renderer.");
			
		renderer.setParent(this);
		this.renderer = renderer;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	@Override
	public void tick() {}
	
	@Override
	public void onEnd() {}

	@Override
	public void onStart() {}

}
