package warInterface;


import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import Enum.DistractorType;
import model.Location;
import model.Missile;
public interface IWarController {
	
	void addLauncher(String id , boolean isHidden , List<Missile>missels);
	void addMissleDistractor(String id, List<Missile>missels);
	void addLauncherDistractor(String id,DistractorType type);
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
 