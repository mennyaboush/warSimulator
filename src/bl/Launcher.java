package bl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Enum.City;

public class Launcher extends AbstractLauncher {
	DataAfterFire daf;
	private final int FIRE_NOW = 0;
	private Missile missielToFire;
	
	// Test : no space in the city(the city is full)
	public Launcher(String id, City gaza, boolean hiddenLauncher, List<Missile> missiles  ) {
		super(id,missiles,gaza,hiddenLauncher );
	}



	@Override
	public  DataAfterFire fire(Location destination) {
		missielToFire = new Missile(destination ,FIRE_NOW );
		run();
		return daf;
	}



	@Override
	public String toString() {
		return "Launcher [" +super.toString() + "]";
	}


	public static String makeId() {
		return "L"+numberId++;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addMissle() {
		// TODO Auto-generated method stub
		
	}
}
