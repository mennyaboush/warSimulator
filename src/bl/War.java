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
		Launcher l = new Launcher(Launcher.makeId(), City.GAZA, MyRandom.isHidden(), new ArrayList<Missile>());
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
		MissileDestructors md = new MissileDestructors(MissileDestructors.makeId(), new ArrayList<MissileD>(),
				MyRandom.getCity());
		launchers.add(md);
		fireAddLauncherEvent(md);
	}

	private Launcher getLauncherRadyToFire() {
		return (Launcher) getLauncherableRadyToFire(Launcher.class);
	}

	private void fireFireFromeLauncherEvent(DataAfterFire daf) {
		for (WarModelEventListener warModelEventListener : allListeners) {
			warModelEventListener.fireFromeLauncherInModel(daf);
		}
	}

	private Launcherable getLauncherableRadyToFire(Class<?> c) {
		int counter = 0;
		AbstractLauncher<?> l;
		for (Launcherable launcherable : launchers) {
			if (launcherable.getClass() == c) {
				System.out.println("found launcer in array");
				counter++;
				l = (AbstractLauncher<?>) launcherable;
				if (!l.isActive()) {
					l.setActive(true);
					return l;
				}
			}
		}
		if (counter == 0)
			System.out.println("there are now " + c.getName() + " in war.");
		return null;
	}

	public void fireFromLauncher(City city) {
		Launcher radyToFire = getLauncherRadyToFire(); // Search launcher for fire.
		if (radyToFire != null) {
			radyToFire.setActive(true);
			DataAfterFire daf = radyToFire.fire(city);
			dataList.add(daf);// save the data from the fire
			radyToFire.setActive(false);
			fireFireFromeLauncherEvent(daf);
		} else
			System.out.println("fire didnt happened - no launcher avilable");
	}

	public void fireFromlauncherDestructor() {
		LauncherDestructors radyToFire = getLauncherDestructorsRadyToFire();
		if (radyToFire != null) {
			radyToFire.setActive(true);
			DataAfterFire daf = radyToFire.fire(new Location(City.GAZA));
			if(daf!=null) {
				dataList.add(daf);// save the data from the fire
				radyToFire.setActive(false);
				fireFireFromeLauncherEvent(daf);
			}
		} else
			System.out.println("fire didnt happened - no launcherDestructor avilable");
	}

	private LauncherDestructors getLauncherDestructorsRadyToFire() {
		return (LauncherDestructors) getLauncherableRadyToFire(LauncherDestructors.class);
	}

	private MissileDestructors getMissileDestructorsRadyToFire() {
		return (MissileDestructors) getLauncherableRadyToFire(MissileDestructors.class);
	}

	public void fireFromMissileDestructor() {
		MissileDestructors radyToFire = getMissileDestructorsRadyToFire();
		if (radyToFire != null) {
			radyToFire.setActive(true);
			DataAfterFire daf = radyToFire.fire(getActiveMissile());
			dataList.add(daf);// save the data from the fire
			radyToFire.setActive(false);
			fireFireFromeLauncherEvent(daf);
		} else
			System.out.println("fire didnt happened - no launcherDestructor avilable");
	}

	@SuppressWarnings("unchecked")
	private Missile getActiveMissile() {
		Launcherable l = getActiveLancherable();
		Missile missile = null;
		if(l != null)
			missile = ((AbstractLauncher<Missile>)l).missielToFire;
		return missile;
	}

	/**return Launcherable from LauncherDestructors or Launcher*/
	private Launcherable getActiveLancherable() {
		for (Launcherable l : launchers) {
			if(((AbstractLauncher<?>)l).isActive() && MissileDestructors.class != l.getClass())
				return l;
		}
		return null;
	}

}
