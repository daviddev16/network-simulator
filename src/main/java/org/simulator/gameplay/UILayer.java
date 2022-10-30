package org.simulator.gameplay;

import org.simulator.core.annotation.StaticLayer;
import org.simulator.core.render.layering.Layer;

@StaticLayer
public class UILayer extends Layer {

	public UILayer() {
		super(Ordering.UI);
	}

}
