package mvc;

import java.util.List;

import javax.sound.sampled.LineListener;

import Enum.City;
import Ui.WarUi;
import bl.DataAfterFire;
import bl.Launcher;
import bl.LauncherDestructors;
import bl.Launcherable;
import bl.Missile;
import bl.War;

public class WarController implements WarModelEventListener, WarUiEventListener {
	private War war;
	private WarUi warView;

	public WarController(War war, WarUi warView) {
		this.war = war;
		this.warView = warView;

		war.registerListener(this);
		warView.registerListener(this);
		
	}

	@Override
	public void addLauncherFromUi() {
		war.addLauncher();
	}

	@Override
	public void addLauncherInModel(Launcherable l) {
		warView.showLaunchers(l);
	}
	@Override
	public void addLauncherDestructorFromUi() {
		war.addLauncherDestructor();
	}

	@Override
	public void addMissileDestructorFromUi() {
		war.addMissileDestructor();
	}

	@Override
	public void fireFromLauncherFromUi(City city) {
		war.fireFromLauncher(city);
	}

	@Override
	public void fireFromeLauncherInModel(DataAfterFire daf) {
		warView.showFire(daf);
	}

}
