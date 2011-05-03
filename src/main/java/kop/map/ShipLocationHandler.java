package kop.map;

import com.bbn.openmap.layer.location.AbstractLocationHandler;
import com.bbn.openmap.layer.location.BasicLocation;
import com.bbn.openmap.layer.location.Location;
import com.bbn.openmap.omGraphics.OMLine;
import com.bbn.openmap.omGraphics.OMRect;
import kop.game.Game;
import kop.ports.Port;
import kop.ports.PortMap;
import kop.ports.PortsOfTheWorld;
import kop.ships.ShipModel;

import java.awt.*;
import java.util.List;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: ola
 * Date: 5/1/11
 * Time: 9:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShipLocationHandler extends AbstractLocationHandler {
	@Override
	public Vector get(float v, float v1, float v2, float v3, Vector vector) {
		Vector retVector;

		if (vector == null) {
			retVector = new Vector();
		} else {
			retVector = vector;
		}

		List<ShipModel> ships = Game.getInstance().getPlayerCompany().getShips();

		for (ShipModel ship: ships) {

			OMLine line = new OMLine((float)ship.getLatitude(),
					(float)ship.getLongitude(),
					-1,-1,1,1);
			line.setFillPaint(Color.red);
			line.setLinePaint(Color.red);
			line.setVisible(true);

			Location location = new BasicLocation((float)ship.getLatitude(),
					(float)ship.getLongitude(),
					ship.getName(),
					line);


			location.setShowName(false);
			location.setShowLocation(true);
			location.setLocationHandler(this);

			//noinspection unchecked
			retVector.add(location);
		}

		return retVector;
	}

	@Override
	public void reloadData() {

	}
}