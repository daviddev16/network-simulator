package org.simulator.core.exception;

import javax.management.InstanceAlreadyExistsException;

public class SingletonException extends RuntimeException {

	private static final long serialVersionUID = 8588399228147981636L;

	public SingletonException(Class<?> clazz) {
		super("A instance of " + clazz.getClass() + " already exists.", 
				new InstanceAlreadyExistsException());
	}
	
}
