package bl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

import org.json.JSONException;

import com.sun.jmx.snmp.tasks.Task;

import Enum.City;
import mvc.WarController;
import mvc.WarModelEventListener;

public class War {
	
//	static {
//		private final int startWar = 
//	}
//	
	public static String WAR_FILE = "warFile.txt";
	private List<WarModelEventListener> allListeners = new ArrayList<>();
	private List<Launcherable> launchers = new ArrayList<>();
	private List<DataAfterFire> dataList = new ArrayList<>();
	private boolean exit = false;
	private boolean exitTimerTask = false;
	MyTimer timer = MyTimer.getInstance();

	public War() {
		readData();
		int maxTime = getMaxTime();

		/* evry sec the timer task over on all the launchers and fire if they need */
		timer.getTimer().schedule(new TimerTask() {
			int time = 0;

			@Override
			public void run() {
				while (!exitTimerTask) {
					for (Launcherable l : launchers)
						dataList.addAll( l.fireIfNeed(time));
					time++;
					System.out.println("time : " + time );
					if (time >= maxTime) {
						System.out.println("max time");
						exitTimerTask = true;
						fireStartUiEvent();
					}
				}
				
			}

			private void fireStartUiEvent() {
				for (WarModelEventListener warModelEventListener : allListeners) {
					warModelEventListener.startUiInModel();
				}
			}
		}, 1000);
	}

	/* get the max time to know when the program need to start runtime command */
	private int getMaxTime() {
		int max = 0;
		for (Launcherable launcherable : launchers) {
			List<AbstractMissile> currentMissiles = ((AbstractLauncher) launcherable).getMissileArr();
			if (currentMissiles != null) {
				for (AbstractMissile m : currentMissiles) {
					if (m.getLaunchTime() > max)
						max = m.getLaunchTime();
				}
			}
		}
		return max;
	}

	private void readData() {

		try {
			JsonReader jr = new JsonReader();
			launchers.addAll(jr.ReadLaunchers());
			launchers.addAll(jr.readMissileDestructor());
			launchers.addAll(jr.readMissileLauncherDestructors());
		} catch (IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

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
			Launcher lancherToDestruct = getLauncherToDestruct();
			if (lancherToDestruct != null) {
				DataAfterFire daf = radyToFire.fire(new Location(City.GAZA));
				if (daf != null) {
					if (daf.isHit() == true)
						launchers.remove(lancherToDestruct);// delete the launcher
					dataList.add(daf);// save the data from the fire
					radyToFire.setActive(false);
					fireFireFromeLauncherEvent(daf);
				}
			} else
				System.out.println("fire didnt happened - no launcher can be destruct");
		} else
			System.out.println("fire didnt happened - no launcherDestructor avilable");
	}

	/* get launcher not hidden */
	private Launcher getLauncherToDestruct() {
		for (Launcherable l : launchers) {
			if (l.getClass() == Launcher.class)
				if (!((Launcher) l).getIsHidden())
					return (Launcher) l;
		}
		return null;
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
			System.out.println("missile destruct active");
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
		if (l != null)
			missile = ((AbstractLauncher<Missile>) l).missielToFire;
		return missile;
	}

	/** return Launcherable from LauncherDestructors or Launcher */
	private Launcherable getActiveLancherable() {
		for (Launcherable l : launchers) {
			if (((AbstractLauncher<?>) l).isActive() && MissileDestructors.class != l.getClass())
				return l;
		}
		return null;
	}

	public void printSummary() {
		int counterMissile = 0, counterMissileLauncherD = 0, counterHitTarget = 0, counterMissileD = 0,
				counterDamage = 0, counterLauncherImpact = 0;
		for (DataAfterFire daf : dataList) {
			if (daf.getL().getClass() == Launcher.class) {
				counterMissile++;
				if (daf.isHit()) {
					counterHitTarget++;
					counterDamage += daf.getDamage();
				}
			} else if (daf.getL().getClass() == LauncherDestructors.class) {
				counterMissileLauncherD++;
				if (daf.isHit())
					counterLauncherImpact++;
			} else { // Missile destructor
				counterMissileD++;
			}
		}
		fireSummaryEvent(new SummaryObj(counterMissile, counterMissileD, counterMissileLauncherD, counterHitTarget,
				counterDamage, counterLauncherImpact));
	}

	private void fireSummaryEvent(SummaryObj summaryObj) {
		for (WarModelEventListener warModelEventListener : allListeners) {
			warModelEventListener.summaryInModle(summaryObj);
		}
	}

	public void Exit() {
		exit = true;
		closeHandlers();
		fireExitEvent();
	}

	private void fireExitEvent() {
		for (WarModelEventListener warModelEventListener : allListeners) {
			warModelEventListener.ExitInModle();
		}
	}

	private void closeHandlers() {
		Handler h[] = AbstractLauncher.theLogger.getHandlers();
		for (Handler handler : h) {
			handler.close();
		}
	}

}
