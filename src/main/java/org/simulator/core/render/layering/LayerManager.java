package org.simulator.core.render.layering;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class LayerManager {

	private final Set<Layer> layers;

	public LayerManager() {
		layers = Collections.synchronizedSet(new LinkedHashSet<Layer>());
	}

	public void remove(Layer layer) {
		if (layers.contains(layer))
			layers.remove(layer);
	}

	public void insert(Layer layer) {
		if(layers.contains(layer))
			layers.add(layer);
	}

	public Set<Layer> getLayers() {
		return layers;
	}

}
