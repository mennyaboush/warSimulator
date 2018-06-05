package bl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import Enum.City;

public class MissileDestructors extends AbstractLauncher {

	@Override
	public String toString() {
		return "MissileDestructors [" + super.toString() + "]";
	}

	public MissileDestructors(String id, List<MissileD> missile, City city) {
		super(id, missile, city, false);
		printToLog("222");
	}

	public MissileDestructors(String id, ArrayList<MissileD> missiles) {
		this(id,missiles , MyRandom.getCity());
	}

	@Override
	public void addMissle() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public static String makeId() {
		return "D" + numberId++;
	}

	@SuppressWarnings("unchecked")
	public DataAfterFire fire(Missile missile) {
		missielToFire = new MissileD(missile, FIRE_NOW);
		System.out.println("missileD before fire");
		missielToFire.fire();
		return getDataAfterFire();
	}

	@Override
	public DataAfterFire fire(Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFileName() {
		return "MissileDestructors_"+getId()+".txt";
	}

	

	@Override
	protected void printToLog(String message) {
		theLogger.log(Level.INFO, message, this);
	}

}
