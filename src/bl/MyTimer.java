package bl;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;


public class MyTimer {//Singleton class.
	
	private static MyTimer myTimer;
	private static Timer timer;
	private static int time = 0;
	private MyTimer(){}
	
	public static MyTimer getInstance(){
		if(myTimer == null){
			myTimer=new MyTimer();
			timer = new Timer();
			timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					time++;
				}
			}, 1000);
		}
		return myTimer;
	}
	public static int getTime() {
		return time;
	}
	
	public Timer getTimer() {
		return myTimer.timer;
	}

	public void setTimer(Timer timer) {
		myTimer.timer = timer;
	}
	
}
