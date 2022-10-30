package org.simulator.gameplay.renderer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import org.simulator.core.Debug;
import org.simulator.core.render.Renderer;
import org.simulator.core.resource.SpriteManager;
import org.simulator.gameplay.devices.BasicComputer;

public class BasicComputerRenderer implements Renderer<BasicComputer> {

	private Image defaultImage;
	private BasicComputer computer;
	
	public BasicComputerRenderer(BasicComputer computer) {
		this.defaultImage = SpriteManager.getSprite("computer-c1");
		this.computer = computer;
	}
	
	public static final Font ARIAL = new Font("Segoe UI", Font.TRUETYPE_FONT, 5);
	
	@Override
	public void draw(Graphics2D g2d) {
		g2d.setFont(ARIAL);
		g2d.setColor(Color.white);
		g2d.drawString(getParent().getName(), getParent().getX(), getParent().getY() - 2);
		g2d.drawImage(defaultImage, getParent().getX(), getParent().getY(), null);
		Debug.to(computer, g2d);
	}

	@Override
	public BasicComputer getParent() {
		return computer;
	}

}
