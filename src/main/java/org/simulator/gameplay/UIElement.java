package org.simulator.gameplay;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import org.simulator.core.main.Engine;
import org.simulator.core.render.Base2DElement;
import org.simulator.core.render.Renderer;
import org.simulator.core.render.layering.Layer;
import org.simulator.core.render.layering.LayerManager;

public class UIElement extends Base2DElement {

	public UIElement(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	@Override
	public void onStart() {}

	/*TODO:*/
	public static final Font ARIAL = new Font("Segoe UI", Font.TRUETYPE_FONT, 10);

	@Override
	public Renderer<UIElement> getRenderer() {
		return new Renderer<UIElement>() {
			public UIElement getParent() {
				return UIElement.this;
			}
			@Override
			public void draw(Graphics2D g2d) {
				g2d.setFont(ARIAL);
				g2d.setColor(Color.white);
				Layer deviceLayer =  LayerManager.getLayerManager().getLayerByType(DevicesLayer.class);

				int c = 0;
				for(String line : deviceLayer.toString().split("\n")) {
					g2d.drawString(line, getX(), getY()+c);
					c+=12;
				}
			}
		};
	}


}
