package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Enum.City;

public class MissileDestructors extends AbstractLauncher {
	

	@Override
	public String toString() {
		return "MissileDestructors ["+ super.toString() + "]";
	}

	public MissileDestructors(String id, List<Missile> missile,City city) {
		super(id,missile,city , false);
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
