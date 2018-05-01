package controller;

import java.util.List;

import Enum.DistractorType;
import model.DataAfterFire;
import model.Missile;
import model.WarConsol;
import viewConsol.WarView;
import warInterface.IWarController;

public class WarController implements IWarController {
	private WarView warView;
	private WarConsol warModel;

	public WarController(WarView warView, WarConsol warConsol) {
		setWarModel(warConsol);
		setWarView(warView);
		startWar();
	}

	private void startWar() {
		int action;
		do {
			action = warView.gatActionFromUser();
			warModel.startAction(action);
		} while (action != 8);
	}

	public WarView getWarView() {
		return warView;
	}

	public void setWarView(WarView warView) {
		this.warView = warView;
	}

	public WarConsol getWarModel() {
		return warModel;
	}

	public void setWarModel(WarConsol warModel) {
		this.warModel = warModel;
	}

	@Override
	public void addLauncher(String id, boolean isHidden, List<Missile> missels) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addMissleDistractor(String id, List<Missile> missels) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addLauncherDistractor(String id, DistractorType type, List<Missile> m) {
		// TODO Auto-generated method stub

	}

	@Override
	public DataAfterFire fireFromeLauncher() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataAfterFire fireFromMissileDistractor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataAfterFire fireFromDistactorLauncher() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void warSummary() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Exit() {
		// TODO Auto-generated method stub

	}

}
