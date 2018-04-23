package model;

public class RocketLauncher extends AbstractLauncher implements launcherable{

	
	public RocketLauncher(String id , Location location, boolean hiddenLauncher) {
		setId(id);
		this.location = location;
		if(hiddenLauncher)
			getHiding();
		else
			getUnhiding();
	}
	@Override
	public void fire(Location location) {
		if(missileArr.isEmpty())
			missileArr.add(new Missile());
		Missile m = missileArr.remove(0);
		m.setDestination(location);
		
	}
	@Override
	public void addMissle() {
		// TODO Auto-generated method stub
		
	}
}
