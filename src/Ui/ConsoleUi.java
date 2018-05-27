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
					System.out.println("Press = " + press);
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
		City city;
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

			city = getCityFromUser();
			new Thread(new Runnable() {

				@Override
				public void run() {
					for (WarUiEventListener warUiEventListener : allListeners) {
						warUiEventListener.fireFromLauncherFromUi(city);
					}
				}
			}).start();
			break;
		case 5:
			System.out.println("fire from launcherDestructors in - ConsolUi(getAction).");
			new Thread(new Runnable() {

				@Override
				public void run() {
					for (WarUiEventListener warUiEventListener : allListeners) {
						warUiEventListener.fireFromlauncherDestructorsFromUi();
					}
				}
			}).start();
			break;
		case 6:
			System.out.println("fire from missileDestructors in - ConsolUi(getAction).");
			new Thread(new Runnable() {

				@Override
				public void run() {
					for (WarUiEventListener warUiEventListener : allListeners) {
						warUiEventListener.fireFromMissileDestructorsFromUi();
					}
				}
			}).start();
			break;
		default:
			System.out.println("on defult in getAction");
			break;
		}

	}

	private City getCityFromUser() {
		int press = -1;
		s.nextLine(); // Clean the buffer
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
		Menu menu = new Menu();
		return menu.getPressFromMenu();
	}

	@Override
	public void showFire(DataAfterFire daf) {
		System.out.println(daf);
	}

	class Menu {
		private List<String> menu = new ArrayList<>();

		public Menu() {
			menu.add("add launcher.");
			menu.add("add launcherDestructors.");
			menu.add("add MissileDestructor.");
			menu.add("fire from launcher.");
			menu.add("fire from launcherDestructors.");
			menu.add("fire from MissileDestructors.");
		}

		public int getPressFromMenu() {
			int size = menu.size();
			int press = -1;
			do {
				for (int i = 1; i <= size; i++)
					System.out.println(i + " - " + menu.get(i - 1));
				press = s.nextInt();
			} while (press <= 0 || press > menu.size());

			System.out.println("press = "+ press);
			return press;
		}
	}
}
