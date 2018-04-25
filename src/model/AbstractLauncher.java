package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public abstract class AbstractLauncher implements launcherable{
	private String id;
	protected ArrayList<Missile> missileArr = new ArrayList<>();
	private boolean isHidden;
	Location location;
	
	public void addFileHandler(Logger l) {
		try {
			FileHandler handler = new FileHandler(getFileName(),true);
			l.addHandler(handler);
			handler.setFormatter(new SimpleFormatter());
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
	}
	public String getFileName() {
		return "Launcher:"+getId()+".xml";
	}
	
	/*hiding and unhiding.. its ok to put that her? for luncher who can't hide*/
	protected void getHiding() {
		setHidden(true);
	}
	protected void getUnhiding() { 
		setHidden(false);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public boolean getIsHidden() {
		return isHidden;
	}
	
	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	} 
	
	/**/
	//public abstract boolean checkLocation ();
	

}