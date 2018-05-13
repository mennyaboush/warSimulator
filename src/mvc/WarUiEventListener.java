package mvc;

import java.util.List;

import Enum.City;
import bl.Missile;

public interface WarUiEventListener {
	void addLauncherFromUi();
	void addLauncherDestructorFromUi();
	void addMissileDestructorFromUi();
	void fireFromLauncherFromUi(City city);
}

