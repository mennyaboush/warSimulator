package model;

import view.WarView;


public class Location {
	private int x;
	private int y;
	
	
	public Location(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}

	public void setX(int x) throws Throwable {
		if(x > WarView.MAX_COORD || x < WarView.MIN_COORD ) {
			throw new Exception("out of range.\nmax coord = "+WarView.MAX_COORD+
					"min coord = "+WarView.MIN_COORD);
		}
		this.x = x;
	}
	
	public void setY(int y) throws Throwable {
		if(y > WarView.MAX_COORD || y < WarView.MIN_COORD ) {
			throw new Exception("out of range.\nmax coord = "+WarView.MAX_COORD+
					"min coord = "+WarView.MIN_COORD);
		}
		this.y = y;
	}

}
