package model;

<<<<<<< HEAD
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Missile extends Thread{
	public static Logger logger;
	private String id;
	private String destination;
	private int launchTime;
	private int flyTime;
	private int demage;
	private boolean launched;

	public Missile(String id,String destination, int launchTime,int flyTime,int demage,String logFileName) {
		super();
		this.id = id;
		this.destination = destination;
		this.launchTime = launchTime;
		this.flyTime = flyTime;
		this.demage = demage;
		this.launched = false; //missle hasnt launched yet.	
		initiateLogger(logFileName);
		
		
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
	logger.log(Level.INFO,"Missle id: "+id+" has hit "+destination);
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




	public String getDestination() {
		return destination;
	}




	public void setDestination(String destination) {
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
	
=======
public class Missile implements Runnable{
	private String id;

	
	@Override
	public void run() {
		
		
	}
>>>>>>> branch 'master' of https://github.com/mennyaboush/warSimulator.git
}
