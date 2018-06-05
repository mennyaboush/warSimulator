package Main;

import java.util.ArrayList;

import org.json.JSONException;

import Ui.ConsoleUi;
import bl.JsonReader;
import bl.Launcher;
import bl.War;
import jdk.nashorn.internal.runtime.regexp.joni.Config;
import mvc.WarController;

public class MainConsole {

	public static void main(String[] args) {
		
		War war = new War();
		ConsoleUi warView = new ConsoleUi();
		WarController warController = new WarController(war, warView);
	}

}
