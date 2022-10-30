package org.simulator.core.render.layering;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.management.InstanceAlreadyExistsException;


public class LayerManager {

	private static LayerManager instance;
	
	private final Set<Layer> layers;

	public LayerManager() throws InstanceAlreadyExistsException {

		if (instance != null)
			throw new InstanceAlreadyExistsException();

		layers = Collections.synchronizedSet(new LinkedHashSet<Layer>());
		instance = this;

	}

	public Layer getLayerByType(Class<? extends Layer> layerClass) {
		for (Layer layer : getLayers()) {
			if(layer.getClass().isAssignableFrom(layerClass)) {
				return layer;
			}
		}
		return null;
	}
	
	public static LayerManager getLayerManager() {
		return instance;
	}
	
	public void remove(Layer layer) {
		if (layers.contains(layer))
			layers.remove(layer);
	}

	public void insert(Layer layer) {
		if(!layers.contains(layer))
			layers.add(layer);
	}

	public Set<Layer> getLayers() {
		return layers;
	}

}
