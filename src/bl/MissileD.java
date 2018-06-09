package bl;


public class MissileD extends AbstractMissile {
	private Missile missileToDestruct;

	public MissileD(Missile missile, int launchTime) {
		super(Missile.makeId(), launchTime);
		this.missileToDestruct = missile;
	}
	
	
	public MissileD(String id, int launchTime) {
		super(id, launchTime);
	}


	@Override
	public synchronized void run() {
		if (missileToDestruct != null) {
			missileToDestruct.getHit();
			System.out.println("missileD hit the missile");
			setHit(true , getLaunchTime());
		}else {
			System.out.println("missile destruct miss.");
			setHit(false);
		}
	}


	public Missile getMissileToDestruct() {
		return missileToDestruct;
	}


	public void setMissileToDestruct(Missile missileToDestruct) {
		this.missileToDestruct = missileToDestruct;
	}

}
