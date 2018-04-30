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
	
	public Missile() {
		this(makeId(),new Location(MyRandom.getCity()),
				MyRandom.getLaunchTime(),MyRandom.flyingTime(),MyRandom.getDemage());
	}
	public Missile(Location destination , int launchTime) {
		this(makeId(),destination,launchTime,MyRandom.flyingTime(),MyRandom.getDemage());
	}

	public Missile(String id,Location destination, int launchTime,int flyTime,int demage) {
		super();
		this.id = id;
		this.destination = destination;
		this.launchTime = launchTime;
		this.flyTime = flyTime;
		this.demage = demage;
		//this.launched = false; //missle hasnt launched yet.	
		initiateLogger(id);
	}
		public static String makeId() {
		return "M"+ID++;
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
	//this.launched = true;
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


	
}
