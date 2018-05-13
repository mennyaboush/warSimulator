package mvc;


import java.util.List;

import bl.DataAfterFire;
import bl.Launcher;
import bl.LauncherDestructors;
import bl.Launcherable;
public interface WarModelEventListener {
	void addLauncherInModel(Launcherable l);// after launcher add in the model

	void fireFromeLauncherInModel(DataAfterFire daf);
}
