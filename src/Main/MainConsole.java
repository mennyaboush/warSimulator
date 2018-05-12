package Main;

import Ui.ConsoleUi;
import bl.War;
import mvc.WarController;

public class MainConsole {

	public static void main(String[] args) {
		War war = new War();
		ConsoleUi warView = new ConsoleUi();
		WarController warController = new WarController(war, warView);
	}

}
