package bl;

import java.util.List;

import Enum.City;

public class MissileDestructors extends AbstractLauncher {

	@Override
	public String toString() {
		return "MissileDestructors [" + super.toString() + "]";
	}

	public MissileDestructors(String id, List<MissileD> missile, City city) {
		super(id, missile, city, false);
	}

	public synchronized DataAfterFire fire() {// we need to creat 
		Missile missile= getActiveMissile();;
		missielToFire = new MissileD(missile, FIRE_NOW);
		return null;
	}

	private Missile getActiveMissile() {
		// TODO Auto-generated method stub
		return null;
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

	public DataAfterFire fire(Missile missile) {
		missielToFire = new MissileD(missile, FIRE_NOW);
		missielToFire.fire();
		return getDataAfterFire();
	}

	@Override
	public DataAfterFire fire(Location location) {
		// TODO Auto-generated method stub
		return null;
	}

}
