

import java.util.Queue;
import javax.tools.DocumentationTool.Location;
import model.DistractorType;
import model.Missile;

public interface IWarController {
	
	boolean addLauncher(String id,Location location, boolean isHidden, Queue<Missile> missles);
	boolean addLauncher(String id,Location location, boolean isHidden);
	boolean addLauncherDistractor(String id,Location location,DistractorType type,int distructTime);
	boolean addLauncherDistractor(String id,Location location,DistractorType type);
	boolean addMissleDistractor(String id,Location location,String targerId,int destructAfterLaunch);
	boolean fireMissle(String id,Location location,boolean isHidden,Queue<Missile> missles);
	
	
}
