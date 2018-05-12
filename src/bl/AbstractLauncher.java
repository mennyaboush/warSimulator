package bl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import Enum.City;

public abstract class AbstractLauncher implements Launcherable , Runnable {
	public static int numberId;
	private String id;
	private List<Missile> missileArr = new ArrayList<>();
	private boolean isHidden;
	protected final int MILISECEND_TO_SECONDE = 1000;
	Location location;

	public AbstractLauncher(String id, List<Missile> missileArr, Location locathion, boolean isHiden ) {
		setId(id);
		setLocation(locathion);
		setMissileArr(missileArr);
		setHidden(isHiden);
	}

	public AbstractLauncher(String id, List<Missile> missileArr, City city, boolean isHiden) {
		this(id,missileArr,new Location(city) , isHiden);
	}


	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void addFileHandler(Logger l) {
		try {
			FileHandler handler = new FileHandler(getFileName(), true);
			l.addHandler(handler);
			handler.setFormatter(new SimpleFormatter());
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
	}

	public String getFileName() {
		return "Launcher:" + getId() + ".xml";
	}

	/* hiding and unhiding.. its ok to put that her? for luncher who can't hide */
	protected void getHiding() {
		setHidden(true);
	}

	protected void getUnhiding() {
		setHidden(false);
	}

	public List<Missile> getMissileArr() {
		return missileArr;
	}

	public void setMissileArr(List<Missile> missileArr) {
		this.missileArr = missileArr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean getIsHidden() {
		return isHidden;
	}

	@Override
	public String toString() {
		return " id=" + id + ", missileArr=" + missileArr + ", isHidden=" + isHidden + ", location="
				+ location ;
	}

	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}


}