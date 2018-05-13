package Ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bl.DataAfterFire;
import bl.Launcher;
import bl.Launcherable;
import mvc.WarController;
import mvc.WarUiEventListener;
import Enum.City;

public class ConsoleUi implements WarUi {
	private List<WarUiEventListener> allListeners = new ArrayList<>();
	private final Scanner s = new Scanner(System.in);

	public ConsoleUi() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				int press;
				while (true) {
					press = getPressFromMenu();
					getAction(press);
				}
			}
		}).start();
	}

	@Override
	public void registerListener(WarController warController) {
		allListeners.add(warController);
	}

	@Override
	public void showLaunchers(Launcherable l) {
		System.out.println(l);
	}

	private void getAction(int press) {
		switch (press) {
		case 1:
			System.out.println("add launcher in - ConsolUi(getAction).");
			for (WarUiEventListener warUiEventListener : allListeners) {
				warUiEventListener.addLauncherFromUi();
			}
			break;
		case 2:
			System.out.println("add launcher Destructor in - ConsolUi(getAction).");
			for (WarUiEventListener warUiEventListener : allListeners) {
				warUiEventListener.addLauncherDestructorFromUi();
			}
			break;
		case 3:
			System.out.println("add Missile Destructor in - ConsolUi(getAction).");
			for (WarUiEventListener warUiEventListener : allListeners) {
				warUiEventListener.addMissileDestructorFromUi();
			}
			break;
		case 4:
			System.out.println("fire from launcher in - ConsolUi(getAction).");
			City city = getCityFromUser();
			for (WarUiEventListener warUiEventListener : allListeners) {
				warUiEventListener.fireFromLauncherFromUi(city);
			}
			break;
		default:
			break;
		}

	}

	private City getCityFromUser() {
		s.nextLine(); // clean buffer.
		int press = -1;
		do {
			System.out.println("press index for choose city.");
			for (City city : City.values())
				System.out.println(city.ordinal() + " - " + city.name());

			press = s.nextInt();
			
			if (press < 0 && press > City.values().length)
				System.out.println("wrong index chooce again.");
		} while (press < 0 && press > City.values().length);
		return City.values()[press];
	}

	private int getPressFromMenu() {
		int press = -1;
		while (press < 1 || press > 4) {
			System.out.println("1- add launcher.");
			System.out.println("2- add launcherDestructors.");
			System.out.println("3- add MissileDestructor.");
			System.out.println("4- fire from launcher.");
			press = s.nextInt();
		}
		return press;
	}

	@Override
	public void showFire(DataAfterFire daf) {
		System.out.println(daf);
	}

}
