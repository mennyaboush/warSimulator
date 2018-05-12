package bl;

import java.util.ArrayList;
import java.util.List;

import Enum.City;
import mvc.WarController;
import mvc.WarModelEventListener;

public class War {
	private List<WarModelEventListener> allListeners = new ArrayList<>();
	private List<Launcherable> launchers = new ArrayList<>();
	
	public void registerListener(WarController warController) {
		allListeners.add(warController);
	}

	public void addLauncher() {
		Launcher l = new Launcher(Launcher.makeId(), City.GAZA, MyRandom.isHidden(),new ArrayList<Missile>());		
		fireAddLauncherEvent(l);
	}

	private void fireAddLauncherEvent(Launcher l) {
		for (WarModelEventListener warModelEventListener : allListeners) {
			warModelEventListener.addLauncherInModel(l);
		}
	}



}
