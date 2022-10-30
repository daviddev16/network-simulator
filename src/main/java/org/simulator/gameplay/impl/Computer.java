package org.simulator.gameplay.impl;

import java.awt.Graphics2D;
import java.awt.Image;
import org.simulator.core.render.Base2DElement;
import org.simulator.core.render.Renderer;
import org.simulator.core.resource.SpriteManager;

public class Computer extends BaseNetworkDevice implements Renderer {

	public Computer(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	Image image = null;
	@Override
	public void onStart() {
		setRenderer(this);
		image = SpriteManager.getSprite("router-s1-disabled");
		/* blinking test */
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while(true) {
						image = SpriteManager.getSprite("router-s1-enabled");
						Thread.sleep(1000/2);
						image = SpriteManager.getSprite("router-s1-disabled");
						Thread.sleep(1000/2);
					}
				} catch (InterruptedException e) {
				}
			}
		}).start();

	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
	}

	@Override
	public Base2DElement getParent() {
		return this;
	}

}
