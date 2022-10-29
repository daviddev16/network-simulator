package org.simulator.gameplay.api.device;

import java.util.Set;

import org.simulator.gameplay.api.IHardware;
import org.simulator.gameplay.api.networking.INetworkInterface;

/* IoT, computer, printer, switch routers, firewalls, etc... */
public interface IDevice extends IHardware {
	
	public abstract Set<INetworkInterface> getNetworkInterfaces();
	
}
