package bl;

import java.util.Random;

import Enum.City;
import Enum.DestractorType;

public class MyRandom {
	private static Random r = new Random();
	
	public static int getDemage() {
		return 500 + r.nextInt(3000);
	}

	public static boolean isHidden() {
		return r.nextBoolean();
	}

	public static int flyingTime() {
		return 1 + r.nextInt(10);
	}
	
	public static City getCity() {
		int size = City.values().length;
		int num = r.nextInt(size-1);
		return City.values()[num+1];
	}

	public static int getLaunchTime() {
		return r.nextInt(1000);
	}

	public static boolean getHit() {
		int ProbabilityOfInjury = 7;
		return r.nextInt(10) > ProbabilityOfInjury ? false : true ;
	}

	public static DestractorType getLauncherDestructorsType() {
		return r.nextBoolean()? DestractorType.PLANE : DestractorType.SHIP ;
	}

}
