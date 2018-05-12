package Ui;

import bl.Launcher;
import mvc.WarController;

public interface WarUi  {

	void registerListener(WarController warController);

	void showLaunchers(Launcher l);
	
	
	
}
