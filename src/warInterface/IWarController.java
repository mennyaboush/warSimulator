package warInterface;


import java.util.ArrayList;
import java.util.Queue;

import model.Location;
import model.DistractorType;
import model.Missile;
public interface IWarController {
	
	boolean addLauncher(String id , boolean isHidden , Queue<Missile>missels);
	boolean addMissleDistractor(String id,ArrayList <String> targetId ,Queue<Missile>missels);
	boolean addLauncherDistractor(String id,DistractorType type,int distructTime);
	void launcherFire(Location target , int  damage , int flyTime  );
	void launcherDistractorFire(String targetID , int flyTime  );
	void missleDistractorFire();
	void warSummary();
	void Exit();
	
	
	//boolean addLauncherDistractor(String id,Location location,DistractorType type,int distructTime);
	//boolean addLauncherDistractor(String id,Location location,DistractorType type);
	//boolean addMissleDistractor(String id,Location location,String targerId,int destructAfterLaunch);
	//boolean fireMissle(String id,Location location,boolean isHidden,Queue<Missile> missles);
	//boolean addLauncher(String id,Location location, boolean isHidden);
	
	
}
 