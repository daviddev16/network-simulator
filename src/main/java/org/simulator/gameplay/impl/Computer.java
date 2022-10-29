package org.simulator.gameplay.impl;

import java.awt.Graphics2D;

import org.simulator.core.Base2DElement;
import org.simulator.core.render.Renderer;

public class Computer extends BaseNetworkDevice {

	public Computer(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	@Override
	public void onStart() {

		Renderer renderer = new Renderer() {
			
			@Override
			public void setParent(Base2DElement element) {

			}
			
			@Override
			public Base2DElement getParent() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void draw(Graphics2D g2d) {
				// TODO Auto-generated method stub
				
			}
		};
	
	}

}
