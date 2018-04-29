package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

import Enum.City;
import Enum.DistractorType;
import warInterface.IWarController;
import model.*;
import sun.launcher.resources.launcher;

public class WarController implements IWarController {
	private List<launcherable> launchers = new ArrayList<>();

	Scanner s = new Scanner(System.in);

	public  WarController() {
		printMenu();
		int press = s.nextInt();
		while(press != 8) {
			switch (press) {
			case 1:
				addLauncher();
				break;
			case 2:
				System.out.println("Enter city for adding MissleDistractor ");
				printCitys();
				int cityIndex = s.nextInt();
				addMissleDistractor(City.values()[cityIndex]);
				break;
			case 3:
				addLauncherDistractor();
				break;
			case 4:
				addLauncher(id, isHidden, missels)
				break;
			case 5:
				addLauncher(id, isHidden, missels)
				break;
			case 6:
				addLauncher(id, isHidden, missels)
				break;
			case 7:
				addLauncher(id, isHidden, missels)
				break;
			default:
				break;
			}
			System.out.println("bye bye :).");
		}
	}

	private void addLauncherDistractor() {
		DistractorType t = EnterType();
		addLauncherDistractor(makeLauncherDistractorId(), t);
	}

	private String makeLauncherDistractorId() {
		return "D" + Launcher.numberId++;
	}

	private DistractorType EnterType() {// PLANE ,SHIP
		System.out.println("press 1 - for PLANE ");
		System.out.println("press 2 - for SHIP ");
		int p = s.nextInt();
		if (p == 1)
			return DistractorType.PLANE;
		return DistractorType.SHIP;
	}

	private void printMenu() {
		System.out.println("Menu\n1 - add launcher");
		System.out.println("2 - add missile distactor");
		System.out.println("3 - add launcher distactor");
		System.out.println("4 - add fire from launcher");
		System.out.println("5 - fire from distactor-launcher");
		System.out.println("6 - fire from missle - distractor");
		System.out.println("7 - war summary");
		System.out.println("8 - EXIT");

	}

	private void printCitys() {
		System.out.println("Select a number representing the desired city");
		for (City c : City.values()) {
			System.out.println(c.ordinal() + "-" + c.name());
		}

	}

	private void addMissleDistractor(City city) {
		String id = "D" + MissileDestructors.numberId++;
		List l = creatMissiles();
		addMissleDistractor(id, l);

	}

	private List creatMissiles() {
		List<Missile> l = new ArrayList();
		MyRandom r = new MyRandom();
		System.out.println("Enter target for missle:");
		String target = s.nextLine();
		City flag = checkLocation(target);
		while (flag != null) {
			l.add(new Missile(Missile.makeId(), new Location(flag), 
					EnterLaunchTime(), r.flyingTime(), r.getDemage()));
			System.out.println("Enter target for missle:");
			 target = s.nextLine();
			 flag = checkLocation(target);
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
		MyRandom r = new MyRandom();
		String id = "L" + Launcher.numberId++;
		List <Missile> l = creatMissiles();
		addLauncher(id, r.isHidden(), l);
	}

	/** the Queue<Missile> missiles didn't use */
	@Override
	public void addLauncher(String id, boolean isHidden, List <Missile> missiles) {
		Launcher l = new Launcher(id, City.GAZA, isHidden , missiles);
		launchers.add(l);
	}

	@Override
	public void addLauncherDistractor(String id, DistractorType type) {
		System.out.println("");
	}

	@Override
	public void launcherFire(Location target, int damage, int flyTime) {
		// TODO Auto-generated method stub

	}

	@Override
	public void launcherDistractorFire(String targetID, int flyTime) {
		// TODO Auto-generated method stub

	}

	@Override
	public void missleDistractorFire() {
		// TODO Auto-generated method stub

	}

	@Override
	public void warSummary() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Exit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addMissleDistractor(String id, List<Missile> missiles) {
		MissileDestructors md = new MissileDestructors(id, missiles,MyRandom.getCity());
		launchers.add(md);
	}

}
