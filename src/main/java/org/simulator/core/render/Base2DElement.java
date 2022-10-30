package org.simulator.core.render;

import java.awt.Graphics2D;

import org.simulator.core.essential.Behaviour;

public abstract class Base2DElement implements Behaviour {

	private int x, y, width, height;
	
	public Base2DElement(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void tick() {}
	
	@Override
	public void onEnd() {}

	@Override
	public void onStart() {}
	
	@Override
	public void render(Graphics2D g2d) {
		if (getRenderer() != null)
			getRenderer().draw(g2d);
	}

	public abstract Renderer<?> getRenderer();
	
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
	
}
