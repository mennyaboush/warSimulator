package Ui;

import bl.DataAfterFire;
import bl.Launcher;
import bl.Launcherable;
import mvc.WarController;

public interface WarUi  {

	void registerListener(WarController warController);

	void showLaunchers(Launcherable l);

	void showFire(DataAfterFire daf);
	
	
	
}
