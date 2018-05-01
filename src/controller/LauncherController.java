package controller;

import model.DataAfterFire;
import model.LauncherModel;
import model.Launcherable;
import model.Location;
import viewConsol.LauncherView;

public class LauncherController implements Launcherable{
	private LauncherView launcherView;
	private LauncherModel launcherModel;
	
	public LauncherController(LauncherView launcherView , LauncherModel launcherModel) {
		setLauncherView(launcherView);
		setLauncherModel(launcherModel);
	}

	public LauncherView getLauncherView() {
		return launcherView;
	}

	public void setLauncherView(LauncherView launcherView) {
		this.launcherView = launcherView;
	}

	public LauncherModel getLauncherModel() {
		return launcherModel;
	}

	public void setLauncherModel(LauncherModel launcherModel) {
		this.launcherModel = launcherModel;
	}

	@Override
	public DataAfterFire fire(Location destination) {
		return launcherModel.fire(destination);
	}

	@Override
	public void addMissle() {
		launcherModel.addMissle();
	}
}
