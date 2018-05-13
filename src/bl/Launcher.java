package bl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Enum.City;

public class Launcher extends AbstractLauncher {
	DataAfterFire daf = null;
	private final int FIRE_NOW = 0;
	private Missile missielToFire;
	
	// Test : no space in the city(the city is full)
	public Launcher(String id, City gaza, boolean hiddenLauncher, List<Missile> missiles  ) {
		super(id,missiles,gaza,hiddenLauncher );
	}



	@Override
	public  DataAfterFire fire(Location destination) {
		missielToFire = new Missile(destination ,FIRE_NOW );
		run();
		setActive(false);
		return getDataAfterFire();
	}



	private DataAfterFire getDataAfterFire() {
		return new DataAfterFire(this, missielToFire.getDemage(), MyRandom.getHit());
	}



	@Override
	public String toString() {
		return "Launcher [" +super.toString() + "]";
	}


	public static String makeId() {
		return "L"+numberId++;
	}


	@Override
	public void run() {
		try {
			Thread.sleep(MILISECEND_TO_SECONDE * missielToFire.getFlyTime());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Missile after flyTime");
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
