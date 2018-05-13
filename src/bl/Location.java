package bl;

import java.util.Random;

import Enum.City;

public class Location {
	private static final int MAX_COORD = 20;

	@Override
	public String toString() {
		return "[city=" + city + ", x=" + x + ", y=" + y + "]";
	}

	City city;
	private int x;
	private int y;

	public Location(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Location(City city) {
		super();
		this.city = city;
		setCordinate(city);
		
	}

	private void setCordinate(City city) {
		Random r = new Random();
		switch (city) {
		case GAZA:
			try {
				setX(r.nextInt(5));
				setY(r.nextInt(5));
			} catch (Throwable e) {
				System.out.println("thrwo in GAZA");
				e.printStackTrace();
			}

			break;

		default:
			try {
				setX(5 + r.nextInt(MAX_COORD));
				setY(5 + r.nextInt(MAX_COORD));
			} catch (Throwable e) {
				System.out.println("thrwo in GAZA");
				e.printStackTrace();
			}

			break;
		}
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(int x) throws Throwable {
		
		this.x = x;
	}

	public void setY(int y) throws Throwable {
		
		this.y = y;
	}



}
