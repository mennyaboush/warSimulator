package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Enum.City;

public class Launcher extends AbstractLauncher {
	

	// Test : no space in the city(the city is full)
	public Launcher(String id, City gaza, boolean hiddenLauncher, List<Missile> missiles) {
		super(id,missiles,gaza,hiddenLauncher);
	}


	@Override
	public void fire(Location location) {
		if (getMissileArr().isEmpty())
			getMissileArr().add(new Missile());
		//Missile m = getMissileArr().remove(0);
		//m.setDestination(location);

	}

	@Override
	public void addMissle() {
		// TODO Auto-generated method stub

	}

}
