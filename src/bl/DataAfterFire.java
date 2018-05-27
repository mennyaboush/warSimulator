package bl;

public class DataAfterFire {
	private Launcherable l;
	private int damage;
	private boolean hit;
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
