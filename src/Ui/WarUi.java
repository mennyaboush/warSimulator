package Ui;

import bl.DataAfterFire;
import bl.Launcher;
import bl.Launcherable;
import bl.SummaryObj;
import mvc.WarController;

public interface WarUi  {

	void registerListener(WarController warController);

	void showLaunchers(Launcherable l);

	void showFire(DataAfterFire daf);

	void showSummary(SummaryObj summaryObj);

	void showExit();
	
	
	
}
