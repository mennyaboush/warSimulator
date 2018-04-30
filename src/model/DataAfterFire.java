package model;

public class DataAfterFire {
	private Launcherable l;
	private int damage;
	private boolean hit;
	
	public void setL(Launcherable l) {
		this.l = l;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public void setHit(boolean hit) {
		this.hit = hit;
	}

	public DataAfterFire(Launcherable l , int damage , boolean hit) {
		this.l=l;
		this.damage = damage;
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "DataAfterFire [l=" + l + ", damage=" + damage + ", hit=" + hit + "]";
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
