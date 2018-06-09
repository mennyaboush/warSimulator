package bl;

public class DataAfterFire {
	private Launcherable l;
	private int damage;
	private boolean hit;
	private boolean fireComplete = true;
	private Location destination;

	/*
	 * for now startFireTime and finishFireTime no work
	 */
	private int startFireTime;
	private int finishFireTime;

	public DataAfterFire(Launcherable l, int damage, boolean hit, Location location) {
		this.l = l;
		this.damage = damage;
		this.hit = hit;
		setDestination(location);
		
	}

	public DataAfterFire(Launcherable l, int damage, boolean hit, Location location, boolean fireComplete) {
		this(l, damage, hit, location);
		setFireComplete(false);
		
	}

	public DataAfterFire(Launcherable l, int demage, boolean hit, Location location, boolean fireComplete,
			int launchTime, int finishFireTime) {
		this(l, demage, hit, location);
		setStartFireTime(launchTime);
		setFinishFireTime(finishFireTime);
	}

	public int getStartFireTime() {
		return startFireTime;
	}

	public void setStartFireTime(int startFireTime) {
		this.startFireTime = startFireTime;
	}

	public int getFinishFireTime() {
		return finishFireTime;
	}

	public void setFinishFireTime(int finishFireTime) {
		this.finishFireTime = finishFireTime;
	}

	public Location getDestination() {
		return destination;
	}

	public void setDestination(Location destination) {
		this.destination = destination;
	}

	public void setL(Launcherable l) {
		this.l = l;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public void setHit(boolean hit) {
		this.hit = hit;
	}

	public boolean isFireComplete() {
		return fireComplete;
	}

	public void setFireComplete(boolean fireComplete) {
		this.fireComplete = fireComplete;
	}

	@Override
	public String toString() {
		if (finishFireTime != -1)
			return "[Missile fire from=" + l + ",destination = " + destination + " damage=" + damage + ", hit=" + hit
					+ "\nFire start in time " + startFireTime + "\nFire end in " + finishFireTime + " time ]";
		return "[Missile fire from=" + l + ",destination = " + destination + " damage=" + damage + ", hit=" + hit+" ]";
	}

	public Launcherable getL() {
		return l;
	}

	public int getDamage() {
		return damage;
	}

	public boolean isHit() {
		return hit;
	}
}
