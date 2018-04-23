package model;

public class RocketLauncher extends abstractLauncher implements launcherable{

	public static int ID = 1;
	
	public RocketLauncher(String id , int coordinateX ,int coordinateY , boolean hiddenLauncher) {
		setId(id);
		setCoordinateX(coordinateX);
		setCoordinateY(coordinateY);
		if(hiddenLauncher)
			getHiding();
		else
			getUnhiding();
	}
	@Override
	public void fire(int coordinateX, int coordinateY) {
		// TODO Auto-generated method stub
		
	}
<<<<<<< HEAD
=======
	
	//Make id for RocketLauncher
	public static String makeId() {
		return "L"+ID++;
	}
>>>>>>> branch 'master' of https://github.com/mennyaboush/warSimulator.git
	@Override
	public void addMissle() {
		// TODO Auto-generated method stub
		
	}
}
