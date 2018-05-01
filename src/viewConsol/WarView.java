package viewConsol;

import java.util.Scanner;

import Enum.City;

public class WarView {
	private Scanner scanner = new Scanner(System.in);

	public WarView() {

	}

	public int gatActionFromUser() {
		int selectedNumber;
		printMenu();
		System.out.println("Select a number from the menu.");
		selectedNumber = scanner.nextInt();
		return selectedNumber;
	}

	private void printMenu() {
		System.out.println("Menu\n1 - add launcher");
		System.out.println("2 - add missile distactor");
		System.out.println("3 - add launcher distactor");
		System.out.println("4 - fire from launcher");
		System.out.println("5 - fire from distactor-launcher");
		System.out.println("6 - fire from missle - distractor");
		System.out.println("7 - war summary");
		System.out.println("-1 - EXIT");

	}
}
