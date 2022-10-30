package org.simulator.gameplay.impl;

import java.awt.Graphics2D;
import java.awt.Image;

import org.simulator.core.main.Mouse;
import org.simulator.core.render.Base2DElement;
import org.simulator.core.render.Renderer;
import org.simulator.core.resource.SpriteManager;

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
		Image image = SpriteManager.getSprite("router-s1");
		
		if (Math.abs(Mouse.mouseX - getX()) <= 6 && Math.abs(Mouse.mouseX - getX()) <= 6) {
			System.out.println("perto");
		}
		
		g2d.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
	}

	@Override
	public Base2DElement getParent() {
		return this;
	}

}
