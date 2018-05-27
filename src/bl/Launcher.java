package bl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.sun.swing.internal.plaf.synth.resources.synth_zh_CN;

import Enum.City;

public class Launcher extends AbstractLauncher {
	DataAfterFire daf = null;
	private final int FIRE_NOW = 0;

	// Test : no space in the city(the city is full)
	public Launcher(String id, City gaza, boolean hiddenLauncher, List<Missile> missiles) {
		super(id, missiles, gaza, hiddenLauncher);
	}

	@Override
	public DataAfterFire fire(Location destination) {
		missielToFire = new Missile(destination, FIRE_NOW);
		missielToFire.fire();
		return getDataAfterFire();
	}

	

	@Override
	public String toString() {
		return "Launcher [" + super.toString() + "]";
	}

	public static String makeId() {
		return "L" + numberId++;
	}

	@Override
	public synchronized void run() {
		
	}

	@Override
	public void addMissle() {
		// TODO Auto-generated method stub

	}

	public DataAfterFire fire(City city) {
		Location location = new Location(city); // must get location properly. for now its randome
		return fire(location);
	}

}
