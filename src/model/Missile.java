package model;

import java.io.IOException;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import view.WarView;


public class Missile extends Thread{
	
	public static int ID = 1;
	
	public static Logger logger;
	private String id;
	private Location destination;
	private int launchTime;
	private int flyTime;
	private int demage;
	private boolean launched;

	public Missile() {
		super();
		Random r = new Random();
		this.id = makeId();
		launchTime = r.nextInt(2);
		flyTime = r.nextInt(WarView.MAX_COORD);
		demage = r.nextInt(3000);
		launched = false;
	}
	public static String makeId() {
		return "M"+ID++;
	}
	public Missile(String id,Location destination, int launchTime,int flyTime,int demage) {
		super();
		this.id = id;
		this.destination = destination;
		this.launchTime = launchTime;
		this.flyTime = flyTime;
		this.demage = demage;
		this.launched = false; //missle hasnt launched yet.	
		initiateLogger(id);
	}
	
	

	
private void initiateLogger(String logFileName) {
	logger  = Logger.getLogger("myLogger");
	try {
		logger.addHandler(new FileHandler(logFileName));
	} catch (SecurityException e) {
		System.out.println("initiateLogger logger security exception");
		e.printStackTrace();
	} catch (IOException e) {
		System.out.println("initiateLogger logger  IOexception");
		e.printStackTrace();
	}
	}




@Override
	public void run() {
		super.run();
		launchMissle();
		
	}



	private void launchMissle() {	
	this.launched = true;
	fireMissle();
	//logger.log(Level.INFO,"Missle id: "+id+" has hit "+destination);
	System.out.println("Missle id: "+id+" has hit "+destination);
	}

	private void fireMissle() {
		try {
			sleep(flyTime * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}

	public String getMissleId() {
		return id;
	}




	public void setMissleId(String id) {
		this.id = id;
	}




	public Location getDestination() {
		return destination;
	}




	public void setDestination(Location destination) {
		this.destination = destination;
	}




	public int getLaunchTime() {
		return launchTime;
	}




	public void setLaunchTime(int launchTime) {
		this.launchTime = launchTime;
	}




	public int getFlyTime() {
		return flyTime;
	}




	public void setFlyTime(int flyTime) {
		this.flyTime = flyTime;
	}




	public int getDemage() {
		return demage;
	}




	public void setDemage(int demage) {
		this.demage = demage;
	}




	public boolean isLaunched() {
		return launched;
	}




	public void setLaunched(boolean launched) {
		this.launched = launched;
	}
	
}
