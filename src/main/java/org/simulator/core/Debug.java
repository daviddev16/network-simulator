package org.simulator.core;

import java.awt.Color;
import java.awt.Graphics2D;

import org.simulator.core.main.Engine;
import org.simulator.core.render.Base2DElement;

public final class Debug {

	public static void to(Base2DElement element, Graphics2D g2d) {
		if(element != null && g2d != null && Engine.getEngine().isDebugMode()) {
			g2d.setColor(Color.MAGENTA);
			g2d.drawRect(element.getX(), element.getY(), element.getWidth(), element.getHeight());
		}
	}

}
