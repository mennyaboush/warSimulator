package Model;

import java.util.Timer;
//Singeltone class.
/*
 * This class should be the timer for the whole war
 * Rocket will start shooting at the currect time by this timer.
 * 
 */
public class MyTimer{
	
	private static MyTimer myTimer;
	private static Timer timer;
	
	private MyTimer(){}
	
	public static MyTimer getInstance(){
		if(myTimer == null){
			myTimer=new MyTimer();
			timer = new Timer();
		}
		return myTimer;
	}
	
	
	public Timer getTimer() {
		return myTimer.timer;
	}

	public void setTimer(Timer timer) {
		myTimer.timer = timer;
	}

	
	
	
}
