package model;

import java.util.Random;

public class Launcher extends AbstractLauncher implements launcherable {
	
	public static int id = 1;
	
	// Test : no space in the city(the city is full)
	public Launcher(String id, City gaza, boolean hiddenLauncher) {
		setId(id);
		this.location = new Location(gaza);
		if (hiddenLauncher)
			getHiding();
		else
			getUnhiding();
	}


	@Override
	public void fire(Location location) {
		if (missileArr.isEmpty())
			missileArr.add(new Missile());
		Missile m = missileArr.remove(0);
		m.setDestination(location);

	}

	@Override
	public void addMissle() {
		// TODO Auto-generated method stub

	}

}
