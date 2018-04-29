package model;

import java.util.Random;

import Enum.City;
import view.WarView;

public class Location {
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
		this.x = x;
		this.y = y;
	}

	private void setCordinate(City city) {
		Random r = new Random();
		switch (city) {
		case GAZA:
			try {
				setX(r.nextInt(5));
				setY(4 + r.nextInt(8));
			} catch (Throwable e) {
				System.out.println("thrwo in GAZA");
				e.printStackTrace();
			}

			break;

		default:
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
		if (x > WarView.MAX_COORD || x < WarView.MIN_COORD) {
			throw new Exception("out of range.\nmax coord = " + WarView.MAX_COORD + "min coord = " + WarView.MIN_COORD);
		}
		this.x = x;
	}

	public void setY(int y) throws Throwable {
		if (y > WarView.MAX_COORD || y < WarView.MIN_COORD) {
			throw new Exception("out of range.\nmax coord = " + WarView.MAX_COORD + "min coord = " + WarView.MIN_COORD);
		}
		this.y = y;
	}

}
