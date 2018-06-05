package bl;

import java.util.logging.Logger;

import org.json.JSONObject;

import Enum.City;

public class Missile extends AbstractMissile {

	private static final int MILI_TO_SEC = 1000;

	public static int ID = 1;

	public static Logger logger;
	private Location destination;
	private int flyTime;
	private int demage;
	private boolean fireComplete = true;

	public Missile() {
		this(makeId(), new Location(MyRandom.getCity()), MyRandom.getLaunchTime(), MyRandom.flyingTime(),
				MyRandom.getDemage());
	}

	public Missile(Location destination, int launchTime) {
		this(makeId(), destination, launchTime, MyRandom.flyingTime(), MyRandom.getDemage());
	}

	public Missile(String id, Location destination, int launchTime, int flyTime, int demage) {
		super(id, launchTime);
		setDestination(destination);
		setFlyTime(flyTime);
		setDemage(demage);
	}

	public Missile(String id, String destination, int launchTime, int flyTime, int damage) {
		this(id, getLocation(destination), launchTime, flyTime, damage);
	}

	public Missile(String id, int launchTime) {
		this(id, new Location(City.GAZA), launchTime, MyRandom.flyingTime(), MyRandom.getDemage());
	}

	private static Location getLocation(String destination) {
		try {
			if (destination.compareTo("Beer-Sheva") == 0)
				return new Location(City.BEER_SHEVA);
			return new Location(City.valueOf(destination.toUpperCase()));
		} catch (Exception e) {
			AbstractLauncher.theLogger.severe("random city for json replace - " + destination);
			return new Location(MyRandom.getCity());
		}
	}

	@Override
	public synchronized void run() {
		try {
			wait(getFlyTime() * MILI_TO_SEC);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Location getDestination() {
		return destination;
	}

	public void setDestination(Location destination) {
		this.destination = destination;
	}

	public int getFlyTime() {
		return flyTime;
	}

	public void setFlyTime(int flyTime) {
		this.flyTime = flyTime;
	}

	public int getDemage() {
		return demage;
	}

	public void setDemage(int demage) {
		this.demage = demage;
	}

	public synchronized void getHit() {
		this.notifyAll();
		setFireComplete(false);
		setDemage(0);
		setHit(false);
	}

	public boolean isFireComplete() {
		return fireComplete;
	}

	private void setFireComplete(boolean b) {
		this.fireComplete = b;
	}

}
