package bl;

import java.util.ArrayList;
import java.util.List;

import Enum.City;
import mvc.WarController;
import mvc.WarModelEventListener;

public class War {
	private List<WarModelEventListener> allListeners = new ArrayList<>();
	private List<Launcherable> launchers = new ArrayList<>();
	private List<DataAfterFire> dataList = new ArrayList<>();
	public void registerListener(WarController warController) {
		allListeners.add(warController);
	}

	public void addLauncher() {
		Launcher l = new Launcher(Launcher.makeId(), City.GAZA, MyRandom.isHidden(),new ArrayList<Missile>());		
		launchers.add(l);
		fireAddLauncherEvent(l);
	}

	public void addLauncherDestructor() {
		LauncherDestructors ld = new LauncherDestructors(LauncherDestructors.makeId(),
				MyRandom.getLauncherDestructorsType(), new ArrayList<Missile>());
		launchers.add(ld);
		fireAddLauncherEvent(ld);
	}
	
	private void fireAddLauncherEvent(Launcherable l) {
		for (WarModelEventListener warModelEventListener : allListeners) {
			warModelEventListener.addLauncherInModel(l);
		}
	}

	public void addMissileDestructor() {
		MissileDestructors md = new MissileDestructors(MissileDestructors.makeId(), new ArrayList<Missile>(), MyRandom.getCity());		
		launchers.add(md);
		fireAddLauncherEvent(md);
	}

	public void fireFromLauncher(City city) {
		Launcher radyToFire = getLauncherRadyToFire(); // Search launcher for fire. 
		if(radyToFire != null) {
			DataAfterFire daf = radyToFire.fire(city);
			dataList.add(daf);// save the data from the fire
			fireFireFromeLauncherEvent(daf);
		}
		System.out.println("fire didnt happened - no launcher avilable"); 
	}

	private void fireFireFromeLauncherEvent(DataAfterFire daf) {
		for (WarModelEventListener warModelEventListener : allListeners) {
			warModelEventListener.fireFromeLauncherInModel(daf);
		}
	}

	private Launcher getLauncherRadyToFire() {
		int counter= 0;
		Launcher l;
		for (Launcherable launcherable : launchers) {
			if(launcherable.getClass() == Launcher.class) {
				System.out.println("found launcer in array");
				counter++;
				l = (Launcher)launcherable;
				if(!l.isActive()) {
					l.setActive(true);
					return l;
				}
			}
		}
		if(counter == 0)
			System.out.println("there are now launcher in war.");
		return null;
	}
	



}
