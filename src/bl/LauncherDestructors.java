package bl;

import java.util.List;

import org.omg.CORBA.SetOverrideType;

import Enum.DistractorType;
import bl.AbstractLauncher;
import bl.DataAfterFire;
import bl.Location;
import bl.Missile;
import bl.MyRandom;

public class LauncherDestructors extends AbstractLauncher {
	DistractorType type;
	
	
	public LauncherDestructors(String id ,DistractorType type , List<Missile> m) {
		super(id,m,MyRandom.getCity(),false);
		this.type = type;
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

	
	
}
