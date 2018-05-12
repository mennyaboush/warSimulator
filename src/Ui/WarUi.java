package Ui;

import bl.Launcher;
import bl.Launcherable;
import mvc.WarController;

public interface WarUi  {

	void registerListener(WarController warController);

	void showLaunchers(Launcherable l);
	
	
	
}
