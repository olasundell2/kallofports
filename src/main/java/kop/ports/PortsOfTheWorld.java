package kop.ports;

import kop.ships.ModelSerializer;
import kop.ships.ShipModel;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: ola
 * Date: 4/3/11
 * Time: 11:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class PortsOfTheWorld {
	private PortMap ports;
	private List<Distance> distances;

	public PortsOfTheWorld() {
		distances = new ArrayList<Distance>();
	}

	public void populatePorts()  {
		try {
//			ports = factory.createPorts();
			ports = (PortMap) ModelSerializer.readFromFile("kop/ports/ports.xml", PortMap.class);
		} catch (Exception e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
	}

	public static PortMap getPorts() {
		PortsOfTheWorld instance = new PortsOfTheWorld();
		instance.populatePorts();
		return instance.ports;
	}

	public Port putPort(String name) {
		Port p = new Port();
		p.setName(name);
		ports.put(name, p);

		return p;
	}


	public double getDistance(Port origin, Port destination, ShipModel ship) throws NoRouteFoundException {
		for (Distance d: distances) {
			if (d.getOrigin().equals(origin) && d.getDestination().equals(destination)) {
				return d.shortestDistance(ship);
			}
		}

		throw new NoRouteFoundException("Could not find route between the ports "+origin.getName() + " and " + destination.getName());
	}

	public Port getPortByName(String portName) throws NoSuchPortException {
		Port port = ports.get(portName);

		if (port == null) {
			throw new NoSuchPortException("There's no port named " + portName);
		}

		return port;
	}

	public void setDistance(Port origin, Port destination, int nm) {
		Distance d = new Distance(origin, destination);
		d.addRoute(nm, false, false);
		distances.add(d);
	}

	public Collection<Port> getPortsAsList() {
		return ports.values();
	}
}
