package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

import Enum.City;
import Enum.DistractorType;
import controller.LauncherController;
import warInterface.IWarController;
import model.*;
import sun.launcher.resources.launcher;
import viewConsol.LauncherView;

public class WarConsol {
	private List<Launcherable> launchers = new ArrayList<>();
	private List<DataAfterFire> dataList = new ArrayList<>();
	private List<LauncherController> activeLauncher = new ArrayList<>();

	public List<Launcherable> getLaunchers() {
		return launchers;
	}

	public void setLaunchers(List<Launcherable> launchers) {
		this.launchers = launchers;
	}

	public List<DataAfterFire> getDataList() {
		return dataList;
	}

	public void setDataList(List<DataAfterFire> dataList) {
		this.dataList = dataList;
	}

	public List<Launcher> getActiveLauncher() {
		return activeLauncher;
	}

	public void setActiveLauncher(List<Launcher> activeLauncher) {
		this.activeLauncher = activeLauncher;
	}

	public Scanner getS() {
		return s;
	}

	public void setS(Scanner s) {
		this.s = s;
	}

	public DataAfterFire getDaf() {
		return daf;
	}

	public void setDaf(DataAfterFire daf) {
		this.daf = daf;
	}

	Scanner s = new Scanner(System.in);
	DataAfterFire daf;

	public WarConsol() {
		int press = s.nextInt();

	}

	private void printSummary() {

	}

	private DataAfterFire fireFromRandomLauncher(Location location, Class c) {
		for (Launcherable launcherable : launchers) {
			if (launcherable.getClass() == c) {
				return launcherable.fire(location);
			}
		}
		System.out.println("No launcher exist in the system.");
		return new DataAfterFire(null, 0, false);
	}

	private Location getLocathionFromUserByCity() {
		System.out.println("Enter the number of the city.");
		printCitys();
		int cityIndex = s.nextInt();
		return new Location(City.values()[cityIndex]);
	}

	private Launcherable findLauncherById(String id, Class c) {
		for (Launcherable l : launchers) {
			if (l.getClass() == c)
				if (((AbstractLauncher) l).getId() == id)
					return l;
		}
		return null;
	}

	private void addLauncherDistractor() {
		DistractorType t = getDistractorTypeFromUser();
		List<Missile> m = creatMissiles();
		addLauncherDistractor(makeLauncherDistractorId(), t, m);
	}

	private String makeLauncherDistractorId() {
		return "D" + Launcher.numberId++;
	}

	private DistractorType getDistractorTypeFromUser() {// PLANE ,SHIP
		System.out.println("press 1 - for PLANE ");
		System.out.println("press 2 - for SHIP ");
		int p = s.nextInt();
		if (p == 1)
			return DistractorType.PLANE;
		return DistractorType.SHIP;
	}

	private void printCitys() {
		for (City c : City.values()) {
			System.out.println(c.ordinal() + "-" + c.name());
		}
	}

	private void addMissleDistractor(City city) {
		String id = "D" + MissileDestructors.numberId++;
		List l = creatMissiles();
		addMissleDistractor(id, l);

	}

	private List<Missile> creatMissiles() {
		List<Missile> l = new ArrayList<>();
		System.out.println("Enter target for missle:");
		String target = s.nextLine();
		City city = checkLocation(target);
		while (city != null) {
			l.add(new Missile(Missile.makeId(), new Location(city), EnterLaunchTime(), MyRandom.flyingTime(),
					MyRandom.getDemage()));
			System.out.println("Enter target for missle:");
			target = s.nextLine();
			city = checkLocation(target);
		}
		return l;
	}

	private int EnterLaunchTime() {
		System.out.println("Enter launch time:");
		return s.nextInt();
	}

	private City checkLocation(String target) {
		for (City c : City.values()) {
			if (c.name().equals(target)) {
				return c;
			}
		}
		return null;
	}

	private void addLauncher() {
		LauncherModel launcherModel = new LauncherModel(LauncherModel.makeId(), City.GAZA
				,MyRandom.isHidden(),  creatMissiles(), this);
		LauncherView launcherView = new LauncherView();
		LauncherController launcherController = new LauncherController(launcherView, launcherModel);
		launchers.add(launcherController);
	}

	/** the Queue<Missile> missiles didn't use */
	@Override
	public void addLauncher(String id, boolean isHidden, List<Missile> missiles) {
		Launcher l = new Launcher(id, City.GAZA, isHidden, missiles);
		launchers.add(l);
	}

	@Override
	public void addLauncherDistractor(String id, DistractorType type, List<Missile> m) {
		LauncherDestructors launcherDestructors = new LauncherDestructors(id, type, m);
		launchers.add(launcherDestructors);
	}

	@Override
	public void warSummary() {
		printSummary();
	}

	@Override
	public void Exit() {
		System.out.println("bye bye. ");
	}

	@Override
	public void addMissleDistractor(String id, List<Missile> missiles) {
		MissileDestructors md = new MissileDestructors(id, missiles, MyRandom.getCity());
		launchers.add(md);
	}

	@Override
	public DataAfterFire fireFromeLauncher() {
		System.out.println("Enter launcherId to fire.");
		String id = s.nextLine();
		Location location = getLocathionFromUserByCity();
		Class c = Launcher.class;
		Launcher l = (Launcher) findLauncherById(id, c);
		if (l == null)
			return fireFromRandomLauncher(location, c);
		else
			return l.fire(location);

	}

	@Override
	public DataAfterFire fireFromMissileDistractor() {
		System.out.println("Enter missile distarctor Id to fire.");
		String id = s.nextLine();
		Class c = LauncherDestructors.class;
		// the location didn't relevant for the missileDistreactor - the location is
		// other missile.
		Location location = new Location(0, 0);
		MissileDestructors md = (MissileDestructors) findLauncherById(id, c);
		if (md != null) {
			return md.fire(location);
		} else {
			return fireFromRandomLauncher(location, c);
		}
	}

	@Override
	public DataAfterFire fireFromDistactorLauncher() {
		System.out.println("Enter launcher distarctor Id to fire.");
		String id = s.nextLine();
		Class c = LauncherDestructors.class;
		Location location = getLocathionFromUserByCity();
		LauncherDestructors ld = (LauncherDestructors) findLauncherById(id, c);
		if (ld != null) {
			return ld.fire(location);
		} else {
			return fireFromRandomLauncher(location, c);
		}

	}

	public void startAction(int action) {
		while(action != 8) {
			switch (action) {
			case 1:
				addLauncher();
				break;
			case 2:
				System.out.println("Enter index of city for adding MissleDistractor ");
				printCitys();
				int cityIndex = s.nextInt();
				addMissleDistractor(City.values()[cityIndex]);
				break;
			case 3:
				addLauncherDistractor();
				break;
			case 4:
				daf = fireFromeLauncher();
				dataList.add(daf);
				break;
			case 5:
				daf = fireFromDistactorLauncher();
				dataList.add(daf);
				break;
			case 6:
				daf = fireFromMissileDistractor();
				dataList.add(daf); 
				break;
			case 7:
				printSummary();
				break;
			default:
				break;
			}
			Exit();
	}

}
