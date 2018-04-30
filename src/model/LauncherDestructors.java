package model;

import java.util.List;

import org.omg.CORBA.SetOverrideType;

import Enum.DistractorType;

public class LauncherDestructors extends AbstractLauncher {
	@Override
	public String toString() {
		return "LauncherDestructors [type=" + type + ", " + super.toString() + "]";
	}

	DistractorType type;
	public LauncherDestructors(String id ,DistractorType type , List<Missile> m) {
		super(id,m,MyRandom.getCity(),false);
		this.type = type;
	}

	public static String makeId() {
		return "LD" + numberId++;
	}

	@Override
	public DataAfterFire fire(Location location) {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public void addMissle() {
		// TODO Auto-generated method stub

	}

}
