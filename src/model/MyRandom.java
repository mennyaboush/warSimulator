package model;

import java.util.Random;

import Enum.City;

public class MyRandom {
	private static Random r = new Random();
	
	public static int getDemage() {
		return 500 + r.nextInt(3000);
	}

	public static boolean isHidden() {
		return r.nextBoolean();
	}

	public static int flyingTime() {
		return r.nextInt(10);
	}
	public static City getCity() {
		int size = City.values().length;
		int num = 1+ r.nextInt(size+1);
		return City.values()[num];
	}

}
