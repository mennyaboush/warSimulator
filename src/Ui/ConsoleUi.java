package Ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bl.Launcher;
import bl.Launcherable;
import mvc.WarController;
import mvc.WarUiEventListener;

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
		default:
			break;
		}
		
	}

	private int getPressFromMenu() {
		int press = -1;
		while (press < 1 || press  > 2) {// for add launcher only
			System.out.println("1- add launcher.");
			System.out.println("2- add launcherDestructors.");
			press = s.nextInt();
		}
		return press;
	}

}
