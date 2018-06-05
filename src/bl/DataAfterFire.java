package bl;

public class DataAfterFire {
	private Launcherable l;
	private int damage;
	private boolean hit;
	private boolean fireComplete = true;
	private Location destination;
	
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

	public DataAfterFire(Launcherable l , int damage , boolean hit, Location location) {
		this.l=l;
		this.damage = damage;
		this.hit = hit;
		setDestination(location);
	}
	public DataAfterFire(Launcherable l , int damage , boolean hit, Location location ,boolean fireComplete) {
		this(l,damage,hit,location);
		setFireComplete(false);
	}
	public boolean isFireComplete() {
		return fireComplete;
	}

	public void setFireComplete(boolean fireComplete) {
		this.fireComplete = fireComplete;
	}

	@Override
	public String toString() {
		return "[Missile fire from=" + l + ",destination = "+destination +" damage=" + damage + ", hit=" + hit + "]";
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
