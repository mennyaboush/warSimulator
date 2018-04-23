package model;

public class RocketLauncher extends abstractLauncher implements launcherable{

	
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
}
