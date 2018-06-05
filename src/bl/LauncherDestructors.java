package bl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.omg.CORBA.SetOverrideType;

import Enum.DestractorType;
import bl.AbstractLauncher;
import bl.DataAfterFire;
import bl.Location;
import bl.Missile;
import bl.MyRandom;

public class LauncherDestructors extends AbstractLauncher {
	DestractorType type;
	
	
	public LauncherDestructors(String id ,DestractorType type , List<Missile> m) {
		super(id,m,MyRandom.getCity(),false);
		printToLog("333");
		this.type = type;
	}
	//jsonMissileLauncherDestructor.getString(TYPE),launcherDistractorMissileLis
	public LauncherDestructors(String type, ArrayList<Missile> Missiles) {
		this(makeId(),getType(type),Missiles);
	}

	private static DestractorType getType(String type) {
		if(type.compareTo("ship") == 0)
			return DestractorType.SHIP;
		else 
			return DestractorType.PLANE;
	}
	@Override
	public String getFileName() {
		return "LauncherDestructors_"+getId()+ ".txt";
	}
	public static String makeId() {
		return "D" + numberId++;
	}

	@Override
	public void addMissle() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "LauncherDestructors [type=" + type + ", " + super.toString() + "]";
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public synchronized DataAfterFire fire(Location destination) {
		missielToFire = new Missile(destination, FIRE_NOW);
		missielToFire.fire();
		return getDataAfterFire();
	}
	@Override
	protected void printToLog(String message) {
		theLogger.log(Level.INFO, message , this);
	}

	
	
}
