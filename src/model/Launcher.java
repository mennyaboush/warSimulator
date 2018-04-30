package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Enum.City;
import controller.WarController;

public class Launcher extends AbstractLauncher {
	DataAfterFire daf;
	private final int FIRE_NOW = 0;
	private Missile missielToFire;
	// Test : no space in the city(the city is full)
	public Launcher(String id, City gaza, boolean hiddenLauncher, List<Missile> missiles ,WarController war ) {
		super(id,missiles,gaza,hiddenLauncher ,war);
	}


	@Override
	public  DataAfterFire fire(Location destination) {
		missielToFire = new Missile(destination ,FIRE_NOW );
		run();
	}

	@Override
	public void addMissle() {
		// TODO Auto-generated method stub

	}


	@Override
	public String toString() {
		return "Launcher [" +super.toString() + "]";
	}


	@Override
	public synchronized void run() {
		war.getActiveLauncher().add(this);
		boolean hit;
		System.out.println("missile "+missielToFire.getId()+"get fired from launcher" + getId());
		try {
			
			Thread.sleep(missielToFire.getFlyTime()*MILISECEND_TO_SECONDE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		stop(MyRandom.getHit());
	}
	
	public void stop(boolean hit) {
		daf= new DataAfterFire(this, missielToFire.getDemage(), hit);
		
	}

}
