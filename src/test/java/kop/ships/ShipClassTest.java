package kop.ships;

import kop.ships.blueprint.ContainerShipBlueprint;
import kop.ships.engine.Engine;
import kop.ships.engine.EngineList;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

import static org.testng.AssertJUnit.*;


/**
 * Created by IntelliJ IDEA.
 * User: ola
 * Date: 4/9/11
 * Time: 9:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class ShipClassTest {
	@Test
	public void getShipClasses() {
		List<ShipClass> list = ShipClass.getShipClasses();
		assertNotNull(list);
		assertTrue(list.size() > 0);
	}
	@Test
	public void testSerializeDeserialize() throws Exception {
		// TODO replace this factory with kop.ships.ModelSerializer usage.
		ContainerShipBlueprint blueprint = new ContainerShipBlueprint();
		EngineList instance = EngineList.getInstance();
		Engine anEngineForTest = instance.getAnEngineForTest();
		blueprint.addEngine(anEngineForTest);

		ShipClass c = new ShipClass(blueprint, 10.0, "Feeder");
		Serializer serializer = new Persister();
		File result = new File("foobar.xml");
		serializer.write(c, result);
		File source = new File("foobar.xml");
		ShipClass r = serializer.read(ShipClass.class, source);
		assertEquals(c.getClassName(), r.getClassName());
	}
}
