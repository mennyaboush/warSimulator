package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

import model.DistractorType;
import model.Location;
import model.Missile;
import warInterface.IWarController;
import model.*;

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
				addMissleDistractor();
				break;
			case 3:
				addLauncher(id, isHidden, missels)
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

	private void addMissleDistractor(City city) {
		Random r = new Random();
		String id = "D" + MissileDestructors.id++;

		addMissleDistractor(id, null, null);

	}

	private void addLauncher() {
		Random r = new Random();
		String id = "L" + Launcher.id++;
		addLauncher(id, r.nextBoolean(), null);
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

	@Override
	public boolean addLauncher(String id, boolean isHidden, Queue<Missile> missels) {
		Launcher l = new Launcher("R" + Launcher.id++, City.GAZA, isHidden);
		launchers.add(l);// need to add launchers in view
		return true;
	}

	@Override
	public boolean addLauncherDistractor(String id, DistractorType type, int distructTime) {
		// TODO Auto-generated method stub
		return false;
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
	public boolean addMissleDistractor(String id, ArrayList<String> targetId, Queue<Missile> missiles) {
		MissileDestructors md;
		if (targetId == null)
			if (missels == null)
				md = new MissileDestructors(id);
			else
				md = new MissileDestructors(id, targetId);
		else
			md = new MissileDestructors(id, targetId , missiles);

		launchers.add(md);
		return false;
	}

}
