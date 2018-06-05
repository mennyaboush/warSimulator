package bl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.sun.glass.ui.Window.Level;

import Enum.City;

public abstract class AbstractLauncher <E extends AbstractMissile>implements Launcherable, Runnable {
	public static int numberId;
	private String id;
	protected static int FIRE_NOW = 0;
	private List<E> missileArr = new ArrayList<>();
	private boolean isHidden;
	private boolean isActive;
	protected final int MILISECEND_TO_SECONDE = 1000;
	protected E missielToFire;
	Location location;
	protected static Logger theLogger = Logger.getLogger("myLogger");
	
	static {
		Handler theHandler;
		try {
			theHandler = new FileHandler(War.WAR_FILE);
			theHandler.setFormatter(new SimpleFormatter());
			theLogger.addHandler(theHandler);
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
		
	}
	public AbstractLauncher(String id, List<E> missileArr, Location locathion, boolean isHiden) {
		setId(id);
		setLocation(locathion);
		setMissileArr(missileArr);
		setHidden(isHiden);
		setActive(false);
		initLogger();
		
	}
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public AbstractLauncher(String id, List<E> missileArr, City city, boolean isHiden) {
		this(id, missileArr, new Location(city), isHiden);
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void initLogger() {
		FileHandler theHandler ;
		theLogger.setLevel(java.util.logging.Level.INFO);
		try {
			theHandler = new FileHandler(getFileName());
			theHandler.setFilter(new ObjectFilter(this));
			theHandler.setFormatter(new SimpleFormatter());
			theLogger.addHandler(theHandler);
			
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
	}

	public abstract String getFileName();
	protected abstract void printToLog(String message);
	protected void getHiding() {
		setHidden(true);
	}

	protected void getUnhiding() {
		setHidden(false);
	}

	public List<E> getMissileArr() {
		return missileArr;
	}

	public void setMissileArr(List<E> missileArr) {
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
		return " id=" + id + ", missileArr=" + missileArr + ", isHidden=" + isHidden + ", location=" + location;
	}

	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}

	protected DataAfterFire getDataAfterFire() {
		if(missielToFire.getClass().getName().compareTo(Missile.class.getName()) == 0) {
			Missile temp = Missile.class.cast(missielToFire);
			DataAfterFire daf = new DataAfterFire(this, temp.getDemage(), temp.isFireComplete() ? MyRandom.getHit() : false,
					temp.getDestination(),temp.isFireComplete());
			printDataToLogfile(daf);
			return daf;
		}
		else {
			MissileD temp = MissileD.class.cast(missielToFire);
			DataAfterFire daf = new DataAfterFire(this, 0, temp.isHit, null); 
			printDataToLogfile(daf);
			return daf; 
		}
		
		
	}

	public void printDataToLogfile(DataAfterFire daf) {
		printToLog(daf.toString());
	}
	

}