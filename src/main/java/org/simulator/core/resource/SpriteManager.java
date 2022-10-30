package org.simulator.core.resource;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.management.InstanceAlreadyExistsException;

public final class SpriteManager {

	private static SpriteManager instance;

	private Map<String, Image> spriteMapper;

	public SpriteManager() throws InstanceAlreadyExistsException {

		if (instance != null)
			throw new InstanceAlreadyExistsException();

		spriteMapper = new HashMap<>();
		instance = this;

	}

	public void scan(File directory) throws IllegalAccessException, IOException {
		Objects.requireNonNull(directory, "Directory cannot be null.");
		
		if (!directory.exists() || !directory.canRead())
			throw new IllegalAccessException();
		
		for (File file : directory.listFiles()) {
			if (file.isFile()) {
				Image image = getFileAsImage(file);
				String name = file.getName().substring(0, file.getName().lastIndexOf('.'));
				getSpriteMapper().putIfAbsent(name, image);
				continue;
			}
			scan(file);
		}
		
	}
	
	public static Image getSprite(String name) {
		return getSpriteManager().getSpriteMapper().getOrDefault(name, null);
	}
	
	private Image getFileAsImage(File file) throws IOException {
		return ImageIO.read(file);
	}

	public static SpriteManager getSpriteManager() {
		return instance;
	}

	public Map<String, Image> getSpriteMapper() {
		return spriteMapper;
	}




}
