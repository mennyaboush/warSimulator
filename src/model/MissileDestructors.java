package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MissileDestructors extends AbstractLauncher {
	public static int id = 1;
	private HashMap<String, Integer> targetId = new HashMap<>();//key = tagetIndex value = time 
	
	public MissileDestructors(String id) {
		super();
		setId(id);
	}

	public MissileDestructors(String id, ArrayList<String> targetId) {
		this(id);
		for (String string : targetId) {
			
		}
	}

	@Override
	public void fire(Location location) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addMissle() {
		// TODO Auto-generated method stub

	}

}
