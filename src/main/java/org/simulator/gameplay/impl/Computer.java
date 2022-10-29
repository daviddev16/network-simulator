package org.simulator.gameplay.impl;

import java.awt.Color;
import java.awt.Graphics2D;

import org.simulator.core.render.Base2DElement;
import org.simulator.core.render.Renderer;

public class Computer extends BaseNetworkDevice implements Renderer {

	public Computer(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void onStart() {
		System.out.println("co");
		setRenderer(this);
	}

	@Override
	public void draw(Graphics2D g2d) {
		System.out.println("oao");
		g2d.setColor(Color.red);
		g2d.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	@Override
	public Base2DElement getParent() {
		return this;
	}

}
