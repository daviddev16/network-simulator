package org.simulator.gameplay;

import java.awt.Graphics2D;
import java.awt.Image;

import org.simulator.core.main.Mouse;
import org.simulator.core.render.Base2DElement;
import org.simulator.core.render.Renderer;
import org.simulator.core.resource.SpriteManager;

public class UIElement extends Base2DElement implements Renderer {

	public UIElement(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	@Override
	public void onStart() {
		setRenderer(this);

	}


	@Override
	public void draw(Graphics2D g2d) {
		g2d.drawString("Ola!", getX(), getY());
	}


	@Override
	public Base2DElement getParent() {
		return this;
	}
	
	
}
