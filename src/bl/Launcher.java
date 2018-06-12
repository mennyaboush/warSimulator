package bl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.swing.internal.plaf.synth.resources.synth_zh_CN;

import Enum.City;

public class Launcher extends AbstractLauncher {
	DataAfterFire daf = null;
	public Launcher(String id, City gaza, boolean hiddenLauncher, List<Missile> missiles) {
		super(id, missiles, gaza, hiddenLauncher);
	}

	@Override
	public String getFileName() {
		return "Launcher_" + getId() + ".txt";
	}

	@Override
	public DataAfterFire fire(Location destination) {
		missielToFire = new Missile(destination, MyTimer.getTime());
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

	@Override
	protected void printToLog(String message) {
		theLogger.log(Level.INFO, message, this);
	}

	@Override
	public List<DataAfterFire> fireIfNeed(int time) {
		System.out.println(this+" inside fire if need.");
		List<Missile> removeList = new ArrayList();
		List<Missile> arr = getMissileArr();
		List<DataAfterFire> data = new ArrayList<>();
		if (arr != null) {
			for (Missile m : arr) {
				if (m.getLaunchTime() <= time) {
					System.out.println(m + "need to be fire");
					missielToFire = m;
					data.add(fire(((Missile) m).getDestination()));
					removeList.add(m);
				}
			}
		}
		arr.removeAll(removeList);
		return data;
	}
}
