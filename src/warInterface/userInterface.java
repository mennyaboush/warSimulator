package warInterface;

import java.util.Queue;

import Enum.DistractorType;
import model.Location;
import model.Missile;

public interface userInterface {
	
	// on userInterface the method put values randomly.
	void addLauncher();
	void addMissleDistractor();
	void addLauncherDistractor(DistractorType type);
	void launcherFire(Location target );
	void launcherDistractorFire(String targetID );
	void missleDistractorFire();
	void warSummary();
	void Exit();
	
}
