package model;

public abstract class abstractLauncher implements launcherable{
	private String id;
	private boolean isHidden;
	private Area area;
	private int coordinateX;
	private int coordinateY;
	
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public int getCoordinateX() {
		return coordinateX;
	}
	public void setCoordinateX(int coordinateX) {
		this.coordinateX = coordinateX;
	}
	public int getCoordinateY() {
		return coordinateY;
	}
	public void setCoordinateY(int coordinateY) {
		this.coordinateY = coordinateY;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public boolean getIsHidden() {
		return isHidden;
	}
	
	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	} 
	
	
	/*hiding and unhiding.. its ok to put that her? for luncher who can't hide*/
	protected void getHiding() {
		setHidden(true);
	}
	protected void getUnhiding() { 
		setHidden(false);
	}
}