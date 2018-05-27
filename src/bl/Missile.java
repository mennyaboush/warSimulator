package bl;

import java.util.logging.Logger;


public class Missile extends AbstractMissile {

	private static final int MILI_TO_SEC = 1000;

	public static int ID = 1;

	public static Logger logger;
	private Location destination;
	private int flyTime;
	private int demage;
	private boolean isHit = false;

	public Missile() {
		this(makeId(), new Location(MyRandom.getCity()), MyRandom.getLaunchTime(), MyRandom.flyingTime(),
				MyRandom.getDemage());
	}

	public Missile(Location destination, int launchTime) {
		this(makeId(), destination, launchTime, MyRandom.flyingTime(), MyRandom.getDemage());
	}

	public Missile(String id, Location destination, int launchTime, int flyTime, int demage) {
		super(id, launchTime);
		
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

	public boolean isHit() {
		return isHit;
	}
	public void setHit(boolean isHit) {
		this.isHit = isHit;
	}
	
	public void getHit() {
		this.notifyAll();
		setDemage(0);
		setHit(true);
	}

}
