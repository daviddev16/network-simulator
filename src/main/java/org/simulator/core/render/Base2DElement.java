package org.simulator.core.render;

import java.awt.Graphics2D;
import java.util.Objects;

import org.simulator.core.essential.Behaviour;

public abstract class Base2DElement implements Behaviour {

	private int x, y, width, height;
	private Renderer renderer;
	
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
		if (renderer != null)
			renderer.draw(g2d);
	}

	public Renderer getRenderer() {
		return this.renderer;
	}
	
	public void setRenderer(Renderer renderer) {
		this.renderer = Objects.requireNonNull(renderer, "Renderer cannot be null.");
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
	
}
