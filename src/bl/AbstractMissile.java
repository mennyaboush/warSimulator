package bl;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public abstract class AbstractMissile extends Thread {

	public static int ID = 1;
	private String id;
	private int launchTime;
	private int destructTime  = -1;
	protected boolean isHit = false;

	public AbstractMissile(String id, int launchTime) {
		this.id = id;
		this.launchTime = launchTime;
	}

	public static String makeId() {
		return "M" + ID++;
	}

	public String getMissleId() {
		return id;
	}

	public void setMissleId(String id) {
		this.id = id;
	}

	public int getLaunchTime() {
		return launchTime;
	}

	public void setLaunchTime(int launchTime) {
		this.launchTime = launchTime;
	}

	public String getMissileId() {
		return id;
	}

	public abstract void run();

	public void fire() {
		run();
	}

	public boolean isHit() {
		return isHit;
	}

	public void setHit(boolean isHit, int missileDtime) {
		setHit(isHit);
		destructTime = getLaunchTime() + missileDtime;
	}

	/**
	 * @param isHit
	 */
	public void setHit(boolean isHit) {
		this.isHit = isHit;
	}

	public int getDestructTime() {
		return destructTime;
	}

	// public void fire() {
	// run();
	// }

}
