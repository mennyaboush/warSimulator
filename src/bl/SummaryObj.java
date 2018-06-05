package bl;

public class SummaryObj {
	private int counterMissile = 0 ,counterMissileLauncherD = 0 ,counterHitTarget = 0, counterMissileD = 0 , counterDamage = 0 ,counterLauncherImpact = 0;

	
	public SummaryObj(int counterMissile, int counterMissileD, int counterMissileLauncherD, int counterHitTarget,
			int counterDamage, int counterLauncherImpact) {
		setCounterDamage(counterDamage);
		setCounterLauncherImpact(counterLauncherImpact);
		setCounterMissile(counterMissile);
		setCounterMissileD(counterMissileD);
		setCounterMissileLauncherD(counterMissileLauncherD);
		setCounterHitTarget(counterHitTarget);
	}

	@Override
	public String toString() {
		return "Summary:"
			+ "[Number of missiles fired:" + counterMissile
			+ "\nDestroyed launchers:" + counterMissileLauncherD
			+ "\nNumber of missiles hitting the target:" + counterHitTarget 
			+ "\nNumber of missiles fired by a missile destroyer:" + counterMissileD 
			+ "\nAmount of damage:"+ counterDamage 
			+ "\nNumber of launchers destroyed:" + counterLauncherImpact + "]";
	}

	public int getCounterMissile() {
		return counterMissile;
	}

	public void setCounterMissile(int counterMissile) {
		this.counterMissile = counterMissile;
	}

	public int getCounterMissileLauncherD() {
		return counterMissileLauncherD;
	}

	public void setCounterMissileLauncherD(int counterMissileLauncherD) {
		this.counterMissileLauncherD = counterMissileLauncherD;
	}

	public int getCounterHitTarget() {
		return counterHitTarget;
	}

	public void setCounterHitTarget(int counterHitTarget) {
		this.counterHitTarget = counterHitTarget;
	}

	public int getCounterMissileD() {
		return counterMissileD;
	}

	public void setCounterMissileD(int counterMissileD) {
		this.counterMissileD = counterMissileD;
	}

	public int getCounterDamage() {
		return counterDamage;
	}

	public void setCounterDamage(int counterDamage) {
		this.counterDamage = counterDamage;
	}

	public int getCounterLauncherImpact() {
		return counterLauncherImpact;
	}

	public void setCounterLauncherImpact(int counterLauncherImpact) {
		this.counterLauncherImpact = counterLauncherImpact;
	}
	
}
